package aino.render;

import aino.AImage;
import aino.Scene;
import aino.camera.Camera;
import aino.entity.Intersection;
import aino.material.AColor;
import aino.material.LightVector;
import aino.math.geometry3.Ray3;
import aino.math.geometry3.Vector3;
import aino.light.Light;
import java.util.ArrayList;
import java.util.Collections;

public class BackwardRayTracer implements Renderer
{
    private Sampler sampler;
    private Scene scene;
    public BackwardRayTracer(Sampler s)
    {
        sampler = s;
    }
    public void render(Scene scene, AImage<AColor> render)
    {
        this.scene = scene;
        Camera camera = scene.getCurrentCamera();
        for (int i=0; i<render.width(); ++i)
        {
			System.out.println((i*100.0f/render.width()) + "%");
            for (int j=0; j<render.height(); ++j)
            {
                AColor pixel_color = new AColor(0.0f);
                Sample[] samples = sampler.generateSamples();
                for (int k=0; k<samples.length; ++k)
                {
                    Ray3 ray = camera.generateRay(i + samples[k].X, render.height()-j-1 + samples[k].Y, render.width(), render.height());
                    AColor c = traceRay(ray);
                    pixel_color = pixel_color.add(c.multiply(samples[k].weight));
                }
                render.set(i, j, pixel_color);
            }
			
        }
    }
    
    public AColor traceRay(Ray3 ray)
    {
        Ray3 ro = scene.aggregate.toObjectSpace(ray);
        Intersection it = scene.aggregate.getIntersection(ro);
        if (it == null)
        {
            return scene.background_color;
        }
        
        it.Rw = ray;
        it.Pw = ray.pointAt(it.T);
        Collections.reverse(it.transforms);
        return it.E.getColor(it, this);
    }
    
    public ArrayList<LightVector> gatherRadiance(Intersection it)
    {
        ArrayList<LightVector> r = new ArrayList<LightVector>();
        for (int i=0; i<scene.lights.size(); ++i)
        {
            scene.lights.get(i).collectContribution(it, scene.aggregate, r);
        }

        for (int i=0; i<r.size(); ++i)
        {
            LightVector lv = r.get(i);
            Vector3 v = it.toObjectSpace(lv);
            lv.X = v.X;
            lv.Y = v.Y;
            lv.Z = v.Z;
            lv.normalize();
        }
        
        return r;
    }

}

package aino.render;

import aino.AImage;
import aino.Scene;
import aino.camera.Camera;
import aino.math.geometry3.Ray3;
import aino.entity.Intersection;
import aino.material.AColor;
import aino.material.LightVector;
import java.util.ArrayList;

public class BooleanRenderer implements Renderer
{
    private Scene scene;
    public BooleanRenderer()
    {
        
    }
    public void render(Scene scene, AImage<AColor> render)
    {
        this.scene = scene;
        Camera camera = scene.getCurrentCamera();
        for (int i=0; i<render.width(); ++i)
        {
            for (int j=0; j<render.height(); ++j)
            {
                Ray3 ray = camera.generateRay(i, render.height()-j-1, render.width(), render.height());
                AColor c = traceRay(ray);
                render.set(i, j, c);
            }
        }
    }
    
    public AColor traceRay(Ray3 ray)
    {
        if (scene.aggregate.getIntersection(ray) != null)
        {
            return new AColor(0.0f);
        }
        return new AColor(1.0f);
    }
    
    public ArrayList<LightVector> gatherRadiance(Intersection it)
    {
        return null;
    }

}

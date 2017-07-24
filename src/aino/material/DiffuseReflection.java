package aino.material;

import aino.entity.Intersection;
import aino.entity.SurfaceGeometry;
import aino.math.geometry3.Vector3;
import aino.render.Renderer;
import java.util.ArrayList;

public class DiffuseReflection implements Material
{
    private Material color;
    public DiffuseReflection(Material c)
    {
        color = c;
    }
    public AColor getColor(Vector3 v, SurfaceGeometry s, Intersection it, ArrayList<LightVector> radiance, Renderer renderer)
    {
        ArrayList<LightVector> l = renderer.gatherRadiance(it);
        AColor c = new AColor(0.0f);
        for (int i=0; i<l.size(); ++i)
        {
            LightVector lv = l.get(i);
            float dot = lv.dot(s.N);
            AColor tc = new AColor(lv.color);
            tc = tc.multiply(dot);
            c = c.add(tc);
        }
        c = c.multiply(color.getColor(v, s, it, radiance, renderer));
        return c;
    }
    public boolean needsLight()
    {
        return true;
    }
}
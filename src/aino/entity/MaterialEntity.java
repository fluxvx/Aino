package aino.entity;

import aino.math.geometry3.Vector3;
import aino.material.AColor;
import aino.material.LightVector;
import aino.material.Material;
import aino.render.Renderer;
import java.util.ArrayList;

public abstract class MaterialEntity extends Entity
{
    protected Material material;
    public MaterialEntity(Material m)
    {
        material = m;
    }
    public abstract SurfaceGeometry getSurfaceGeometry(Intersection it);
    public AColor getColor(Intersection it, Renderer renderer)
    {
        Vector3 v = new Vector3(it.Ro.D);
        v.negate();
        
        SurfaceGeometry sg = getSurfaceGeometry(it);
        if (sg.N.dot(v) < 0)
        {
            sg.N.negate();
        }
        sg.N.normalize();
        
        ArrayList<LightVector> radiance;
        if (material.needsLight())
        {
            radiance = renderer.gatherRadiance(it);
        }
        else
        {
            radiance = new ArrayList<LightVector>();
        }
        
        return material.getColor(v, sg, it, radiance, renderer);
    }
    
}

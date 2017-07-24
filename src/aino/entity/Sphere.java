package aino.entity;

import aino.math.AMath;
import aino.Aino;
import aino.math.geometry3.Box3;
import aino.math.geometry3.Normal3;
import aino.math.geometry3.Point3;
import aino.math.geometry3.Ray3;
import aino.material.Material;

public class Sphere extends MaterialEntity
{
    public float radius;
    public Sphere(float r, Material m)
    {
        super(m);
        radius = r;
    }
    
    public Intersection getIntersection(Ray3 r)
    {
        float a = r.D.dot(r.D);
        float b = 2*r.O.dot(r.D);
        float c = r.O.dot(r.O) - radius*radius; 
        float[] t = AMath.quadratic(a, b, c);
        if (t.length > 0)
        {
            if (Aino.isValid(t[0]))
            {
                return new Intersection(r, t[0], this);
            }
            
            if (t.length == 2 && Aino.isValid(t[1]))
            {
                return new Intersection(r, t[1], this);
            }
        }
        return null;
    }
    
    public SurfaceGeometry getSurfaceGeometry(Intersection it)
    {
        return new SurfaceGeometry(it.Po, new Normal3(it.Po));
    }
    
    public Box3 getBounds()
    {
        Point3 pmin = new Point3(-radius, -radius, -radius);
        Point3 pmax = new Point3 (radius, radius, radius);
        Box3 r = new Box3(pmin, pmax);
        return super.toWorldSpace(r);
    }
}

package aino.entity;

import aino.Aino;
import aino.material.Material;
import aino.math.geometry3.Box3;
import aino.math.geometry3.Normal3;
import aino.math.geometry3.Point3;
import aino.math.geometry3.Ray3;

public class Cube extends MaterialEntity
{
    
    public float radius;
    public Cube(float r, Material m)
    {
        super(m);
        radius = r;
    }
    
    public SurfaceGeometry getSurfaceGeometry(Intersection it)
    {
        float max_val = it.Po.X;
        Normal3 n = new Normal3((max_val > 0)? 1.0f: -1.0f, 0.0f, 0.0f);

        if (Math.abs(it.Po.Y) > Math.abs(max_val))
        {
            max_val = it.Po.Y;
            n = new Normal3(0.0f, (max_val > 0)? 1.0f: -1.0f, 0.0f);
        }
        if (Math.abs(it.Po.Z) > Math.abs(max_val))
        {
            max_val = it.Po.Z;
            n = new Normal3(0.0f, 0.0f, (max_val > 0)? 1.0f: -1.0f);
        }
        return new SurfaceGeometry(it.Po, n);
    }
    
    public Intersection getIntersection(Ray3 r)
    {
        float tx1 = (-radius - r.O.X)/r.D.X;
        float tx2 = (radius - r.O.X)/r.D.X;

        float tmin = Math.min(tx1, tx2);
        float tmax = Math.max(tx1, tx2);

        float ty1 = (-radius - r.O.Y)/r.D.Y;
        float ty2 = (radius - r.O.Y)/r.D.Y;

        tmin = Math.max(tmin, Math.min(ty1, ty2));
        tmax = Math.min(tmax, Math.max(ty1, ty2));

        float tz1 = (-radius - r.O.Z)/r.D.Z;
        float tz2 = (radius - r.O.Z)/r.D.Z;

        tmin = Math.max(tmin, Math.min(tz1, tz2));
        tmax = Math.min(tmax, Math.max(tz1, tz2));

        if (tmax >= Math.max(0.0f, tmin))
        {
            if (Aino.isValid(tmin))
            {
                return new Intersection(r, tmin, this);
            }
            else if (Aino.isValid(tmax))
            {
                return new Intersection(r, tmax, this);
            }
        }
        return null;
    }
    
    public Box3 getBounds()
    {
        Point3 pmin = new Point3(-radius, -radius, -radius);
        Point3 pmax = new Point3 (radius, radius, radius);
        Box3 r = new Box3(pmin, pmax);
        return super.toWorldSpace(r);
    }
    
}

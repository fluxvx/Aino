package aino.math.geometry3;

import java.util.ArrayList;

public class CoordinateSystem3 extends Transform3
{
    public ArrayList<Transform3> transforms;
    public CoordinateSystem3()
    {
        transforms = new ArrayList<Transform3>();
    }
    public void add(Transform3 t)
    {
        transforms.add(t);
    }
    public Point3 toWorldSpace(Point3 p)
    {
        for (int i=0; i<transforms.size(); ++i)
        {
            p = transforms.get(i).toWorldSpace(p);
        }
        return p;
    }
    public Point3 toObjectSpace(Point3 p)
    {
        for (int i=transforms.size()-1; i>=0; --i)
        {
            p = transforms.get(i).toObjectSpace(p);
        }
        return p;
    }
    public Vector3 toWorldSpace(Vector3 v)
    {
        for (int i=0; i<transforms.size(); ++i)
        {
            v = transforms.get(i).toWorldSpace(v);
        }
        return v;
    }
    public Vector3 toObjectSpace(Vector3 v)
    {
        for (int i=transforms.size()-1; i>=0; --i)
        {
            v = transforms.get(i).toObjectSpace(v);
        }
        return v;
    }
    public Ray3 toWorldSpace(Ray3 r)
    {
        for (int i=0; i<transforms.size(); ++i)
        {
            r = transforms.get(i).toWorldSpace(r);
        }
        return r;
    }
    public Ray3 toObjectSpace(Ray3 r)
    {
        for (int i=transforms.size()-1; i>=0; --i)
        {
            r = transforms.get(i).toObjectSpace(r);
        }
        return r;
    }
    public Normal3 toWorldSpace(Normal3 n)
    {
        for (int i=0; i<transforms.size(); ++i)
        {
            n = transforms.get(i).toWorldSpace(n);
        }
        return n;
    }
    public Normal3 toObjectSpace(Normal3 n)
    {
        for (int i=transforms.size()-1; i>=0; --i)
        {
            n = transforms.get(i).toObjectSpace(n);
        }
        return n;
    }
}
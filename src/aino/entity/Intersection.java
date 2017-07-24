package aino.entity;

import aino.math.geometry3.CoordinateSystem3;
import aino.math.geometry3.Point3;
import aino.math.geometry3.Ray3;

public class Intersection extends CoordinateSystem3
{
    public Ray3 Ro, Rw;
    public Point3 Po, Pw;
    public float T;
    public Entity E;
    public Intersection(Ray3 ro, float t, Entity e)
    {
        this(ro, ro.pointAt(t), t, e);
    }
    public Intersection(Ray3 ro, Point3 po, float t, Entity e)
    {
        Ro = ro;
        Po = po;
        Rw = null;
        Pw = null;
        T = t;
        E = e;
        
        add(e);
    }

}
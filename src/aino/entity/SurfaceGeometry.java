package aino.entity;

import aino.math.geometry3.Normal3;
import aino.math.geometry3.Point3;

public class SurfaceGeometry
{
    public Point3 P;
    public Normal3 N;
    public float U, V;
    public SurfaceGeometry(Point3 p, Normal3 n)
    {
        this(p, n, 0.0f, 0.0f);
    }
    public SurfaceGeometry(Point3 p, Normal3 n, float u, float v)
    {
        P = p;
        N = n;
        U = u;
        V = v;
    }
}

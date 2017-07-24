package aino.entity;

import aino.math.geometry3.Box3;
import aino.math.geometry3.CoordinateSystem3;
import aino.math.geometry3.Ray3;
import aino.material.AColor;
import aino.render.Renderer;

public abstract class Entity extends CoordinateSystem3
{
    public abstract Intersection getIntersection(Ray3 r);
    public abstract AColor getColor(Intersection it, Renderer renderer);
    public boolean testIntersection(Ray3 r, float d)
    {
        Intersection it = getIntersection(r);
        return it != null && it.T < d;
    }
    public abstract Box3 getBounds();
}


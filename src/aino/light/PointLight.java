package aino.light;

import aino.entity.Aggregate;
import aino.entity.Intersection;
import aino.math.geometry3.Point3;
import aino.math.geometry3.Ray3;
import aino.material.AColor;
import aino.material.LightVector;
import java.util.ArrayList;

public class PointLight extends Light
{
    public AColor P;
    public PointLight(AColor p)
    {
        P = new AColor(p);
    }
    public void collectContribution(Intersection it, Aggregate aggregate, ArrayList<LightVector> l)
    {
        Point3 ow = super.toWorldSpace(new Point3(0.0f, 0.0f, 0.0f));
        Ray3 rw = new Ray3(it.Pw, ow);
        float d2 = rw.D.lengthSquared();
        float d = (float)Math.sqrt(d2);
        rw.D.multiplyBy(1.0f/d);
        if (!aggregate.testIntersection(rw, d))
        {
            float id2 = 1.0f/d2;
            AColor c = new AColor(P.R*id2, P.G*id2, P.B*id2);
            l.add(new LightVector(rw.D, c));
        }
    }
    
}

package aino.light;

import aino.entity.Aggregate;
import aino.entity.Intersection;
import aino.math.geometry3.CoordinateSystem3;
import aino.material.LightVector;
import java.util.ArrayList;

public abstract class Light extends CoordinateSystem3
{
    public Light() {}
    public abstract void collectContribution(Intersection it, Aggregate aggregate, ArrayList<LightVector> l);
}


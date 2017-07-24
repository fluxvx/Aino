package aino.material;

import aino.math.geometry3.Vector3;

public class LightVector extends Vector3
{
    public AColor color;
    public LightVector(Vector3 v, AColor c)
    {
        super(v);
        color = c;
    }
}
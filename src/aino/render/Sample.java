package aino.render;

import aino.math.geometry2.Point2;

public class Sample extends Point2
{
    public float weight;
    public Sample(float x, float y, float w)
    {
        super(x, y);
        weight = w;
    }
}
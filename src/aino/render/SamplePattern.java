package aino.render;

import aino.math.geometry2.Point2;

public interface SamplePattern
{
    public Point2[] generateSamples();
    public boolean isConstant();
}

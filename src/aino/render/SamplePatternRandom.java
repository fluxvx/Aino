package aino.render;

import aino.math.AMath;
import aino.math.geometry2.Point2;

public class SamplePatternRandom implements SamplePattern
{
    private int n_samples;
    public SamplePatternRandom(int n)
    {
        n_samples = n;
    }
    
    public Point2[] generateSamples()
    {
        Point2[] samples = new Point2[n_samples];
        for (int i=0; i<samples.length; ++i)
        {
            samples[i] = new Point2(AMath.random(), AMath.random());
        }
        return samples;
    }
    
    public boolean isConstant()
    {
        return false;
    }
    
}

package aino.render;

import aino.math.AMath;
import aino.math.geometry2.Point2;

public class SamplePatternStratified implements SamplePattern
{
    private int n;
    private Point2[] basis;
    private float sample_scale;
    public SamplePatternStratified(int n)
    {
        this.n = n;
        basis = (new SamplePatternUniform(n)).generateSamples();
        sample_scale = 1.0f/n;
    }
    
    
    public Point2[] generateSamples()
    {
        Point2[] samples = new Point2[basis.length];
        for (int i=0, k=0; i<n; ++i)
        {
            for (int j=0; j<n; ++j, ++k)
            {
                float x = basis[k].X + (AMath.random()-0.5f)*sample_scale;
                float y = basis[k].Y + (AMath.random()-0.5f)*sample_scale;
                samples[k] = new Point2(x, y);
            }
        }
        return samples;
    }
    
    public boolean isConstant()
    {
        return false;
    }

}

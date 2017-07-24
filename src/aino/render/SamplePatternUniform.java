package aino.render;

import aino.math.geometry2.Point2;

public class SamplePatternUniform implements SamplePattern
{
    private Point2[] samples;
    public SamplePatternUniform(int n)
    {
        samples = new Point2[n*n];
        float scale = 1.0f / n;
        for (int i=0; i<n; ++i)
        {
            for (int j=0; j<n; ++j)
            {
                int k = i*n + j;
                float x = 0.5f*scale + i*scale;
                float y = 0.5f*scale +  j*scale;
                samples[k] = new Point2(x, y);
            }
        }
    }
    
    public Point2[] generateSamples()
    {
        return samples;
    }
    
    public boolean isConstant()
    {
        return true;
    }
}
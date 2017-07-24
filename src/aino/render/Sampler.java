package aino.render;

import aino.math.Function3;
import aino.math.geometry2.Point2;

public class Sampler
{
    private Sample[] samples;
    public SamplePattern sample_pattern;
    public Function3 filter;
    public Sampler(SamplePattern sp, Function3 f)
    {
        sample_pattern = sp;
        filter = f;
        if (sample_pattern.isConstant())
        {
            samples = Sampler.generateSamples(sample_pattern, filter);
        }
        else
        {
            samples = null;
        }
    }
    public Sample[] generateSamples()
    {
        if (samples == null)
        {
            return Sampler.generateSamples(sample_pattern, filter);
        }
        return samples;
    }
    
    public static Sample[] generateSamples(SamplePattern sample_pattern, Function3 filter)
    {
        Point2[] p = sample_pattern.generateSamples();
        Sample[] samples = new Sample[p.length];
        float ws = 0.0f;
        for (int i=0;  i<samples.length; ++i)
        {
            float w = filter.Z(p[i].X-0.5f, p[i].Y-0.5f);
            samples[i] = new Sample(p[i].X, p[i].Y, w);
            ws += w;
        }
        float iws = 1.0f / ws; // normalize the weights
        for (int i=0; i<samples.length; ++i)
        {
            samples[i].weight *= iws;
        }
        return samples;
    }
    
    public static Function3 createBoxFilter()
    {
        return new Function3()
        {
            public float Z(float x, float y)
            {
                return 1.0f;
            }
        };
    }
    
    public static Function3 createTriangleFilter()
    {
        return new Function3()
        {
            public float Z(float x, float y)
            {
                return Math.max(0.0f, 1.0f-Math.abs(x))*Math.max(0.0f, 1.0f - Math.abs(y));
            }
        };
    }
    
    
    public static Function3 createGaussianFilter(float a)
    {
        return new GaussianFilter(a);
    }
    public static Function3 createGaussianFilter(float width, float height, float a)
    {
        return new GaussianFilter(width, height, a);
    }
    
    private static class GaussianFilter implements Function3
    {
        private float a, ex, ey;
        public GaussianFilter(float a)
        {
            this(1.0f, 1.0f, a);
        }
        public GaussianFilter(float xw, float yw, float a)
        {
            this.a = a;
            ex = (float)Math.exp(-a*xw*xw);
            ey = (float)Math.exp(-a*yw*yw);
            
        }
        private float gaussian(float v, float ev)
        {
            return Math.max(0.0f, (float)Math.exp(-a*v*v) - ev);
        }
        public float Z(float x, float y)
        {
            return gaussian(x, ex)*gaussian(y, ey);
        }    
    }
    
}

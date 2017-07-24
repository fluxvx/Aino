package aino.material;

import aino.math.AMath;
import aino.math.geometry3.Vector3;
import aino.entity.Intersection;
import aino.entity.SurfaceGeometry;
import aino.render.Renderer;
import java.util.ArrayList;

public class AColor implements Material
{
    public float R, G, B;
    
    public AColor(float c)
    {
        R = G = B = c;
    }
    public AColor(float r, float g, float b)
    {
        R = r;
        G = g;
        B = b;
    }
    
    public AColor(AColor c)
    {
        R = c.R;
        G = c.G;
        B = c.B;
    }
    
    
    
    public void clamp()
    {
        R = AMath.clamp(R);
        G = AMath.clamp(G);
        B = AMath.clamp(B);
    }
    
    
    
    
    public AColor add(AColor c)
    {
        return new AColor(R+c.R, G+c.G, B+c.B);
    }
    
    
    public AColor multiply(float c)
    {
        return new AColor(R*c, G*c, B*c);
    }
    public AColor multiply(AColor c)
    {
        return new AColor(R*c.R, G*c.G, B*c.B);
    }
    
    
    
    public AColor getColor(Vector3 v, SurfaceGeometry s, Intersection it, ArrayList<LightVector> radiance, Renderer renderer)
    {
        return new AColor(this);
    }
    
    public boolean needsLight()
    {
        return false;
    }

}

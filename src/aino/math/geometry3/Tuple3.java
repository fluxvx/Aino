package aino.math.geometry3;

public class Tuple3
{
    public float X, Y, Z;
    public Tuple3()
    {
        X = Y = Z = 0.0f;
    }
    public Tuple3(float x, float y, float z)
    {
        X = x;
        Y = y;
        Z = z;
    }
    public Tuple3(Tuple3 t)
    {
        X = t.X;
        Y = t.Y;
        Z = t.Z;
    }
    
    public float get(int i)
    {
        return (i == 0)? X: (i == 1)? Y: Z;
    }
    public void set(int i, float v)
    {
        if (i == 0)
        {
            X = v;
        }
        else if (i == 1)
        {
            Y = v;
        }
        else
        {
            Z = v;
        }
    }
    
    
    
    public float distanceSquaredTo(Tuple3 t)
    {
        float x = X - t.X;
        float y = Y - t.Y;
        float z = Z - t.Z;
        return x*x + y*y + z*z;
    }
    public float distanceTo(Tuple3 t)
    {
        return (float)Math.sqrt(distanceSquaredTo(t));
    }
    
    
    
    public Vector3 add(Tuple3 t)
    {
        return new Vector3(X + t.X, Y + t.Y, Z + t.Z);
    }
    public Vector3 subtract(Tuple3 t)
    {
        return new Vector3(X-t.X, Y-t.Y, Z-t.Z);
    }
    
    
    
    
    public void addBy(Tuple3 t)
    {
        X += t.X;
        Y += t.Y;
        Z += t.Z;
    }
    
    public Tuple3 multiply(Tuple3 t)
    {
        return new Tuple3(X*t.X, Y*t.Y, Z*t.Z);
    }
    
    public Tuple3 multiply(float t)
    {
        return new Tuple3(X*t, Y*t, Z*t);
    }
    
    
    public void multiplyBy(Tuple3 t)
    {
        X *= t.X;
        Y *= t.Y;
        Z *= t.Z;
    }
    public void multiplyBy(float t)
    {
        X *= t;
        Y *= t;
        Z *= t;
    }
    
    
    
    public float lengthSquared()
    {
        return X*X + Y*Y + Z*Z;
    }
    public float length()
    {
        return (float)Math.sqrt(lengthSquared());
    }
    
    public void normalize()
    {
        float il = 1.0f/length();
        X *= il;
        Y *= il;
        Z *= il;
    }
    
    public void negate()
    {
        X = -X;
        Y = -Y;
        Z = -Z;
    }

    public float dot(Tuple3 t)
    {
        return X*t.X + Y*t.Y + Z*t.Z;
    }
    
    public Vector3 cross(Tuple3 t)
    {
        return new Vector3(Y*t.Z - Z*t.Y, 
                            Z*t.X - X*t.Z,
                            X*t.Y - Y*t.X);
    }
    
    
    
    public Vector3 reflectAcross(Tuple3 n)
    {
        float cosI = dot(n);
        float rx = -X + 2*cosI*n.X;
        float ry = -Y + 2*cosI*n.Y;
        float rz = -Z + 2*cosI*n.Z;
        return new Vector3(rx, ry, rz);
        
        /*
        float dd = 2*dot(n);
        float rx = -X - dd*n.X;
        float ry = -Y - dd*n.Y;
        float rz = -Z - dd*n.Z;
        return new Vector3(-rx, -ry, -rz);*/
    }
    
    
    
    public Tuple3[] formBasis()
    {
        Tuple3 vx, vy, vz;
        vz = this;
        if (Math.abs(vz.X) > Math.abs(vz.Y))
        {
            float inv_len = 1.0f/(float)Math.sqrt(vz.X*vz.X + vz.Z*vz.Z);
            vy = new Vector3(-vz.Z*inv_len, 0.0f, vz.X*inv_len);
        }
        else
        {
            float inv_len = 1.0f/(float)Math.sqrt(vz.Y*vz.Y + vz.Z*vz.Z);
            vy = new Vector3(0.0f, vz.Z*inv_len, -vz.Y*inv_len);
        }
        vx = vz.cross(vy);
        return new Tuple3[]{vx, vy};
    }
    
    
    public String toString()
    {
        return "{"+X+","+Y+","+Z+"}";
    }
}

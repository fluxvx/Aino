package aino.math.geometry3;

public class Point3
{
	public float X, Y, Z;
	public Point3()
	{
		X = 0.0f;
		Y = 0.0f;
		Z = 0.0f;
	}
	public Point3(float x, float y, float z)
    {
        X = x;
		Y = y;
		Z = z;
	}
	public Point3(Point3 p)
    {
        X = p.X;
        Y = p.Y;
        Z = p.Z;
    }
    public float distanceSquaredTo(Point3 t)
    {
        float x = X - t.X;
        float y = Y - t.Y;
        float z = Z - t.Z;
        return x*x + y*y + z*z;
    }
    public float distanceTo(Point3 t)
    {
        return (float)Math.sqrt(distanceSquaredTo(t));
    }
}

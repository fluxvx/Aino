package aino.math.geometry3;

public class Translate3 extends Transform3
{
    public float Tx, Ty, Tz;
    public Translate3(float tx, float ty, float tz)
    {
        Tx = tx;
        Ty = ty;
        Tz = tz;
    }
    public Point3 toWorldSpace(Point3 p)
    {
        return new Point3(p.X + Tx, p.Y + Ty, p.Z + Tz);
    }
    public Point3 toObjectSpace(Point3 p)
    {
        return new Point3(p.X - Tx, p.Y - Ty, p.Z - Tz);
    }
    public Vector3 toWorldSpace(Vector3 v)
    {
        return new Vector3(v);
    }
    public Vector3 toObjectSpace(Vector3 v)
    {
        return new Vector3(v);
    }
    public Normal3 toWorldSpace(Normal3 n)
    {
        return new Normal3(n);
    }
    public Normal3 toObjectSpace(Normal3 n)
    {
        return new Normal3(n);
    }
}


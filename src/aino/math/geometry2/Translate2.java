package aino.math.geometry2;

public class Translate2 implements Transform2
{
    public float Tx, Ty;
    public Translate2(float tx, float ty)
    {
        Tx = tx;
        Ty = ty;
    }
    public Point2 transform(Point2 p)
    {
        return new Point2(p.X+Tx, p.Y+Ty);
    }
    public Point2 invert(Point2 p)
    {
        return new Point2(p.X-Tx, p.Y-Ty);
    }
    public Vector2 transform(Vector2 v)
    {
        return new Vector2(v);
    }
    public Vector2 invert(Vector2 v)
    {
        return new Vector2(v);
    }
}
package aino.math.geometry2;

public class Scale2 implements Transform2
{
    public float Sx, Sy;
    public Scale2(float sx, float sy)
    {
        Sx = sx;
        Sy = sy;
    }
    public Point2 transform(Point2 p)
    {
        return new Point2(p.X*Sx, p.Y*Sy);
    }
    public Point2 invert(Point2 p)
    {
        return new Point2(p.X/Sx, p.Y/Sy);
    }
    public Vector2 transform(Vector2 v)
    {
        return new Vector2(v.X*Sx, v.Y*Sy);
    }
    public Vector2 invert(Vector2 v)
    {
        return new Vector2(v.X/Sx, v.Y/Sy);
    }

}


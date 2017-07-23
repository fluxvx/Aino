package aino.math.geometry2;

public final class Rotate2 implements Transform2
{
    private float angle;
    private float cosa, sina;
    
    public Rotate2(float a)
    {
        setAngle(a);
    }
    
    public float getAngle()
    {
        return angle;
    }
    public void setAngle(float a)
    {
        angle = a;
        cosa = (float)(Math.cos(angle));
        sina = (float)(Math.sin(angle));
    }
    public Point2 transform(Point2 p)
    {
        return new Point2(p.X*cosa + p.Y*sina, -p.X*sina + p.Y*cosa);
    }
    public Point2 invert(Point2 p)
    {
        return new Point2(p.X*cosa - p.Y*sina, p.X*sina + p.Y*cosa);
    }
    public Vector2 transform(Vector2 v)
    {
        return new Vector2(v.X*cosa + v.Y*sina, -v.X*sina + v.Y*cosa);
    }
    public Vector2 invert(Vector2 v)
    {
        return new Vector2(v.X*cosa - v.Y*sina, v.X*sina + v.Y*cosa);
    }

}
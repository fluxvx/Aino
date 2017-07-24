package aino.math.geometry2;

public class Point2 extends Tuple2
{
    public Point2()
    {
        super(0.0f, 0.0f);
    }
    public Point2(float x, float y)
    {
        super(x, y);
    }
    public Point2(Tuple2 t)
    {
        super(t);
    }
    public float dydx(Point2 p)
    {
        return (Y-p.Y)/(X-p.X);
    }
}

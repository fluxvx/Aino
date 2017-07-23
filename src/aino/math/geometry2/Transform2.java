package aino.math.geometry2;

public interface Transform2
{
    public abstract Point2 transform(Point2 p);
    public abstract Point2 invert(Point2 p);
    
    public abstract Vector2 transform(Vector2 v);
    public abstract Vector2 invert(Vector2 v);
}

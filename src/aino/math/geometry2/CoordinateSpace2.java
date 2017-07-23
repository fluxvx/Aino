package aino.math.geometry2;

import java.util.ArrayList;

public class CoordinateSpace2 implements Transform2
{
    public ArrayList<Transform2> transforms;
    
    public CoordinateSpace2()
    {
        transforms = new ArrayList<Transform2>();
    }
    
    public void add(Transform2 t)
    {
        transforms.add(t);
    }
    
    public void translate(float x, float y)
    {
        transforms.add(new Translate2(x, y));
    }
    
    public void scale(float x, float y)
    {
        transforms.add(new Scale2(x, y));
    }
    
    public void rotate(float a)
    {
        transforms.add(new Rotate2(a));
    }
    
    public Point2 transform(Point2 p)
    {
        for (int i=0; i<transforms.size(); ++i)
        {
            p = transforms.get(i).transform(p);
        }
        return p;
    }
    
    public Point2 invert(Point2 p)
    {
        for (int i=transforms.size()-1; i>=0; --i)
        {
            p = transforms.get(i).invert(p);
        }
        return p;
    }
    
    public Vector2 transform(Vector2 v)
    {
        for (int i=0; i<transforms.size(); ++i)
        {
            v = transforms.get(i).transform(v);
        }
        return v;
    }
    
    public Vector2 invert(Vector2 v)
    {
        for (int i=transforms.size()-1; i>=0; --i)
        {
            v = transforms.get(i).invert(v);
        }
        return v;
    }
}
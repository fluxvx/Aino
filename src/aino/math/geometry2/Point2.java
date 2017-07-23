package aino.math.geometry2;

public class Point2
{
	public float X, Y;
	public Point2()
	{
		X = 0.0f;
		Y = 0.0f;
	}
	public Point2(float x, float y)
	{
		X = x;
		Y = y;
	}
	public float distance(Point2 p)
	{
		float dx = X - p.X;
		float dy = Y - p.Y;
		return (float)Math.sqrt(dx*dx + dy*dy);
	}
}

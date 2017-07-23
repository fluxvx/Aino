package aino.math.geometry2;

public class Vector2
{
	public float X, Y;
	public Vector2()
	{
		X = 0.0f;
		Y = 0.0f;
	}
	public Vector2(float x, float y)
	{
		X = x;
		Y = y;
	}
	public Vector2(Vector2 v)
	{
		X = v.X;
		Y = v.Y;
	}
	public float length()
	{
		return (float)Math.sqrt(X*X + Y*Y);
	}
}

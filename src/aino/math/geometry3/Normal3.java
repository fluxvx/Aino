package aino.math.geometry3;

public class Normal3
{
	public float X, Y, Z;
	public Normal3()
	{
		X = 0.0f;
		Y = 0.0f;
		Z = 0.0f;
	}
	public Normal3(float x, float y, float z)
	{
		X = x;
		Y = y;
		Z = z;
	}
	public Normal3(Normal3 n)
	{
		X = n.X;
		Y = n.Y;
		Z = n.Z;
	}
}

package aino.math.geometry2;

public class Tuple2
{
	public float X, Y;
    public Tuple2()
    {
        X = 0.0f;
        Y = 0.0f;
    }
    public Tuple2(float x, float y)
    {
        X = x;
        Y = y;
    }
    public Tuple2(Tuple2 t)
    {
        X = t.X;
        Y = t.Y;
    }
}

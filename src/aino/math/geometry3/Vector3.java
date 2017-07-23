package aino.math.geometry3;

public class Vector3
{
	public float X, Y, Z;
	public Vector3()
	{
		X = 0.0f;
		Y = 0.0f;
		Z = 0.0f;
	}
	public Vector3(float x, float y, float z)
	{
		X = x;
		Y = y;
		Z = z;
	}
	public Vector3(Vector3 v)
	{
		X = v.X;
		Y = v.Y;
		Z = v.Z;
	}
	public Vector3(Point3 p0, Point3 p1)
	{
		X = p1.X - p0.X;
		Y = p1.Y - p0.Y;
		Z = p1.Z - p0.Z;
	}

	public float lengthSquared()
	{
		return X*X + Y*Y + Z*Z;
	}
	public float length()
	{
		return (float)Math.sqrt(lengthSquared());
	}

	public void normalize()
	{
		float il = 1.0f/length();
		X *= il;
		Y *= il;
		Z *= il;
	}

	public void negate()
	{
		X = -X;
		Y = -Y;
		Z = -Z;
	}

	public float dot(Vector3 t)
	{
		return X*t.X + Y*t.Y + Z*t.Z;
	}

	public Vector3 cross(Vector3 t)
	{
		return new Vector3(Y*t.Z - Z*t.Y,
				Z*t.X - X*t.Z,
				X*t.Y - Y*t.X);
	}



	public Vector3 reflectAcross(Vector3 n)
	{
		float cosI = dot(n);
		float rx = -X + 2*cosI*n.X;
		float ry = -Y + 2*cosI*n.Y;
		float rz = -Z + 2*cosI*n.Z;
		return new Vector3(rx, ry, rz);

        /*
        float dd = 2*dot(n);
        float rx = -X - dd*n.X;
        float ry = -Y - dd*n.Y;
        float rz = -Z - dd*n.Z;
        return new Vector3(-rx, -ry, -rz);*/
	}
	
	public Vector3[] formBasis()
	{
		Vector3 vx, vy, vz;
		vz = this;
		if (Math.abs(vz.X) > Math.abs(vz.Y))
		{
			float inv_len = 1.0f/(float)Math.sqrt(vz.X*vz.X + vz.Z*vz.Z);
			vy = new Vector3(-vz.Z*inv_len, 0.0f, vz.X*inv_len);
		}
		else
		{
			float inv_len = 1.0f/(float)Math.sqrt(vz.Y*vz.Y + vz.Z*vz.Z);
			vy = new Vector3(0.0f, vz.Z*inv_len, -vz.Y*inv_len);
		}
		vx = vz.cross(vy);
		return new Vector3[]{vx, vy};
	}

}

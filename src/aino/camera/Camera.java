package aino.camera;

import aino.math.geometry2.CoordinateSpace2;
import aino.math.geometry3.CoordinateSystem3;
import aino.math.geometry3.Ray3;

public abstract class Camera extends CoordinateSystem3
{
    public CoordinateSpace2 screen_space;
    public Camera()
    {
        screen_space = new CoordinateSpace2();
    }
    public abstract Ray3 generateRay(float x, float y, float w, float h);
}

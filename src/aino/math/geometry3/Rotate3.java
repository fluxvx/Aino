package aino.math.geometry3;

public class Rotate3 extends CoordinateSystem3
{
    public RotateXY XY;
    public RotateXZ XZ;
    public RotateYZ YZ;
    public Rotate3(float xy, float xz, float yz)
    {
        XY = new RotateXY(xy);
        XZ = new RotateXZ(xz);
        YZ = new RotateYZ(yz);
        add(XY);
        add(XZ);
        add(YZ);
    }
    
    
    public HMTransform3 toHMTransform()
    {
        HMTransform3 r = new HMTransform3();
        r.setAsRotator(XY.alpha, XZ.alpha, YZ.alpha);
        return r;
    }
}

package aino.material;

import aino.math.geometry3.Vector3;
import aino.entity.Intersection;
import aino.entity.SurfaceGeometry;
import aino.render.Renderer;
import java.util.ArrayList;

public interface Material
{
    public AColor getColor(Vector3 v, SurfaceGeometry s, Intersection it, ArrayList<LightVector> radiance, Renderer renderer);
    public boolean needsLight();
}

package aino.render;

import aino.AImage;
import aino.Scene;
import aino.math.geometry3.Ray3;
import aino.entity.Intersection;
import aino.material.AColor;
import aino.material.LightVector;
import java.util.ArrayList;

public interface Renderer
{
    public void render(Scene scene, AImage<AColor> image);
    public AColor traceRay(Ray3 ray);
    public ArrayList<LightVector> gatherRadiance(Intersection it);
}

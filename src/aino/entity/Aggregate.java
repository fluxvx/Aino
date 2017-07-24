package aino.entity;

import aino.math.geometry3.Box3;
import aino.material.AColor;
import aino.render.Renderer;
import java.util.ArrayList;

public abstract class Aggregate extends Entity
{
    public ArrayList<Entity> entities;
    public Aggregate()
    {
        entities = new ArrayList<Entity>();
    }
    public abstract void beginAdd();
    public void add(Entity intersectable)
    {
        entities.add(intersectable);
    }
    public abstract void finishAdd();
    
    public AColor getColor(Intersection it, Renderer renderer)
    {
        return null;
    }
    
    public Box3 getBounds()
    {
        Box3 r = null;
        for (int i=0; i<entities.size(); ++i)
        {
            if (r == null)
            {
                r = entities.get(i).getBounds();
            }
            else
            {
                r.unionWith(entities.get(i).getBounds());
            }
        }
        return r;
    }
}

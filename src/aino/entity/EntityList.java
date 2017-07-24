package aino.entity;

import aino.math.geometry3.Ray3;

public class EntityList extends Aggregate
{
    public EntityList() {}
    
    public boolean testIntersection(Ray3 rw, float d)
    {
        for (int i=0; i<entities.size(); ++i)
        {
            Entity entity = entities.get(i);
            Ray3 ro = entity.toObjectSpace(rw);
            if (entity.testIntersection(ro, d))
            {
                return true;
            }
        }
        return false;
    }
    
    public Intersection getIntersection(Ray3 rw)
    {
        Intersection r = null;
        for (int i=0; i<entities.size(); ++i)
        {
            Entity entity = entities.get(i);
            Ray3 ro = entity.toObjectSpace(rw);
            Intersection t = entity.getIntersection(ro);
            if (r == null || (t != null && t.T < r.T))
            {
                r = t;
            }
        }
        
        if (r != null) r.add(this);
        
        return r;
    }
    
    public void beginAdd() {}
    public void finishAdd() {}

    

    

}

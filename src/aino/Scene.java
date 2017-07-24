package aino;

import aino.camera.Camera;
import aino.entity.Aggregate;
import aino.entity.Entity;
import aino.entity.EntityList;
import aino.light.Light;
import aino.material.AColor;
import java.util.ArrayList;

public class Scene
{
    public String name;
    public Aggregate aggregate;
    public ArrayList<Camera> cameras;
    public ArrayList<Light> lights;
    public int current_camera_id;
    public AColor background_color;
    public Scene(String name)
    {
        this.name = name;
        
        aggregate = new EntityList();
        
        cameras = new ArrayList<Camera>();
        current_camera_id = -1;
        
        
        lights = new ArrayList<Light>();
        
        
        background_color = new AColor(0.0f);
    }
    
    public void add(Entity entity)
    {
        aggregate.add(entity);
    }
    
    public void add(Camera camera)
    {
        cameras.add(camera);
        current_camera_id = cameras.size() - 1;
    }
    
    public void add(Light light)
    {
        lights.add(light);
    }
    
    
    public Camera getCurrentCamera()
    {
        return (current_camera_id < 0)? null: cameras.get(current_camera_id);
    }
    
}
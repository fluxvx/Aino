package aino;

import aino.math.AMath;
import aino.camera.Camera;
import aino.camera.SimpleCamera;
import aino.entity.Cube;
import aino.entity.Sphere;
import aino.light.Light;
import aino.light.PointLight;
import aino.math.geometry2.Scale2;
import aino.math.geometry3.Translate3;
import aino.material.AColor;
import aino.material.DiffuseReflection;
import aino.render.BackwardRayTracer;
import aino.render.BooleanRenderer;
import aino.render.Renderer;
import aino.render.SamplePatternStratified;
import aino.render.Sampler;
import java.awt.Color;

public class Aino
{
	public static void main(String[] args)
	{
		System.out.println("seed: "+AMath.seedRNG());
		
		Scene scene = new Scene("scene1");
		
		Camera camera = new SimpleCamera(50.0f);
        camera.add(new Translate3(0, 0, -50.0f));
		camera.screen_space.transforms.add(new Scale2(60.0f, 60.0f));
        scene.add(camera);
		
		Light light = new PointLight(new AColor(3000.0f));
		light.transforms.add(new Translate3(50, 50, -50));
		scene.add(light);
		
		Sphere sphere = new Sphere(20, new DiffuseReflection(new AColor(1.0f)));
		scene.add(sphere);
		
		Cube cube = new Cube(100, new DiffuseReflection(new AColor(1.0f)));
		scene.add(cube);
		
		
		Sampler sampler = new Sampler(new SamplePatternStratified(4),
										Sampler.createGaussianFilter(1.0f));
		Renderer renderer = new BackwardRayTracer(sampler);
		AImage<AColor> render = new AImage<AColor>(1000, 1000);
		renderer.render(scene, render);
		
		ImageManager.save(render);
		ImageManager.show(render);
	}

	
	public static boolean isValid(float t)
    {
        return t > 1.0E-3f;
    }

}

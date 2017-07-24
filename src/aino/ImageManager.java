package aino;

import aino.gui.ImagePanel;
import aino.material.AColor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageManager
{
	public static void save(AImage<AColor> img)
	{
		Date date = new Date() ;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		save("render" + format.format(date), img);
	}
    
    public static void save(String name, AImage<AColor> img)
    {
        BufferedImage image = new BufferedImage(img.width(), img.height(), BufferedImage.TYPE_INT_RGB);
        for (int i=0; i<img.width(); ++i)
        {
            for (int j=0; j<img.height(); ++j)
            {
                Color color = AColorToColor(img.get(i, j));
                image.setRGB(i, j, color.getRGB());
            }
        }
        save(name, image);
    }
    
    
    private static Color AColorToColor(AColor c)
    {
        c.clamp();
        int r = (int)(c.R*255);
        int g = (int)(c.G*255);
        int b = (int)(c.B*255);
        return new Color(r, g, b);
    }
    
    private static void save(String name, BufferedImage image)
    {
        // String default_path = System.getProperty("user.dir");
        File file = new File("./renders/"+name+".png");
        file.mkdirs();
        try
        {
            ImageIO.write(image, "png", file);
        }
        catch (IOException ex)
        {
			ex.printStackTrace();
        }
    }
	
	
	
	public static void show(AImage<AColor> render)
	{
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        ImagePanel image_panel = new ImagePanel();
        image_panel.setImage(render);
        frame.setLayout(new BorderLayout());
        frame.add(image_panel, BorderLayout.CENTER);
        
        
        frame.setSize(render.width()+100, render.height()+100);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}

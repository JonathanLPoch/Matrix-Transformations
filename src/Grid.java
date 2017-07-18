import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.IOException;

public class Grid {
	private BufferedImage grid;
	private int x,y,height,width;
	 public Grid(int x, int y)
	    {
	    	InputStream input = getClass().getResourceAsStream("Grid.jpg");
	    	try
	    	{
	    		this.grid = ImageIO.read(input);
	    	}
	    	catch(IOException ie)
	    	{
	    	}
	    	this.x = x;
	    	this.y = y;
	    	this.width = grid.getWidth();
	    	this.height = grid.getHeight();
	    }
	 public Rectangle getBounds() 
	    {
			return new Rectangle(x, y, width, height);
		}
	 public BufferedImage getImage()
	    {
	    	return grid;
	    }
	    
	    
	    public int getX()
	    {
	    	return x;
	    }
	    
	    public int getY()
	    {
	    	return y;
	    }    
	    
	    public int getWidth()
	    {
	    	return width;
	    }
	    public int getHeight()
	    {
	    	return height;
	    }
}

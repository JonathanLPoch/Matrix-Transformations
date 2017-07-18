/*
 * Jonathan Poch
 * Naoman
 * Joel Sakyi
 */
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.IOException;
public class Point 
{
	private BufferedImage p;
	private int x,y,height,width;
	public Point(int x, int y)
	{
		InputStream input = getClass().getResourceAsStream("Coordinate.jpg");
    	try
    	{
    		this.p = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
    	this.x = x;
    	this.y = -y;
    	this.width = p.getWidth();
    	this.height = p.getHeight();
	}
	public void changeImage()
	{
		InputStream input = getClass().getResourceAsStream("Coordinate2.jpg");
    	try
    	{
    		this.p = ImageIO.read(input);
    	}
    	catch(IOException ie)
    	{
    	}
	}
	public Rectangle getBounds() 
    {
		return new Rectangle(x, y, width, height);
	}
	public BufferedImage getImage()
	{
	    return p;
	}
	public void setX(int x1)
	{
		x = x1;
	}
	public void setY(int y1)
	{
		y = y1;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public String toString()
	{
		String s = "("+getX()+", "+getY()+")";
		return s;
	}
}


/*
public class Grid {
	private BufferedImage grid;
	private int x,y,height,width;
	 public Grid(int x, int y)
	    {
	    	InputStream input = getClass().getResourceAsStream("Grid.jpg");
	    	System.out.println("**");
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
*/

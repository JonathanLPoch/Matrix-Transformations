import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.Timer;
public class MatrixTransformations extends JPanel implements ActionListener
{
	private Timer timer;
	private static int[][]trans = {{1,0},{0,1}};
	private static ArrayList<Point> inputs = new ArrayList<Point>();
	private static ArrayList<Point> out = new ArrayList<Point>();
	private static boolean display;
	private static boolean inputMatrix;
	private static boolean inputPoints;
	private static boolean clear;
	private static boolean apply;
	private Grid grid;
	public MatrixTransformations()
	{
		setFocusable(true);
		setBackground(Color.WHITE);
		setDoubleBuffered(true);
		grid = new Grid(0,0);
		timer = new Timer(100,this); //timer will call actionPerformed every 100 ms
		timer.start(); 
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.GREEN);
		g2d.drawLine(MatrixDisplay.BOARD_WIDTH/2,0,MatrixDisplay.BOARD_WIDTH/2,MatrixDisplay.BOARD_HEIGHT);
		g2d.drawLine(0,MatrixDisplay.BOARD_HEIGHT/2,MatrixDisplay.BOARD_WIDTH,MatrixDisplay.BOARD_HEIGHT/2);
		for(int k=0;k<inputs.size();k++)
		{
				g2d.drawImage(inputs.get(k).getImage(), inputs.get(k).getX()+MatrixDisplay.BOARD_WIDTH/2, inputs.get(k).getY()+MatrixDisplay.BOARD_HEIGHT/2, this);
				if(out.size()>0)
					g2d.drawImage(out.get(k).getImage(), out.get(k).getX(), out.get(k).getY(), this);
			if(k>0)
			{
				g2d.setColor(Color.ORANGE);
				g2d.drawLine(inputs.get(k-1).getX()+MatrixDisplay.BOARD_WIDTH/2, inputs.get(k-1).getY()+MatrixDisplay.BOARD_HEIGHT/2, inputs.get(k).getX()+MatrixDisplay.BOARD_WIDTH/2, inputs.get(k).getY()+MatrixDisplay.BOARD_HEIGHT/2);
				g2d.setColor(Color.BLUE);
				if(out.size()>0)
					g2d.drawLine(out.get(k-1).getX(), out.get(k-1).getY(), out.get(k).getX(), out.get(k).getY());
				g2d.setColor(Color.BLACK);
			}
			if(k==inputs.size()-1)
			{
				g2d.setColor(Color.ORANGE);
				g2d.drawLine(inputs.get(k-1).getX()+MatrixDisplay.BOARD_WIDTH/2, inputs.get(k-1).getY()+MatrixDisplay.BOARD_HEIGHT/2, inputs.get(0).getX()+MatrixDisplay.BOARD_WIDTH/2, inputs.get(0).getY()+MatrixDisplay.BOARD_HEIGHT/2);
				g2d.setColor(Color.BLUE);
				if(out.size()>0)
					g2d.drawLine(out.get(k).getX(), out.get(k).getY(), out.get(0).getX(), out.get(0).getY());
				g2d.setColor(Color.BLACK);
			}
		}
		g2d.drawString("X", MatrixDisplay.BOARD_WIDTH-15, MatrixDisplay.BOARD_HEIGHT/2);
		g2d.drawString("Y", MatrixDisplay.BOARD_WIDTH/2, 15);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	public static Point transform(Point p)
	{
		Point temp = new Point(trans[0][0]*p.getX() + trans[0][1]*p.getY(),trans[1][0]*p.getX() + trans[1][1]*p.getY());
		return temp;
	}
	public static void main(String[] args)
	{
		String s = "";
		int x = 0;
		int y = 0;
		String[] beans = new String[2];
		Scanner sc = new Scanner(System.in);
		System.out.println("How many points? ");
		int n = Integer.parseInt(sc.nextLine());
		for(int k=0;k<n;k++)
		{
			System.out.println("Enter a point x, y");
			s = sc.nextLine();
			beans = s.split(", ");
			x = Integer.parseInt(beans[0]);
			y = Integer.parseInt(beans[1]);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = "";
		int x = 0;
		int y = 0;
		String[] beans = new String[2];
		Scanner sc = new Scanner(System.in);
		if(inputMatrix)
		{
			System.out.println("Input a transformation matrix (2x2)");
			for(int k = 0; k < trans.length; k++)
			{
				for(int j = 0; j < trans[0].length; j++)
				{
					trans[k][j] = Integer.parseInt(sc.nextLine());
				}
			}
			inputMatrix = false;
		}
		if(inputPoints)
		{
			System.out.println("How many points? ");
			int n = Integer.parseInt(sc.nextLine());
			for(int k=0;k<n;k++)
			{
				System.out.println("Enter a point x, y");
				s = sc.nextLine();
				beans = s.split(", ");
				x = Integer.parseInt(beans[0]);
				y = Integer.parseInt(beans[1]);
				inputs.add(new Point(x,y));
			}
			inputPoints = false;
			//apply = true;
		}
		if(apply)
		{
			for(int k = 0; k < inputs.size(); k++)
			{
				out.add(MatrixTransformations.transform(inputs.get(k)));
				out.get(k).setX(out.get(k).getX()+MatrixDisplay.BOARD_WIDTH/2);
				out.get(k).setY(-1*(out.get(k)).getY()+MatrixDisplay.BOARD_HEIGHT/2);
				//out.get(k).changeImage();
			}
				apply = false;
		}
		if(clear)
		{
			//inputs = new ArrayList<Point>();
			out = new ArrayList<Point>();
			clear = false;
		}
		repaint();
	}
	public static void inputMatrix()
	{
		inputMatrix = true;
	}
	public static void inputPoints()
	{
		inputPoints = true;
	}
	public static void clear()
	{
		clear = true;
	}
	public static void apply()
	{
		apply = true;
	}
}
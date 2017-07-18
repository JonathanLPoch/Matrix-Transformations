import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MatrixDisplay extends JFrame 
	{
	private static final long serialVersionUID = -6983684920441887628L;
		public static final int BOARD_WIDTH = 700;
		public static final int BOARD_HEIGHT = 700;//470
		 private JPanel panel1;
		public MatrixDisplay()
		{
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(BOARD_WIDTH, BOARD_HEIGHT); 
			setLocationRelativeTo(null);
			setTitle("Matrix Transformations"); 
			MatrixTransformations mt = new MatrixTransformations();
			add(mt);
			setResizable(true);
			setVisible(true);
			setLayout(new BorderLayout());
		    panel1 = new JPanel();
		    panel1.setFocusable(false);
		    JButton a = new JButton("Input Transformation Matrix");//input trans: input points: Clear 
		    a.setFocusable(false);
		    a.addActionListener(new AListener());
		    panel1.add(a);
		    JButton b = new JButton("Input Points");
		    b.setFocusable(false);
		    b.addActionListener(new BListener());
		    panel1.add(b);
		    JButton c = new JButton("Clear");
		    c.setFocusable(false);
		    c.addActionListener(new CListener());
		    panel1.add(c);
		    JButton d = new JButton("Apply");
		    d.setFocusable(false);
		    d.addActionListener(new DListener());
		    panel1.add(d);
			add(panel1, BorderLayout.SOUTH); 
		}
		public static void main(String[] args) 
		{
			new MatrixDisplay();
		}
		private class AListener implements ActionListener
		   {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  MatrixTransformations.inputMatrix();
		      }
		   } 
		   private class BListener implements ActionListener
		   {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  MatrixTransformations.inputPoints();
		      }
		   }
		   private class CListener implements ActionListener
		   {
		      public void actionPerformed(ActionEvent e)
		      {          
		    	  MatrixTransformations.clear();
		      }
		   }
		   private class DListener implements ActionListener
		   {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  MatrixTransformations.apply();
		      }
		   
		   }
	}
/*
100, 100
50, 50
100, 50
50, 100
75, 100

50, 50
0, 0
50, 0
0, 50
25, 50

*/

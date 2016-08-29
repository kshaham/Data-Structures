// GUI-related imports

import java.awt.*;
import java.awt.event.*;


// File-related imports

import java.io.IOException;

import javax.swing.JOptionPane;


public class Project05 extends Frame implements ActionListener
{
	
	ArrayOperations arr = new ArrayOperations();
	
	String command = "";
	String[] description = new String[] {
			" This program receives the geometrical properties of a shape and calculates",
			"   and Displays the perimeter, area and other properties of the shape",
			" Input:",
			"      - Cartesian coordinates of the three endpoints of the triangle  ",
			" Output:",
			"      - Coordinates, sides, perimeter and area of the triangle"
		};
		
	public static void main(String[] args)
	{
		Frame frame = new Project05();
		
			
		frame.setResizable(false);
		frame.setSize(900,620);
		frame.setVisible(true);
		
	}
	
	public Project05()
	{
		setTitle("Recursive Routines");
		
		// Create Menu Bar and menu items
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		// Create Menu Group Labeled "File"
		
		Menu FileMenu = new Menu("File");
		
		// Add it to Menu Bar
		
		mb.add(FileMenu);
		
		// Create Menu Items
		// Add action Listener 
		// Add to "File" Menu Group
		
		MenuItem miOpen = new MenuItem("About");
		miOpen.addActionListener(this);
		FileMenu.add(miOpen);
						
		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		FileMenu.add(miExit);

		// Create Menu Group Labeled "File"
		
		Menu SearchMenu = new Menu("Functions");
		
		// Add it to Menu Bar
		
		mb.add(SearchMenu);
		
		// Create Menu Items
		// Add action Listener 
		// Add to "Search" Menu Group
		
		MenuItem miRecur = new MenuItem("Recursion");
		miRecur.addActionListener(this);
		SearchMenu.add(miRecur);
		
		MenuItem miGCF = new MenuItem("GCD");
		miGCF.addActionListener(this);
		SearchMenu.add(miGCF);
		
		MenuItem miHanoi = new MenuItem("Hanoi");
		miHanoi.addActionListener(this);
		SearchMenu.add(miHanoi);
		
			
		
		WindowListener l = new WindowAdapter()
		{
						
			public void windowClosing(WindowEvent ev)
			{
				System.exit(0);
			}
			
			public void windowActivated(WindowEvent ev)
			{
				repaint();
			}
			
			public void windowStateChanged(WindowEvent ev)
			{
				repaint();
			}
		
		};
		
		ComponentListener k = new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e) 
			{
        		repaint();           
    		}
		};
		
		// register listeners
			
		this.addWindowListener(l);
		this.addComponentListener(k);

	}
	
//******************************************************************************
//  called by windows manager whenever the application window performs an action
//  (select a menu item, close, resize, ....
//******************************************************************************

	public void actionPerformed (ActionEvent ev)
		{
			// figure out which command was issued
			
			command = ev.getActionCommand();
			
			// take action accordingly
			
			if ("About".equals(command))
			{
				repaint();
			}
			else
			if("Exit".equals(command))
			{
				System.exit(0);
			}
			else
			if("Recursion".equals(command))
			{
				arr.getsumN();
				repaint();
			}
			if("GCD".equals(command))
			{	
				arr.getbase();
				repaint();
			}
			if("Hanoi".equals(command))
			{
			arr.getAs();	
				repaint();
			}
		}
//********************************************************
// called by repaint() to redraw the screen
//********************************************************
		
		public void paint(Graphics g)
		{
									
			int x=200;
			int y=150;
			
			int ww = (int)this.getWidth();
			int wh = (int)this.getHeight() -40;
			
			if ("About".equals(command))
			{
				for (int i=0; i<6; i++)
				{
					g.drawString(description[i],x-120,y+40);
					y=y+25;
				}
			}
			
			
			if("Recursion".equals(command))
			{
				long startTime = System.nanoTime();
				g.drawString("Summation = "+Long.toString(arr.sum(arr.getN())), 255, 325);
				long estTime = System.nanoTime() - startTime;
				g.drawString("Execute time = "+estTime, x, y+250);
			}
			if("GCD".equals(command))
			{
				
				//g.drawString("K = "+Integer.toString(arr.n), x, y);
				g.drawString("X = "+arr.getX(), x, y+50);
				g.drawString("Y = "+arr.getY(), x, y+100);
				long startTime = System.nanoTime();
				g.drawString("GCD = "+arr.gCd(arr.getX(), arr.getY()), x, y+150);
				long estTime = System.nanoTime() - startTime;
				g.drawString("Execute time = "+estTime, x, y+250);
				
					
			}
			if("Hanoi".equals(command))
			{
				long startTime = System.nanoTime();
				arr.doTowers(arr.A, 'A', 'B', 'C');	
				long estTime = System.nanoTime() - startTime;
				g.drawString("Execute time = "+estTime, x, y+250);
			
		}


}	
}
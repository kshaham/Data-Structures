
// GUI-related imports

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends Frame implements ActionListener
{
	/**
	 * 
	 */
	//program description displayed in About menu
		String[] description = new String[]
				{
					"This program demonstrates the functionality ",
					"of a Linked List. "
				};
	private static final long serialVersionUID = 1L;
	String command = "";
	RandomNumberGenerator RN = new RandomNumberGenerator(0,100,1000);
	LinkedList            LL = new LinkedList();
	int                   position, value;
	String                input;
	Node                  location = new Node();
	Node				  foundNode = new Node();
	public static void main(String[] arg )
	{
		Frame frame = new Main();	
			
		frame.setResizable(false);
		frame.setSize(900,500);
		frame.setVisible(true);
	}
	
	public Main()
	{
		setTitle("Linked List Operations");
		
		// Create Menu Bar
		   			
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		// Create Menu Group Labeled "File"
		Menu FileMenu = new Menu("File");
		mb.add(FileMenu);
		
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		FileMenu.add(miAbout);
		
		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		FileMenu.add(miExit);
		
	// **** add menu items
		//Add Menu Items
		Menu AddMenu = new Menu("Add");
		mb.add(AddMenu);

		MenuItem miAddBeg = new MenuItem("Beginning");
		miAddBeg.addActionListener(this);
		AddMenu.add(miAddBeg);
		
		MenuItem miAddEnd = new MenuItem("End");
		miAddEnd.addActionListener(this);
		AddMenu.add(miAddEnd);
		
		MenuItem miAddAfterN = new MenuItem("Add after Nth node");
		miAddAfterN.addActionListener(this);
		AddMenu.add(miAddAfterN);
		
	// **** add menu items
		//Delete Menu Items
		Menu DeleteMenu = new Menu("Delete");
		mb.add(DeleteMenu);
		
		MenuItem miDeleteFirst = new MenuItem("First Node");
		miDeleteFirst.addActionListener(this);
		DeleteMenu.add(miDeleteFirst);
		
		MenuItem miDeleteLast = new MenuItem("Last Node");
		miDeleteLast.addActionListener(this);
		DeleteMenu.add(miDeleteLast);
		
		MenuItem miDeleteContent = new MenuItem("Given Content");
		miDeleteContent.addActionListener(this);
		DeleteMenu.add(miDeleteContent);
		
		MenuItem miDeletePosition = new MenuItem("Given Position");
		miDeletePosition.addActionListener(this);
		DeleteMenu.add(miDeletePosition);
		
		//Locate Menu Items
		Menu LocateMenu = new Menu("Locate");
		mb.add(LocateMenu);
		
		MenuItem miByContent = new MenuItem("By Content");
		miByContent.addActionListener(this);
		LocateMenu.add(miByContent);
		
		
		
		
		
		
		
	// **** add menu items
				
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
						
			
			//file menu
			if ("About".equals(command)){
				repaint();
			}
			else if ("Exit".equals(command)){
				System.exit(0);
			}
			
			//add menu
			if("Beginning".equals(command))
			{
				LL.AddToBeginning(RN.getRandomNumber());
				repaint();		
			}
			else if("End".equals(command)){
				LL.AddToEnd(RN.getRandomNumber());
				repaint();
			}
			else if("Add after Nth node".equals(command))
			{
				input = JOptionPane.showInputDialog("What is the value of N?");
				LL.AddAfterNthNode(RN.getRandomNumber(), Integer.parseInt(input));
				repaint();
			}
			
			//delete menu
			if ("First Node".equals(command)) {
				LL.DeleteFromBeginning();
				repaint();
			}
			else if ("Last Node".equals(command)) {
				LL.DeleteFromEnd();
				repaint();
			}
			else if("Given Content".equals(command)){
				input = JOptionPane.showInputDialog("What value would you like to delete?");
				LL.DeleteSpecificValue(Integer.parseInt(input));
				repaint();
			}
			else if("Given Position".equals(command)){
				input = JOptionPane.showInputDialog("Which position would you like to delete?");
				LL.DeleteSpecificNode(Integer.parseInt(input));
				repaint();
			}
			
			//locate menu
			if ("By Content".equals(command)) {
				input = JOptionPane.showInputDialog("What value would you like to find?");
				foundNode = LL.LocateNode(Integer.parseInt(input));
				repaint();
			}
			
		}
//********************************************************
// called by repaint() to redraw the screen
//********************************************************
		
		public void paint(Graphics g)
		{
			
			if ("About".equals(command)) 
			{
				int x = 250;
				int y = 150;
				for (int i=0; i<(description.length); i++)
				{
					g.drawString(description[i], x, y);
					y=y+25;
				}
			}
			else{
			
			if (LL.head == null)
			{
				g.drawString(" Empty List", 400, 250);
				return;
			}
			else
			{
				
				int rectX = 80;
				int rectY = 110;
				Node t= LL.head;
				g.drawString("Head", 50, 60);
				g.drawLine(60, 65, 100, 110);
				while (t != null)
				{
					g.drawLine(rectX+46, rectY+10, rectX+90, rectY+10);
					g.drawLine(rectX+85, rectY+5, rectX+90, rectY+10);
					g.drawLine(rectX+85, rectY+15, rectX+90, rectY+10);
					
					if ("By Content".equals(command))
					{
						if (t.data == foundNode.data) {
							g.setColor(Color.RED);
						}
					}
					g.drawRect(rectX, rectY, 40, 20);
					g.drawString(Integer.toString(t.data), rectX+10, rectY+15);
					g.setColor(Color.BLACK);
					rectX = rectX + 100;
					if(rectX > 700)
					{
						g.drawLine(rectX-10, rectY+10, rectX+20, rectY+10);
						g.drawLine(rectX+20, rectY+10, rectX+20, rectY+40);
						g.drawLine(rectX+20, rectY+40, 85, rectY+40);
						g.drawLine(85, rectY+40, 85, rectY+60);
						g.drawLine(85, rectY+60, 80, rectY+55);
						g.drawLine(85, rectY+60, 90, rectY+55);
						rectX = 80;
						rectY = rectY+70;
					}
					t = t.next;
				}
				g.drawString("End Of List", rectX, rectY+15);
			}
			}
			
			
			
		}
}
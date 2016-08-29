import javax.swing.JOptionPane;
public class LinkedList 
{
    Node head = null;
    Node tail = null;
    long  length;
    
    public LinkedList()
    {
        head = null; 
        tail = null;
        length = 0;
    }
     public void AddToBeginning(int number)
     {
         Node t = new Node();
         t.data = number;
         t.next = head;
         head = t;
    	 
     }
     public void AddToEnd(int number)
     {
     	Node end = new Node();
     	end.data = number;
     	Node t = head;
     	while (t.next != null)
     		t = t.next;
     	t.next = end;
     	end.next = null;
     }
     public void AddAfterNthNode(int number, int position)
     {
         Node n = new Node();
         n.data = number;
         Node t = head;
         for (int x = 1; x < position; x++)
         {
         	t = t.next;
         }
         n.next = t.next;
         t.next = n;
     }
     public void DeleteFromBeginning()
     {
         head = head.next;
     }
     public void DeleteFromEnd()
     {
     	Node t = head;
     	Node previous = new Node(); 
     	while (t.next != null)
     	{
     		previous = t;
     		t = t.next;
     	}
     	previous.next = null;
     	
     }
     public void DeleteSpecificNode(int arg)
     {
     	System.out.println(arg);
     	if (arg == 1)
     	{
     		head = head.next;
     		
     	}
     	
       else {
     	  
       Node t = head;
       Node prevNode = new Node();
       for (int x = 1; x<arg;x++)
       {
     	  prevNode = t;
     	  t = t.next;
     	  if (t == null)
     	  {
     		  JOptionPane.showMessageDialog(null, "Node not found");
     		  return;
     	  }
     		  
       }
       prevNode.next = t.next;
       }
     }
    public void DeleteSpecificValue(int arg)
    {
    	if (head.data == arg)
    	{
    		head = head.next;
    		return;
    	}
    	Node t = head;
    	Node prevNode = new Node();
    	while (t.next != null)
    	{
    		prevNode = t;
    		t = t.next;
    		if(t.data == arg)
    		{
    			prevNode.next = t.next;
    			return;
    		}
    		
    	}
    	JOptionPane.showMessageDialog(null, "Value not found.");
    	
    	
    }
    public Node LocateNode(int arg)
    {
    	if (head.data == arg)
    	{
    		return head;
    	}
    	Node t = head;
    	while (t.data != arg && t.next != null)
    	{
    		t = t.next;
    		if(t.data == arg)
    		{
    			return t;
    		}
    		
    	}
    	JOptionPane.showMessageDialog(null, "Value not found.");
    	return null;
    }
    public void Traverse()
    {
       
	   
    }
    
}
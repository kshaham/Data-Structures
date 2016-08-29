import javax.swing.*;
//File-related imports

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.math.*;

public class ArrayOperations
{


public int gcd;
int X1, Y1;
long N;
long estTime;
int A;
	public ArrayOperations()
    {   

    }   
public void getbase(){
	String input = JOptionPane.showInputDialog(null, "Please enter the first number:",
			"Enter X",	JOptionPane.QUESTION_MESSAGE);
	X1 = Integer.parseInt(input);
	String input2 = JOptionPane.showInputDialog(null, "Please enter the second number:",
			"Enter Y",	JOptionPane.QUESTION_MESSAGE);
	Y1 = Integer.parseInt(input2);
}
public void getsumN(){
	String input = JOptionPane.showInputDialog(null, "Please enter an integer:",
			"Enter N",	JOptionPane.QUESTION_MESSAGE);
	N = Long.parseLong(input);
}
public void getAs(){
	String input = JOptionPane.showInputDialog(null, "Please enter an integer:",
			"Enter A",	JOptionPane.QUESTION_MESSAGE);
	A = Integer.parseInt(input);
}
public int getX()
{
	return X1;

}
public int getY()
{
	return Y1;

}
public long getN()
{
	return N;

}
public int getA()
{
	return A;

}
    	public long sum(long n)
    	{
    		//JOptionPane.showMessageDialog( null, "Gives a stack overflow error in eclipse :(");
			if (n == 1)		                        // base case
    			return 1;
    		else
    			
    			return (n/(3*n - 1)) + sum(n - 1);	// general solution
		
    	}

public int gCd(int x, int y) {
	 long startTime = System.nanoTime();
	 
    if(y == 0) {
    	
        return x;
    }
    estTime = System.nanoTime() - startTime;
    return gCd(y, x%y);
}
public void haninput(){
	
	int a=Integer.parseInt(JOptionPane.showInputDialog("Number of Disks: "));
	 
	doTowers(a, 'A', 'B', 'C');
	
  }
public void doTowers(int topN, char from,
		   char inter, char to) {
		      if (topN == 1){
		    	  JOptionPane.showMessageDialog( null, "Disk 1 from "
		 		         + from + " to " + to );
		      }else {
		         doTowers(topN - 1, from, to, inter);
		         JOptionPane.showMessageDialog( null, "Disk "
		         + topN + " from " + from + " to " + to);
		         doTowers(topN - 1, inter, from, to);
		      }
		   
		}


}   
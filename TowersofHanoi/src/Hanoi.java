import java.util.Scanner;

public class Hanoi {
  
  static int [] a, b, c;

  static int numA, numB, numC;
	
	public static void main(String[] args) {
		
     Scanner console = new Scanner (System.in);
		
	 System.out.println("How many disks on needle 1?");
	 int n = console.nextInt();
	
	 a = new int[n];
	 b = new int[n];
	 c = new int[n];
	 
	 String pos1 = "1";
	 String pos2 = "2";
	 String pos3 = "3";
	 
	 moveDisks(n, a, b, c, pos1, pos3, pos2);
	 }
	public static void moveDisks(int n,int [] a,int [] c,int [] b, 
			                     String pos1, String pos3, String pos2){
	 numA = n;
	 numB = 0;
	 numC = 0;
	 if (n > 0){
	  moveDisks(n - 1, a, b, c, pos1, pos2, pos3);
	  System.out.println("Move disk " + n + " from needle " + pos1
	            + " to needle " + pos3 + ".");
          moveDisks(n - 1, b, c, a, pos2, pos3, pos1);
	 }
	}
}

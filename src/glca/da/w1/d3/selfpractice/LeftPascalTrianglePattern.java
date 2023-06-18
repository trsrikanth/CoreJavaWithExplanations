package glca.da.w1.d3.selfpractice;

import java.util.Scanner;  

/* 
 * Q2) Write a java program to print the left pascal triangle as shown below.
        *
	   **
	  ***
	 ****
	*****
	 ****
	  ***
	   **
	    *
 * 
*/
public class LeftPascalTrianglePattern  {  
//	1. Declare all the required variables
	int i, j, k, rows;  
	
//	2. cretae Scanner object
	Scanner sc = new Scanner(System.in);
	
//	3. create the required method
	public void printPattern() {
		// accept no of rows to print
		System.out.print("Enter the number of rows you want to print: ");  
		rows = sc.nextInt();
		
		//loop to print the first half of the pattern
		for (i= 1; i<= rows ; i++)  {  
			for (j=i; j <rows ;j++)  {  
				System.out.print(" ");  
			}  
			for (k=1; k<=i;k++)  {  
				System.out.print("*");   
			}   
			System.out.println("");   
		}   
		
//		loop to print the second half of the pattern
		for (i=rows; i>=1; i--)  {  
			for(j=i; j<=rows;j++)  {  
				System.out.print(" ");  
			}  
			for(k=1; k<i ;k++)  {  
				System.out.print("*");  
			}  
			System.out.println("");  
		}  
		sc.close();  
	}
	
	public static void main(String[] args)  {  
		
//		4. create an Object for the class 
		LeftPascalTrianglePattern obj = new LeftPascalTrianglePattern();
		
//		5. call the method to print the pattern
		obj.printPattern();
	}  
}  

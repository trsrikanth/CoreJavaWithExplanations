package glca.da.w1.d2.selfpractice;

import java.util.Scanner;

/*
 * Q3) Write a java program to print the left triangle star pattern as shown below:
 		 *
	    **
	   ***
	  ****
	 *****
	******
 */
public class Triangle_pattern {

    public static void main(String[] args) {
//    	1. create scanner object
    	Scanner sc = new Scanner(System.in);

//    	2. Read no of rows from user input
    	System.out.print("Enter the number of rows:");
    	int row = sc.nextInt();
    	
//    	3. Logic to print the pattern
    	for (int i = 1; i <= row ; i++) {
    		for (int j = 1; j <= row - i; j++) {
    			System.out.print(" ");
    	    }
    	    for (int k = 1; k <= i; k++) {
    	        System.out.print("*");
    	    }
    	    System.out.println("");
    	}
    }
}


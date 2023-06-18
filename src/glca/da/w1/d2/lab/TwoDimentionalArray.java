package glca.da.w1.d2.lab;

import java.util.Scanner;

/*
 * Q3) Write a program to accept a Number from the user and multiply it with 2D Array values and 
 * make sure the output is also in 2D format after multiplication. 
 * You can hardcode the values of 2D Array, if you wish. Make use of for or for..each loop.
 */
public class TwoDimentionalArray {

	public static void main(String[] args) {
//		1. create required objects
		Scanner sc = new Scanner(System.in);
		
//		2. Declare and initialize the 2D array
		int[][] array = {{4,54,2,66},{34,86,-4,22,56},{0,23,-21,43},{-323,43,78,45}};
		int operand;
		
//		3. Print the 2D array and Take user input to multiply the array with
		System.out.println("-------------------Printing using for..each Before Multiplication-------------------");
		System.out.println("[");
		for(int[] row : array) {
			System.out.print("\t[ ");
			for(int val : row) {
				System.out.print(" "+val+" ");
			}
			System.out.print("]\n");
		}
		System.out.print("]\n\n");
		// taking user input to multiply
		System.out.println("Enter the number to multiply with 2D array");
		operand = sc.nextInt();
		
//		4. Multiply the array
		System.out.println("-------------------Printing using for loop After Multiplication-------------------");
		System.out.println("[");
		for(int i=0;i<array.length;i++) {
			System.out.print("\t[");
			for(int j = 0;j<array[i].length;j++) {
				array[i][j] *= operand;
				System.out.print(" "+array[i][j]+" ");
			}
			System.out.println("]");
		}
		System.out.println("]");
	}
}

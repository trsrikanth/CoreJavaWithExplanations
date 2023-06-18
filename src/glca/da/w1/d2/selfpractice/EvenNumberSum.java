package glca.da.w1.d2.selfpractice;

import java.util.Scanner;
/*
 * Q2) Write a java program to print all the even numbers between 0 to n(including n) and 
 * the sum of all even numbers using a while loop, accept the value of n from the user.
 */
public class EvenNumberSum {
	
	public static void main(String[] args) {
	
//		1. Declare variables
		int i=0,sum=0;
		
//		2. Create Scanner Object
		Scanner sc = new Scanner(System.in);
		
//		3. Accept value from user
		System.out.println("Enter the n value");
		int n = sc.nextInt();
		
//		4. While loop to calculate sum of all even number between 1 to n
		System.out.println("Even number between 1 to "+ n +" are:");
		while(i<=n){
			sum = sum + i; 
			System.out.println(i);
			i = i + 2;	
			
		}
		System.out.print("Sum of all even number is : "+sum);
	}
}



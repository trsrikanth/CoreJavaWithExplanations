package glca.da.w1.d1.lab;

/*
 * Write a java program to find 
 * 1. Fibonacci series till 5th term
 * 2. Sum of all the numbers
 * 3. Average of the numbers
 * 4. Modulus 10 of the sum
 * 
 * Example: 
	Fibonacci series of 3 numbers 1 1 2
	Sum is : 4
	Average is : 1.333
	Modulus of (4%10) is: 4
 */
public class FibonacciSeries {

	public static void main(String[] args) {
		
//		1. Declare variables
		int num1, num2, num3, num4, num5;
		int sum, modulus;
		float average;
		
//		2. Initialize the variables
		sum = 0;
		num1 = 1;
		num2 = 1;
		num3 = num1+num2;
		num4 = num2+num3;
		num5 = num3+num4;
		
//		3. Calculate sum, average and Modulus
		sum = num1 + num2 + num3 + num4 + num5;
		average = sum/5.0f;
		modulus = sum%10;
		
//		3. Print all values
		System.out.println("First first 5 fibonacci numbers are: ");
		System.out.println(num1+" "+num2+" "+num3+" "+num4+" "+num5);
		System.out.println("Sum of all 5 numbers is: "+ sum);
		System.out.println("Average of sum is: "+ average);
		System.out.println("Modulus of sum is: "+ modulus);
		
	}
}

package glca.da.w1.d1.lab;

/*
 * Write a Java Program to find the maximum of three numbers using if..else and 
 * nested if..else conditions.
 */
public class MaxNumber {

	public static void main(String[] args) {

//		1. Declare and initialize variables
		int a = 12;
		int b = 29;
		int c = 4;

//		2. Implement logic
		System.out.println("** Using if..else block **\n");
		// if..else
		if(a>b && a>c)								
			System.out.println("a is greater than b and c");
		else if (b>a && b>c)
			System.out.println("b is greater than a and c");
		else 
			System.out.println("c is greater than a and b");

		System.out.println("\n** Using nested if..else block **\n");
		// nested if..else
		if(a>b)
			if(a>c)
				System.out.println("a is greater than b and c");
			else
				System.out.println("c is greater than a and b");
		else if (b>c)
			System.out.println("b is greater than a and c");

	}
}

package glca.da.w1.d2.selfpractice;

import java.util.Scanner;
/*
 * Q4) Write a java program to Check if a String is Palindrome or not.
 * 		(Use Scanner class to take String input from the user)
 * 		Note: A string is called a palindrome string if the reverse of that string is the same as the original string Ex: madam, radar.
 */
public class Check_Palindrome {

	public static void main(String[] args) {

//		1. create Scanner object
		Scanner sc = new Scanner(System.in);
		
//		2. Read string from user.
		System.out.println("Enter String of your choice: ");
		String str = sc.nextLine();
		
//		3. Find the length of string and store it in length variable
		int length = str.length();
		
//		4. Declare a reverseStr of type String to keep the reverse copy of original string
		String reverseStr = "";
		
//		5. Logic to reverse a String
		for (int i = length-1; i >=0; --i) {
			reverseStr = reverseStr + str.charAt(i);
		}

//		6. compare and print the result
		if (str.toLowerCase().equals(reverseStr.toLowerCase())) {
			System.out.println(str + " is a Palindrome String.");
		}
		else {
			System.out.println(str + " is not a Palindrome String.");
		}
	}
}



package glca.da.w1.d2.lab;

/*
 * Q5) Write a program to 
 * 	swap two numbers without using a third variable.
 * 	Convert String any given String to Studly Caps.
 * 	Example of Studly Caps: Ramesh to RaMeSh
 */
public class PracticeLogic {

	public static void main(String[] args) {
//		1. Declare and initialize variables
		int letter;
		int num1 = -1320;
		int num2 = 243220;
		char[] ch;
		String statement = "This& is a^ test";

//		2. Logic for sub question 1
		System.out.println("Before Conversion \nnum1 = "+num1+", num2 = "+num2);
		num2 += num1;
		num1 = num2 - num1;
		num2 = num2 - num1;
		
		System.out.println("After Conversion \nnum1 = "+num1+", num2 = "+num2);
		
//		3. Logic for sub question 2
		
		// conversion string to array
		ch = statement.toCharArray();
		
//		logic for studly caps 
		System.out.println("\nStatement is: "+statement);
		for(int i=0; i<ch.length; i++) {
			letter = ch[i];
			if(i%2==0) {
				// Only Capital letter
				// Logic to convert to Capital letter
				if(97<=letter && letter<=122){
					ch[i] -= 32;
				}
			}
			else {
				// Only Small letter. 
				// Logic to convert to small letter
				if(65<=letter && letter<=96) {
					ch[i] +=32;
				}
			}
		}
		statement = String.valueOf(ch);
		System.out.println("Studly caps String: "+statement);
	}
}

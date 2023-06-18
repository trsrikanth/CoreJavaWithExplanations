package glca.da.w1.d2.lab;

/*
 * Q4) Write a program to 
 * 	Convert a boolean value to String
 * 	Convert a character array to String
 * 	Print every character of a string in a new line using charAt() inbuilt method.
 */
public class StringCharOperations {

	public static void main(String[] args) {
//		1. Declare and initialize variables
		boolean bool = false;
		char[] ch = {'n','a','m','e','s'};
		String booleanToString;
		String charArrayToString;
		
//		2. conversion
		booleanToString  = String.valueOf(bool);
		charArrayToString = String.valueOf(ch);
		
//		3. Print the values
		System.out.println("converted value from boolean to String: "+booleanToString);
		System.out.println("converted value from character array to String: "+charArrayToString);
		
		for(int i = 0; i<charArrayToString.length(); i++) {
			System.out.println(charArrayToString.charAt(i));
		}
	}
}

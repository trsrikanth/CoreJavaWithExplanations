package glca.da.w1.d1.lab;

/*
 * Write a program in java to convert integer value to String and character to integer.
 * Print the values before and after conversion with headings. 
 * Use appropriate comments and naming conventions. 
 */

public class TypeCasting {

	public static void main(String[] args) {
		
//		1. Declare variables
			int number;
			char letter;
			String convertedInteger;
			int convertedCharacter;
			
//		2. Initialize variables
			number = 10;
			letter = 'A';
			
//		3. Print the values
			System.out.println("Before Conversion:");
			System.out.println("1. Number: "+number+"\n2. Letter: "+letter+"\n");
			
//		4. Do the conversion
		//Not possible using Type casting. Use String.valueOf() method
			convertedInteger = String.valueOf(number);
		//	convertedInteger = (String)number; //Compilation error
			convertedCharacter = letter;
			
//		5. Print the values
			System.out.println("After Conversion: ");
			System.out.println("1. Converted from Integer to String "+convertedInteger);
			System.out.println("1. Converted from character to Integer "+convertedCharacter);
	}
}

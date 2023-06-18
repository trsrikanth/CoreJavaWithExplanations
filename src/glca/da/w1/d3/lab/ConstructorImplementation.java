//package name where my class is located
package glca.da.w1.d3.lab;

/*
 * Q1) Write a program to create a class with a 
 * 		1. default constructor and print �I am from Default constructor� 
 * 		2. Parameterized constructor accepting two arguments float and array and 
 * 		   print the array with multiple of float value.
 * Use only one object name and re-initialize it with a different constructor every time.
*/
public class ConstructorImplementation {

//	1. Default constructor
	public ConstructorImplementation() {
		System.out.println("I am default constructor");
	}
	
//	2. Parameterized constructor
	public ConstructorImplementation(float decimal, int[] array){

		System.out.println("\nFrom Parameterized constructor\n");
		System.out.println(decimal+" x array is: " );
		
		// Multiply and print the value 
		for(int i = 0; i<array.length;i++) {
			System.out.print(array[i]*decimal+" ");
		}
	}
	
	public static void main(String[] args) {
		
		int[] array = {12,43,65,77};
		
//		3. Creating object for the class and initializing with default constructor
		ConstructorImplementation constructorImplementation = new ConstructorImplementation();
		
//		4. re-initialize the same object with a parameterized constructor
		constructorImplementation = new ConstructorImplementation(1.77f, array);
	}
}

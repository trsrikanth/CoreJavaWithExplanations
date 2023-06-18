package glca.da.w1.d4.selfpractice;

/*
 * Q5) Write an algorithm to create a class Method and create two methods performleftShift and performRightShift. 
 * 	Make the method performleftShift with int as return type and make no.of shifts to be made as 1 by default. Do not take any input argument for the method performleftShift and perform left shift operation for predefined integer variable. 
 * 
 * 	Make the method performRightShift with no return type and two input arguments (val and digitstoshift) to perform right shift operation for integer.
 */
public class ShiftOperators {
	
//	1. Declare variables needed
	public int num = 10, output;
	
//	2. create method for left shift operations
	public int performLeftShift() {
		output = num << 1;
		return output;
	}
	
//	3. create method for right shift operations 
	public void performRightShift(int val, int digitstoshift) {
		num = val;
		output = num >> digitstoshift;
		System.out.println("Right shift of the number " + num + " is: " +
				output);
	}
	
	public static void main(String[] args) {
		
//		4. Create object and execute the methods
		ShiftOperators obj= new ShiftOperators();
		
		System.out.println("Left shift of the number " + obj.num + " is: " + obj.performLeftShift());
		obj.performRightShift(45, 2);
	}
}
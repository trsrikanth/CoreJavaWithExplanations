package glca.da.w1.d3.lab;

/*
 * Q4) Write a java program to 
 * 	a. create a class with static and final integer arrays as tempMarks and finalMarks respectively.
 * 	b. Ask user for no of students, and marks of all the students and store in tempArray.
 * 	c. Ask user for any modifications and do the changes accordingly. 
 * 		Once the modifications are made, try to copy the tempMarks to finalMarks and print the finalMarks
 */
//public class StaticAndFinal {
//
////	1. declare tempArray 
//	static int tempArray[];
////	final int finalMarks[];
//	
//	Scanner sc = new Scanner(System.in);
//	
////	2. Ask user to input the no of students
//	public void acceptUserDetails() {
//		System.out.println("How many students are ther? ");
//		tempArray = new int[sc.nextInt()];
//		
//		System.out.println("Enter all the marks: ");
//		for(int i=0;i<tempArray.length;i++) {
//			System.out.println("Enter marks for student "+(i+1)+": ");
//			tempArray[i] = sc.nextInt();
//		}
//	}
//
////	3. Ask user to update marks if needed
//	public void updateMarks() {
//		System.out.println("Enter student number to update marks: ");
//		int i = sc.nextInt()-1;
//		if(i>=0 && i<tempArray.length) {
//			System.out.println("Enter new marks for student "+i);
//			tempArray[i] = sc.nextInt();
//		}
//		else {
//			System.out.println("Invalid student number");
//		}
//	}
//	
//	public static void main(String[] args) {
//		
//		StaticAndFinal staticAndFinal = new StaticAndFinal();
//		staticAndFinal.acceptUserDetails();
//		staticAndFinal.updateMarks();
//		// will throw error. We have to initialize final variable while declaration.
////		staticAndFinal.finalMarks = staticAndFinal.tempArray;
//		
//	}
//}

/*
 * Write a program to do the following
	1. Create integer non-static variable var1 and a static variable var2 and assign value 10 to var1 & var2.
	2. create two methods method1 and method2.
	3. In method1, use increment operator to increment var1 and use print statement to print var1.
	4. Similarly perform for method2 with var2.
	5. Create three objects obj1, obj2, obj3.
	6. Execute method1 with all the objects.
	7. Similarly perform for method2.
	8. (Optional) Replace static with final for var2 and run the program. Note your observations.
 */

public class StaticAndFinal {
	
//	1. Declare and initialize variables
	int var1 = 10;
	static int var2 = 10;
	
//	2. Method to increment var1 and print its value
	public void method1() {
		var1++;
		System.out.println(var1);
	}
	
//	3. Method to increment var2 and print its value
	public void method2() {
		var2++;
		System.out.println(var2);
	}
	
	public static void main(String[] args) {
		
//		4. Declare and intialze all the required methods
		StaticAndFinal obj = new StaticAndFinal ();
		StaticAndFinal obj2 = new StaticAndFinal ();
		StaticAndFinal obj3 = new StaticAndFinal ();
		
//		5. call the methods with various objects
		System.out.println("Using non-static keyword");
		obj.method1();
		obj2.method1();
		obj3.method1();
		
		System.out.println("\nUsing static keyword");
		obj.method2();
		obj2.method2();
		obj3.method2();
	}
}
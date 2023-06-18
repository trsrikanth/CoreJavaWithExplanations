package glca.da.w1.d4.selfpractice;

/*
 * Q3) Write a program to do the following
	1. Create two classes A, B with default as access modifier outside the class in which the main method exists.
	2. Create a method Car in class A and B, and print I am method A and I am method B respectively in both classes.
	3. The class in which the main method exists, execute class A method using obj.
	4. Create another object obj1 and execute method in class B by overriding the same method in class A.
	(Optional): use public as access modifier for class A and B and execute the same code and discuss your observations with co-learners.
 */
class Vehicle{
	public void carDetails() {
		System.out.println("I am from class A method");
	}
}
class B extends Vehicle{
	public void carDetails() {
		System.out.println("I am from class B method");
	}
}

public class Run_time_polymorphism{
	public static void main(String[] args) { // main method
		
		Vehicle obj = new Vehicle();
		Vehicle obj1 = new B();
		obj.carDetails();
		obj1.carDetails();
	}
}

package glca.da.w1.d4.selfpractice;

public class InheritanceB extends InheritanceA {

//	1. Declare required variables
	public float length, breadth;

//	2. Create the parameterized method for Rectangle Area
	public void findRectangleArea(int l, int b) {

		length = l;
		breadth = b;
		result = length * breadth;
		System.out.println("The area of the rectangle is: " + result + " cm square");
	}
}

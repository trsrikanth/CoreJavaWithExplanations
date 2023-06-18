package glca.da.w1.d4.selfpractice;

/*
 * Q1) Write an algorithm to create classes InheritanceA, InheritanceB and InheritanceC to find 
 * 		the area of circleArea, rectangleArea and triangleArea respectively. 
 * 		Use multi level inheritance and execute all methods using the object of class InheritanceC.
 * 
 * 		Note: create methods circleArea, rectangleArea and triangleArea in the classes 
 * 		InheritanceA, InheritanceB and InheritanceC respectively.
 */
public class InheritanceC extends InheritanceB {

//	1. Declare required variables
	public float base, height;

//	2. Create the parameterized method for triangle Area
	public void findTriangleArea(int b, int h) {

		base = b;
		height = h;
		result = 0.5f * base * height;
		System.out.println("The area of the triangle is: " + result + " cm square");
	}

	public static void main(String[] args) {

//		3. Create object and call required methods
		InheritanceC inheritancec = new InheritanceC();

		inheritancec.findCircleArea(22.5f);
		inheritancec.findRectangleArea(5, 6);
		inheritancec.findTriangleArea(3, 4);

	}
}

package glca.da.w1.d4.selfpractice;

public class InheritanceA {

//	1. Declare required variables
	final float pi = 22 / 7;
	public float radius, result;

//	2. Create the parameterized method for Circle Area
	public void findCircleArea(float rad) {

		radius = rad;
		result = pi * radius * radius;
		System.out.println("The area of the circle is: " + result + " cm square");
	}
}

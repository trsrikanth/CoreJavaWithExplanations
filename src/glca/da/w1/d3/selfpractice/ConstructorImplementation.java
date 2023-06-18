package glca.da.w1.d3.selfpractice;

/*
 * Q5) Write a program in java to exploit constructor overloading. (cube and cuboid volume calculation)
		i) Create a class ThreeDimensionShape with three variables  width, height, depth of type double;
		ii) Create three constructors 
				Doesn�t accepts any parameter
				Accepts 1 parameter of type double(length)
				Accepts 3 parameters of type double(width, height, depth)
		iii) Create a method volume of return type double that returns a product of width, height, and depth.
		iv) in case of No argument constructor make length=width=depth = 0;
		v) in case of 1 argument constructor make length=width=depth = value passed;
 */
// Driver code
public class ConstructorImplementation {
	public static void main(String args[]) {
		// create boxes using the various
		// constructors
		ThreeDimensionShape shape1 = new ThreeDimensionShape(5, 6, 7);
		ThreeDimensionShape shape2 = new ThreeDimensionShape();
		ThreeDimensionShape shape3 = new ThreeDimensionShape(8);
		double volume;
		
		// get volume of first box
		volume = shape1.volume();
		System.out.println(" Volume of shape1 is " + volume);
		
		// get volume of second box
		volume = shape2.volume();
		System.out.println(" Volume of shape2 is " + volume);
		
		// get volume of cube
		volume = shape3.volume();
		System.out.println(" Volume of shape3 is " + volume);
	}
}
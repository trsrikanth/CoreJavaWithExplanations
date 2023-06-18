package glca.da.w1.d3.selfpractice;

public class ThreeDimensionShape {

	double width, height, depth;

	//Constructor used when width, height, and depth are specified
	ThreeDimensionShape(double w, double h, double d) {
		width = w;
		height = h;
		depth = d;
	}

	// constructor used when no dimension is specified
	ThreeDimensionShape() {
		width = height = depth = 0;
	}

	// constructor used when only the length is specified ie. case for cube
	ThreeDimensionShape(double l) {
		width = height = depth = l;
	}

	// method to calculate and return volume of the shape
	double volume(){
		return width * height * depth;
	}
}
package glca.da.w1.d1.selfpractice;

/* 
 * Q3) Write a java program to display the area and perimeter of the rectangle. 
 * Declare 4 variables (length,width,area,perimeter) of type float, 
 * initialize sample values to length and width.Calculate area and perimeter 
 * of rectangle and assign the value to area and perimeter variable.
 */
public class Rectangle {
	
	public static void main(String[] args) {
		//1. Declare and initialize the variables as needed
		float length, width, area, perimeter;
    	length =20;
   	    width=10;
   	    
    	//2. calculate area and store in area variable
    	area = length * width;
    	
    	//3. calculate perimeter value and store in perimeter value
    	perimeter = 2*(length+width);
    	
    	//4. print area and perimeter values
    	System.out.println("Area of rectangle is: "+ area);
    	System.out.println("Perimeter of rectangle is: "+perimeter); 	
   }           	
}

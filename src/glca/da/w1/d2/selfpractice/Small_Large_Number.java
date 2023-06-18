package glca.da.w1.d2.selfpractice;

 import java.util.Scanner;
 /*
  * Write a java program to find and print the largest and smallest numbers in an array.
  * (Array size and array values should be taken from the user).
  */
 public class Small_Large_Number {
	 
	public static void main(String[] args) {
		
//		1. Declare required variables
		int numbers[], size;
		Scanner sc = new Scanner(System.in);
		
//		2. Take user input for number of array values 
		System.out.println("Enter the number of values: ");
		size = sc.nextInt();
		
//		3. Initialize array size
		numbers=new int[size];
		
//		4. Take array values from user
		System.out.println("Enter array values");
		for(int i=0;i<size;i++)
		{
			numbers[i]=sc.nextInt();
		}
		
//		5. initialize largest and smallest value to numbers[0];
		int largest = numbers[0];
		int smallest = numbers[0];

//		6. Write logic to find smallest and largest value in an array
		for (int i = 1; i < numbers.length; i++) {
			if(numbers[i]>largest){
				largest=numbers[i];
			}else if(numbers[i]<smallest){
				smallest=numbers[i];
			}
		}

//		7. Display largest and smallest value of an array on the console.
		System.out.println("Largest number in array is : " + largest);
		System.out.println("Smallest number in array is : " + smallest);	
	}
}
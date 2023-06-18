package glca.da.w1.d3.selfpractice;

// Q4) Write a program to take integer user input and check whether the given number is prime or not.
public class PrimeNumbers{
	
	static void checkPrime(int number){
//		1. Declare and initialize all the required variables
		int i,mid=0,status=0;
		mid=number/2;
		
//		2. check if number is equal to 0 or 1.
		if(number==0||number==1){
			System.out.println(number+" is not prime number");
		}else{
			// find the mod of given number from 2 to m if mod is 0, not prime, else prime
			for(i=2;i<=mid;i++) {
				if(number%i==0){
					System.out.println(number+" is not prime number");
					status=1;
					break;
				}
			}
			if(status==0)  { 
				System.out.println(number+" is prime number"); 
			}
		}
	}  
	
	public static void main(String args[]){    
		
//		execute the method with various input numbers
		checkPrime(1);  
		checkPrime(3);  
		checkPrime(17);  
		checkPrime(20);  
	}    
}   
package glca.da.w1.d1.selfpractice;

/* 
 * Q4) Write a java program to check if a given year is leap year or not, 
 * print �Leap year� if it is leap year otherwise print �Not a leap year�
 */
public class CheckLeapYear {
	
        public static void main(String[] args) {
        	int year = 2024;
            
        	// 1. if year is divisible by 400 then its a leap year
            if (year % 400 == 0) {
            	System.out.println("Leap Year");
            }
            // 2. if year is divisible by 4 and not divisible by 100 then its a leap year
            else if ((year % 4 == 0)&&(year % 100 != 0)) {
            	System.out.println("Leap Year");
            }
            else {
            	System.out.println("Not a Leap Year");
            }
       }
}

package glca.da.w1.d1.lab;

/*
 * Write a java program to increment salary of an employee based on 
 * performance rating using switch case
 */
public class SalaryRevision {

	public static void main(String[] args) {
		
//		1. Declare variables
			int salary, rating;
			float updatedSalary, percentageIncrement;
			
//		2. Initialize variable
			salary = 600000;
			rating = 5;
			
//		3. ImplementSwitch case
			switch(rating) {
			case 1:
				percentageIncrement = 2;
				break;
			case 2:
				percentageIncrement = 3.5f;
				break;
			case 3:
				percentageIncrement = 4;
				break;
			case 4:
				percentageIncrement = 4.5f;
				break;
			case 5:
				percentageIncrement = 5;
				break;
			case 6:
				percentageIncrement = 7;
				break;
			case 7:
				percentageIncrement = 8.5f;
				break;
			case 8:
				percentageIncrement = 10;
				break;
			case 9:
				percentageIncrement = 12;
				break;
			case 10:
				percentageIncrement = 15;
				break;
			default:
				percentageIncrement = 0;
			}
			
//		4. Calculate updated salary
			updatedSalary = salary +(salary*percentageIncrement)/100;
			
//		5. Print Final salary and percentage increment
			System.out.println("Increment percentage: "+percentageIncrement+"%");
			System.out.println("Updated Salary: "+updatedSalary);
	}
}

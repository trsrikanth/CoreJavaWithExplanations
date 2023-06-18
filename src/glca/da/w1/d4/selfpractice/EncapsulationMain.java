package glca.da.w1.d4.selfpractice;

/*
 * Q4) Write an program to create a class Encapsulation with getter and setter methods 
 * to assign and print values of variables country, nationalAnthem and touristSpot
 */
public class EncapsulationMain {
	
	public static void main(String[] args) {

//		1. Create object as required
		EncapsulationService encapsulation = new EncapsulationService();

//		2. print the variables before updating 
		System.out.println("Before updating the variable values:");
//		System.out.println("Country: " + encapsulation.country); //Error
//		System.out.println("National Anthem: " + encapsulation.nationalAnthem); //Error
//		System.out.println("Tourist Spot: " + encapsulation.touristSpot); //Error

		
		System.out.println("Country: " + encapsulation.getCountry());
		System.out.println("National Anthem: " + encapsulation.getNationalAnthem());
		System.out.println("Tourist Spot: " + encapsulation.getTouristSpot());
		
//		2. Set variables with new values
		encapsulation.setCountry("India");
		encapsulation.setNationalAnthem("Jana Gana Mana");
		encapsulation.setTouristSpot("Taj Mahal");

//		3. Print the variables after updating
		System.out.println("\nAfter updating the variable values:");
		System.out.println("Country: " + encapsulation.getCountry());
		System.out.println("National Anthem: " + encapsulation.getNationalAnthem());
		System.out.println("Tourist Spot: " + encapsulation.getTouristSpot());
	}
}

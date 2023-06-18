package glca.da.w1.d4.lab;

import java.util.Random;

public class CredentialService implements ICredentials{

	public String generatePassword() {

		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialCharacters = "!@#$%^&*_=+-/.?<>)";

		String values = capitalLetters + smallLetters  + specialCharacters+ numbers;
//		System.out.println(values);
		// Using random method
		Random random = new Random();

		String password="";
		char temp;
		for (int i = 0; i < 8; i++) {
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
//			Approach 1
			password += String.valueOf(values.charAt(random.nextInt(values.length())));
			
//			Approach 2
//			temp = (char) (random.nextInt(126 - 33) + 33);
//			password += temp;
		}
		return password;
	}
	
	public String generateEmailAddress(String firstName, String lastName, String department)
	{
		return firstName+lastName+"@"+department+".gl.in";
	}
	
	public void showCredentials(Employee employee) {
		
		System.out.println("Dear "+employee.getFirstName()+ " your generated credentials are as follows ");
		System.out.println("Email\t\t"+ employee.getEmail());
		System.out.println("Password\t"+employee.getPassword());
	}
}

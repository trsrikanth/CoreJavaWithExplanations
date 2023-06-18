package glca.da.w1.d4.selfpractice;

/*
 * Q2) Write a program in Java to implement Multilevel inheritance.
	Create three Classes Account, CurrentAccount, AccountDetails.
	i) Account Class is the super Class
	    Declare two variables customerName (of type String), accountNo(of type int)
	    Account class will contain a parameterized constructor Account(String customerName, int accountNo)
	    Inside Constructor Assign parameter values to the variables declared 
	    Create a method display of type void to display customerName and accountNo
	    
	ii) CurrentAccount class will extend Account class
	    Declare a variable currentBalance (of type int)
	    CurrentAccount will contain a parameterized constructor  CurrentAccount(String customerName, int accountNo, int CurrentBalance)
	    Use super keyword inside Constructor to access Account constructor and assign currentBalance to CurrentBalance method parameters.
	Create a method display of type void to display (customerName, AccountNo, CurrentBalance)
	Inside display method use super keyword to display customerName and accountNo
  
	iii) AccountDetails will extend CurrentAccount
	     Declare two variables depositAmount, withdrawalAmount of type Int.
	     AccountDetails class will contain a parameterized constructor as follows
	                      AccountDetails(String customerName, int accountNo, int CurrentBalance, int depositAmount, int withdrawalAmount)
	     Use super keyword inside Constructor to access CurrentAccount constructor and assign depositAmount and withdrawalAmount to depositAmount and withdrawalAmount method parameters respectively.
	      Create a method display of type void to display (customerName, accountNo, CurrentBalance, depositAmount, withdrawalAmount)
	Inside display method use super keyword to display customerName, accountNo,currentBalance)
	 
	 
	iv) Create a driver class main
	      Create an object of AccountDetails and pass customerName, accountNo, CurrentBalance, depositAmount, withdrawalAmount in the constructor.
      	Call display method of AccountDetails class.
 */
class Account {
	String customerName;
	int accountNo;
	Account(String customerName, int accountNo) {
		this.customerName=customerName;
		this.accountNo=accountNo;
	}
	
	void display() {
		System.out.println ("Customer Name: "+customerName);
		System.out.println ("Account No: "+accountNo);
	}
}

class CurrentAccount extends Account {
	int currentBalance;
	CurrentAccount(String customerName, int accountNo, int currentBalance) {
		super(customerName,accountNo);
		this.currentBalance=currentBalance;
	}
	void display() {
		super.display();
		System.out.println ("Current Balance: "+currentBalance);
	}
}

class AccountDetails extends CurrentAccount {
	int depositAmount, withdrawalAmount;
	AccountDetails(String customerName, int accountNo, int currentBalance, int depositAmount, int withdrawalAmount) {
		super(customerName,accountNo,currentBalance);
		this.depositAmount=depositAmount;
		this.withdrawalAmount=withdrawalAmount;
	}
	void display() {
		super.display();
		System.out.println ("Deposit Amount: "+depositAmount);
		System.out.println ("Withdrawal Amount: "+withdrawalAmount);
	}
}

public class Main {
	public static void main(String args[]) {
		AccountDetails A = new AccountDetails("Harshit",11111,10000,5000,500);
		A.display();
	}
}
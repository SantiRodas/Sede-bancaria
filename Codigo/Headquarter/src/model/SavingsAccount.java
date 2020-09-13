package model;

public class SavingsAccount {
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the SavingsAccount class
	
	private double balance;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the SavingsAccount class

	public SavingsAccount(double balance) {

		this.balance = balance;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Get's methods of the SavingsAccount class

	public double getBalance() {
		return balance;
	}
	
	//------------------------------------------------------------------------------------
	
	// Set's methods of the SavingsAccount class

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//------------------------------------------------------------------------------------

}

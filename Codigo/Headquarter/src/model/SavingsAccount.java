package model;

public class SavingsAccount {
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the SavingsAccount class
	
	private double balance;
	
	private String number;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the SavingsAccount class

	public SavingsAccount(double balance, String number) {

		this.balance = balance;
		
		this.number = number;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Get's methods of the SavingsAccount class

	public double getBalance() {
		return balance;
	}
	
	public String getNumber() {
		return number;
	}
	
	//------------------------------------------------------------------------------------
	
	// Set's methods of the SavingsAccount class

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	//------------------------------------------------------------------------------------

}

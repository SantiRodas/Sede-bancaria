package model;

public class DebitCard {
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the DebitCard class
	
	private String number;
	
	//------------------------------------------------------------------------------------

	// Relations of the DebitCard class
	
	private SavingsAccount associatedAccount;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the DebitCard class

	public DebitCard(String number) {

		this.number = number;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Get's methods of the DebitCard class

	public String getNumber() {
		return number;
	}
	
	//------------------------------------------------------------------------------------
	
	// Set's methods of the DebitCard class

	public void setNumber(String number) {
		this.number = number;
	}
	
	//------------------------------------------------------------------------------------
	
	//Operations of the debit card
	
	public boolean debit(double amount) {
		
	}
	
	public boolean credit(double amount) {
		
	}
	
	//------------------------------------------------------------------------------------
	
}
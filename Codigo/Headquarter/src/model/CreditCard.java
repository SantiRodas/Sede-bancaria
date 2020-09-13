package model;

public class CreditCard {
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the CreditCard class
	
	private String number;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the CreditCard class

	public CreditCard(String number) {

		this.number = number;
		
	}

	//------------------------------------------------------------------------------------
	
	// Get's methods of the CreditCard class

	public String getNumber() {
		return number;
	}

	//------------------------------------------------------------------------------------
	
	// Set's methods of the CreditCard class

	public void setNumber(String number) {
		this.number = number;
	}
	
	//------------------------------------------------------------------------------------
	
}

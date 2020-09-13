package model;

public class DebitCart {
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the DebitCard class
	
	private String number;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the DebitCard class

	public DebitCart(String number) {

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
	
}

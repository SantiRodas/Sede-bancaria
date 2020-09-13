package model;

public class ChekingAccount {
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the ChekingAccount class
	
	private double availableCredit;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the ChekingAccount class

	public ChekingAccount(double availableCredit) {

		this.availableCredit = availableCredit;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Get's methods of the ChekingAccount class

	public double getAvailableCredit() {
		return availableCredit;
	}
	
	//------------------------------------------------------------------------------------
	
	// Set's methods of the ChekingAccount class

	public void setAvailableCredit(double availableCredit) {
		this.availableCredit = availableCredit;
	}
	
	//------------------------------------------------------------------------------------

}

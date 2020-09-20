package model;

public class CurrentAccount {

	//------------------------------------------------------------------------------------
	
	//Constants of the CurrentAccount class
	
	public static double DEFAULT_CREDIT = 5000000;
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the CurrentAccount class
	
	private String number;
	
	private double availableCredit;
	
	private double balanceToPay;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the DebitCard class

	public CurrentAccount(String number) {
		
		this.number = number;
		
		availableCredit = DEFAULT_CREDIT;
	}
	
	//------------------------------------------------------------------------------------
	
	// Get's methods of the DebitCard class

	public String getNumber() {
		return number;
	}

	public double getAvailableCredit() {
		return availableCredit;
	}

	public double getBalanceToPay() {
		return balanceToPay;
	}
	
	//------------------------------------------------------------------------------------
	
	// Set's methods of the DebitCard class

	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setBalanceToPay(double balanceToPay) {
		this.balanceToPay = balanceToPay;
	}

	public void setAvailableCredit(double availableCredit) {
		this.availableCredit = availableCredit;
	}
	
	//------------------------------------------------------------------------------------
	
}

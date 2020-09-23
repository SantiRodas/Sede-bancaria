package model;

public class CreditCard {
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the CreditCard class
	
	private String number;
	
	//------------------------------------------------------------------------------------
	
	// Relations of the CreditCard class
	
	private CurrentAccount associatedCAccount;
	
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

	public double getBalanceTopPay() {
		return associatedCAccount.getBalanceToPay();
	}
	
	public double getAvailableCredit() {
		return associatedCAccount.getAvailableCredit();
	}
	//------------------------------------------------------------------------------------
	
	// Set's methods of the CreditCard class
	
	
	//------------------------------------------------------------------------------------
	
	//Operations of the Credit card class
	
	public boolean pay(double amount) {
		return associatedCAccount.pay(amount);
	}
	
	public boolean use(double amount) {
		return associatedCAccount.use(amount);
	}
	
	//------------------------------------------------------------------------------------
	
}

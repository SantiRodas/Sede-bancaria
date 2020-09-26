/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

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

	public double getBalanceToPay() {
		return associatedCAccount.getBalanceToPay();
	}
	
	public double getAvailableCredit() {
		return associatedCAccount.getAvailableCredit();
	}
	//------------------------------------------------------------------------------------
	
	// Set's methods of the CreditCard class
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setAssociatedCAccount(CurrentAccount associatedCAccount) {
		this.associatedCAccount = associatedCAccount;
	}
	
	//------------------------------------------------------------------------------------
	
	//Operations of the Credit card class
	
	public boolean pay(double amount) {
		return associatedCAccount.pay(amount);
	}
	
	public boolean use(double amount) {
		return associatedCAccount.use(amount);
	}

	public CurrentAccount getCurrentAccount() {
		return associatedCAccount;
		
	}
	
	//------------------------------------------------------------------------------------
	
}

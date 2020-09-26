/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package model;

public class DebitCard {
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the DebitCard class
	
	private String number;
	
	//------------------------------------------------------------------------------------

	// Relations of the DebitCard class
	
	private SavingsAccount associatedSAccount;
	
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
	
	public String getAssociatedAccountNumber() {
		return associatedSAccount.getNumber();
	}
	
	public double getBalance() {
		return associatedSAccount.getBalance();
	}
	
	//------------------------------------------------------------------------------------
	
	// Set's methods of the DebitCard class
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setAssociatedSAccount(SavingsAccount associatedSAccount) {
		this.associatedSAccount = associatedSAccount;
	}
	
	//------------------------------------------------------------------------------------
	
	//Operations of the card
	
	public boolean debit(double amount) {
		return associatedSAccount.debit(amount);
	}
	
	public boolean credit(double amount) {
		return associatedSAccount.credit(amount);
	}

	public SavingsAccount getSavingAccount() {
		return associatedSAccount;
	}
	
	//------------------------------------------------------------------------------------
	
}
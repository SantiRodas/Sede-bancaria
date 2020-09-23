/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package model;

public class SavingsAccount {
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the SavingsAccount class
	
	private double balance;
	
	private String number;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the SavingsAccount class

	public SavingsAccount(String number) {

		this.number = number;
		
		balance = 0;
		
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
	
	// operation of the SavingsAccount class
	
	public boolean debit(double amount) {
		
		if(balance > amount) {
			
			balance -= amount;
			
			return true;
			
		} else {
			
			return false;
			
		}	
		
	}
	
	//------------------------------------------------------------------------------------
	
	// operation credit of the SavingsAccount class

	public boolean credit(double amount) {
		
		balance += amount;
		
		return true;
		
	}
	
	//------------------------------------------------------------------------------------

}

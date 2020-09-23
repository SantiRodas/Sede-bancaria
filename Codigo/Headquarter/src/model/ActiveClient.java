/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package model;

import java.time.LocalDate;

public class ActiveClient extends Client {
	
	//------------------------------------------------------------------------------------
	
	//Constants of the CurrentAccount class
	
	public static int MAX_DEBIT_CARDS = 1;
	
	public static int MAX_CREDIT_CARDS = 1;
		
	//------------------------------------------------------------------------------------
		
	// Attributes of the ActiveClient class
	
	private LocalDate startDate;
	
	private LocalDate lastCreditCardPayDate;
	
	//------------------------------------------------------------------------------------
	
	// Relations of the ActiveClient class
	
	private CurrentAccount cAccount;
	
	private CreditCard cCard;
	
	private DebitCard dCard;
	
	private SavingsAccount sAccount;
	
	//------------------------------------------------------------------------------------

	
	// Constructor method of the ActiveClient class

	public ActiveClient(String name, String id, LocalDate startDate) {
		
		super(name, id);
		
		this.startDate = startDate;	

	}
	
	//------------------------------------------------------------------------------------
	
	// Get's methods of the ActiveClient class

	public LocalDate getStartDate() {
		return startDate;
	}
	
	public LocalDate getLastCreditCardPayDate() {
		return lastCreditCardPayDate;
	}
	
	//------------------------------------------------------------------------------------
	
	// Set's methods of the ActiveClient class

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setLastCreditCardPayDate(LocalDate lastCreditCardPayDate) {
		this.lastCreditCardPayDate = lastCreditCardPayDate;
	}
	
	//------------------------------------------------------------------------------------

	//Operations of class ActiveClient
	
	public boolean payCreditCard(double amount) {
		
		if(cCard != null) {
			
			return cCard.pay(amount);
			
		} else {
			
			return false;
			
		}
		
	}
	
	// *****************************************************
	
	public boolean retrieveCredit(double amount) {
		
		if(cCard != null) {
			
			return cCard.use(amount);
			
		} else {
			
			return false;
			
		}
		
	}
	
	// *****************************************************
	
	public boolean retrieveSavings(double amount) {
		
		if(dCard != null) {
			
			return dCard.debit(amount);
			
		} else {
			
			return false;
			
		}
		
	}
	
	// *****************************************************
	
	public boolean addSavings(double amount) {
		
		if(dCard != null) {
			
			return dCard.credit(amount);
			
		} else {
			
			return false;
			
		}
		
	}
	
	// *****************************************************
	
	public boolean createDebitCard(String number) {
		
		if(dCard != null) {
			
			dCard = new DebitCard(number);
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	// *****************************************************
	
	public boolean createCreditCard(String number) {
		
		if(cCard != null) {
			
			cCard = new CreditCard(number);
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	//------------------------------------------------------------------------------------

}

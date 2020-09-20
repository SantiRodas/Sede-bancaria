package model;

import java.time.LocalDate;

public class ActiveClient extends Client {
	
	//------------------------------------------------------------------------------------
	
	//Constants of the CurrentAccount class
	
	public static int MAX_DEBIT_CARDS = 5;
	
	public static int MAX_CREDIT_CARDS = 1;
		
	//------------------------------------------------------------------------------------
		
	// Attributes of the ActiveClient class
	
	private LocalDate startDate;
	
	private LocalDate lastCreditCardPayDate;
	
	//------------------------------------------------------------------------------------
	
	// Relations of the ActiveClient class
	
	private CurrentAccount cAcount;
	
	private CreditCard cCard;
	
	private DebitCard[] dCard;
	
	private SavingsAccount[] sAccount;
	
	//------------------------------------------------------------------------------------

	
	// Constructor method of the ActiveClient class

	public ActiveClient(String name, String id, LocalDate startDate) {
		
		super(name, id);
		
		this.startDate = startDate;
		
		dCard = new DebitCard[5];
		
		sAccount = new SavingsAccount[5];

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
	
	public void payCreditCard(double amount) {
		
	}
	
	public boolean retrieveCredit(double amount) {
		
	}
	
	public boolean retrieveSavings(double amount) {
		
	}
	
	public void addSavings(double amount) {
		
	}
	
	public boolean createDebitCard() {
		
	}
	
	public boolean createCreditCard() {
		
	}
	
	//------------------------------------------------------------------------------------

}

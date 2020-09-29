/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package model;

import java.time.LocalDate;

public class ActiveClient extends Client implements Cloneable {
	
	//------------------------------------------------------------------------------------
	
	//Constants of the CurrentAccount class
	
	public static int MAX_DEBIT_CARDS = 2;
	
	public static int MAX_CREDIT_CARDS = 5;
		
	//------------------------------------------------------------------------------------
		
	// Attributes of the ActiveClient class
	
	private LocalDate startDate;
	
	private LocalDate lastCreditCardPayDate;
	
	//------------------------------------------------------------------------------------
	
	// Relations of the ActiveClient class
	
	//Not used but kept for model purposes
	private CurrentAccount[] cAccounts;
	
	private CreditCard[] cCards;
	
	private DebitCard[] dCards;
	
	private SavingsAccount[] sAccounts;
	
	//------------------------------------------------------------------------------------

	
	// Constructor method of the ActiveClient class

	public ActiveClient(String name, String id, LocalDate birthday, LocalDate startDate) {
		
		super(name, id, birthday);
		
		this.startDate = startDate;	

		cAccounts = new CurrentAccount[MAX_CREDIT_CARDS];
		cCards = new CreditCard[MAX_CREDIT_CARDS];
		sAccounts = new SavingsAccount[MAX_DEBIT_CARDS];
		dCards = new DebitCard[MAX_DEBIT_CARDS];
	}
	
	//------------------------------------------------------------------------------------
	
	// Get's methods of the ActiveClient class

	public LocalDate getStartDate() {
		return startDate;
	}
	
	public LocalDate getLastCreditCardPayDate() {
		return lastCreditCardPayDate;
	}
	
	public CreditCard[] getcCards() {
		return cCards;
	}
	
	public SavingsAccount[] getsAccounts() {
		return sAccounts;
	}
	
	//------------------------------------------------------------------------------------
	
	// Set's methods of the ActiveClient class

	public void setcCards(CreditCard[] cCards) {
		this.cCards = cCards;
	}

	public void setsAccounts(SavingsAccount[] sAccounts) {
		this.sAccounts = sAccounts;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setLastCreditCardPayDate(LocalDate lastCreditCardPayDate) {
		this.lastCreditCardPayDate = lastCreditCardPayDate;
	}
	
	//------------------------------------------------------------------------------------

	//Operations of class ActiveClient
	
	public boolean payCreditCard(String cardNumber, double amount) {
		
		int i = searchCreditCard(cardNumber); 
		
		if(i != -1) {
			
			return cCards[i].pay(amount);
			
		}
		else {
			
			return false;
			
		}
		
	}
	
	// *****************************************************
	
	//Retrieve credit
	
	public boolean retrieveCredit(String cardNumber, double amount) {
		
		int i = searchCreditCard(cardNumber); 
		
		if(i != -1) {
			
			return cCards[i].use(amount);
			
		}
		else {
			
			return false;
			
		}
		
	}
	
	// *****************************************************
	
	//Retrieve savings
	
	public boolean retrieveSavings(String accountNumber, double amount) {
		
		int i = searchSavingsAccount(accountNumber); 
		
		if(i != -1) {
			
			return sAccounts[i].debit(amount);
			
		}
		else {
			
			return false;
			
		}
		
	}
	
	// *****************************************************
	
	//Add savings
	
	public boolean addSavings(String accountNumber, double amount) {
		
		int i = searchSavingsAccount(accountNumber); 
		
		if(i != -1) {
			
			return sAccounts[i].credit(amount);
			
		}
		else {
			
			return false;
			
		}
	}
	
	// *****************************************************
	
	//Create savings accounts
	
	public boolean createSavingsAccount(String accountNumber, String cardNumber) {
		
		if(searchSavingsAccount(accountNumber) == -1) {
			
			int emptySlotIndex = -1;
			
			boolean check = false;
			
			for (int i = 0; i < sAccounts.length && !check; i++) {
				
				if(sAccounts[i] == null) {
					
					emptySlotIndex = i;
					
					check = true;
					
				}
				
			}
			
			if(emptySlotIndex != -1) {
				
				sAccounts[emptySlotIndex] = new SavingsAccount(accountNumber);
				
				dCards[emptySlotIndex] = new DebitCard(cardNumber);
				
				dCards[emptySlotIndex].setAssociatedSAccount(sAccounts[emptySlotIndex]);
			
				return true;
				
			}
			else {
				
				return false;
				
			}
		}
		else {
			
			return false;
		
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Search savings accounts
	
	private int searchSavingsAccount(String accountNumber) {
		
		for (int i = 0 ; i < sAccounts.length ; i++) {
		
			if(sAccounts[i] != null && sAccounts[i].getNumber().equals(accountNumber)) {
				
				return i;
				
			}
			
		}
		
		return -1;		
	}
	
	// *****************************************************
	
	//Create a new credit card
	
	public boolean createCreditCard(String cardNumber, String accountNumber) {
		
		if(searchCreditCard(cardNumber) == -1) {
			
			int emptySlotIndex = -1;
			
			boolean check = false;
			
			for (int i = 0; i < cCards.length && !check; i++) {
				
				
				if(cCards[i] == null) {
					
					emptySlotIndex = i;
					
					check = true;
					
				}
				
			}
			
			if(emptySlotIndex != -1) {
				
				cCards[emptySlotIndex] = new CreditCard(cardNumber);
				
				cAccounts[emptySlotIndex] = new CurrentAccount(accountNumber);
				
				cCards[emptySlotIndex].setAssociatedCAccount(cAccounts[emptySlotIndex]);
			
				return true;
				
			}
			else {
				
				return false;
				
			}
		}
		else {
			
			return false;
		
		}
	
	}	
	
	//------------------------------------------------------------------------------------
	
	//Search credit card
	
	private int searchCreditCard(String cardNumber) {
		
		for (int i = 0 ; i < cCards.length ; i++) {
		
			if(cCards[i] != null && cCards[i].getNumber().equals(cardNumber)) {
				
				return i;
				
			}
			
		}
		
		return -1;		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to get the number of a credit card

	public String[] getCreditCardNumbers() {
		
		String[] numbers = new String[cCards.length];
		
		int emptySpotsCount = 0;
	
		for (int i = 0 ; i < cCards.length ; i++) {
			
			if(cCards[i] != null) {
				numbers[i] = cCards[i].getNumber();	
			}
			else {
				emptySpotsCount++;
			}
			
		}
		
		if(emptySpotsCount == cCards.length ) {
			
			return null;
		
		}
		else {
		
			return numbers;
		}
		
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to get savings accounts numbers

	public String[] getSavingsAccountsNumbers() {
		
		String[] numbers = new String[sAccounts.length];
		
		int emptySpotsCount = 0;
	
		for (int i = 0 ; i < sAccounts.length ; i++) {
			
			if(sAccounts[i] != null) {
				
				numbers[i] = sAccounts[i].getNumber();	
				
			}
			else {
				
				emptySpotsCount++;
				
			}
			
		}
		
		if(emptySpotsCount == sAccounts.length ) {
			
			return null;
		
		}
		else {
		
			return numbers;
			
		}
	}	
	
	//------------------------------------------------------------------------------------
	
	//Method to string
	
	public String toStringSavingsAccounts() {
		
		String msg = "";
	
		for (int i = 0 ; i < sAccounts.length ; i++) {
			
			if(sAccounts[i] != null) {
				
				msg+= "Account number " + sAccounts[i].getNumber() + " - Balance:" + sAccounts[i].getBalance() + "\n";
				
			}
			
		}
		
		return msg;
	}	
	
	//------------------------------------------------------------------------------------
	
	//Method to string
	
	public String toStringCreditCards() {
		
		String msg = "";
	
		for (int i = 0 ; i < cCards.length ; i++) {
			
			if(cCards[i] != null) {
				
				msg+= "Credit Card #: " + cCards[i].getNumber() + " -Available Credit: $" + cCards[i].getAvailableCredit() + " - Balance to pay: $" + cCards[i].getCurrentAccount().getBalanceToPay() + "\n";
				
			}
			
		}
		
		return msg;
	}	
	
	//------------------------------------------------------------------------------------
	
	//Method to string
	
	@Override
	public String toString() {
		return "Name: " + getName() + "\nID: " + getId() + "\nBirth date: " + getBirthday() + "\nStart date: " + startDate + "\nLast credit card pay date: " + lastCreditCardPayDate;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to clone active client
	
	public ActiveClient clone() {
		ActiveClient copyAC = new ActiveClient(this.getName(), this.getId(), this.getBirthday(), this.startDate);
		copyAC.setLastCreditCardPayDate(this.lastCreditCardPayDate);
		
		for (int i = 0; i < cCards.length; i++) {
			if(cCards[i]!=null && cAccounts[i]!=null){
				copyAC.createCreditCard(cCards[i].getNumber(), cAccounts[i].getNumber());
				copyAC.cCards[i].getCurrentAccount().setAvailableCredit(cCards[i].getAvailableCredit());
				copyAC.cCards[i].getCurrentAccount().setBalanceToPay(cCards[i].getBalanceToPay());
			}
		}
		
		for (int i = 0; i < dCards.length; i++) {
			if(sAccounts[i]!=null && dCards[i]!=null){
				copyAC.createSavingsAccount(sAccounts[i].getNumber(), dCards[i].getNumber());
				copyAC.dCards[i].getSavingAccount().setBalance(sAccounts[i].getBalance());			
			}
		}
		
		return copyAC;
	}
	
	
	//------------------------------------------------------------------------------------
	
	//Both methods suppose that the client has the card or account number
	
	public String getBalanceFromCreditCard(String cardNumber) {
		return Double.toString(cCards[searchCreditCard(cardNumber)].getAvailableCredit());
	}
	
	public String getBalanceFromSavingsAccount(String accountNumber) {
		return Double.toString(sAccounts[searchSavingsAccount(accountNumber)].getBalance());
	}

	public String getAmountToPayFromCreditCard(String cardNumber) {
		return Double.toString(cCards[searchCreditCard(cardNumber)].getBalanceToPay());
	}

}

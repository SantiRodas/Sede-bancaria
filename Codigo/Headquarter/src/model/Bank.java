package model;

public class Bank {
	
	//------------------------------------------------------------------------------------
	
	//Attributes of the CurrentAccount class
	
	private String bankName;
	
	//------------------------------------------------------------------------------------

	//Relations of the CurrentAccount class
	
	private HashTableInterface activeClients; //help I don't know how to define this

	private HashTableInterface removedClients; //help I don't know how to define this

	private StackInterface currentClientActions; //help I don't know how to define this
	
	private PriorityQueueInterface priorityQueue; //help I don't know how to define this

	private ActiveClient currentActiveClient;
	
	//------------------------------------------------------------------------------------

	
	// Constructor method of the Bank class

	public Bank(String n) {
		
		bankName = n;
		
	}
	
	//------------------------------------------------------------------------------------

	//Getters methods of the Bank class
	
	public String getBankName() {
		return bankName;
	}
	
	//------------------------------------------------------------------------------------

	//Setters methods of the Bank class

	public void setBankName(String n) {
		bankName = n;
	}
	
	//------------------------------------------------------------------------------------

	//Operations methods of the Bank class

	public void generateRandomClients(int activeAmount, int inactiveAmount) {
		
	}
	
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
	
	public ActiveClient[] getSortedClients(SortCriteria sortCriteria) {
		
	}
	
	public void saveAction() {
		
	}
	
	public void undoLastAction() {
		
	}
	
	public void assignClientToQueue(String id) {
		
	}
	
	public void attendNextClient() {
		
	}
	
	private void sortClientsByName(ActiveClient[] ac) {
		
	}
	
	private void sortClientsById(ActiveClient[] ac) {
		
	}
	
	private void sortClientsByStartDate(ActiveClient[] ac) {
		
	}
	
	private void sortClientsByLastCreditCardPayDate(ActiveClient[] ac) {
		
	}
	
	//------------------------------------------------------------------------------------

}

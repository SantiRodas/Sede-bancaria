/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package model;

import collections.HashTableInterface;
import collections.PriorityQueueInterface;
import collections.StackInterface;

public class Bank {
	
	//------------------------------------------------------------------------------------
	
	//Attributes of the CurrentAccount class
	
	private String bankName;
	
	//------------------------------------------------------------------------------------

	//Relations of the CurrentAccount class
	
	private HashTableInterface activeClients; 

	private HashTableInterface removedClients; 

	private StackInterface currentClientActions; 
	
	private PriorityQueueInterface priorityQueue; 

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
	
	//------------------------------------------------------------------------------------
	
	//Method to pay in a credit card
	
	public void payCreditCard(double amount) {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to retrieve a credit card
	
	public boolean retrieveCredit(double amount) {
		
		return true;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to retrieve savings in a credit card
	
	public boolean retrieveSavings(double amount) {
		
		return true;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to add savings in a credit card
	
	public void addSavings(double amount) {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to create
	
	public boolean createDebitCard() {
		
		return true;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to create a credit card
	
	public boolean createCreditCard() {
		
		return true;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to active client in the system
	
	public ActiveClient[] getSortedClients(SortCriteria sortCriteria) {
		return null;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to save action in the system
	
	public void saveAction() {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to know the last action in the system
	
	public void undoLastAction() {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method put a client in a queue
	
	public void assignClientToQueue(String id) {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to attend a client in a queue
	
	public void attendNextClient() {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to sort the clients by name
	
	private void sortClientsByName(ActiveClient[] ac) {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to sort the clients by id
	
	private void sortClientsById(ActiveClient[] ac) {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to sort the clients by date
	
	private void sortClientsByStartDate(ActiveClient[] ac) {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to sort clients by last credit card pay date
	
	private void sortClientsByLastCreditCardPayDate(ActiveClient[] ac) {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to search a client by id
	
	private Client searchClientbyId(String id) {
		return null;
		
	}
	
	//------------------------------------------------------------------------------------

}

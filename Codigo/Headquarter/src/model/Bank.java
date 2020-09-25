/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package model;

import java.util.Arrays;
import java.util.Comparator;

import collections.*;

public class Bank {
	
	//For 7 digit account number
	public static final long MAX_ACCOUNTS_NUMBER = 9999990; 
	
	//For 16 digit card number
	public static final long MAX_CARDS_NUMBER = Long.parseLong("9999999999999990");
	//------------------------------------------------------------------------------------
	
	//Attributes of the CurrentAccount class
	
	private String bankName;
	
	private HashTable<String,String> usedSavingAccountNumbers;
	
	private HashTable<String,String> usedDebitCardNumbers;
	
	private HashTable<String,String> usedCurrentAccountNumbers;
	
	private HashTable<String,String> usedCreditCardNumbers;
	
	//------------------------------------------------------------------------------------

	//Relations of the CurrentAccount class
	
	private HashTableInterface<String, ActiveClient> activeClients; 

	private HashTableInterface<String, RemovedClient> removedClients; 

	private StackInterface<?> currentClientActions; //Pending
	
	private PriorityQueueInterface<ActiveClient> priorityQueue; 
	
	private QueueInterface<ActiveClient> queue;

	private ActiveClient currentActiveClient;
	
	//------------------------------------------------------------------------------------

	// Constructor method of the Bank class

	public Bank(String n) {
		bankName = n;
		activeClients = new HashTable<>();
		removedClients = new HashTable<>();
		currentClientActions = new Stack<>();
		priorityQueue = new PriorityQueue<>(new Comparator<ActiveClient>() {
			@Override
			public int compare(ActiveClient ac1, ActiveClient ac2) {
				if(ac1.getBirthday().compareTo(ac2.getBirthday()) > 0) {
					return 1;
				}
				else if(ac1.getBirthday().compareTo(ac2.getBirthday()) < 0) {
					return -1;
				}
				else {
					return 0;
				}
			};
		
		});
		queue = new Queue<>();
		currentActiveClient = null;
		usedSavingAccountNumbers = new HashTable<>();
		usedDebitCardNumbers = new HashTable<>();
		usedCurrentAccountNumbers = new HashTable<>();
		usedCreditCardNumbers = new HashTable<>();
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
	
	public ActiveClient[] getActiveClientsArray(){
		return activeClients.getAll();
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to pay in a credit card
	
	public boolean payCreditCard(String cardNumber, double amount) {
		if(currentActiveClient != null) {
			return currentActiveClient.payCreditCard(cardNumber, amount);
		}
		else {
			return false;
		}
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to retrieve a credit card
	
	public boolean retrieveCredit(String cardNumber, double amount) {
		if(currentActiveClient != null) {
			return currentActiveClient.retrieveCredit(cardNumber, amount);
		}
		else {
			return false;
		}		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to retrieve savings in a credit card
	
	public boolean retrieveSavings(String accountNumber, double amount) {
		if(currentActiveClient != null) {
			return currentActiveClient.retrieveSavings(accountNumber, amount);
						
		}
		else {
			return false;
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to add savings in a credit card
	
	public boolean addSavings(String accountNumber, double amount) {
		if(currentActiveClient != null) {
			return currentActiveClient.addSavings(accountNumber, amount);
		}
		else {
			return false;
		}
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to create
	
	public boolean createSavingsAccount() {
		
		if(currentActiveClient != null) {
			return currentActiveClient.createSavingsAccount(generateNewSavingsAccountNumber(), generateNewDebitCardNumber());
		}
		else {
			return false;
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to create a credit card
	
	public boolean createCreditCard() {
		
		if(currentActiveClient != null) {
			return currentActiveClient.createCreditCard(generateNewCurrentAccountNumber(), generateNewCreditCardNumber());
		}
		else {
			return false;
		}
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to active client in the system
	
	public ActiveClient[] getSortedClients(SortCriteria sortCriteria) {
		
		ActiveClient[] ac = activeClients.getAll();
			
		switch(sortCriteria) {
		case NAME:
			sortClientsByName(ac);
		break;		
		case ID:
			sortClientsById(ac);
		break;
		case START_DATE:
			sortClientsByStartDate(ac);
		break;
		case BIRTHDAY:
			sortClientsByBirthday(ac);
		break;
		case NONE:
			return ac;		
		}
		
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
		ac = PriorityQueue.heapsort(ac, new Comparator<ActiveClient>() {			
			public int compare(ActiveClient ac1, ActiveClient ac2) {
				if(ac1.getName().compareTo(ac2.getName()) > 0) {
					return 1;
				}
				else if(ac1.getName().compareTo(ac2.getName()) < 0) {
					return -1;
				}
				else {
					return 0;
				}
			}
			
		});
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to sort the clients by id using mergesort
	
	private void sortClientsById(ActiveClient[] ac) {
		if(ac!=null && ac.length>1)
			mergesort(ac,0,ac.length-1);
	}
	
	private void mergesort(ActiveClient[] ac,int left, int right) {
		if (left < right){
            int m=(left+right)/2;
            mergesort(ac,left, m);
            mergesort(ac,m+1, right);                                                                                
            merge(ac,left, m, right);                                                                                 
		}
	}
	
	private void merge(ActiveClient[] ac,int left, int middle, int right) {
		 //Finds the length of the sub-vectors
		  int n1 = middle - left + 1;
		  int n2 = right - middle;

		  //Temporal arrays
		  ActiveClient leftArray[] = new ActiveClient[n1];
		  ActiveClient rightArray[] = new ActiveClient[n2];

		  //Copies the data to the temporal arrays
		  for (int i=0; i < n1; i++) { 
		    leftArray[i] = ac[left+i]; 
		  }
		  for (int j=0; j < n2; j++) {
		    rightArray[j] = ac[middle + j + 1]; 
		  }
		  /* Unites the temporal arrays */

		  //Start indexes of the first and second sub-arrays.
		  int i = 0, j = 0;

		  //Start index of the sub-vector ac.
		  int k = left;

		  //Sorting.
		  while (i < n1 && j < n2) {
		    if (leftArray[i].getId().compareTo(rightArray[j].getId())<=0 ) {
		      ac[k] = leftArray[i];
		      i++;
		    } else {
		        ac[k] = rightArray[j];
		        j++;
		    }
		    k++;
		  }//End of the while.

		  /* If there are remaining elements to sort */
		  //Copies the remaining elements of leftArray[].
		  while (i < n1) {
		    ac[k] = leftArray[i];
		    i++;
		    k++;
		  }
		  //Copies the remaining elements of rightArray[].
		  while (j < n2) {
		    ac[k] = rightArray[j];
		    j++;
		    k++;
		  }
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to sort the clients by date using bubble sort
	
	private void sortClientsByStartDate(ActiveClient[] ac) {
		if(ac!=null && ac.length>1) {
			for(int i = ac.length;i > 0;i--) {
				for(int j = 0;j < i-1;j++) {
					if(ac[j].getStartDate().compareTo(ac[j+1].getStartDate())>0) {
						ActiveClient temp = ac[j];
						ac[j] = ac[j+1];
						ac[j+1] = temp;
					}
				}
			}
		}
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to sort clients by last credit card pay date
	
	private void sortClientsByBirthday(ActiveClient[] ac) {
		Arrays.sort(ac, new Comparator<ActiveClient>() {
			@Override
			public int compare(ActiveClient ac1, ActiveClient ac2) {
				if(ac1.getBirthday().compareTo(ac2.getBirthday()) > 0) {
					return 1;
				}
				else if(ac1.getBirthday().compareTo(ac2.getBirthday()) < 0) {
					return -1;
				}
				else {
					return 0;
				}
			};
		
		});
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to search a client by id
	
	public Client searchClientbyId(String id) {
		return activeClients.search(id);		
	}
	
	//------------------------------------------------------------------------------------

	public String[] getCurrentClientCreditCardsNumbers() {
		return currentActiveClient.getCreditCardNumbers();
	}
	
	public String[] getCurrentClientSavingsAccountsNumbers() {
		return currentActiveClient.getSavingsAccountsNumbers();
	}
	
	private String generateNewSavingsAccountNumber() {
		if(usedSavingAccountNumbers.size() + usedCurrentAccountNumbers.size() < MAX_ACCOUNTS_NUMBER) {
			String number;
			do {
				number = Long.toString((long)Math.random()*((MAX_ACCOUNTS_NUMBER) + (long)1) + (long)1000000);
			}while(usedSavingAccountNumbers.search(number) != null && usedCurrentAccountNumbers.search(number) != null);
			usedSavingAccountNumbers.insert(number, number);
			return number;
		}
		return null;
	}
	
	private String generateNewCreditCardNumber() {
		if(usedCreditCardNumbers.size() + usedDebitCardNumbers.size() < MAX_CARDS_NUMBER) {
			String number;
			do {
				number = Long.toString((long)Math.random()*((MAX_CARDS_NUMBER) + (long)1) + Long.parseLong("1000000000000000"));
			}while(usedCreditCardNumbers.search(number) != null && usedDebitCardNumbers.search(number) != null);
			usedCreditCardNumbers.insert(number, number);
			return number;
		}
		return null;
	}
	
	private String generateNewDebitCardNumber() {
		if(usedCreditCardNumbers.size() + usedDebitCardNumbers.size() < MAX_CARDS_NUMBER) {
			String number;
			do {
				number = Long.toString((long)Math.random()*((MAX_CARDS_NUMBER) + (long)1) + Long.parseLong("1000000000000000"));
			}while(usedCreditCardNumbers.search(number) != null && usedDebitCardNumbers.search(number) != null);
			usedDebitCardNumbers.insert(number, number);
			return number;
		}
		return null;
	}
	
	private String generateNewCurrentAccountNumber() {
		if(usedSavingAccountNumbers.size() + usedCurrentAccountNumbers.size() < MAX_ACCOUNTS_NUMBER) {
			String number;
			do {
				number = Long.toString((long)Math.random()*((MAX_ACCOUNTS_NUMBER) + (long)1) + (long)1000000);
			}while(usedSavingAccountNumbers.search(number) != null && usedCurrentAccountNumbers.search(number) != null);
			usedCurrentAccountNumbers.insert(number, number);
			return number;
		}
		
		return null;
	}
}

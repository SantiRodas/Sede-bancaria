/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import collections.*;


public class Bank {
	
	//For 7 digit account number
	public static final double MAX_ACCOUNTS_NUMBER = 8999999.0; 
	
	//For 16 digit card number
	public static final double MAX_CARDS_NUMBER = 8999999999999999.0;
	
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

	private StackInterface<ActiveClient> currentClientActions; //Pending
	
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
					
				} else if(ac1.getBirthday().compareTo(ac2.getBirthday()) < 0) {
					
					return -1;
					
				} else {
					
					return 0;
					
				}
				
			}
		
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

	public boolean addNewActiveClient(String name, String id, LocalDate birthday, LocalDate startDate) {
		
		if(activeClients.search(id) == null) {
			
			activeClients.insert(id, new ActiveClient(name,id,birthday,startDate));
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Operations methods of the Bank class

	public void generateRandomClients(int activeAmount, int inactiveAmount) {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Active clients
	
	public ActiveClient[] getActiveClientsArray(){
		
		Object[] objA = activeClients.getAll();
		
		ActiveClient[] ac = new ActiveClient[objA.length];
		
		for (int i = 0; i < ac.length; i++) {
			
			ac[i] = (ActiveClient)objA[i];
			
		}
		
		return ac;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to pay in a credit card
	
	public boolean payCreditCard(String cardNumber, double amount) {
		
		if(currentActiveClient != null) {
			
			return currentActiveClient.payCreditCard(cardNumber, Math.round(amount*100.0)/100.0);
			
		} else {
			
			return false;
			
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to retrieve a credit card
	
	public boolean retrieveCredit(String cardNumber, double amount) {
		
		if(currentActiveClient != null) {
			
			return currentActiveClient.retrieveCredit(cardNumber, Math.round(amount*100.0)/100.0);
			
		} else {
			
			return false;
			
		}	
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to retrieve savings in a credit card
	
	public boolean retrieveSavings(String accountNumber, double amount) {
		
		if(currentActiveClient != null) {
			
			return currentActiveClient.retrieveSavings(accountNumber, Math.round(amount*100.0)/100.0);
						
		} else {
			
			return false;
			
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to add savings in a credit card
	
	public boolean addSavings(String accountNumber, double amount) {
		
		if(currentActiveClient != null) {
			
			return currentActiveClient.addSavings(accountNumber, Math.round(amount*100.0)/100.0);
			
		} else {
			
			return false;
			
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to create
	
	public StackInterface<ActiveClient> getCurrentClientActions() {
		return currentClientActions;
	}

	public void setCurrentClientActions(StackInterface<ActiveClient> currentClientActions) {
		this.currentClientActions = currentClientActions;
	}

	public boolean createSavingsAccount() {
		
		if(currentActiveClient != null) {
			
			return currentActiveClient.createSavingsAccount(generateNewSavingsAccountNumber(), generateNewDebitCardNumber());
		
		} else {
			
			return false;
			
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to create a credit card
	
	public boolean createCreditCard() {
		
		if(currentActiveClient != null) {
			
			return currentActiveClient.createCreditCard(generateNewCreditCardNumber(), generateNewCurrentAccountNumber());
		
		} else {
			
			return false;
			
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to active client in the system
	
	public void getSortedClients(SortCriteria sortCriteria) {
				
		Object[] objA = activeClients.getAll();
		
		ActiveClient[] ac = new ActiveClient[objA.length];
		
		for (int i = 0; i < ac.length; i++) {
			
			ac[i] = (ActiveClient)objA[i];
			
		}
		
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
				
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to save action in the system
	//Only works for bank operations except remove client
	
	public void saveAction() {
		
		if(currentActiveClient != null) {
			
			currentClientActions.push(currentActiveClient.clone());
			
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to know the last action in the system
	//Works for bank operations except remove client and create credit card or savings account
	
	public boolean undoLastAction() {
		
		if(currentActiveClient != null && !currentClientActions.isEmpty()) {
			
			currentActiveClient = currentClientActions.pop();
			
			activeClients.delete(currentActiveClient.getId());
			
			activeClients.insert(currentActiveClient.getId(), currentActiveClient);
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Clears actions history
	
	public void clearActions() {
		
		currentClientActions = new Stack<>();
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method put a client in a queue
	
	public int assignClientToQueue(String id) {
		
		ActiveClient ac = searchActiveClientById(id);
					
		if(ac != null) {
			
			if(Period.between(ac.getBirthday(), LocalDate.now()).getYears() >= 65) {
				
				priorityQueue.maxHeapInsert(ac);
				
				return 2;
				
			} else {
				
				queue.offer(ac);
				
				return 1;
			}
			
		}
		
		return 0;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to attend a client in a queue
	
	public boolean attendNextClient() {
		
		if(queue.isEmpty() && priorityQueue.isEmpty()) {
			
			currentActiveClient = null;
			
			return false;
			
		} else {
			
			if(priorityQueue.isEmpty()) {
				
				currentActiveClient = queue.poll();
				
				return true;
				
			} else {
				
				currentActiveClient = priorityQueue.heapExtractMax();
				
				return true;
				
			}			
		}
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to remove a client given its id
	
	public boolean removeActiveClient(String removalReason) {
				
		if(currentActiveClient != null) {
			
			boolean check = true;
			
			CreditCard[] cc = currentActiveClient.getcCards();
			SavingsAccount[] sa = currentActiveClient.getsAccounts();
			
			for (int i = 0; i < sa.length && check; i++) {
				if(sa[i] != null && sa[i].getBalance() != 0) {
					check = false;
				}
			}
			
			for (int i = 0; i < cc.length && check; i++) {
				if(cc[i] != null && cc[i].getBalanceToPay() != 0) {
					check = false;
				}
			}
			
			if(check) {
				activeClients.delete(currentActiveClient.getId());
				
				RemovedClient rc = new RemovedClient(currentActiveClient.getName(), currentActiveClient.getId(), currentActiveClient.getBirthday(), LocalDate.now(), removalReason);
				
				String[] cCNumbers = currentActiveClient.getCreditCardNumbers();
				
				String[] sANumbers = currentActiveClient.getSavingsAccountsNumbers();
				
				if(cCNumbers != null) {
					for (int i = 0; i < cCNumbers.length; i++) {
						if(cCNumbers[i] != null) {
							usedCreditCardNumbers.delete(cCNumbers[i]);
							
							usedCurrentAccountNumbers.delete(cCNumbers[i]);
						}
					}
				}
				
				if(sANumbers != null) {
					for (int i = 0; i < sANumbers.length; i++) {
						if(sANumbers[i] != null) {
							usedSavingAccountNumbers.delete(sANumbers[i]);
							
							usedDebitCardNumbers.delete(sANumbers[i]);
						}
					}
				}
					
				
				removedClients.insert(currentActiveClient.getId(), rc);
				
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
	
	//Method to sort the clients by name
	
	private void sortClientsByName(ActiveClient[] ac) {
		
		ac = PriorityQueue.heapsort(ac, new Comparator<ActiveClient>() {
			
			public int compare(ActiveClient ac1, ActiveClient ac2) {
				
				if(ac1.getName().compareTo(ac2.getName()) > 0) {
					
					return 1;
					
				} else if(ac1.getName().compareTo(ac2.getName()) < 0) {
					
					return -1;
					
				} else {
					
					return 0;
					
				}
			}
			
		});
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to sort the clients by id using merge sort
	
	private void sortClientsById(ActiveClient[] ac) {
		
		if(ac!=null && ac.length>1)
			
			mergesort(ac,0,ac.length-1);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Merge sort
	
	private void mergesort(ActiveClient[] ac,int left, int right) {
		
		if (left < right){
			
            int m=(left+right)/2;
            
            mergesort(ac,left, m);
            
            mergesort(ac,m+1, right);
            
            merge(ac,left, m, right); 
            
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Final merge
	
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
					
				} else if(ac1.getBirthday().compareTo(ac2.getBirthday()) < 0) {
					
					return -1;
					
				} else {
					
					return 0;
					
				}
				
			};
			
		});
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to search a client by id
	
	public ActiveClient searchActiveClientById(String id) {
		
		return activeClients.search(id);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Some get's method

	public String[] getCurrentClientCreditCardsNumbers() {
		return currentActiveClient.getCreditCardNumbers();
	}
	
	public String[] getCurrentClientSavingsAccountsNumbers() {
		return currentActiveClient.getSavingsAccountsNumbers();
	}
	
	//------------------------------------------------------------------------------------
	
	// Generate new saving accounts 
	
	private String generateNewSavingsAccountNumber() {
		if(usedSavingAccountNumbers.size() + usedCurrentAccountNumbers.size() < MAX_ACCOUNTS_NUMBER) {
			String number;
						
			do {
				
				number = Long.toString((long)(Math.random()*((MAX_ACCOUNTS_NUMBER) + 1.0) + 1000000.0));
				
			} while(usedSavingAccountNumbers.search(number) != null && usedCurrentAccountNumbers.search(number) != null);
			
			usedSavingAccountNumbers.insert(number, number);
			return number;
		}
		return null;
	}
	
	//------------------------------------------------------------------------------------
	
	// Generate new credit card
	
	private String generateNewCreditCardNumber() {
		if(usedCreditCardNumbers.size() + usedDebitCardNumbers.size() < MAX_CARDS_NUMBER) {
			String number;
			do {
				
				number = Long.toString((long)(Math.random()*((MAX_CARDS_NUMBER) + 1.0) + 1000000000000000.0));
								
				
			}while(usedCreditCardNumbers.search(number) != null && usedDebitCardNumbers.search(number) != null);
			usedCreditCardNumbers.insert(number, number);
			return number;
		}
		return null;
	}
	
	//------------------------------------------------------------------------------------
	
	//Generate new card
	
	private String generateNewDebitCardNumber() {
		if(usedCreditCardNumbers.size() + usedDebitCardNumbers.size() < MAX_CARDS_NUMBER) {
			String number;
			do {
				
				number = Long.toString((long)(Math.random()*((MAX_CARDS_NUMBER) + 1.0) + 1000000000000000.0));
				
			}while(usedCreditCardNumbers.search(number) != null && usedDebitCardNumbers.search(number) != null);
			usedDebitCardNumbers.insert(number, number);
			return number;
		}
		return null;
	}
	
	//------------------------------------------------------------------------------------
	
	//Generate new current accounts
	
	private String generateNewCurrentAccountNumber() {
		if(usedSavingAccountNumbers.size() + usedCurrentAccountNumbers.size() < MAX_ACCOUNTS_NUMBER) {
			String number;
			do {

				number = Long.toString((long)(Math.random()*((MAX_ACCOUNTS_NUMBER) + 1.0) + 1000000.0));
				
			}while(usedSavingAccountNumbers.search(number) != null && usedCurrentAccountNumbers.search(number) != null);
			usedCurrentAccountNumbers.insert(number, number);
			return number;
		}
		
		return null;
	}
	
	//------------------------------------------------------------------------------------
	
	//Returns queue and priority queue
	
	public ActiveClient[] getQueue(){
		
		ActiveClient[] ac = new ActiveClient[queue.size()];		
		
		if(queue.size() > 0) {
			
			for(int i = 0; i < ac.length; i++) {
				
				ac[i] = queue.poll();
				
			}
			
			for(int i = 0; i < ac.length; i++) {
				
				queue.offer(ac[i]);
				
			}
			
		}
		
		return ac;	
		
	}
	
	//------------------------------------------------------------------------------------
	
	public ActiveClient[] getPriorityQueue(){
		
		ActiveClient[] ac = new ActiveClient[priorityQueue.heapSize()];		
		
		if(priorityQueue.heapSize() > 0) {
			
			for(int i = 0; i < ac.length; i++) {
				
				ac[i] = priorityQueue.heapExtractMax();
				
			}
			
			for(int i = 0; i < ac.length; i++) {
				
				priorityQueue.maxHeapInsert(ac[i]);
				
			}			
			
		}
		
		return ac;		
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to get current active client

	public ActiveClient getCurrentActiveClient() {
		return currentActiveClient;
	}
	
	//------------------------------------------------------------------------------------
	
	
}

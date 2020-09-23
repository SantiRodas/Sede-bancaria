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
	
	//------------------------------------------------------------------------------------
	
	//Attributes of the CurrentAccount class
	
	private String bankName;
	
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
	
	private void sortClientsById(ActiveClient[] ac,int left, int right) {
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
	
	private Client searchClientbyId(String id) {
		return activeClients.search(id);		
	}
	
	//------------------------------------------------------------------------------------

}

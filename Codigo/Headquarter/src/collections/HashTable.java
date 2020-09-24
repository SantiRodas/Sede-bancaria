/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package collections;

public class HashTable<K,V> implements HashTableInterface<K,V> {
	
	//------------------------------------------------------------------------------------
	
	//Attributes of the hash table

	public static final int DEFAULT_CAPACITY = 1000000;

	private int capacity;

	private int size;
	
	private HashTableNode<K,V>[] nodesArray;
	
	//------------------------------------------------------------------------------------
	
	//Constructor method 1 of the hash table
	
	@SuppressWarnings("unchecked")
	public HashTable() {
		nodesArray = (HashTableNode<K,V>[]) new HashTableNode[DEFAULT_CAPACITY];
		capacity = DEFAULT_CAPACITY;
	}
	
	//------------------------------------------------------------------------------------
	
	//Constructor method 2 of the hash table
	
	@SuppressWarnings("unchecked")
	public HashTable(int capacity) {
		nodesArray = (HashTableNode<K,V>[]) new HashTableNode[capacity];
		this.capacity = capacity;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method insert of the hash table
	
	public void insert(K key, V value) {
		
		int i = hash(key);
		
		if(nodesArray[i] == null) {
			
			nodesArray[i] = new HashTableNode<K,V>(key,value,null,null);
			
		} else {						
			
			nodesArray[i] = new HashTableNode<K,V>(key,value,null,nodesArray[i]);	
			
		}	
		
		size++;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method delete of the hash table
	
	public V delete(K key) {
		
		int i = hash(key);
		
		if(nodesArray[i] == null) {
			
			return null;
			
		} else {
			
			boolean found = false;
			
			HashTableNode<K,V> temp = nodesArray[i];
			
			while(temp != null && !found) {
				
				if(temp.getKey().equals(key)) {
					
					found = true;
					
				} else {
					
					temp = temp.getNextNode();
					
				}		
				
			}
			
			if(found) {
				
				if(temp.getPrevNode() == null && temp.getNextNode() == null) {
					
					nodesArray[i] = null;
					
				} else if(temp.getPrevNode() == null) {
					
					nodesArray[i] = temp.getNextNode();
					
					nodesArray[i].setPrevNode(null);
					
				} else if(temp.getNextNode() == null) {
					
					temp.getPrevNode().setNextNode(null);
					
				} else {
					
					temp.getNextNode().setPrevNode(temp.getPrevNode());
					
					temp.getPrevNode().setNextNode(temp.getNextNode());
					
				}	
				
				size--;
				
				return temp.getValue();
				
			} else {
				
				return null;
				
			}	
			
		}	
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method serach of the hash table
	
	public V search(K key) {
		
		int i = hash(key);
					
		if(nodesArray[i] == null) {
			
			return null;
			
		} else {
			
			HashTableNode<K,V> temp = nodesArray[i];
			
			while(temp != null) {
				
				if(temp.getKey().equals(key)) {
					
					return temp.getValue();
					
				} else {
					
					temp = temp.getNextNode();
					
				}
				
			}
			
			return null;
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method hash of the hash table
	
	public int hash(K key) {
		return (key.hashCode()%capacity < 0)? (key.hashCode()%capacity)*-1 : key.hashCode()%capacity;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method size of the hash table
	
	public int size() {
		return size;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to get capacity of the hash table
	
	public int getCapacity() {
		return capacity;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method empty of the hash table
	
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V[] getAll() {
		@SuppressWarnings("unchecked")
		V[] vArray = (V[]) new Object[size];
		int j = 0;
		
		for (int i = 0; i < nodesArray.length; i++) {
			if(nodesArray[i] != null) {
				HashTableNode<K,V> temp = nodesArray[i];
				
				while(temp != null) {
					vArray[j] = temp.getValue();					
					temp = temp.getNextNode();
					j++;
				}
			}
		}
		return vArray;
	}
	
	//------------------------------------------------------------------------------------
	
}

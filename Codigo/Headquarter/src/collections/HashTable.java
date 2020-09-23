package collections;

public class HashTable<K,V> implements HashTableInterface<K,V> {

	public static final int DEFAULT_CAPACITY = 1000000;
	//Node's array size
	private int capacity;
	//Number of elements in the table
	private int size;
	
	private HashTableNode<K,V>[] nodesArray;		
	
	@SuppressWarnings("unchecked")
	public HashTable() {
		nodesArray = (HashTableNode<K,V>[]) new HashTableNode[DEFAULT_CAPACITY];
		capacity = DEFAULT_CAPACITY;
	}
	
	
	@SuppressWarnings("unchecked")
	public HashTable(int capacity) {
		nodesArray = (HashTableNode<K,V>[]) new HashTableNode[capacity];
		this.capacity = capacity;
	}
	
	public void insert(K key, V value) {
		int i = hash(key);
		
		if(nodesArray[i] == null) {
			nodesArray[i] = new HashTableNode<K,V>(key,value,null,null);
		}
		else {						
			nodesArray[i] = new HashTableNode<K,V>(key,value,null,nodesArray[i]);			
		}	
		size++;
	}
	
	public V delete(K key) {
		int i = hash(key);
		
		if(nodesArray[i] == null) {
			return null;
		}
		else {
			boolean found = false;
			HashTableNode<K,V> temp = nodesArray[i];
			
			while(temp != null && !found) {
				if(temp.getKey().equals(key)) {
					found = true;					
				}
				else {
					temp = temp.getNextNode();
				}				
			}
			if(found) {
				if(temp.getPrevNode() == null && temp.getNextNode() == null) {
					nodesArray[i] = null;
				}
				else if(temp.getPrevNode() == null) {
					nodesArray[i] = temp.getNextNode();
					nodesArray[i].setPrevNode(null);					
				}
				else if(temp.getNextNode() == null) {
					temp.getPrevNode().setNextNode(null);
				}
				else {
					temp.getNextNode().setPrevNode(temp.getPrevNode());
					temp.getPrevNode().setNextNode(temp.getNextNode());
				}	
				
				size--;
				return temp.getValue();
			}
			else {
				return null;
			}			
		}			
	}
	
	public V search(K key) {
		int i = hash(key);
					
		if(nodesArray[i] == null) {
			return null;
		}
		else {
			HashTableNode<K,V> temp = nodesArray[i];
			while(temp != null) {
				if(temp.getKey().equals(key)) {
					return temp.getValue();
				}
				else {
					temp = temp.getNextNode();
				}
				
			}
			return null;
		}
	}
	
	public int hash(K key) {
		return (key.hashCode()%capacity < 0)? (key.hashCode()%capacity)*-1 : key.hashCode()%capacity;
	}
	
	public int size() {
		return size;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}

/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package collections;

public class HashTableNode<K,V> {
	
	//------------------------------------------------------------------------------------
	
	//Attributes of the hash table node 
	
	private K key;
	
	private V value;
	
	private HashTableNode<K,V> prevNode;
	
	private HashTableNode<K,V> nextNode;
	
	//------------------------------------------------------------------------------------
	
	//Constructor method of the hash table node
	
	public HashTableNode(K key, V value, HashTableNode<K,V> prevNode, HashTableNode<K,V> nextNode) {
		
		this.key = key;
		this.value = value;
		this.prevNode = prevNode;
		this.nextNode = nextNode;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method's get of the hash table node

	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public HashTableNode<K, V> getPrevNode() {
		return prevNode;
	}
	
	public HashTableNode<K, V> getNextNode() {
		return nextNode;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method's set of the hash table node

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public void setPrevNode(HashTableNode<K, V> prevNode) {
		this.prevNode = prevNode;
	}

	public void setNextNode(HashTableNode<K, V> nextNode) {
		this.nextNode = nextNode;
	}
	
	//------------------------------------------------------------------------------------
	
}

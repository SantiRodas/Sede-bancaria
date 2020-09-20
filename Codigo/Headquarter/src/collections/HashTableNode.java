package collections;

public class HashTableNode<K,V> {
	private K key;
	private V value;
	private HashTableNode<K,V> prevNode;
	private HashTableNode<K,V> nextNode;
	
	public HashTableNode(K key, V value, HashTableNode<K,V> prevNode, HashTableNode<K,V> nextNode) {
		this.key = key;
		this.value = value;
		this.prevNode = prevNode;
		this.nextNode = nextNode;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public HashTableNode<K, V> getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(HashTableNode<K, V> prevNode) {
		this.prevNode = prevNode;
	}

	public HashTableNode<K, V> getNextNode() {
		return nextNode;
	}

	public void setNextNode(HashTableNode<K, V> nextNode) {
		this.nextNode = nextNode;
	}	
}

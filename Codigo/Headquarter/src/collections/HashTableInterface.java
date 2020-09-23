package collections;

public interface HashTableInterface<K,V> {
	public void insert(K key, V value);
	public V delete(K key);
	public V search(K key);
	public boolean isEmpty();
	public int size();
	public int getCapacity();
}

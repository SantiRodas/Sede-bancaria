package collections;

public interface QueueInterface<E> {
 
	public void offer(E newValue);
	
	public E poll();
	
	public E peek();

	public boolean isEmpty();
	
}

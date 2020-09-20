package collections;

public interface PriorityQueueInterface<E> {

	void insert(E e);
	
	E extractMax();
	
	E max();
	
	boolean isEmpty();
	
}

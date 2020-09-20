package collections;

public class Queue<T> implements QueueInterface<T>{
	
	private int size;
	
	private Node<T> front;
	
	private Node<T> back;
	
	public Queue() {
		front = null;
		back = null;
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	
	public void offer(T newValue) {
		Node<T> toAdd = new Node<T>(newValue);
		if(size==0) {
			front = toAdd;
		}
		else if(size==1) {
			front.setNext(toAdd);
			back = toAdd;
		}
		else {
			back.setNext(toAdd);
			back = toAdd;
		}
		size++;
	}

	
	public T poll() {
		if(size==0) {
			return null;
		}
		else {
			Node<T> aux = front;
			front = aux.getNext();
			size--;
			return aux.getValue();
		}
		
	}

	
	public T peek() {
		if(size!=0)
			return front.getValue();
		else
			return null;
	}

	
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		else {
			return false;
		}
	}

}

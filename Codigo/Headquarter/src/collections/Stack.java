package collections;

public class Stack<B> implements StackInterface<B>{

	private Node<B> top;
	
	private int size;
	
	public Stack() {
		top = null;
		size = 0;
	}
	
	@Override
	public B pop() {
		
		if(size==0) {
			return null;
		}
		else {
			Node<B> aux = top;
			top = aux.getNext();
			size--;
			return aux.getValue();
		}
		
	}
	
	@Override
	public void push(B toAdd) {
		Node<B> oldTop = top;
		top = new Node<B>(toAdd);
		top.setNext(oldTop);
		size++;
	}
	
	@Override
	public B peek() {
		if(top!=null)
			return top.getValue();
		else
			return null;
	}
	
	public int size() {
		return size;
	}
	
	public Node<B> getTop(){
		return top;
	}
	
	@Override
	public void empty() {
		size = 0;
		top = null;
	}
	
	@Override
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		else {
			return false;
		}
	}


}

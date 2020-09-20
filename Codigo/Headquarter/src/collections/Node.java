package collections;

public class Node<P> {
	
	private Node<P> next;
	
	private P value;
	
	public Node(P value) {
		this.value = value;
	}

	public Node<P> getNext() {
		return next;
	}

	public void setNext(Node<P> next) {
		this.next = next;
	}

	public P getValue() {
		return value;
	}

	public void setValue(P value) {
		this.value = value;
	}
	

}

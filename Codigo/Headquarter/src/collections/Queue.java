/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package collections;

public class Queue<T> implements QueueInterface<T>{
	
	//------------------------------------------------------------------------------------
	
	//Attributes of the queue generic
	
	private int size;
	
	private Node<T> front;
	
	private Node<T> back;
	
	//------------------------------------------------------------------------------------
	
	//Constructor method of the queue generic
	
	public Queue() {
		
		front = null;
		
		back = null;
		
		size = 0;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method size of the queue generic
	
	@Override
	public int size() {
		return size;
	}

	//------------------------------------------------------------------------------------
	
	//Method offer of the queue generic
	
	public void offer(T newValue) {
		
		Node<T> toAdd = new Node<T>(newValue);
		
		if(size==0) {
			
			front = toAdd;
			
		} else if(size==1) {
			
			front.setNext(toAdd);
			
			back = toAdd;
			
		} else {
			
			back.setNext(toAdd);
			
			back = toAdd;
			
		}
		
		size++;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method poll of the queue generic
	
	public T poll() {
		
		if(size==0) {
			
			return null;
			
		} else {
			
			Node<T> aux = front;
			
			front = aux.getNext();
			
			size--;
			
			return aux.getValue();
			
		}
		
	}

	//------------------------------------------------------------------------------------
	
	//Method peel of the queue generic
	
	public T peek() {
		
		if(size!=0)
			
			return front.getValue();
		
		else
			
			return null;
	}

	//------------------------------------------------------------------------------------
	
	//Method isEmpty of the queue generic
	
	public boolean isEmpty() {
		
		if(size==0) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	//------------------------------------------------------------------------------------

}

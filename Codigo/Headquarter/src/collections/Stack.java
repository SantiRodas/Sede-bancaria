/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package collections;

public class Stack<B> implements StackInterface<B>{
	
	//------------------------------------------------------------------------------------
	
	//Attributes of the generic stack

	private Node<B> top;
	
	private int size;
	
	//------------------------------------------------------------------------------------
	
	//Constructor method of the generic stack
	
	public Stack() {
		top = null;
		size = 0;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method pop of the generic stack
	
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
	
	//------------------------------------------------------------------------------------
	
	//Method push of the generic stack
	
	@Override
	public void push(B toAdd) {
		Node<B> oldTop = top;
		top = new Node<B>(toAdd);
		top.setNext(oldTop);
		size++;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method peek of the generic stack
	
	@Override
	public B peek() {
		if(top!=null)
			return top.getValue();
		else
			return null;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method size of the generic stack
	
	@Override
	public int size() {
		return size;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method empty of the generic stack
	
	@Override
	public void empty() {
		size = 0;
		top = null;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method isEmpty of the generic stack
	
	@Override
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//------------------------------------------------------------------------------------


}

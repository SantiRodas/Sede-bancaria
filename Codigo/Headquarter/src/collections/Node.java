/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package collections;

public class Node<P> {
	
	//------------------------------------------------------------------------------------
	
	//Attributes of the node class
	
	private Node<P> next;
	
	private P value;
	
	//------------------------------------------------------------------------------------
	
	//Constructor method of the node class
	
	public Node(P value) {
		this.value = value;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method of the node class to get the next element

	public Node<P> getNext() {
		return next;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method of the node class to set the next element

	public void setNext(Node<P> next) {
		this.next = next;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to get the value of the node class

	public P getValue() {
		return value;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to set the value of the node class
	
	public void setValue(P value) {
		this.value = value;
	}
	
	//------------------------------------------------------------------------------------

}

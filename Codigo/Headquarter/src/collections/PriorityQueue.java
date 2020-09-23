/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package collections;

import java.util.Comparator;

public class PriorityQueue<E> implements PriorityQueueInterface<E>{
	
	//------------------------------------------------------------------------------------
	
	//Attributes of the priority queue
	
	private E[] elementsHeap;
	
	//------------------------------------------------------------------------------------
	
	//Constructor method of the priority queue
	
	public PriorityQueue(Comparator<E> c) {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Constructor method 2 of the priority queue
	
	public PriorityQueue(E[] unorderedArray, Comparator<E> c) {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method parent of the priority queue
	
	private int parent(int index) {
		return index;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method left of the priority queue
	
	private int left(int index) {
		return index;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method right of the priority queue
	
	private int right(int index) {
		return index;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method max of the priority queue
	
	private void maxHeapify(int index) {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method insert of the priority queue

	@Override
	public void insert(E e) {
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method extract of the priority queue

	@Override
	public E extractMax() {
		return null;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method max (return E) of the priority queue

	@Override
	public E max() {
		return null;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method empty of the priority queue

	@Override
	public boolean isEmpty() {
		return false;
	}
	
	//------------------------------------------------------------------------------------

}

/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package collections;

public interface PriorityQueueInterface<E> {
	
	//------------------------------------------------------------------------------------
	
	//Method 1

	public void maxHeapInsert(E e);
	
	//------------------------------------------------------------------------------------
	
	//Method 2
	
	public E heapExtractMax();
	
	//------------------------------------------------------------------------------------
	//Method 3
	
	public E heapMax();
	
	//------------------------------------------------------------------------------------
	
	//Method 4
	
	public boolean isEmpty();
	
	//------------------------------------------------------------------------------------
	
	
}

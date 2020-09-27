/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package collections;

import java.util.Arrays;
import java.util.Comparator;

public class PriorityQueue<E> implements PriorityQueueInterface<E>{
	
	//------------------------------------------------------------------------------------
	
	//Attributes of the priority queue class
	
	public static int DEFAULT_CAPACITY = 10;
	
	private E[] heap;
	
	private int length;
	private int heapSize;
	
	private Comparator<E> comparator;
	
	//------------------------------------------------------------------------------------
	
	//Constructor method
	
	@SuppressWarnings("unchecked")
	public PriorityQueue(Comparator<E> c) {
		
		heap = (E[]) new Object[DEFAULT_CAPACITY];
		
		length = 10;
		
		heapSize = 0;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Another constructor method
		
	public PriorityQueue(E[] unorderedArray, int heapSize, Comparator<E> c) {
		
		heap = unorderedArray;
		
		length = unorderedArray.length;
		
		this.heapSize = heapSize;
		
		buildHeap();
		
	}	
	
	//------------------------------------------------------------------------------------
	
	//Method to build the heap
	
	private void buildHeap() { 
		
		for(int i = heapSize/2 ; i >= 0 ; i--) {
			
			maxHeapify(i);
			
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to insert in the max heap
		
	public void maxHeapInsert(E element) {
		
		ensureSize(length*2);
		
		heap[heapSize] = element;
		
		heapSize++;	
		
		for(int i = heapSize - 1; i >= 0 ; i = parent(i)) {
			
			maxHeapify(parent(i));
			
		}
				
		maxHeapify(parent(heapSize));	
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to extract the max heap
	
	public E heapExtractMax() {
		
		if(heapSize > 0) {
			
			E max = heap[0];
			
			if(heapSize == 1) {
				
				heap[0] = null;	
				
			} else {	
				
				heap[0] = heap[heapSize-1];
				
				heap[heapSize - 1] = null;
				
				maxHeapify(0);	
				
			}
			
			heapSize--;
			
			return max;
			
		}
		
		return null;		
	}
	
	//------------------------------------------------------------------------------------
	
	// Method to get max heap
	
	public E heapMax() {		
		return heap[0];
	}
	
	//------------------------------------------------------------------------------------
	
	//Method to do max
	
	private void maxHeapify(int index) {
		
		int left = left(index);
		
		int right = right(index);
		
		int largest;
		
		if(left < heapSize && comparator.compare(heap[left],heap[index]) > 0) {
			
			largest = left;
			
		} else {
			
			largest = index;
			
		}
		
		if(right < heapSize && comparator.compare(heap[right], heap[largest]) > 0) {
			
			largest = right;
			
		}
		
		if(largest != index) {
			
			//Exchange
			E temp = heap[largest];
			
			heap[largest] = heap[index];
			
			heap[index] = temp;		
			
			maxHeapify(largest);
			
		} 
		
	}	
	
	//------------------------------------------------------------------------------------
	
	//Method to do heap sort
	
	public static<T> T[] heapsort(T[] array, Comparator<T> comparator){
		
		PriorityQueue<T> mH = new PriorityQueue<T>(array, array.length, comparator);
		
		for(int i = array.length - 1; i >= 0 ; i++) {
			
			array[i] = mH.heapExtractMax();
			
		}	
		
		return array;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method ensure size
		
	private void ensureSize(int newLength) {
		
		if((double)length/(double)heapSize >= 0.9 && newLength > length) {
			
			heap = Arrays.copyOf(heap, newLength);
			
			length = newLength;
			
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Method length
	
	public int length() {
		return length;
	}
	
	//------------------------------------------------------------------------------------
	
	//Method heap size
	
	public int heapSize() {
		return heapSize;
	}	
	
	//------------------------------------------------------------------------------------
	
	//Method isEmpty
	
	public boolean isEmpty() {
		return heapSize == 0;
	}
	
	//------------------------------------------------------------------------------------
	
	//Left method
		
	private int left(int index) {
		return 2*index + 1;
	}
	
	//------------------------------------------------------------------------------------
	
	//Right method
	
	private int right(int index) {
		return 2*index + 2;
	}
	
	//------------------------------------------------------------------------------------
	
	//Parent method

	private int parent(int index) {
		return (index - 1)/2;
	}	
	
	//------------------------------------------------------------------------------------
}
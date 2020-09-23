/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package collections;

import java.util.Arrays;
import java.util.Comparator;

public class PriorityQueue<E> implements PriorityQueueInterface<E>{
	
	public static int DEFAULT_CAPACITY = 10;
	private E[] heap;
	private int length;
	private int heapSize;
	private Comparator<E> comparator;
	
	@SuppressWarnings("unchecked")
	public PriorityQueue(Comparator<E> c) {
		heap = (E[]) new Object[DEFAULT_CAPACITY];
		length = 10;
		heapSize = 0;
	}
		
	public PriorityQueue(E[] unorderedArray, int heapSize, Comparator<E> c) {
		heap = unorderedArray;
		
		length = unorderedArray.length;
		this.heapSize = heapSize;
		
		buildHeap();
		
	}	
	
	private void buildHeap() { 
		for(int i = heapSize/2 ; i >= 0 ; i--) {
			maxHeapify(i);
		}
	}
		
	public void maxHeapInsert(E element) {
		ensureSize(length*2);
		
		heap[heapSize] = element;
		heapSize++;	
		
		for(int i = heapSize - 1; i >= 0 ; i = parent(i)) {
			maxHeapify(parent(i));
		}
				
		maxHeapify(parent(heapSize));					
	}
	
	public E heapExtractMax() {
		
		if(heapSize > 0) {
			E max = heap[0];
			
			if(heapSize == 1) {
				heap[0] = null;							
			}
			else {				
				heap[0] = heap[heapSize-1];
				heap[heapSize - 1] = null;
				maxHeapify(0);							
			}
			
			heapSize--;
			
			return max;
		}
		return null;		
	}
	
	public E heapMax() {		
		return heap[0];
	}
	
	private void maxHeapify(int index) {
		int left = left(index);
		int right = right(index);
		int largest;
		
		
		if(left < heapSize && comparator.compare(heap[left],heap[index]) > 0) {
			largest = left;
		}
		else {
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
		}
		else {
			maxHeapify(largest);
		}
	}	
	
	//Out place sort, returns sorted array of type T in decreasing order
	public static<T> T[] heapsort(T[] unorderedArray, Comparator<T> comparator){
		PriorityQueue<T> mH = new PriorityQueue<T>(Arrays.copyOf(unorderedArray, unorderedArray.length), unorderedArray.length, comparator);
		
		@SuppressWarnings("unchecked")
		T[] sortedArray = (T[]) new Object[unorderedArray.length];
				
		for(int i = unorderedArray.length - 1; i >= 0 ; i++) {
			sortedArray[i] = mH.heapExtractMax();
		}	
		
		return sortedArray;
	}
		
	private void ensureSize(int newLength) {
		if((double)length/(double)heapSize >= 0.9 && newLength > length) {
			heap = Arrays.copyOf(heap, newLength);
			length = newLength;
		}
	}
	
	
	public int length() {
		return length;
	}
	
	public int heapSize() {
		return heapSize;
	}	
	
	public boolean isEmpty() {
		return heapSize == 0;
	}
		
	private int left(int index) {
		return 2*index + 1;
	}
	
	private int right(int index) {
		return 2*index + 2;
	}

	private int parent(int index) {
		return (index - 1)/2;
	}

	
	
}
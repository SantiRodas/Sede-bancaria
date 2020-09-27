/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestPriorityQueue<E> {
	
	//------------------------------------------------------------------------------------
	
	//Relation with priority Queue
	
	PriorityQueue<E> priorityQueue;
	
	//------------------------------------------------------------------------------------
	
	//Setup 1
	
	void setup1() {
		
		priorityQueue = new PriorityQueue<E>(null);
		
	}
		
	//------------------------------------------------------------------------------------
	
	//Test max heap insert
	
	@Test
	void maxHeapInsertTest1() {
		
		setup1();
		
		E node = null;
		
		priorityQueue.maxHeapInsert(node);
		
		assertTrue(priorityQueue.heapSize() == 1);
		
	}
	
	//****************************************
	
	@Test
	void maxHeapInsertTest2() {
		
		setup1();
		
		assertTrue(priorityQueue.heapSize() == 0);
		
	}
	
	//****************************************
	
	@Test
	void maxHeapInsertTest3() {
		
		setup1();
		
		assertTrue(priorityQueue.heapSize() == 0);
		
		assertTrue(priorityQueue.isEmpty());
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test heap extract max
	
	@Test
	void heapExtractMaxTest1() {
		
		setup1();
		
		assertNull(priorityQueue.heapExtractMax());
		
	}
	
	//****************************************
	
	@Test
	void heapExtractMaxTest2() {
		
		setup1();
		
		E node = null;
		
		priorityQueue.maxHeapInsert(node);
		
		assertNull(priorityQueue.heapExtractMax());
		
	}
	
	//****************************************
	
	@Test
	void heapExtractMaxTest3() {
		
		setup1();
		
		E node = null;
		
		priorityQueue.maxHeapInsert(node);
		
		assertNull(priorityQueue.heapExtractMax());
		
		assertEquals(priorityQueue.heapSize(), 0);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test max
	
	@Test
	void maxHeapifyTest1() {
		
		setup1();
		
		assertNull(priorityQueue.heapMax());
		
	}
	
	//****************************************
	
	@Test
	void maxHeapifyTest2() {
		
		setup1();
		
		assertEquals(priorityQueue.heapMax(), null);
		
	}
	
	@Test
	void maxHeapifyTest3() {
		
		setup1();
		
		assertTrue(priorityQueue.heapMax() == null);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test isEmpty
	
	@Test
	void isEmptyTest1() {
		
		setup1();
		
		assertEquals(priorityQueue.isEmpty(), true);
		
	}
	
	//****************************************
	
	@Test
	void isEmptyTest2() {
		
		setup1();
		
		E node = null;
		
		priorityQueue.maxHeapInsert(node);
		
		assertFalse(priorityQueue.isEmpty());
		
	}
	
	//****************************************
	
	@Test
	void isEmptyTest3() {
		
		setup1();
		
		E node = null;
		
		priorityQueue.maxHeapInsert(node);
		
		assertFalse(priorityQueue.isEmpty());
		
		assertEquals(priorityQueue.heapSize(), 1);
		
	}
	
	//------------------------------------------------------------------------------------
	
	
}

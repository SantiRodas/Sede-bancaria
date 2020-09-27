/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class TestQueue<T> {
	
	//------------------------------------------------------------------------------------
	
	//Relation with queue
	
	Queue<T> queue;
	
	//------------------------------------------------------------------------------------
	
	//Setup 1
	
	void setup1() {
		
		queue = new Queue<>();
		
	}
		
	//------------------------------------------------------------------------------------
	
	//Test offer
	
	@Test
	void offerTest1() {
		
		setup1();
		
		T node = null;
		
		queue.offer(node);
		
		int size = queue.size();
		
		assertTrue(size == 1);
		
	}
	
	//****************************************
	
	@Test
	void offerTest2() {
		
		setup1();
		
		T node1 = null;
		
		T node2 = null;
		
		queue.offer(node1);
		
		queue.offer(node2);
		
		int size = queue.size();
		
		assertTrue(size == 2);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test poll
	
	@Test
	void pollTest1() {
		
		setup1();
		
		assertTrue(queue.poll() == null);
		
	}
	
	//****************************************
	
	@Test
	void pollTest2() {
		
		setup1();
		
		T node = null;
		
		queue.offer(node);
		
		int size = queue.size();
		
		assertTrue(size == 1);
		
		assertTrue(queue.poll() == null);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test peek
	
	@Test
	void peekTest1() {
		
		setup1();
		
		assertTrue(queue.peek() == null);
		
	}
	
	//****************************************
	
	@Test
	void peekTest2() {
		
		setup1();
		
		T node = null;
		
		queue.offer(node);
		
		int size = queue.size();
		
		assertTrue(size == 1);
		
		assertFalse(size == 2);
		
		assertTrue(queue.peek() == null);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test isEmpty
	
	@Test
	void isEmptyTest1() {
		
		setup1();
		
		assertTrue(queue.isEmpty() == true);
		
	}
	
	//****************************************
	
	@Test
	void isEmptyTest2() {
		
		setup1();
		
		T node = null;
		
		queue.offer(node);
		
		int size = queue.size();
		
		assertTrue(size == 1);
		
		assertFalse(queue.isEmpty());
		
	}
	
	//------------------------------------------------------------------------------------

}

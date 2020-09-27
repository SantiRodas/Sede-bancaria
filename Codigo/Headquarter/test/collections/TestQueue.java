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
	
	//****************************************
	
	@Test
	void offerTest3() {
		
		Queue<String> theQueue = new Queue<String>();
		
		theQueue.offer("String1");
		
		theQueue.offer("String2");
		
		theQueue.offer("String3");
		
		theQueue.offer("String4");
		
		int size = theQueue.size();
		
		assertTrue(size == 4);
		
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
	
	//****************************************
	
	@Test
	void pollTest3() {
		
		Queue<Double> v = new Queue<Double>();
		
		v.offer(545.2);
		v.offer(90.8);
		v.offer(6.55);
		v.offer(7.7);
		
		int size = v.size();
		
		assertTrue(size == 4);
		
		assertTrue(v.poll() == 545.2);
		
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
	
	//****************************************
	
	@Test
	void peekTest3() {
		
		Queue<String> q = new Queue<String>();
		
		q.offer("Texto de prueba");
		q.offer("String 1");
		q.offer("String 2");
		
		int size = q.size();
		
		assertTrue(size == 3);
		
		assertFalse(size == 2);
		
		assertTrue(q.peek() == "Texto de prueba");
		
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
	
	//****************************************
	
	@Test
	void isEmptyTest3() {
		
		setup1();
		
		Queue<Integer> q = new Queue<Integer>();
		
		int d = 9;
		int w = 87;
		
		q.offer(d);
		q.offer(w);
		
		int size = q.size();
		
		assertTrue(size == 2);
		
		assertFalse(q.isEmpty());
		
	}
	
	//------------------------------------------------------------------------------------

}

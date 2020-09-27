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

class TestStack<T> {
	
	//------------------------------------------------------------------------------------
	
	//Relation with stack
	
	Stack<T> stack;
	
	//------------------------------------------------------------------------------------
	
	//Setup1 stack
	
	void setup1() {
		
		stack = new Stack<>();
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Pop test
	
	@Test
	void popTest1() {
		
		setup1();
		
		assertNull(stack.pop());
		
	}
	
	//****************************************
	
	@Test
	void popTest2() {
		
		setup1();
		
		T node = null;
		
		stack.push(node);
		
		assertTrue(stack.size() == 1);
		
		assertTrue(stack.pop() == null);
		
	}
	
	//------------------------------------------------------------------------------------
	
	@Test
	void popTest3() {
		
		setup1();
		Stack<Integer> h = new Stack<Integer>();
		
		int t = 9;
		int e = 54;
		int r = 32;
		
		h.push(t);
		h.push(e);
		h.push(r);
		
		assertTrue(h.size() == 3);
		
		assertTrue(h.pop() == 32);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Push test
	
	@Test
	void pushTest1() {
		
		setup1();
		
		T node = null;
		
		stack.push(node);
		
		int size = stack.size();
		
		assertEquals(size, 1);
		
	}
	
	//****************************************
	
	@Test
	void pushTest2() {
		
		setup1();
		
		T node1 = null;
		
		T node2 = null;
		
		stack.push(node1);
		
		stack.push(node2);
		
		int size = stack.size();
		
		assertTrue(size == 2);
		
	}
	
	//------------------------------------------------------------------------------------
	
	@Test
	void pushTest3() {
		
		Stack<Double> c = new Stack<Double>();
		
		Double o = 3.5;
		
		Double u = 9.1;
		
		c.push(o);
		
		c.push(u);
		
		int size = c.size();
		
		assertTrue(size == 2);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Peek test
	
	@Test
	void peekTest1() {
		
		setup1();
		
		T node = null;
		
		stack.push(node);
		
		assertTrue(stack.peek() == null);
		
	}
	
	//****************************************
	
	@Test
	void peekTest2() {
		
		setup1();
		
		int size = stack.size();
		
		assertEquals(size, 0);
		
		assertTrue(stack.peek() == null);
		
	}
			
	//------------------------------------------------------------------------------------
	
	@Test
	void peekTest3() {
		
		Stack<String> p = new Stack<String>();
		
		String f = "testString1";
		String g = "testString2";
		
		p.push(f);
		p.push(g);
		
		assertTrue(p.peek().equals("testString2"));
		
	}
			
	//------------------------------------------------------------------------------------
	
	//IsEmpty test
	
	@Test
	void isEmptyTest1() {
		
		setup1();
		
		assertTrue(stack.isEmpty());
		
	}
	
	//****************************************
	
	@Test
	void isEmptyTest2() {
		
		setup1();
		
		T node = null;
		
		stack.push(node);
		
		assertFalse(stack.isEmpty());
		
	}
	
	//------------------------------------------------------------------------------------
	
	@Test
	void isEmptyTest3() {
		
		
		Stack<Integer> s = new Stack<Integer>();
		
		int x = 2;
		int y = 6;
		
		s.push(x);
		s.push(y);
		
		assertFalse(s.isEmpty());
		
	}
	
	//------------------------------------------------------------------------------------

}

/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestHashTable<K,V> {
	
	//------------------------------------------------------------------------------------
	
	//Relation with HashTable
	
	HashTable<K, V> hashTable;
	
	//------------------------------------------------------------------------------------
	
	//Setup 1
	
	void setup1() {
		
		hashTable = new HashTable<>();
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Insert test
	
	@Test
	void insertTest1() {
		
		setup1();
		
		@SuppressWarnings("unchecked")
		K key = (K) new Integer((int) (Math.random()*10));
		
		@SuppressWarnings("unchecked")
		V value = (V) new Integer((int) (Math.random()*10));
		
		hashTable.insert(key, value);
		
		int size = hashTable.size();
		
		assertEquals(size, 1);
		
	}
	
	//****************************************
	
	@Test
	void insertTest2() {
		
		setup1();
		
		for(int i = 0 ; i < 5 ; i ++) {
			
			@SuppressWarnings("unchecked")
			K key = (K) new Integer((int) (Math.random()*10));
			
			@SuppressWarnings("unchecked")
			V value = (V) new Integer((int) (Math.random()*10));
			
			hashTable.insert(key, value);
			
		}

		int size = hashTable.size();
		
		assertEquals(size, 5);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Delete test
	
	@Test
	void deleteTest1() {
		
		setup1();
		
		@SuppressWarnings("unchecked")
		K key = (K) new Integer((int) (Math.random()*10));
		
		assertNull(hashTable.delete(key));
		
	}
	
	//****************************************
	
	@Test
	void deleteTest2() {
		
		setup1();
		
		@SuppressWarnings("unchecked")
		K key = (K) new Integer(100);
		
		@SuppressWarnings("unchecked")
		V value = (V) new Integer(200);
		
		hashTable.insert(key, value);
		
		int size = hashTable.size();
		
		assertEquals(size, 1);
		
		hashTable.delete(key);
		
		assertTrue(hashTable.size() == 0);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Search test
	
	@Test
	void searchTest1() {
		
		setup1();
		
		@SuppressWarnings("unchecked")
		K key = (K) new Integer(100);
		
		assertNull(hashTable.search(key));
		
	}
	
	//****************************************
	
	@Test
	void searchTest2() {
		
		setup1();
		
		@SuppressWarnings("unchecked")
		K key = (K) new Integer(100);
		
		@SuppressWarnings("unchecked")
		V value = (V) new Integer(200);
		
		hashTable.insert(key, value);
		
		int size = hashTable.size();
		
		assertEquals(size, 1);
		
		assertNotNull(hashTable.search(key));
		
	}	
	
	//------------------------------------------------------------------------------------
	
	//IsEmpty test
	
	@Test
	void isEmptyTest1() {
		
		setup1();
		
		assertEquals(hashTable.isEmpty(), true);
		
	}
	
	//****************************************
	
	@Test
	void isEmptyTest2() {
		
		setup1();
		
		@SuppressWarnings("unchecked")
		K key = (K) new Integer(100);
		
		@SuppressWarnings("unchecked")
		V value = (V) new Integer(200);
		
		hashTable.insert(key, value);
		
		assertFalse(hashTable.isEmpty());
		
	}
		
	//------------------------------------------------------------------------------------
	
}

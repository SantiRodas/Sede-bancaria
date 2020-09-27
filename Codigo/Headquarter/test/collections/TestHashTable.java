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
	
	//****************************************
	
	@Test
	void insertTest3() {
		
		setup1();
		
		for(int i = 0 ; i < 3000 ; i ++) {
			
			@SuppressWarnings("unchecked")
			K key = (K) new Integer((int) (Math.random()*20));
			
			@SuppressWarnings("unchecked")
			V value = (V) new Integer((int) (Math.random()*20));
			
			hashTable.insert(key, value);
			
		}

		int size = hashTable.size();
		
		assertEquals(size, 3000);
		
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
	
	//****************************************
	
	@Test
	void deleteTest3() {
		
		setup1();
		
		@SuppressWarnings("unchecked")
		K key = (K) new Integer(99);
		
		@SuppressWarnings("unchecked")
		V value = (V) new Integer(4);
		
		@SuppressWarnings("unchecked")
		K key1 = (K) new Integer(78);
		
		@SuppressWarnings("unchecked")
		V value1 = (V) new Integer(222);
		
		@SuppressWarnings("unchecked")
		K key2 = (K) new Integer(60);
		
		@SuppressWarnings("unchecked")
		V value2 = (V) new Integer(13);
		
		hashTable.insert(key, value);
		
		hashTable.insert(key1, value1);
		
		hashTable.insert(key2, value2);
		
		int size = hashTable.size();
		
		assertEquals(size, 3);
		
		hashTable.delete(key1);
		
		assertTrue(hashTable.size() == 2);
		
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
	
	//****************************************
	
	@Test
	void searchTest3() {
		
		setup1();
		
		@SuppressWarnings("unchecked")
		K key = (K) new Integer(5);
		
		@SuppressWarnings("unchecked")
		V value = (V) new Integer(7);
		
		@SuppressWarnings("unchecked")
		K key1 = (K) new Integer(400);
		
		@SuppressWarnings("unchecked")
		V value1 = (V) new Integer(6);
		
		@SuppressWarnings("unchecked")
		K key2 = (K) new Integer(68);
		
		@SuppressWarnings("unchecked")
		V value2 = (V) new Integer(7568);
		
		hashTable.insert(key, value);
		hashTable.insert(key2, value2);
		hashTable.insert(key1, value1);
		hashTable.insert(key1, value1);
		
		int size = hashTable.size();
		
		assertEquals(size, 4);
		
		assertNotNull(hashTable.search(key));
		
		assertTrue((Integer) hashTable.search(key2) == 7568);
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
		
	//****************************************
	
	@Test
	void isEmptyTest3() {
		
		setup1();
		
		@SuppressWarnings("unchecked")
		K key = (K) new Integer(1000);
		
		@SuppressWarnings("unchecked")
		V value = (V) new Integer(200);
		
		@SuppressWarnings("unchecked")
		K key1 = (K) new Integer(50);
		
		@SuppressWarnings("unchecked")
		V value1 = (V) new Integer(8);
		
		@SuppressWarnings("unchecked")
		K key2 = (K) new Integer(2);
		
		@SuppressWarnings("unchecked")
		V value2 = (V) new Integer(56);
		
		hashTable.insert(key, value);
		hashTable.insert(key, value);
		hashTable.insert(key1, value1);
		hashTable.insert(key2, value2);
		
		assertFalse(hashTable.isEmpty());
		
	}
		
	//------------------------------------------------------------------------------------
	
}

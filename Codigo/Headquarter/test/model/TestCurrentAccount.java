/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class TestCurrentAccount {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	CurrentAccount currentAccount;
	
	//------------------------------------------------------------------------------------
	
	//Setup1
	
	void setup1() {
		
		currentAccount = new CurrentAccount("123456789");
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test pay
	
	@Test
	void testPay1() {
		
		setup1();
		
		assertFalse(currentAccount.pay(1000));
		
	}
	
	//****************************************
	
	@Test
	void testPay2() {
		
		setup1();
		
		assertTrue(currentAccount.pay(-1000));
		
	}
	
	//****************************************
	
	@Test
	void testPay3() {
		
		setup1();
		
		assertFalse(currentAccount.pay(0));
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test use
	
	@Test
	void testUse1() {
		
		setup1();
		
		assertTrue(currentAccount.use(1000));
		
	}
	
	//****************************************
	
	@Test
	void testUse2() {
		
		setup1();
		
		assertTrue(currentAccount.use(-1000));
		
	}
	
	//****************************************
	
	@Test
	void testUse3() {
		
		setup1();
		
		assertTrue(currentAccount.use(0));
		
	}
	
	//------------------------------------------------------------------------------------


}

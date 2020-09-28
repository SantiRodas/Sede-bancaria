/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class TestSavingsAccount {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	SavingsAccount savingsAccount;
	
	//------------------------------------------------------------------------------------
	
	//Setup 1
	
	void setup1() {
		
		savingsAccount = new SavingsAccount("123456789");
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test not credit
	
	@Test
	void testDebit1() {
		
		setup1();
		
		assertFalse(savingsAccount.debit(1000));
		
	}
	
	//****************************************
	
	@Test
	void testDebit2() {
		
		setup1();
		
		assertTrue(savingsAccount.debit(-1000));
		
	}
	
	//****************************************
	
	@Test
	void testDebit3() {
		
		setup1();
		
		assertFalse(savingsAccount.debit(0));
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test credit
	
	@Test
	void testCredit1() {
		
		setup1();
		
		assertTrue(savingsAccount.credit(1000));
		
	}
	
	//****************************************
	
	@Test
	void testCredit2() {
		
		setup1();
				
		assertTrue(savingsAccount.debit(-1000));
		
	}
	
	//****************************************
	
	@Test
	void testCredit3() {
		
		setup1();
				
		assertFalse(savingsAccount.debit(0));
		
	}
	
	//------------------------------------------------------------------------------------

}

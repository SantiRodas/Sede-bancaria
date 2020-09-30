/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TestBank {
	
	//------------------------------------------------------------------------------------
	
	//Relations
	
	Bank bank;
	
	//------------------------------------------------------------------------------------
	
	//Setup1
	
	void setup1() {
		
		bank = new Bank("Bancolombia");
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Setup 2
	
	void setup2() {
		
		setup1();
		
		bank.addNewActiveClient("Santiago", "1193419196", LocalDate.now(),LocalDate.now());
		
		bank.addNewActiveClient("Alejandra", "987654321", LocalDate.now(),LocalDate.now());
		
		bank.addNewActiveClient("Juan", "123456789", LocalDate.now(),LocalDate.now());
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Setup 3
	
	void setup3() {
		
		setup1();
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test bank
	
	@Test
	void testBank1() {
		
		setup1();
		
		assertEquals(bank.getBankName(), "Bancolombia");
		
	}
	
	//****************************************
	
	@Test
	void testBank2() {
		
		setup1();
		
		assertFalse(bank.getBankName().equalsIgnoreCase("Davivienda"));
		
	}
	
	//****************************************
	
	@Test
	void testBank3() {
		
		setup1();
		
		assertNotNull(bank.getBankName());
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test add new active client
	
	@Test
	void testAddNewActiveClient1() {
		
		setup1();
		
		assertTrue(bank.addNewActiveClient("Santiago", "1193419196", LocalDate.now(),LocalDate.now()));
		
	}

	//****************************************
	
	@Test
	void testAddNewActiveClient2() {
		
		setup1();
		
		assertTrue(bank.addNewActiveClient("Santiago", "1193419196", LocalDate.now(),LocalDate.now()));
		
		assertFalse(bank.addNewActiveClient("Alejandra", "1193419196", LocalDate.now(),LocalDate.now()));
		
	}
	
	//****************************************
	
	@Test
	void testAddNewActiveClient3() {
		
		setup1();
		
		assertNotNull(bank.addNewActiveClient("Santiago", "1193419196", LocalDate.now(),LocalDate.now()));
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test get active clients array
	
	@Test
	void testGetActiveClientsArray1() {
		
		setup2();
		
		assertNotNull(bank.getActiveClientsArray());
		
	}
	
	//****************************************
	
	@Test
	void testGetActiveClientsArray2() {
		
		setup2();
		
		assertEquals(bank.getActiveClientsArray().length, 3);
		
	}
	
	//****************************************
	
	@Test
	void testGetActiveClientsArray3() {
		
		setup1();
		
		assertFalse(bank.getActiveClientsArray() == null);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test pay credit card
	
	@Test
	void testPayCreditCard1() {
		
		setup1();
		
		assertFalse(bank.payCreditCard("123456789", 1000));
		
	}
	
	//****************************************
	
	@Test
	void testPayCreditCard2() {
		
		setup1();
		
		assertEquals(bank.payCreditCard("147258369", 2000), false);
		
	}
	
	//****************************************
	
	@Test
	void testPayCreditCard3() {
		
		setup1();
		
		assertTrue(bank.payCreditCard("159753147", 1000) == false);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test retrieve credit card
	
	@Test
	void testRetrieveCreditCard1() {
		
		setup1();
		
		assertFalse(bank.retrieveCredit("123456789", 1000));
		
	}
	
	//****************************************
	
	@Test
	void testRetrieveCreditCard2() {
		
		setup1();
		
		assertEquals(bank.retrieveCredit("147258369", 2000), false);
		
	}
	
	//****************************************
	
	@Test
	void testRetrieveCreditCard3() {
		
		setup1();
		
		assertTrue(bank.retrieveCredit("159753147", 1000) == false);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test retrieve savings
	
	@Test
	void testRetrieveSavings1() {
		
		setup1();
		
		assertFalse(bank.retrieveSavings("123456789", 1000));
		
	}
	
	//****************************************
	
	@Test
	void testRetrieveSavings2() {
		
		setup1();
		
		assertEquals(bank.retrieveSavings("147258369", 2000), false);
		
	}
	
	//****************************************
	
	@Test
	void testRetrieveSavings3() {
		
		setup1();
		
		assertTrue(bank.retrieveSavings("159753147", 1000) == false);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test add savings
	
	@Test
	void testAddSavings1() {
		
		setup1();
		
		assertFalse(bank.addSavings("456789123", 4000));
		
	}
	
	//****************************************
	
	@Test
	void testAddSavings2() {
		
		setup1();
		
		assertFalse(bank.addSavings("1193419196", 4000));
		
		assertFalse(bank.addSavings("1193419196", 1000));
		
	}
	
	//****************************************
	
	@Test
	void testAddSavings3() {
		
		setup1();
		
		assertNotNull(bank.addSavings("963852741", 5000));
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test create savings account
	
	@Test
	void testCreateSavingsAccount1() {
		
		setup1();
		
		assertFalse(bank.createSavingsAccount());
		
	}
	
	//****************************************
	
	@Test
	void testCreateSavingsAccount2() {
		
		setup1();
		
		assertNotNull(bank.createSavingsAccount());
		
	}
	
	//****************************************
	
	@Test
	void testCreateSavingsAccount3() {
		
		setup1();
		
		boolean validacion = bank.createSavingsAccount();
		
		assertEquals(false, validacion);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test create credit card
	
	@Test
	void testCreateCreditCard1() {
		
		setup1();
		
		assertFalse(bank.createCreditCard());
		
	}
	
	//****************************************
	
	@Test
	void testCreateCreditCard2() {
		
		setup1();
		
		assertNotNull(bank.createCreditCard());
		
	}
	
	//****************************************
	
	@Test
	void testCreateCreditCard3() {
		
		setup1();
		
		boolean validacion = bank.createCreditCard();
		
		assertEquals(false, validacion);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test undo last action
	
	@Test
	void testUndoLastAction1() {
		
		setup1();
		
		assertFalse(bank.undoLastAction());
		
	}
	
	//****************************************
	
	@Test
	void testUndoLastAction2() {
		
		setup1();
		
		bank.undoLastAction();
		
		assertEquals(bank.undoLastAction(), false);
		
	}
	
	//****************************************
	
	@Test
	void testUndoLastAction3() {
		
		setup1();
		
		assertTrue(bank.undoLastAction() == false);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test clear actions
	
	@Test
	void testClearActions1() {
		
		setup1();
		
		bank.clearActions();
		
		assertNotNull(bank.getCurrentClientActions());
		
	}
	
	//****************************************
	
	@Test
	void testClearActions2() {
		
		setup1();
		
		assertTrue(bank.getCurrentClientActions() != null);
		
	}
	
	//****************************************
	
	@Test
	void testClearActions3() {
		
		setup1();
		
		bank.saveAction();
		
		assertTrue(bank.getCurrentClientActions() != null);
		
		bank.clearActions();
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test Assign client to queue
	
	@Test
	void testAssignClientToQueue1() {
		
		setup1();
		
		assertTrue(bank.assignClientToQueue("1193419196") == 0);
		
	}
	
	//****************************************
	
	@Test
	void testAssignClientToQueue2() {
		
		setup1();
		
		assertEquals(bank.assignClientToQueue("741258963"), 0);
		
	}
	
	//****************************************
	
	@Test
	void testAssignClientToQueue3() {
		
		setup1();
		
		bank.assignClientToQueue("456789123");
		
		assertTrue(bank.getQueue() != null);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test attend next client
	
	@Test
	void testAttendNextClient1() {
		
		setup1();
		
		assertFalse(bank.attendNextClient());
		
	}
	
	//****************************************
	
	@Test
	void testAttendNextClient2() {
		
		setup1();
		
		assertEquals(bank.attendNextClient(), false);
		
	}
	
	//****************************************
	
	@Test
	void testAttendNextClient3() {
		
		setup1();
		
		assertTrue(bank.attendNextClient() == false);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test remove active client
	
	@Test
	void testRemoveActiveClient1() {
		
		setup2();
		
		assertTrue(bank.getActiveClientsArray().length == 3);
		
	}
	
	//****************************************
	
	@Test
	void testRemoveActiveClient2() {
		
		setup1();
		
		bank.removeActiveClient("Ok");
		
		assertTrue(bank.getActiveClientsArray().length == 0);
		
	}
	
	//****************************************
	
	@Test
	void testRemoveActiveClient3() {
		
		setup2();
		
		bank.removeActiveClient("Ok");
				
		assertTrue(bank.getActiveClientsArray().length == 3);
		
	}	
	
	//------------------------------------------------------------------------------------
	
	//Test search active client by id
	
	@Test
	void testSearchActiveClientById1() {
		
		setup2();
		
		assertTrue(bank.searchActiveClientById("1193419196") != null);
		
	}
	
	//****************************************
	
	@Test
	void testSearchActiveClientById2() {
		
		setup2();
		
		assertEquals(bank.searchActiveClientById("123456789").getName(), "Juan");
		
	}
	
	//****************************************
	
	@Test
	void testSearchActiveClientById3() {
		
		setup2();
		
		assertNotNull(bank.searchActiveClientById("987654321"));
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test get queue
	
	@Test
	void testGetQueue1() {
		
		setup1();
		
		assertNotNull(bank.getQueue());
		
	}
	
	//****************************************
	
	@Test
	void testGetQueue2() {
		
		setup1();
		
		assertTrue(bank.getQueue() != null);
		
	}
	
	//****************************************
	
	@Test
	void testGetQueue3() {
		
		setup1();
		
		assertEquals(bank.getQueue().length, 0);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test priority queue
	
	@Test
	void testGetPriorityQueue1() {
		
		setup1();
		
		assertNotNull(bank.getPriorityQueue());
		
	}
	
	//****************************************
	
	@Test
	void testGetPriorityQueue2() {
		
		setup1();
		
		assertTrue(bank.getPriorityQueue() != null);
		
	}
	
	//****************************************
	
	@Test
	void testGetPriorityQueue3() {
		
		setup1();
		
		assertEquals(bank.getPriorityQueue().length, 0);
		
	}
	
	//------------------------------------------------------------------------------------


}

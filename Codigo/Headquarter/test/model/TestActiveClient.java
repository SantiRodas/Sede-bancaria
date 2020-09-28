/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TestActiveClient {

	private ActiveClient ac;
	private CreditCard card1;
	private CreditCard card2;
	private SavingsAccount sa1;
	private SavingsAccount sa2;
	
	void setup1() {
		ac = new ActiveClient("Valeryan", "A358489", LocalDate.of(1978, 4, 27), null);
	}
	
	void setup2() {
		ac = new ActiveClient("Valeryan", "A358489", LocalDate.of(1978, 4, 27), null);
		
		card1 = new CreditCard("TC39857");
		sa1 = new SavingsAccount("CA23874");
		
		ac.getcCards()[0] = card1;
		ac.getsAccounts()[0] = sa1;
	}
	
	void setup3() {
		ac = new ActiveClient("Valeryan", "A358489", LocalDate.of(1978, 4, 27), null);
		
		card1 = new CreditCard("TC39857");
		sa1 = new SavingsAccount("CA23874");
		card2 = new CreditCard("TC987432");
		sa2 = new SavingsAccount("CA23460");
		
		ac.getcCards()[0] = card1;
		ac.getsAccounts()[0] = sa1;
		ac.getcCards()[1] = card2;
		ac.getsAccounts()[1] = sa2;
	}
	
	@Test
	void testPayCreditCard1() {
		setup1();
		assertFalse(ac.payCreditCard("39024FG4", 800000));
	}
	
	@Test
	void testPayCreditCard2() {
		setup2();
		card1.setAssociatedCAccount(new CurrentAccount("AC9000"));
		card1.getCurrentAccount().setBalanceToPay(40000);
		assertTrue(ac.retrieveCredit("TC39857", 34000));
	}
	
	@Test
	void testPayCreditCard3() {
		//not implemented yet
	}
	
	@Test
	void testRetrieveCredit1() {
		setup1();
		assertFalse(ac.retrieveCredit("32487GG", 2000000));
	}
	
	@Test
	void testRetrieveCredit2() {
		setup2();
		card1.setAssociatedCAccount(new CurrentAccount("AC9000"));
		card1.getCurrentAccount().setAvailableCredit(50000);
		assertTrue(ac.retrieveCredit("TC39857", 34000));
	}
	
	@Test
	void testRetrieveCredit3() {
		setup3();
		card2.setAssociatedCAccount(new CurrentAccount("AC34782"));
		card2.getCurrentAccount().setAvailableCredit(67000);
		assertTrue(ac.retrieveCredit("TC987432", 4000));
	}
	
	@Test
	void retrieveSavings1() {
		setup1();
		assertFalse(ac.retrieveSavings("347CJOA", 130000));
	}
	
	@Test
	void retrieveSavings2() {
		setup2();
		assertFalse(ac.retrieveSavings("3892JD", 9300));
		
		ac.addSavings("CA23874", 25000);
		assertTrue(ac.retrieveSavings("CA23874", 10000));
	}
	
	@Test
	void retrieveSavings3() {
		setup3();
		ac.addSavings("CA23874", 25000);
		assertFalse(ac.retrieveSavings("CA23874", 100000));
		ac.addSavings("CA23460", 70000);
		assertTrue(ac.retrieveSavings("CA23460", 24000));
		assertTrue(ac.retrieveSavings("CA23460", 40000));
	}
	
	@Test
	void testAddSavings1() {
		setup1();

		assertFalse(ac.addSavings("CA72", 25000));
	}
	
	@Test
	void testAddSavings2() {
		setup2();
		assertTrue(ac.addSavings("CA23874", 17500));
		assertFalse(ac.addSavings("ON86734", 2400));
	}
	
	@Test
	void testAddSavings3() {
		setup3();
		assertTrue(ac.addSavings("CA23874", 5000));
		assertTrue(ac.addSavings("CA23460", 78000));
	}

	@Test
	void testCreateSavingsAccount1() {
		setup1();
		assertTrue(ac.createSavingsAccount("CA8976", "CN12324"));
	}
	
	@Test
	void testCreateSavingsAccount2() {
		setup2();
		assertTrue(ac.createSavingsAccount("ASFJ998", ""));
		assertFalse(ac.createSavingsAccount("", "FHEI23FF"));
	}
	
	@Test
	void testCreateSavingsAccount3() {
		setup3();
		assertFalse(ac.createSavingsAccount("NFSAO34","392483"));
	}
	
	@Test
	void testCreateCreditCard1() {
		setup1();
		
		assertTrue(ac.createCreditCard("CC374637",""));
	}
	
	@Test
	void testCreateCreditCard2() {
		setup2();
		assertTrue(ac.createCreditCard("NEFNDI45","9347BM"));
		assertTrue(ac.createCreditCard("","4353F487"));
	}
	
	@Test
	void testCreateCreditCard3() {
		setup3();
		
		assertTrue(ac.createCreditCard("TC987432",""));
		assertTrue(ac.createCreditCard("TC063542","HIH28347"));
		assertTrue(ac.createCreditCard("000003","32085DF"));
		assertFalse(ac.createCreditCard("NASN3487S","PEHCDGKE"));
	}
	
	@Test
	void testGetCreditCardNumbers1() {
		setup1();
		assertNull(ac.getCreditCardNumbers());
	}
	
	@Test
	void testGetCreditCardNumbers2() {
		setup2();
		
		assertTrue(ac.getCreditCardNumbers()[0].equals("TC39857"));
	}
	
	@Test
	void testGetCreditCardNumbers3() {
		setup3();
		
		assertTrue(ac.getCreditCardNumbers()[0].equals("TC39857"));
		assertTrue(ac.getCreditCardNumbers()[1].equals("TC987432"));
	}
	
	@Test
	void testGetSavingsAccountsNumbers1() {
		setup1();
		assertNull(ac.getSavingsAccountsNumbers());
	}
	
	@Test
	void testGetSavingsAccountsNumbers2() {
		setup2();
		assertTrue(ac.getSavingsAccountsNumbers()[0].equals("CA23874"));
	}
	
	@Test
	void testGetSavingsAccountsNumbers3() {
		setup3();
		assertTrue(ac.getSavingsAccountsNumbers()[0].equals("CA23874"));
		assertTrue(ac.getSavingsAccountsNumbers()[1].equals("CA23460"));
	}
	
	@Test
	void testClone1() {
		
	}
	
	@Test
	void testClone2() {
		
	}
	
	@Test
	void testClone3() {
		
	}

}

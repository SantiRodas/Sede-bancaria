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
		
	}
	
	@Test
	void testPayCreditCard2() {
		
	}
	
	@Test
	void testPayCreditCard3() {
		
	}
	
	@Test
	void testRetrieveCredit1() {
		
	}
	
	@Test
	void testRetrieveCredit2() {
		
	}
	
	@Test
	void testRetrieveCredit3() {
		
	}
	
	@Test
	void retrieveSavings1() {
		
	}
	
	@Test
	void retrieveSavings2() {
		
	}
	
	@Test
	void retrieveSavings3() {
		
	}
	
	@Test
	void testAddSavings1() {
		
	}
	
	@Test
	void testAddSavings2() {
		
	}
	
	@Test
	void testAddSavings3() {
		
	}

	@Test
	void testCreateSavingsAccount1() {
		setup1();
		//ac.createSavingsAccount("CA8976", "CN12324");
	}
	
	@Test
	void testCreateSavingsAccount2() {
		
	}
	
	@Test
	void testCreateSavingsAccount3() {
		
	}
	
	@Test
	void testCreateCreditCard1() {
		setup1();
		
		assertTrue(ac.createCreditCard("CC374637",""));
	}
	
	@Test
	void testCreateCreditCard2() {
		
	}
	
	@Test
	void testCreateCreditCard3() {
		setup3();
		
		assertTrue(ac.createCreditCard("TC987432",""));
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

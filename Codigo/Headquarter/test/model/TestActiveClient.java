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
		ac.getcCards()[1] = card1;
		ac.getsAccounts()[1] = sa1;
	}

}

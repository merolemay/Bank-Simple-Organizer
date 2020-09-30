
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Bank;
import model.Client;

class BankTest {

	Bank bank;
	void setUp1(){
		bank = new Bank();
		bank.registerClient(new Client("Daniel Perez",1087212345));
		bank.registerClient(new Client("Andres Peñalosa",1087652891));
		bank.registerClient(new Client("Andres Colmenares", 872109872));
		bank.registerClient(new Client("Amaranta Perea",912385123));
		bank.registerClient(new Client("Andrew Peñaperez",1986091821));
		bank.registerClient(new Client("Alvarito Paramilito",2123912351));
	}
	void setUp2(){
		bank =new Bank();
	}
	void setUp3(){
		bank = new Bank();
		bank.registerClient(new Client("Amaranta Perea",912385123));
		bank.registerClient(new Client("Andrew Peñaperez",1986091821));
		bank.registerClient(new Client("Alvarito Paramilito",2123912351));
	}

	@Test
	void testRegisterClient() {
		setUp3();
		Client  c = new Client("Capitan Teemo",666);
		bank.registerClient(c);
		 assertTrue(bank.searchClient(666).equals(c));
	}
	@Test
	void testAddToClientQueue() {
		setUp3();
		bank.addClientToQueue(bank.searchClient(912385123));
		bank.addClientToQueue(bank.searchClient(1986091821));
		bank.addClientToQueue(bank.searchClient(2123912351));
		
		assertTrue(!bank.getClientQueue().isEmpty());
		
	}
	
	@Test
	void testAddToPriorityQueue() {
		setUp3();
		bank.addToPriorityQueue(bank.searchClient(912385123),3);
		bank.addToPriorityQueue(bank.searchClient(1986091821),4);
		bank.addToPriorityQueue(bank.searchClient(2123912351),1);
		
		assertTrue(bank.getPrioriQueue().Head().equals(bank.searchClient(1986091821)));
		
	}

	@Test
	void testCancelAccount() {
		setUp1();
		
		Client c1 = bank.searchClient(1087212345);
		
		assertTrue(bank.cancelAcount(1087212345).equals(c1));
	}

	@Test
	void testSearchClient() {
		setUp1();
		
		Client c1 = bank.searchClient(1087212345);
		
		assertTrue(bank.searchClient(1087212345).equals(c1));
	}


	@Test
	void testUndo() {
		setUp2();
		
		Client c1 = new Client("Capitan Teemo",6669);
		
		bank.registerClient(c1);
		
		bank.makeATransaction(c1.getCc(),4444);
		bank.makeATransaction(c1.getCc(),6666);
		bank.makeATransaction(c1.getCc(),-5000);
		
		String rs  = bank.undo(c1.getCc());
		
		
	}

	@Test
	void testMakeATransaton() {
		fail("Not yet implemented");
	}

	@Test
	void testDateToString() {
		fail("Not yet implemented");
	}
}


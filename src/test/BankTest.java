package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Bank;
import model.Client;

class BankTest {

	Bank bank;
	void septu1(){
		bank = new Bank();
		bank.registerClient(new Client("Daniel Perez",1087212345));
		bank.registerClient(new Client("Andres Peñalosa",1087652891));
		bank.registerClient(new Client("Andres Colmenares", 872109872));
		bank.registerClient(new Client("Amaranta Perea",912385123));
		bank.registerClient(new Client("Andrew Peñaperez",1986091821));
		bank.registerClient(new Client("Alvarito Paramilito",2123912351));
	}
	void septu2(){
		bank =new Bank();
	}
	void septu3(){
		bank = new Bank();
		bank.registerClient(new Client("Amaranta Perea",912385123));
		bank.registerClient(new Client("Andrew Peñaperez",1986091821));
		bank.registerClient(new Client("Alvarito Paramilito",2123912351));
	}

	@Test
	void testRegisterClient() {
		septu2();
		Client  c = new Client("Capitan Teemo",666);
		bank.registerClient(c);
		 assertTrue(bank.searchClient(666).equals(c));
	}
	@Test
	void testAddToClientQueue() {
		septu3();
		bank.addClientToQueue(bank.searchClient(912385123));
		bank.addClientToQueue(bank.searchClient(1986091821));
		bank.addClientToQueue(bank.searchClient(2123912351));
	
		
	}
	
	@Test
	void testAddToPriorityQueue() {
		fail("Not yet implemented");
	}

	@Test
	void testCancelAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchClient() {
		fail("Not yet implemented");
	}

	@Test
	void testCancelAcount() {
		fail("Not yet implemented");
	}

	@Test
	void testUndo() {
		fail("Not yet implemented");
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

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import model.Bank;
import model.Client;
import model.DebitCard;

class BankTest {

	Bank bank;
	
	void  setUp1(){
		bank = new Bank();
		bank.registerClient("Daniel Perez",1087212345, 0);
		bank.registerClient("Andres Peñalosa",1087652891,0);
		bank.registerClient("Andres Colmenares", 872109872,0);
		bank.registerClient("Amaranta Perea",912385123,0);
		bank.registerClient("Andrew Peñaperez",1986091821,0);
		bank.registerClient("Alvarito Paramilito",2123912351,0);
	}
	
	void  setUp2(){
		bank =new Bank();
	}
	
	void  setUp3(){
		bank = new Bank();
		bank.registerClient("Amaranta Perea",912385123,0);
		bank.registerClient("Andrew Peñaperez",1986091821,0);
		bank.registerClient("Alvarito Paramilito",2123912351,0);
	}

	@Test
	void testRegisterClient() {
		setUp2();
		Client c = new Client("Capitan Teemo",666, null, null);
		bank.registerClient("Capitan Teemo",666,0);
		 assertTrue(bank.searchClient(666).getCc()==c.getCc());
	}
	@Test
	void testAddToClientQueue() {
		setUp3();
		bank.addClientToQueue(bank.searchClient(912385123));
		bank.addClientToQueue(bank.searchClient(1986091821));
		bank.addClientToQueue(bank.searchClient(2123912351));
	
		
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
	void testSearchClient() {
		setUp1();
		
		Client c1 = bank.searchClient(1087212345);
		
		assertTrue(bank.searchClient(1087212345).equals(c1));
	}
	
	@Test
	void testCancelAccount() {
		
		setUp1();
		
		Client c1 = bank.searchClient(1087212345);
		
		assertTrue(bank.cancelAcount(1087212345).equals(c1));
	}

	@Test
	void testUndo() {
		setUp2();
		
		Client c1 = new Client("Capitan Teemo",6669,new DebitCard(123153,new Date(System.currentTimeMillis()),1923),null);
		c1.getDebitCard().setAmount((4444+6666)-5000);
		bank.registerClient("Capitan Teemo",6669,2013);
		
		bank.makeATransaction(c1.getCc(), 2550);
		assertTrue(!bank.undo(c1.getCc()).getLastTransaction().isEmpty());;
		
	}

}

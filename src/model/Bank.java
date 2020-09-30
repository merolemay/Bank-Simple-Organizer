package model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import HashTable.HashTable;
import Queue.iQueue;
import priorityQueue.PriorityQueue;

/**This is the Main Class of the Bank Simply Organizer Project 
 * which is mean to be a simple organizer for attending Clients in a bank.
 * 
 * @authors Alejandro Arce, Alexander Samaca, Duvan Cuero
 * 
 * @date Unreleased
 * 
 */
public class Bank {
	
	HashTable<Integer,Client> bank;
<<<<<<< HEAD
	
	iQueue<Client> clientQueue;
	PriorityQueue<Client> prioriQueue;
=======
>>>>>>> origin/Alejillus
	
	/** The constructor of the Class bank which starts with a designate administrator
	 *  which takes control of the .
	 * @param admin: The administrator of the bank.
	 */
	public Bank() {
<<<<<<< HEAD
		bank = new HashTable<Integer,Client>(50);
		clientQueue = new iQueue<Client>();
		prioriQueue = new PriorityQueue<Client>(12);
		
		
	}
	
	public void addToClientQueue(Client c) {
		
		if(clientQueue.size() < 12) {
		
		clientQueue.enqueue(c);
		
		}
		
		
		
		
		
	}
	
	public void addToPriorityQueue(Client c, int prio) {
		
	
			
			prioriQueue.add(c,prio);
			
		
		
		
		
	}
	
	public void cancelAccount(int id) {
		
		bank.get(key);
		
		
		
=======
		bank = new HashTable<Integer,Client>(12);
>>>>>>> origin/Alejillus
	}
	
	/** Searches a client in the Bank Based on his cc.
	 * @param cc : the key of search in the HashTable
	 * @return Client if it was found or an exception if the client doesn't exist
	 */
	public Client searchClient(Integer cc) {	
		return bank.get(cc);
	}
	
	/** Removes a client from the Bank canceling his account.
	 * @param cc : The key of search and erase of the client.
	 * @return if the Client was found returns the Clients object, else returns and exception.
	 */
	public Client cancelAcount(Integer cc) {
		return bank.remove(cc);
	}
<<<<<<< HEAD
	
	
	/** Undoes the last transaction of the client with entered cc.
	 * @param cc
	 * @return : a message with the last transaction
	 * 
	 * example: The last transaction was a withdraw of -99,99$.
	 */
	public String undo(int cc) {	
		Transactions rs = bank.get(cc).getTransactions().pop();
		return rs.getLastTransaction();
	}
	
	/** Makes a new transaction 
	 * @param cc : the key of the client which transaction is going to be make
	 * @param i : the amount of money that's going to be move into or out of the account.
	 */
	public void makeATransaton(int cc, int i) {
		bank.get(cc).saveTransaction(bank.get(cc), i);
	}
=======
>>>>>>> origin/Alejillus
	
	public String dateToString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		String strDate = dateFormat.format(date);  
		return strDate;
	}
	
}

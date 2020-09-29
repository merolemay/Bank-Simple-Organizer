package model;

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
	
	iQueue<Client> clientQueue;
	PriorityQueue<Client> prioriQueue;
	
	/** The constructor of the Class bank which starts with a designate administrator
	 *  which takes control of the .
	 * @param admin: The administrator of the bank.
	 */
	public Bank() {
		bank = new HashTable<Integer,Client>(50);
		clientQueue = new iQueue<Client>();
		prioriQueue = new PriorityQueue<Client>(12);
		
		
	}
	
	public void addToClientQueue(Client c) {
		
		if(clientQueue.size() < 12) {
		
		clientQueue.enqueue(c);
		
		}
		
		
		
		
		
	}
	
	public void addToPriorityQueue(Client c) {
		
		if(clientQueue.size() < 12) {
			
			clientQueue.enqueue(c);
			
			}
		
		
		
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
	
}

package model;

import HashTable.HashTable;

public class Bank {
	
	HashTable<Integer,Client> bank;
	Administrator admin;
	
	/** The constructor of the Class bank which starts with a designate administrator
	 *  which takes control of the .
	 * @param admin: The administrator of the bank.
	 */
	public Bank(Administrator admin) {
		bank = new HashTable<Integer,Client>(0);
		this.admin=admin;
	}
	
	

}

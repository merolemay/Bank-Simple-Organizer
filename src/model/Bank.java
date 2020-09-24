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
	
	/** Searches a client in the Bank Based on his cc.
	 * @param cc
	 * @return
	 */
	public Client searchClientCc(Integer cc) {	
		return bank.get(cc);
	}
	
	
	public <E extends Comparable<E>> void selectionSort(E[] list) {
		
		 for(int i=0; i<list.length -1; i++) {
			 
	            int iSmallest = i;

	            for(int j=i+1; j<list.length; j++)
	            {
	                if(list[iSmallest].compareTo((list[j])) > 0  )
	                {
	                    iSmallest = j;
	                }
	            }
	            E iSwap = list[iSmallest];
	            list[iSmallest] = list[i];
	            list[i] = iSwap;
	        }
	}
	

}

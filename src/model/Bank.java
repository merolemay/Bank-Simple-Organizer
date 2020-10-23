package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import BTS.BTS;
import HashTable.HashTable;
import Queue.Queue;
import priorityQueue.PriorityQueue;
import sortmethods.HeapSort;

/**This is the Main Class of the Bank Simply Organizer Project 
 * which is mean to be a simple organizer for attending Clients in a bank.
 * 
 * @authors Alejandro Arce, Alexander Samaca, Duvan Cuero
 * 
 * @date Unreleased
 * 
 */
@SuppressWarnings("serial")
public class Bank implements Serializable{
	
	private HashTable<Integer,Client> bank;
	private Queue<Client> clientQueue;
	private PriorityQueue<Client> prioriQueue;
<<<<<<< HEAD
	private int numsCards=100000000;
	private ArrayList<Client> clients;
=======
	private static final int NUMS_CARDS=100000000;
	
>>>>>>> 9c401206f14677b390af3854e3bbfd4c4c6b5ebf
	
	/** The constructor of the Class bank which starts with a designate administrator
	 *  which takes control of the .
	 * @param admin: The administrator of the bank.
	 */
	public Bank() {
		bank = new HashTable<Integer,Client>(90);
		clientQueue = new Queue<Client>();
		prioriQueue = new PriorityQueue<Client>(12);	
<<<<<<< HEAD
		clients = new ArrayList<Client>();
	
=======
		
		registerClient(new Client("",0,0));
		clientQueue.enqueue(new Client("",0,0));
		prioriQueue.add(new Client("",0,0), 0);
>>>>>>> 9c401206f14677b390af3854e3bbfd4c4c6b5ebf
	}
	
	
	public void loadBankData() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream leyendoFichero;
	
			leyendoFichero = new ObjectInputStream(new FileInputStream("./data/BankData") );
			@SuppressWarnings("unchecked")
			HashTable<Integer,Client> readObject = ( HashTable<Integer,Client>)leyendoFichero.readObject();
			bank = readObject;
            leyendoFichero.close();
	
	            
	}

	public void saveBankData() throws FileNotFoundException, IOException {
		ObjectOutputStream escribiendoFichero;
	
			escribiendoFichero = new ObjectOutputStream(new FileOutputStream("./data/BankData") );
			escribiendoFichero.writeObject(bank);
            escribiendoFichero.close();
	   
	}	
	
	/** Registers a Client in the bank data base (HashTable).
	 * @param c : the client that is going to be inserted.
	 */
<<<<<<< HEAD
	
	public void registerClient(String name, int cc,double amount) {
		Date date = new Date(System.currentTimeMillis());
		int cardNumber = (int) (Math.random() *9999999+ 1000000);
		cardNumber += numsCards;
		numsCards++;
		DebitCard debitCard = new DebitCard(amount,date,cardNumber,false);
		Client c = new Client(name, cc,amount,debitCard);
		clients.add(c);
		bank.put(c.getCc(), c);
		
	}
	
	public void registerClient(String name, int cc,double amount,double balance,int limit) {
		Date date = new Date(System.currentTimeMillis());
		int cardNumber = (int) (Math.random() *9999999+ 1000000);
		cardNumber += numsCards;
		numsCards++;
		CreditCard creditCard = new CreditCard(balance,date,numsCards,limit);
		DebitCard debitCard = new DebitCard(amount,date,cardNumber,false);
		Client c = new Client(name, cc,amount,creditCard,debitCard);
		clients.add(c);
		bank.put(c.getCc(), c);
		
	}
	
	
	
	
=======
	public void registerClient(Client test) {
		bank.put(test.getCc(), test);
	}
	
	
	
	
>>>>>>> 9c401206f14677b390af3854e3bbfd4c4c6b5ebf
	public void addClientToQueue(Client c) {	
		if(clientQueue.size() < 12) {
		clientQueue.enqueue(c);
		}
	}
	
	public void addToPriorityQueue(Client c, int prio) {	
			prioriQueue.add(c,prio);
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

	
	
	/** Undoes the last transaction of the client with entered cc.
	 * @param cc
	 * @return : a message with the last transaction
	 * 
	 * example: The last transaction was a withdraw of -99,99$.
	 */
	public Transactions undo(int cc) {	
		Transactions rs = bank.get(cc).getTransactions().pop();
		return rs;
	}
	
	/** Makes a new transaction 
	 * @param cc : the key of the client which transaction is going to be make
	 * @param i : the amount of money that's going to be move into or out of the account.
	 */
	public void makeATransaction(int cc, int i) {
		bank.get(cc).saveTransaction(i);
	}

	public HashTable<Integer, Client> getBank() {
		return bank;
	}

	public ArrayList<Client> getClientQueueList() {
		return clientQueue.toArrayList();
	} 
	
	public Queue<Client> getClientQueue() {
		return clientQueue;
	}
	
	public ArrayList<Client> getPrioriQueueList() {
		return prioriQueue.toArrayList();
	}
	
	public Client[] getArrayClients() {
		return	(Client[]) bank.toArrayList().toArray();
	}
	
<<<<<<< HEAD
=======
	public ArrayList<Client> getArrayListClients(){
		return bank.toArrayList();
	}
		
>>>>>>> 9c401206f14677b390af3854e3bbfd4c4c6b5ebf
	
	public  Client[] selectionSortName() {
		
		Client[] list = getArrayClients();
		
		 for(int i=0; i<list.length -1; i++) {
			 
	            int iSmallest = i;

	            for(int j=i+1; j<list.length; j++)
	            {
	                if(list[iSmallest].getName().compareTo(((list[j].getName()))) > 0  )
	                {
	                    iSmallest = j;
	                }
	            }
	            Client iSwap = list[iSmallest];
	            list[iSmallest] = list[i];
	            list[i] = iSwap;
	     
	        }
		 
		 return list;
	}
	
	public Client[] heapSortId() {
		Client[] c = getArrayClients();
		HeapSort h;
		h = new HeapSort();
		return h.sort(c);
	}
	
	
	public Client[] mergeSortMethod() {
		Client[] c = getArrayClients();
		mergeSort(c,0,c.length);
		return c;
	}
	
	public Client[] mergeSort(Client[] list,int start,int end) {


        if  (list.length <= 1) {

            throw new IllegalArgumentException("There is only 1 account or is null");

        }else {
            int middle = list.length/2;
            mergeSort(list,start,middle);
            mergeSort(list,middle+1,end);

            merge(list,start,middle,end);
            
            
        }
        return list;


    }

	public void merge(Client[] list,int start, int middle, int end) {
		Client[] left  = new Client[middle - start+1];
		Client[] right = new Client[end - middle];

		for (int i = 0; i < left.length; ++i)
			left[i] = list[start+i];

		for (int i = 0; i < right.length; ++i)
			right[i] = list[middle + i+1];

		int leftI= 0;
		int rightI = 0;
		int currentI = 0;

		while (leftI < left.length && rightI < right.length)
		{
			if (( left[leftI].getRegisterDate()).compareTo( right[rightI].getRegisterDate()) <= 0)
			{
				list[currentI] = left[leftI];
				leftI++;
			}
			else
			{
				list[currentI] = right[rightI];
				rightI++;
			}
			currentI++;
		}
	
		while (leftI < left.length) {
			currentI++;
			leftI++;
			list[currentI] = left[leftI];
		}

		while (rightI < right.length) {
			currentI++;
			rightI++;
			list[currentI] = right[rightI];
		}
	}
	
	
	
	
	public ArrayList<Client> bstSort() {
		
		Client[] list = getArrayClients();
		
		BTS<Client> tree = new BTS<>();
		for(int i=0;i<list.length;i++) {
			tree.addNode(list[i]);
		}
		
		tree.traverseInOrder(tree.getRoot());
		
		ArrayList<Client> listA= new ArrayList<Client>(Arrays.asList(list));
		return listA;
	}
	
	public ArrayList<Client> getArrayListClientQueue(){
		 ArrayList<Client> arrClient = new ArrayList<>();
		 Client c;
		int size = clientQueue.size();
		 if(!clientQueue.isEmpty())
		
			for(int i=0;i<size;i++) {
				c = clientQueue.dequeue();
				arrClient.add(c);
				clientQueue.enqueue(c);
			}
			return arrClient;
	}	
	
<<<<<<< HEAD
	public ArrayList<Client> getArrayListClients(){
		return clients;
	}

=======
>>>>>>> 9c401206f14677b390af3854e3bbfd4c4c6b5ebf
}

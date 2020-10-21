package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import BTS.BTS;
import HashTable.HashTable;
import Queue.Queue;
import linkedList.Node;
import priorityQueue.PriorityQueue;
import sortmethods.HeapSort;
import sortmethods.SortingMetdos;

/**This is the Main Class of the Bank Simply Organizer Project 
 * which is mean to be a simple organizer for attending Clients in a bank.
 * 
 * @authors Alejandro Arce, Alexander Samaca, Duvan Cuero
 * 
 * @date Unreleased
 * 
 */
public class Bank implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashTable<Integer,Client> bank;
	private ArrayList<Client> clients;
	private Queue<Client> clientQueue;
	private PriorityQueue<Client> prioriQueue;
	private int numsCards=100000000;
	/** The constructor of the Class bank which starts with a designate administrator
	 *  which takes control of the .
	 * @param admin: The administrator of the bank.
	 */
	public Bank() {
		clients = new ArrayList<Client>();
		bank = new HashTable<Integer,Client>(90);
		clientQueue = new Queue<Client>();
		prioriQueue = new PriorityQueue<Client>(12);	
	}
	
	public void loadBankData() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream leyendoFichero;
	
			leyendoFichero = new ObjectInputStream(new FileInputStream("./data/BankData") );
			@SuppressWarnings("unchecked")
			HashTable<Integer,Client> readObject = ( HashTable<Integer,Client>)leyendoFichero.readObject();
			bank = readObject;
            leyendoFichero.close();
	
	            
	}
	public void loadClients() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream leyendoFichero;
	
			leyendoFichero = new ObjectInputStream(new FileInputStream("./data/ClienList") );
			@SuppressWarnings("unchecked")
			ArrayList<Client> readObject = (ArrayList<Client>)leyendoFichero.readObject();
			clients = readObject;
            leyendoFichero.close();

	            
	}
	public void saveBankData() throws FileNotFoundException, IOException {
		ObjectOutputStream escribiendoFichero;
	
			escribiendoFichero = new ObjectOutputStream(new FileOutputStream("./data/BankData") );
			escribiendoFichero.writeObject(bank);
            escribiendoFichero.close();
	   
	}
	
	public void saveClienList() throws FileNotFoundException, IOException {
		ObjectOutputStream escribiendoFichero;
	
			escribiendoFichero = new ObjectOutputStream(new FileOutputStream("./data/ClienList") );
			escribiendoFichero.writeObject(clients);
            escribiendoFichero.close();
  
	}
	
	/** Registers a Client in the bank data base (HashTable).
	 * @param c : the client that is going to be inserted.
	 */
	public void registerClient(String name, int cc,double amount) {
		Date date = new Date(System.currentTimeMillis());
		int cardNumber = (int) (Math.random() *9999999+ 1000000);
		cardNumber += numsCards;
		numsCards++;
		DebitCard debitCard = new DebitCard(amount,date,cardNumber);
		Client c = new Client(name, cc,debitCard,null);
		
		clients.add(c);
		bank.put(c.getCc(), c);
		
	}
	
	public void registerClient(String name, int cc,double amount,double balance,int limit) {
		Date date = new Date(System.currentTimeMillis());
		int cardNumber = (int) (Math.random() *9999999+ 1000000);
		cardNumber += numsCards;
		numsCards++;
		CreditCard creditCard = new CreditCard(balance,date,numsCards,limit);
		DebitCard debitCard = new DebitCard(amount,date,cardNumber);
		Client c = new Client(name, cc,debitCard,creditCard);
		
		clients.add(c);
		bank.put(c.getCc(), c);
		
	}
	
	
	
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
		bank.get(cc).saveTransaction(bank.get(cc), i);
	}

	public String dateToString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		String strDate = dateFormat.format(date);  
		return strDate;
	}



	public HashTable<Integer, Client> getBank() {
		return bank;
	}



	public Queue<Client> getClientQueue() {
		return clientQueue;
	}



	public PriorityQueue<Client> getPrioriQueue() {
		return prioriQueue;
	}
	
	public Client[] getArrayClients() {
		Client[] c = new Client[clients.size()];
		for(int i=0;i<c.length;i++) {
			c[i]=clients.get(i);
		}
		return c;
	}
	
	public ArrayList<Client> getArrayListClients(){
		return clients;
	}
		
	
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
	

	
}

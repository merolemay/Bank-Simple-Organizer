package model;

import java.util.Date;

import Stack.Stack;

public class Client {
	
	private String name;
	private int cc;
	private DebitCard debitCard;
	private CreditCard crediCard;
	private Stack<Transactions> transactionsStack;
	private Transactions tr;
	
	public Client() {
		
	}

	/** Constructor of the Client class using the basic names to register a Client into the bank following the next instances
	 * @param name : Name of the Client.
	 * @param cc : Document number of the client.
	 * @param bankAcountNumber : Number which the account of the client is in the data base
	 * @param registerDate : The date in which the Client was registered into the bank
	 */
	public Client(String name, int cc,Date registerDate) {
		this.name = name;
		this.cc = cc;
		this.debitCard = null;
		this.crediCard = null;
		transactionsStack = new Stack<Transactions>();
		tr=null;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cc
	 */
	public int getCc() {
		return cc;
	}

	/**
	 * @param cc the cc to set
	 */
	public void setCc(int cc) {
		this.cc = cc;
	}

	/**
	 * @return the debitCard
	 */
	public DebitCard getDebitCard() {
		return debitCard;
	}

	/**
	 * @param debitCard the debitCard to set
	 */
	public void setDebitCard(DebitCard debitCard) {
		this.debitCard = debitCard;
	}

	/**
	 * @return the crediCard
	 */
	public CreditCard getCrediCard() {
		return crediCard;
	}

	/**
	 * @param crediCard the crediCard to set
	 */
	public void setCrediCard(CreditCard crediCard) {
		this.crediCard = crediCard;
	}

	/**
	 * @return the transactions
	 */
	public Stack<Transactions> getTransactions() {
		return transactionsStack;
	}
	
	public void saveTransaction(Client c, int i) {
		c.getTransactions().push(new Transactions(new Date(System.currentTimeMillis()),i));
	}
	

}

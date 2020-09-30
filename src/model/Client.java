package model;

import java.util.Date;

import Stack.Stack;

public class Client {
	
	private String name;
	private int cc;
	private DebitCard debitCard;
	private CreditCard creditCard;
	private Stack<Transactions> transactions;
	private Date registerDate;

	/** Constructor of the Client class using the basic names to register a Client into the bank following the next instances
	 * @param name : Name of the Client.
	 * @param cc : Document number of the client.
	 * @param bankAcountNumber : Number which the account of the client is in the data base
	 * @param registerDate : The date in which the Client was registered into the bank
	 */
	public Client(String name, int cc) {
		this.name = name;
		this.cc = cc;
		this.debitCard = null;
		this.creditCard = null;
		transactions = new Stack<Transactions>();
		registerDate = new Date(System.currentTimeMillis());
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
		return creditCard;
	}

	/**
	 * @param crediCard the crediCard to set
	 */
	public void setCrediCard(CreditCard crediCard) {
		this.creditCard = crediCard;
	}

	/**
	 * @return the transactions
	 */
	public Stack<Transactions> getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(Stack<Transactions> transactions) {
		this.transactions = transactions;
	}

	public boolean saveTransaction(Client c, double i) {
		boolean s;
		if(debitCard.changeAmount(i)) {
			c.getTransactions().push(new Transactions(new Date(System.currentTimeMillis()),i));
			s=true;
		}else {
			s=false;
		}
		return s;
		
		
		
	}
	
	public boolean payCreditCard(Client c, double i,boolean t) {

		boolean s=false;
		if(t) {
			if(debitCard.payWith(i)) {
				creditCard.payCard();
				c.getTransactions().push(new Transactions(new Date(System.currentTimeMillis()),i));
				s=true;
			}
		}else {
			creditCard.payCard();
			c.getTransactions().push(new Transactions(new Date(System.currentTimeMillis()),i));
			s=true;
		}
		return s;
		
	}
	
	public Date getRegisterDate() {
		return registerDate;
	}
}

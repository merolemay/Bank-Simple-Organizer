package model;

import java.util.Date;

import Stack.Stack;

public class Client implements Comparable<Client> {
	
	private String name;
	private int cc;
	private double amount;
	private String registerDateString;
	private DebitCard debitCard;
	private CreditCard creditCard;
	private Stack<Transactions> transactions;
	private Date registerDate;
<<<<<<< HEAD
	
=======
	private String registerDateString;
>>>>>>> 9c401206f14677b390af3854e3bbfd4c4c6b5ebf

	/** Constructor of the Client class using the basic names to register a Client into the bank following the next instances
	 * @param name : Name of the Client.
	 * @param cc : Document number of the client.
	 */
<<<<<<< HEAD
	public Client(String name, int cc,double amount,DebitCard d) {
		this.name = name;
		this.cc = cc;
		this.amount=amount;
		debitCard = d;
=======
	public Client(String name, int cc,double amount) {
		this.name = name;
		this.cc = cc;
		this.amount=amount;
		debitCard = new DebitCard(0,new Date(System.currentTimeMillis()),0,false);
		creditCard= new CreditCard(0,new Date(System.currentTimeMillis()),0,false);;
>>>>>>> 9c401206f14677b390af3854e3bbfd4c4c6b5ebf
		registerDate = new Date(System.currentTimeMillis()); 
		transactions = new Stack<Transactions>();
		transactions.push(new Transactions(new Date(System.currentTimeMillis()),0));
		registerDateString = registerDate.toString();
	}
	
<<<<<<< HEAD
	public Client(String name, int cc,double amount,CreditCard c,DebitCard d) {
		this.name = name;
		this.cc = cc;
		this.amount=amount;
		creditCard = c;
		debitCard = d;
		registerDate = new Date(System.currentTimeMillis()); 
		transactions = new Stack<Transactions>();
		transactions.push(new Transactions(new Date(System.currentTimeMillis()),0));
		registerDateString = registerDate.toString();
	}
	
	
	public double getAmount() {
		return amount;
	}
=======
>>>>>>> 9c401206f14677b390af3854e3bbfd4c4c6b5ebf
	
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



	public void saveTransaction( double i) {
		this.getTransactions().push(new Transactions(new Date(System.currentTimeMillis()),i));		
	
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
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Date getRegisterDate() {
		return registerDate;
	}
	

	
	@Override
	public int compareTo(Client o) {
		if(amount > o.amount) {
			return 1;
		}
		else
			return -1;
	}
<<<<<<< HEAD
	
	public String getRegisterDateString() {
		return registerDateString;
	}
=======
>>>>>>> 9c401206f14677b390af3854e3bbfd4c4c6b5ebf
		
}

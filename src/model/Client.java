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
	

	/** Constructor of the Client class using the basic names to register a Client into the bank following the next instances
	 * @param name : Name of the Client.
	 * @param cc : Document number of the client.
	 */
	public Client(String name, int cc,double amount,DebitCard d) {
		this.name = name;
		this.cc = cc;
		this.amount=amount;
		debitCard = d;
		registerDate = new Date(System.currentTimeMillis()); 
		transactions = new Stack<Transactions>();
		transactions.push(new Transactions(new Date(System.currentTimeMillis()),0));
		registerDateString = registerDate.toString();
	}
	
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
	
	public String getRegisterDateString() {
		return registerDateString;
	}
		
}

package model;

import java.util.Date;

import Stack.Stack;

public class Client implements Comparable<Client> {
	
	private String name;
	private int cc;
	private DebitCard debitCard;
	private double amount;
	private CreditCard creditCard;
	private Stack<Transactions> transactions;
	private Date registerDate;
	private String registerDateString;

	/** Constructor of the Client class using the basic names to register a Client into the bank following the next instances
	 * @param name : Name of the Client.
	 * @param cc : Document number of the client.
	 */
	public Client(String name, int cc,double amount) {
		this.name = name;
		this.cc = cc;
		this.amount=amount;
		debitCard = new DebitCard(0,new Date(System.currentTimeMillis()),0,false);
		creditCard= new CreditCard(0,new Date(System.currentTimeMillis()),0,false);;
		registerDate = new Date(System.currentTimeMillis()); 
		transactions = new Stack<Transactions>();
		transactions.push(new Transactions(new Date(System.currentTimeMillis()),0));
		registerDateString = registerDate.toString();
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
		
}

package model;

import java.util.Date;

public class CreditCard {
	
	private double balance;
	private Date creationDate;
	private int number;
	private int limit;
	private Date dateOfPay;
	private boolean state;
	
	
	public CreditCard(double balance, Date creationDate, int number, boolean limit) {
		this.balance = balance;
		this.creationDate = creationDate;
		this.number = number;
		this.state = limit;
	}
	
	public void payCard() {
		balance =0;
	}
	

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public Date getDateOfPay() {
		return dateOfPay;
	}

	public void setDateOfPay(Date dateOfPay) {
		this.dateOfPay = dateOfPay;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public boolean isState() {
		return state;
	}
	
}

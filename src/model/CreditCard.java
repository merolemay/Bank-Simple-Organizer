package model;

import java.util.Date;

public class CreditCard {
	
	private double balance;
	private Date creationDate;
	private int number;
	private double limit;
	private Date dateOfPay;
	
	
	public CreditCard(double balance, Date creationDate, int number, double limit) {
		this.balance = balance;
		this.creationDate = creationDate;
		this.number = number;
		this.limit = limit;
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

	public void setLimit(double limit) {
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
	
	
}

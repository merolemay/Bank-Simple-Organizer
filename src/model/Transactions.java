package model;

import java.util.Date;

public class Transactions {

	private Date date;
	private String lastTransaction;
	private double money;
	
	public Transactions(Date date, double n) {
		this.date=date;
		money = n;
		if(n<0) {
			lastTransaction="The last transaction was a withdrawal of:"+money+"$";
		} else {
			lastTransaction="The last transaction was a deposit of:"+money+"$";
		}
	}
	
	public String getLastTransaction() {
		return lastTransaction;
	}
	public Date getDate() {
		return date;
	}
	
	public double getMoney() {
		return money;
	}
}

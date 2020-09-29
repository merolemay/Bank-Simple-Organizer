package model;

import java.util.Date;

public class Transactions {

	private Date date;
	private String transaction;
	
	public Transactions(Date date, int n) {
		this.date=date;
		if(n<0) {
			transaction="The last transaction was a withdrawal of:"+n+"$";
		} else {
			transaction="The last transaction was a deposit of:"+n+"$";
		}
	}
	
	public String getTransaction() {
		return transaction;
	}
	
	public Date getDate() {
		return date;
	}
	
}

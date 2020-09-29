package model;

import java.util.Date;

public class Transactions {

	private Date date;
	private String lastTransaction;
	
	public Transactions(Date date, int n) {
		this.date=date;
		if(n<0) {
			lastTransaction="The last transaction was a withdrawal of:"+n+"$";
		} else {
			lastTransaction="The last transaction was a deposit of:"+n+"$";
		}
	}
	
	public String getLastTransaction() {
		return lastTransaction;
	}
	
	public Date getDate() {
		return date;
	}
	
}

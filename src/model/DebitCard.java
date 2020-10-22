package model;

import java.util.Date;

public class DebitCard {

	private double amount;
	private Date creationDate;
	private int number;
	private boolean state;
	
	public DebitCard(double amount, Date creationDate, int number,boolean state) {
		this.amount = amount;
		this.creationDate = creationDate;
		this.number = number;
		this.state=state;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	public boolean payWith (double am) {
		
		
		if (am <= amount ) {
			
			amount= amount -  am;
			
					
			return true;
			
		}else {
			return false;
		}
		
		
	}
	public boolean changeAmount(double money) {
		amount = amount+money;
		boolean b;
		if(amount<0) {
			b = false;
		}else {
			b = true;
		}
		return b;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public boolean isState() {
		return state;
	}
}

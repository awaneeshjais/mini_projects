package com.simplebank.db;

public class Credit {
	private int id;
	private int creditNumber;
	private int summaCredit;
	private int timeCredit;
	private double percentCredit;
	private String typeOfCredit;// (ANN, DEC);
	private int balanceTime;
	private double balanceBody;
	private double balancePercent;
	
	public Credit(){}
	public Credit(int creditNumber) {
	      this.creditNumber = creditNumber;
	      
	   }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCreditNumber() {
		return creditNumber;
	}
	public void setCreditNumber(int creditNumber) {
		this.creditNumber = creditNumber;
	}
	public int getSummaCredit() {
		return summaCredit;
	}
	public void setSummaCredit(int summaCredit) {
		this.summaCredit = summaCredit;
	}
	public int getTimeCredit() {
		return timeCredit;
	}
	public void setTimeCredit(int timeCredit) {
		this.timeCredit = timeCredit;
	}
	public double getPercentCredit() {
		return percentCredit;
	}
	public void setPercentCredit(double percentCredit) {
		this.percentCredit = percentCredit;
	}
	public String getTypeOfCredit() {
		return typeOfCredit;
	}
	public void setTypeOfCredit(String typeOfCredit) {
		this.typeOfCredit = typeOfCredit;
	}
	public int getBalanceTime() {
		return balanceTime;
	}
	public void setBalanceTime(int balanceTime) {
		this.balanceTime = balanceTime;
	}
	public double getBalanceBody() {
		return balanceBody;
	}
	public void setBalanceBody(double balanceBody) {
		this.balanceBody = balanceBody;
	}
	public double getBalancePercent() {
		return balancePercent;
	}
	public void setBalancePercent(double balancePercent) {
		this.balancePercent = balancePercent;
	}
	
}

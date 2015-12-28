package com.simplebank.businesslogic;

public interface IKreditLogic {
	public void AddKredit(int creditNumber, int summa, int time, double percent, String type);
	public void GetDebit(int creditNumber);
	public void AddDebit(int creditNumber,  double balanceBody);
}
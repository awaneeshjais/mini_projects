package com.simplebank.db;

public interface IDataBase {
	public void AddContract(int creditNumber, int summaCredit, int time, double percent, String type);
	public void AddPyment(int creditNumber, int balanceTime, double balanceBody);
	public void AddPyment(int creditNumber, int balanceTime, double balanceBody, double balancePercent);
	public int GetSumma(int creditNumber);
	public int GetTime(int creditNumber);
	public double GetPercent(int creditNumber);
	
	public int GetBalanceTime(int creditNumber);
	public double GetBalanceBody(int creditNumber);
	public double GetBalancePercent(int creditNumber);
	
	public boolean isContract(int creditNumber);
}
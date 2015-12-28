package com.simplebank.businesslogic;

import com.simplebank.db.DataBase;

public class DecliningBalance implements IKreditLogic{

	@Override
	public void AddKredit(int creditNumber, int summaCredit, int time, double percent, String type) {
		DataBase db = new DataBase();
		db.AddContract(creditNumber, summaCredit, time, percent, type);				
	}

	@Override
	public void GetDebit(int creditNumber) {
		DataBase db = new DataBase();
		int summa = db.GetSumma(creditNumber);
		int time = db.GetTime(creditNumber);
		double percent = db.GetPercent(creditNumber);
		//int balanceTime = db.GetBalanceTime(creditNumber);
		double balanceBody = db.GetBalanceBody(creditNumber);
		//double balancePercent = db.GetBalancePercent(creditNumber);
		
		double body = summa/time;
		double perc = (summa-balanceBody) * (percent/12);
		double paym = body + perc;
		
		System.out.println(creditNumber + ", DEC = " + Math.round(paym) + " [body = " + Math.round(body) + ", percents = " + Math.round(perc) + "]");
	}

	@Override
	public void AddDebit(int creditNumber, double balance) {
		DataBase db = new DataBase();
		int summa = db.GetSumma(creditNumber);
		int time = db.GetTime(creditNumber);
		double percent = db.GetPercent(creditNumber);
		int balanceTime = db.GetBalanceTime(creditNumber);
		double balanceBody = db.GetBalanceBody(creditNumber);
		double balancePercent = db.GetBalancePercent(creditNumber);
		
		//double body = summa/time;
		double perc = (summa-balanceBody) * (percent/12);
		double body = balance - perc;
		
		db.AddPyment(creditNumber, balanceTime+1, balanceBody+body, balancePercent+perc);	
	}
}
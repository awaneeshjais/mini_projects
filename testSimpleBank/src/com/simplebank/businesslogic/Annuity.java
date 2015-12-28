package com.simplebank.businesslogic;

import com.simplebank.db.DataBase;

public class Annuity implements IKreditLogic{

	@Override
	public void AddKredit(int creditNumber, int summaCredit, int time, double percent, String type) {
		DataBase db = new DataBase();
		db.AddContract(creditNumber, summaCredit, time, percent, type);		
	}

	@Override
	public void GetDebit(int creditNumber) {
		DataBase db = new DataBase();
		double summa = db.GetSumma(creditNumber);
		int time = db.GetTime(creditNumber);
		double percent = db.GetPercent(creditNumber);
			
		double debit = (summa * (percent/12))/(1 - (1/Math.pow((1 + (percent/12)), time)));
		System.out.println(creditNumber + ", ANN = " + Math.round(debit));
	}

	@Override
	public void AddDebit(int creditNumber, double balanceBody) {
		DataBase db = new DataBase();
		int time = db.GetBalanceTime(creditNumber);
		double body = db.GetBalanceBody(creditNumber);
		db.AddPyment(creditNumber, time+1, body+balanceBody);		
	}
}

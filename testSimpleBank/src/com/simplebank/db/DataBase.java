package com.simplebank.db;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.simplebank.helper.Convert;

public class DataBase implements IDataBase {
	
	public void count(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();//.openSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select creditNumber from Credit.credit");
		List<String[]> list = (List<String[]>) query.list();
		/*if (list.isEmpty()==true){
			System.out.println("Data base is empty: " + list.isEmpty());
		}else{
			for(int i = 0; i<list.size(); i++){
				System.out.println(list.get(i));
			}
		}*/
		System.out.println(list.size());
		session.getTransaction().commit();
	}
	
	@Override
	public void AddContract(int creditNumber, int summaCredit, int time, double percent, String type) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "insert into Credit.credit (creditNumber,summaCredit,timeCredit,percentCredit,typeOfCredit,balanceTime,balanceBody,balancePercent) values (" + 
				creditNumber + "," +
				summaCredit + "," +
				time + "," +
				percent + ",'" +
				type + "',0, 0.0, 0.0)";
		SQLQuery query = session.createSQLQuery(sql);
		query.executeUpdate();
		session.getTransaction().commit();
	}

	@Override
	public void AddPyment(int creditNumber, int balanceTime, double balancePercent) {///не понятно куда ложить в АНН ДЕК
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "update Credit.credit set balanceTime=" + balanceTime + 
				", balancePercent=" + balancePercent + " where creditNumber=" + creditNumber;
		SQLQuery query = session.createSQLQuery(sql);
		query.executeUpdate();
		session.getTransaction().commit();		
	}

	@Override
	public void AddPyment(int creditNumber, int balanceTime, double balanceBody, double balancePercent) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "update Credit.credit set balanceTime=" + balanceTime + 
				", balanceBody=" + balanceBody + 
				", balancePercent=" + balancePercent +
				" where creditNumber=" + creditNumber;
		SQLQuery query = session.createSQLQuery(sql);
		query.executeUpdate();
		session.getTransaction().commit();		
	}
	
	@Override
	public int GetSumma(int creditNumber) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();//.openSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select summaCredit from Credit.credit where creditNumber=" + creditNumber);
		List<String[]> list = (List<String[]>) query.list();
		session.getTransaction().commit();
		return Integer.parseInt(String.valueOf(list.get(0)));
	}

	@Override
	public int GetTime(int creditNumber) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();//.openSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select timeCredit from Credit.credit where creditNumber=" + creditNumber);
		List<String[]> list = (List<String[]>) query.list();
		session.getTransaction().commit();
		return Integer.parseInt(String.valueOf(list.get(0)));
	}

	@Override
	public double GetPercent(int creditNumber) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();//.openSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select percentCredit from Credit.credit where creditNumber=" + creditNumber);
		List<String[]> list = (List<String[]>) query.list();
		session.getTransaction().commit();
		return Double.parseDouble(String.valueOf(list.get(0)));
	}

	@Override
	public int GetBalanceTime(int creditNumber) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();//.openSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select balanceTime from Credit.credit where creditNumber=" + creditNumber);
		List<String[]> list = (List<String[]>) query.list();
		session.getTransaction().commit();
		return Integer.parseInt(String.valueOf(list.get(0)));
	}

	@Override
	public double GetBalanceBody(int creditNumber) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();//.openSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select balanceBody from Credit.credit where creditNumber=" + creditNumber);
		List<String[]> list = (List<String[]>) query.list();
		session.getTransaction().commit();
		return Double.parseDouble(String.valueOf(list.get(0)));
	}

	@Override
	public double GetBalancePercent(int creditNumber) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();//.openSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select balancePercent from Credit.credit where creditNumber=" + creditNumber);
		List<String[]> list = (List<String[]>) query.list();
		session.getTransaction().commit();
		return Double.parseDouble(String.valueOf(list.get(0)));
	}

	@Override
	public boolean isContract(int creditNumber) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select count(creditNumber) from Credit.credit where creditNumber=" + creditNumber);
		List<String[]> list = (List<String[]>) query.list();
		int temp = Integer.parseInt(String.valueOf(list.get(0)));
		if (temp>0){
			return true;
		}else{
			return false;
		}
	}
}

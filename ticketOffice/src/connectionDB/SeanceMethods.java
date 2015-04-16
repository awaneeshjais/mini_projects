package connectionDB;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import connectionDB.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Query;

public class SeanceMethods {
	/*public void countID(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List list = session.createQuery("select count(*) from TICKET_OFFICE.SEANCE where udln is null").list();
		System.out.println("Aggregate function count = "+list);
		session.getTransaction().commit();
	}*/
	public void addSeanceID(String s_country, String s_town, String s_theatre, String s_cinema_hall, 
			                Date s_date_seance, Time s_time_seance, String s_film_name,
			                int s_number_chair, int cost_chair){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "insert into TICKET_OFFICE.SEANCE (udln,country,town,theatre,cinema_hall"
				   + ",date_seance,time_seance,film_name,number_chair,cost_chair) " + 
					"values ('0','"+ 
				           s_country + "','" + 
					       s_town + "','" + 
				           s_theatre + "','" +
				           s_cinema_hall + "','" +
				           s_date_seance + "','" +
				           s_time_seance + "','" +
				           s_film_name + "','" +
				           s_number_chair + "','" +
				           cost_chair + "');";
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
		session.getTransaction().commit();
	}
}

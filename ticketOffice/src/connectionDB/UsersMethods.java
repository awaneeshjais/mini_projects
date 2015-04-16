package connectionDB;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UsersMethods {
	public void addUserID(String s_login, String s_pass, String s_mail, String s_telephone){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "insert into TICKET_OFFICE.USERS (udln,login,pass,mail,telephone) " + 
				"values ('0','"+ 
				s_login + "','" + 
				s_pass + "','" + 
				s_mail + "','" +
				s_telephone + "');";
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
		session.getTransaction().commit();
	}
	
	public String checkLoginDB(String s_login) throws SQLException{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "SELECT LOGIN FROM TICKET_OFFICE.USERS WHERE UDLN='0' AND LOGIN LIKE '"
				+ s_login + "';";
		Query query = session.createSQLQuery(sql);
		List ansver = query.list();
		session.getTransaction().commit();
        return String.valueOf(ansver.get(0));
	}
}

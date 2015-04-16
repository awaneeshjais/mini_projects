package servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionDB.SeanceMethods;

public class SeanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SeanceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String c_country = request.getParameter("country");  
		String c_town = request.getParameter("town");
		String c_theatre = request.getParameter("theatre");
		String c_hall = request.getParameter("hall");
		int dd = Integer.parseInt(request.getParameter("date_dd"));
		int mm = Integer.parseInt(request.getParameter("date_mm"));
		int yyyy = Integer.parseInt(request.getParameter("date_yyyy"));
		int hh = Integer.parseInt(request.getParameter("time_hours"));		
		int mi = Integer.parseInt(request.getParameter("time_minutes"));
		String c_name_seance = request.getParameter("name_seance");
		int count = Integer.parseInt(request.getParameter("count_ticket"));
		int cost = Integer.parseInt(request.getParameter("cost_ticket"));
		
		SeanceMethods sm = new SeanceMethods();
		sm.addSeanceID(c_country, c_town, c_theatre, c_hall, new Date(yyyy-1900,mm,dd), new Time(hh,mi,0), c_name_seance, count, cost);
		request.getRequestDispatcher("/add_seance_page.jsp").forward(request, response);
	}

}

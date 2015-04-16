package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connectionDB.UsersMethods;

public class EnterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EnterServlet() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String c_login = request.getParameter("login");
		String c_pass = request.getParameter("pass");
		
		request.getRequestDispatcher("/seance_user_page.jsp").forward(request, response);
		}
		
}
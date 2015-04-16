package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connectionDB.SeanceMethods;
import connectionDB.UsersMethods;

public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String c_login = request.getParameter("login");  
		String c_pass = request.getParameter("pass");
		String c_mail = request.getParameter("mail");
		String c_telephone = request.getParameter("telephone");
		
		String str;
		try {
			str = new UsersMethods().checkLoginDB(c_login);
			if (str.equals(c_login)){
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, String.valueOf("Логин '" + c_login + "' уже существует"));
				request.getRequestDispatcher("/reg_page.jsp").forward(request, response);
			}else{
				//NOT WORK!!!!
				new UsersMethods().addUserID(c_login, c_pass, c_mail, c_telephone);
				request.getRequestDispatcher("/add_user_page.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}

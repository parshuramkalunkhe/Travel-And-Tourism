package org.travelandtourism.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.travelandtourism.constants.CONSTANTS;
import org.travelandtourism.dao.AdminDAO;
import org.travelandtourism.utils.DBConnectivity;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		boolean isAdmin = req.getParameter("admin") != null;
		
		if (!isAdmin) {
			try {
				boolean isLogin = validate(email, password);
				System.out.println("User");
				if (isLogin) {
					HttpSession session = req.getSession();
					session.setAttribute("isLogin", isLogin);
					session.setAttribute("email", email);
					RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
					rd.include(req, resp);
				} else {
					resp.sendRedirect("login.html");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			AdminDAO dao = new AdminDAO();
			try {
				isAdmin = dao.isAdmin(email, password);
				System.out.println("Admin");
				if (isAdmin) {
					HttpSession session = req.getSession();
					session.setAttribute("isAdmin", isAdmin);
					resp.sendRedirect("dashboard.jsp");
				} else {
					resp.sendRedirect("login.html");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				resp.sendRedirect("error.jsp");
			}
			
		}
	}
	
	private boolean validate(String email, String password) throws SQLException {
		
		DBConnectivity dbc = DBConnectivity.getInstance();
		Connection con = dbc.getConnection();
		
		String query = "SELECT * FROM " + CONSTANTS.DB_NAME + "." + CONSTANTS.USERS_TABLE + " WHERE email=? AND password=?";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, email);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		return rs.next();
	}
}

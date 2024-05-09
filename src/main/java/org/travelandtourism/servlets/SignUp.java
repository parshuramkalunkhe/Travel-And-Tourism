package org.travelandtourism.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.travelandtourism.constants.CONSTANTS;
import org.travelandtourism.utils.DBConnectivity;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/signup")
public class SignUp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String contact = req.getParameter("contact");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try {
			int row = insert(username, contact, email, password);
			if (row > 0) {
				resp.sendRedirect("login.html");
			} else {
				resp.sendRedirect("signup.html");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private int insert(String username, String contact, String email, String password) throws SQLException {
		DBConnectivity dbc = DBConnectivity.getInstance();
		Connection con = dbc.getConnection();
		
		String query = "INSERT INTO " + CONSTANTS.DB_NAME + "." + CONSTANTS.USERS_TABLE + "(username, contact, email, password) VALUES(?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, username);
		ps.setString(2, contact);
		ps.setString(3, email);
		ps.setString(4, password);
		
		return ps.executeUpdate();
	}
}

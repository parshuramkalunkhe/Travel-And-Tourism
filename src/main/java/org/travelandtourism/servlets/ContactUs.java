package org.travelandtourism.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.travelandtourism.constants.CONSTANTS;
import org.travelandtourism.utils.DBConnectivity;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/contactus")
public class ContactUs extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String message = req.getParameter("message");
		
		try {
			int row = insert(name, email, message);
			if (row > 0) {
				RequestDispatcher rd = req.getRequestDispatcher("contactus.jsp");
				rd.forward(req, resp);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
				req.setAttribute("message", "something went wrong");
				rd.include(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private int insert(String name, String email, String message) throws SQLException {
		DBConnectivity dbc = DBConnectivity.getInstance();
		Connection con = dbc.getConnection();
		
		String query = "INSERT INTO " + CONSTANTS.DB_NAME + "." + CONSTANTS.CONTACTUS_TABLE + "(name, email, message, datetime) VALUES(?,?,?,?)";
		Date date = new Date(System.currentTimeMillis()); 
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, message);
		ps.setDate(4, date);
		
		return ps.executeUpdate();
	}
}

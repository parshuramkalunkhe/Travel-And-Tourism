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

import org.travelandtourism.utils.DBConnectivity;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/AddAccommodation")
public class AddAccommodation extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String location = req.getParameter("location");
		String description = req.getParameter("description");
		double price = Double.parseDouble(req.getParameter("price"));
		String imgUrl = req.getParameter("imgUrl");
		
		DBConnectivity dbc = DBConnectivity.getInstance();
		Connection con = dbc.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO travelandtourism.accommodation (title, location, description, price, imgUrl) VALUES (?,?,?,?,?)");
			ps.setString(1, title);
			ps.setString(2, location);
			ps.setString(3, description);
			ps.setDouble(4, price);
			ps.setString(5, imgUrl);
			
			int row = ps.executeUpdate();
			if(row > 0) {
				resp.sendRedirect("accommos.jsp");
			} else {
				resp.sendRedirect("newacc.jsp");
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
			resp.sendRedirect("error.jsp");
		}
	}
}

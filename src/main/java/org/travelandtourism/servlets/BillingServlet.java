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
@WebServlet(urlPatterns = "/BillingServlet")
public class BillingServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		int accommodationId = Integer.parseInt(req.getParameter("accommodationId"));
		double price = Double.parseDouble(req.getParameter("price"));
		String upi = req.getParameter("upi");

		if (upi.isBlank() || upi.isEmpty()) {
			resp.sendRedirect("billing.jsp");
		}

		DBConnectivity dbc = DBConnectivity.getInstance();
		Connection con = dbc.getConnection();

		String query = "INSERT INTO " + CONSTANTS.DB_NAME + "." + CONSTANTS.BILLING_TABLE
				+ "(email, accommodationId, upi, price) VALUES(?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, email);
			st.setInt(2, accommodationId);
			st.setString(3, upi);
			st.setDouble(4, price);
			
			int row = st.executeUpdate();
			
			if (row > 0) {
				resp.sendRedirect("accommodation.jsp");
			} else {
				resp.sendRedirect("billing.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

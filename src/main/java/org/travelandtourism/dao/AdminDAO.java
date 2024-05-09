package org.travelandtourism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.travelandtourism.utils.DBConnectivity;

public class AdminDAO {
	DBConnectivity dbc = null;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public boolean isAdmin(String email, String pass) throws SQLException {
		dbc = DBConnectivity.getInstance();
		con = dbc.getConnection();
		
		String query = "SELECT * FROM travelandtourism.admin WHERE email = ? AND pass = ?";
		
		ps = con.prepareStatement(query);
		
		ps.setString(1, email);
		ps.setString(2, pass);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			return true;
		}
		
		return false;
	}
}

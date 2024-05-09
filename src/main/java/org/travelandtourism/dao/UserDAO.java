package org.travelandtourism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.travelandtourism.model.User;
import org.travelandtourism.utils.DBConnectivity;

public class UserDAO {
	DBConnectivity dbc = null;
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	User user = null;
	List<User> users = new ArrayList<User>();
	
	public UserDAO() {
		dbc = DBConnectivity.getInstance();
		connection = dbc.getConnection();
	}
	
	public List<User> getAllUsers() {
	    try {
	        String query = "SELECT * FROM travelandtourism.users";
	        statement = connection.prepareStatement(query);

	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            user = new User();
	            user.setId(resultSet.getInt("id"));
	            user.setUsername(resultSet.getString("username"));
	            user.setContact(resultSet.getLong("contact")); // Corrected column name
	            user.setEmail(resultSet.getString("email"));
	            user.setPassword(resultSet.getString("password"));
	            users.add(user);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeResources(connection, statement, resultSet);
	    }

	    return users;
	}

	
	public User getUserId(String email) {
		
		try {
			statement = connection.prepareStatement("SELECT * FROM FROM travelandtourism.users WHERE email = ?");
			statement.setString(1, email);

			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setContact(resultSet.getLong("contact"));
				user.setEmail(resultSet.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, statement, resultSet);
		}
		
		return user;
	}

	private void closeResources(Connection connection2, PreparedStatement statement2, ResultSet resultSet2) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

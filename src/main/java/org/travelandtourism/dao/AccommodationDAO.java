package org.travelandtourism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.travelandtourism.model.Accommodation;
import org.travelandtourism.utils.DBConnectivity;

public class AccommodationDAO {
	List<Accommodation> accommodations = new ArrayList<Accommodation>();
	DBConnectivity dbc = null;
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	public AccommodationDAO() {
		dbc = DBConnectivity.getInstance();
		connection = dbc.getConnection();
	}

	public List<Accommodation> getAllAccommodations() {
		try {
			String query = "SELECT * FROM travelandtourism.accommodation";
			statement = connection.prepareStatement(query);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Accommodation accommodation = new Accommodation();
				accommodation.setId(resultSet.getInt("id"));
				accommodation.setTitle(resultSet.getString("title"));
				accommodation.setLocation(resultSet.getString("location"));
				accommodation.setDesc(resultSet.getString("description"));
				accommodation.setPrice(resultSet.getDouble("price"));
				accommodation.setImgUrl(resultSet.getString("imgUrl"));
				accommodations.add(accommodation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, statement, resultSet);
		}

		return accommodations;
	}

	public Accommodation getAccommodationById(int id) {
		Accommodation accommodation = null;

		try {
			String query = "SELECT * FROM travelandtourism.accommodation WHERE id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				accommodation = new Accommodation();
				accommodation.setId(resultSet.getInt("id"));
				accommodation.setTitle(resultSet.getString("title"));
				accommodation.setLocation(resultSet.getString("location"));
				accommodation.setDesc(resultSet.getString("description"));
				accommodation.setPrice(resultSet.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(connection, statement, resultSet);
		}

		return accommodation;
	}
	
	public List<Accommodation> searchAccommodationsByLocation(String location) throws SQLException {
        List<Accommodation> accommodations = new ArrayList<>();
        String query = "SELECT * FROM travelandtourism.accommodation WHERE location LIKE ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + location + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Accommodation accommodation = new Accommodation();
                    accommodation.setId(resultSet.getInt("id"));
                    accommodation.setTitle(resultSet.getString("title"));
                    accommodation.setLocation(resultSet.getString("location"));
                    accommodation.setDesc(resultSet.getString("description"));
                    accommodation.setPrice(resultSet.getDouble("price"));
                    accommodation.setImgUrl(resultSet.getString("imgUrl"));
                    accommodations.add(accommodation);
                }
            }
        }
        return accommodations;
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

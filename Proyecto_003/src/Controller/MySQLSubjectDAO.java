/**
 * 
 * @author KevinPozo
 * Title: Inversión de Dependencia y DAO.
 * 
 * 
 * */

package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Student;
import Model.Subject;
import Model.SubjectDAO;

public class MySQLSubjectDAO implements SubjectDAO {
	private static MySQLSubjectDAO instance;
	private final Connection connection;

	public MySQLSubjectDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/Institute";
		String user = "root";
		String password = "Kevindini2003@";
		connection = DriverManager.getConnection(url, user, password);
	}

	public static MySQLSubjectDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new MySQLSubjectDAO();
		}
		return instance;
	}

	public void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	@Override
	public void create(Subject subject) {
		String query = "INSERT INTO Subject (name, description, level) VALUES (?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, subject.getName());
			statement.setString(2, subject.getDescription());
			statement.setInt(3, subject.getLevel());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Subject read(int id) {
		String query = "SELECT * FROM Subject WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new Subject(resultSet.getInt("id"), resultSet.getString("name"),
							resultSet.getString("description"), resultSet.getInt("level"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Subject subject) {
		String query = "DELETE FROM Subject WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, subject.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Subject subject) {
		String query = "UPDATE Subject SET name = ?, description = ?, level = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, subject.getName());
			statement.setString(2, subject.getDescription());
			statement.setInt(3, subject.getLevel());
			statement.setInt(4, subject.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

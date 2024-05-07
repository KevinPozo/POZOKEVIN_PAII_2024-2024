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

import Model.Teacher;
import Model.TeacherDAO;

public class MySQLTeacherDAO implements TeacherDAO {

	private static MySQLTeacherDAO instance;
	private final Connection connection;

	public MySQLTeacherDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/Institute";
		String user = "root";
		String password = "Kevindini2003@";
		connection = DriverManager.getConnection(url, user, password);
	}

	public static MySQLTeacherDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new MySQLTeacherDAO();
		}
		return instance;
	}

	public void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	@Override
	public void create(Teacher teacher) {
		String query = "INSERT INTO Teacher (name, lastName, age) VALUES (?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, teacher.getName());
			statement.setString(2, teacher.getLastName());
			statement.setInt(3, teacher.getAge());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Teacher read(int id) {
		String query = "SELECT * FROM Teacher WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new Teacher(resultSet.getInt("id"), resultSet.getString("name"),
							resultSet.getString("lastName"), resultSet.getInt("age"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Teacher teacher) {
		String query = "DELETE FROM Teacher WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, teacher.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Teacher teacher) {
		String query = "UPDATE Teacher SET name = ?, lastName = ?, age = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, teacher.getName());
			statement.setString(2, teacher.getLastName());
			statement.setInt(3, teacher.getAge());
			statement.setInt(4, teacher.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

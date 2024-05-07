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

import Model.Schedule;
import Model.ScheduleDAO;

public class MySQLScheduleDAO implements ScheduleDAO {
	private static MySQLScheduleDAO instance;
	private final Connection connection;

	private MySQLScheduleDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/Institute";
		String user = "root";
		String password = "Kevindini2003@";
		connection = DriverManager.getConnection(url, user, password);
	}

	public static MySQLScheduleDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new MySQLScheduleDAO();
		}
		return instance;
	}

	public void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	@Override
	public void create(Schedule schedule) {
		String query = "INSERT INTO Schedule (idSubject, idStudent, idTeacher, timeStart, timeEnd, day) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, schedule.getIdSubject());
			statement.setInt(2, schedule.getIdStudent());
			statement.setInt(3, schedule.getIdTeacher());
			statement.setTime(4, schedule.getTimeStart());
			statement.setTime(5, schedule.getTimeEnd());
			statement.setString(6, schedule.getDay());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Schedule read(int id) {
		String query = "SELECT * FROM Schedule WHERE idSubject = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new Schedule(resultSet.getInt("idSubject"), resultSet.getInt("idStudent"),
							resultSet.getInt("idTeacher"), resultSet.getTime("timeStart"), resultSet.getTime("timeEnd"),
							resultSet.getString("day"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Schedule schedule) {
		String query = "DELETE FROM Schedule WHERE idSubject = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, schedule.getIdSubject());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Schedule schedule) {
		String query = "UPDATE Schedule SET idStudent = ?, idTeacher = ?, timeStart = ?, timeEnd = ?, day = ? WHERE idSubject = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, schedule.getIdStudent());
			statement.setInt(2, schedule.getIdTeacher());
			statement.setTime(3, schedule.getTimeStart());
			statement.setTime(4, schedule.getTimeEnd());
			statement.setString(5, schedule.getDay());
			statement.setInt(6, schedule.getIdSubject());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

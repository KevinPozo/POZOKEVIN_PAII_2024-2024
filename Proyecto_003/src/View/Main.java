/**
 * 
 * @author KevinPozo
 * Title: Inversión de Dependencia y DAO.
 * 
 * 
 * */

package View;

import java.sql.SQLException;
import java.util.Scanner;

import Controller.MySQLStudentDAO;
import Controller.MySQLTeacherDAO;
import Model.Student;
import Model.Teacher;

public class Main {
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
//Desarrollo del dao:
		MySQLStudentDAO dao = new MySQLStudentDAO();
		MySQLTeacherDAO dao2 = new MySQLTeacherDAO();
//Creacion de estudiante:
		Student p1 = new Student(1, "Alejandro", "Ortiz", 35);
		Student p1Nuevo = new Student(1, "Alejandro", "Ortiz", 39);
		Teacher p2 = new Teacher(1, "Perez", "Pineda", 25);

//Dao:
//dao2.create(p2);
//System.out.println(dao2.read(1).toString());
//dao.delete(p1Nuevo);
//dao.update(p1Nuevo);
		dao.closeConnection();
	}
}

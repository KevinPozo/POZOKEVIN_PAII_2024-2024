/**
 * 
 * @author KevinPozo
 * Title: Hibernate e Inyección de Dependencia.
 * 
 * 
 * */
package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.StudentDAO;
import model.Student;

public class StudentPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private final StudentDAO studentDAO;

	public StudentPanel() {
		setTitle("Student");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 100);
		setLocationRelativeTo(null);

		studentDAO = new StudentDAO();

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		JButton btnCreate = new JButton("Create");
		JButton btnRead = new JButton("Read");
		JButton btnUpdate = new JButton("Update");
		JButton btnDelete = new JButton("Delete");
		JButton btnBack = new JButton("Back");

		panel.add(btnCreate);
		panel.add(btnRead);
		panel.add(btnUpdate);
		panel.add(btnDelete);
		panel.add(btnBack);

		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Container container = new Container();
				container.setVisible(true);
			}
		});

		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createStudent();
			}
		});

		btnRead.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				readStudent();
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateStudent();
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteStudent();
			}
		});

		add(panel);
	}

	private void createStudent() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		panel.add(new JLabel("Name:"));
		JTextField nameField = new JTextField(10);
		panel.add(nameField);

		panel.add(new JLabel("Last Name:"));
		JTextField lastNameField = new JTextField(10);
		panel.add(lastNameField);

		panel.add(new JLabel("Age:"));
		JTextField ageField = new JTextField(10);
		panel.add(ageField);

		int result = JOptionPane.showConfirmDialog(this, panel, "Create Student", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			String name = nameField.getText();
			String lastName = lastNameField.getText();
			int age = Integer.parseInt(ageField.getText());
			Student student = new Student();
			student.setName(name);
			student.setLastName(lastName);
			student.setAge(age);
			studentDAO.saveStudent(student);
		}
	}

	private void readStudent() {
		String input = JOptionPane.showInputDialog(this, "Insert Id of a Student:");

		if (input != null && !input.isEmpty()) {
			try {
				int studentId = Integer.parseInt(input);
				Student student = studentDAO.getStudent(studentId);

				if (student != null) {
					JPanel panel = new JPanel();
					panel.setLayout(new GridLayout(4, 1));

					panel.add(new JLabel("ID: " + student.getId()));
					panel.add(new JLabel("Name: " + student.getName()));
					panel.add(new JLabel("Last Name: " + student.getLastName()));
					panel.add(new JLabel("Age: " + student.getAge()));

					JOptionPane.showMessageDialog(this, panel, "Details of Student", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "No student was found with the provided ID.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Student ID must be an integer.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void updateStudent() {
		String input = JOptionPane.showInputDialog(this, "Insert ID of the student to update:");

		if (input != null && !input.isEmpty()) {
			try {
				int studentId = Integer.parseInt(input);

				Student studentToUpdate = studentDAO.getStudent(studentId);

				if (studentToUpdate != null) {
					String newName = JOptionPane.showInputDialog(this, "Name:");
					String newLastName = JOptionPane.showInputDialog(this, "Last Name:");
					String newAgeInput = JOptionPane.showInputDialog(this, "Age:");

					if (newAgeInput != null && !newAgeInput.isEmpty()) {
						int newAge = Integer.parseInt(newAgeInput);

						studentToUpdate.setName(newName);
						studentToUpdate.setLastName(newLastName);
						studentToUpdate.setAge(newAge);

						studentDAO.updateStudent(studentToUpdate);

						JOptionPane.showMessageDialog(this, "The student has been successfully updated.", "Success!",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(this, "Please enter a new valid age.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this, "No student found with ID: " + studentId, "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Student ID and new age must be integers.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void deleteStudent() {
		String input = JOptionPane.showInputDialog(this, "Insert ID of the student to delete:");

		if (input != null && !input.isEmpty()) {
			try {
				int studentId = Integer.parseInt(input);

				int confirm = JOptionPane.showConfirmDialog(this,
						"Are you sure you want to delete student with ID " + studentId + "?", "Confirm Deletion",
						JOptionPane.YES_NO_OPTION);

				if (confirm == JOptionPane.YES_OPTION) {
					studentDAO.deleteStudent(studentId);

					JOptionPane.showMessageDialog(this, "The student has been successfully deleted.", "Success!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Student ID must be an integer.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}

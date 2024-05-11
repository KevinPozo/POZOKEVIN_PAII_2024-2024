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

import Controller.TeacherDAO;
import model.Teacher;

public class TeacherPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private final TeacherDAO teacherDAO;

	public TeacherPanel() {
		setTitle("Teacher");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 100);
		setLocationRelativeTo(null);

		teacherDAO = new TeacherDAO();

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
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
				createTeacher();
			}
		});

		btnRead.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				readTeacher();
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTeacher();
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteTeacher();
			}
		});

		add(panel);
	}

	private void createTeacher() {
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

		int result = JOptionPane.showConfirmDialog(this, panel, "Create Teacher", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			String name = nameField.getText();
			String lastName = lastNameField.getText();
			int age = Integer.parseInt(ageField.getText());
			Teacher teacher = new Teacher();
			teacher.setName(name);
			teacher.setLastName(lastName);
			teacher.setAge(age);
			teacherDAO.saveTeacher(teacher);
		}
	}

	private void readTeacher() {
		String input = JOptionPane.showInputDialog(this, "Insert Id of a Teacher:");

		if (input != null && !input.isEmpty()) {
			try {
				int teacherId = Integer.parseInt(input);
				Teacher teacher = teacherDAO.getTeacher(teacherId);

				if (teacher != null) {
					JPanel panel = new JPanel();
					panel.setLayout(new GridLayout(4, 1));

					panel.add(new JLabel("ID: " + teacher.getId()));
					panel.add(new JLabel("Name: " + teacher.getName()));
					panel.add(new JLabel("Last Name: " + teacher.getLastName()));
					panel.add(new JLabel("Age: " + teacher.getAge()));

					JOptionPane.showMessageDialog(this, panel, "Details of Teacher", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "No teacher was found with the provided ID.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Teacher ID must be an integer.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void updateTeacher() {
		String input = JOptionPane.showInputDialog(this, "Insert ID of the Teacher to update:");

		if (input != null && !input.isEmpty()) {
			try {
				int teacherId = Integer.parseInt(input);

				Teacher teacherToUpdate = teacherDAO.getTeacher(teacherId);

				if (teacherToUpdate != null) {
					String newName = JOptionPane.showInputDialog(this, "Name:");
					String newLastName = JOptionPane.showInputDialog(this, "Last Name:");
					String newAgeInput = JOptionPane.showInputDialog(this, "Age:");

					if (newAgeInput != null && !newAgeInput.isEmpty()) {
						int newAge = Integer.parseInt(newAgeInput);

						teacherToUpdate.setName(newName);
						teacherToUpdate.setLastName(newLastName);
						teacherToUpdate.setAge(newAge);

						teacherDAO.updateTeacher(teacherToUpdate);

						JOptionPane.showMessageDialog(this, "The teacher has been successfully updated.", "Success!",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(this, "Please enter a new valid age.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this, "No teacher found with ID: " + teacherId, "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Teacher ID and new age must be integers.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void deleteTeacher() {
		String input = JOptionPane.showInputDialog(this, "Insert ID of the Teacher to delete:");

		if (input != null && !input.isEmpty()) {
			try {
				int teacherId = Integer.parseInt(input);

				int confirm = JOptionPane.showConfirmDialog(this,
						"Are you sure you want to delete Teacher with ID " + teacherId + "?", "Confirm Deletion",
						JOptionPane.YES_NO_OPTION);

				if (confirm == JOptionPane.YES_OPTION) {
					teacherDAO.deleteTeacher(teacherId);

					JOptionPane.showMessageDialog(this, "The teacher has been successfully deleted.", "Success!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Teacher ID must be an integer.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}

package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ScheduleDAO;
import model.Schedule;

public class SchedulePanel extends JFrame {

    private static final long serialVersionUID = 1L;
    private final ScheduleDAO scheduleDAO;

    public SchedulePanel() {
        setTitle("Schedule");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 100);
        setLocationRelativeTo(null);

        scheduleDAO = new ScheduleDAO(); 

        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);
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
                createSchedule();
            }
        });

        btnRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readSchedule();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSchedule();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSchedule();
            }
        });

        add(panel);
    }

    private void createSchedule() throws NumberFormatException {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2)); 
        
        panel.add(new JLabel("ID Subject:"));
        JTextField idSubjectField = new JTextField(10);
        panel.add(idSubjectField);
        
        panel.add(new JLabel("ID Student:"));
        JTextField idStudentField = new JTextField(10);
        panel.add(idStudentField);
        
        panel.add(new JLabel("ID Teacher:"));
        JTextField idTeacherField = new JTextField(10);
        panel.add(idTeacherField);
        
        panel.add(new JLabel("Time Start (HH:MM:SS):"));
        JTextField timeStartField = new JTextField(10);
        panel.add(timeStartField);
        
        panel.add(new JLabel("Time End (HH:MM:SS):"));
        JTextField timeEndField = new JTextField(10);
        panel.add(timeEndField);
        
        panel.add(new JLabel("Day:"));
        JTextField dayField = new JTextField(10);
        panel.add(dayField);
        
        int result = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Create Schedule",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            try {
                int idSubject = Integer.parseInt(idSubjectField.getText());
                int idStudent = Integer.parseInt(idStudentField.getText());
                int idTeacher = Integer.parseInt(idTeacherField.getText());
                String timeStart = timeStartField.getText();
                String timeEnd = timeEndField.getText();
                String day = dayField.getText();
                
                Schedule schedule = new Schedule();
                schedule.setIdSubject(idSubject);
                schedule.setIdStudent(idStudent);
                schedule.setIdTeacher(idTeacher);
                schedule.setTimeStart(Time.valueOf(timeStart));
                schedule.setTimeEnd(Time.valueOf(timeEnd));
                schedule.setDay(day);
                
                scheduleDAO.saveSchedule(schedule);
                
                JOptionPane.showMessageDialog(
                        this,
                        "Schedule created successfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid input. Please enter valid data.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void readSchedule() {
        String input = JOptionPane.showInputDialog(this, "Insert Id of a Schedule:");
        
        if (input != null && !input.isEmpty()) {
            try {
                int scheduleId = Integer.parseInt(input);
                Schedule schedule = scheduleDAO.getSchedule(scheduleId);

                if (schedule != null) {
                    JPanel panel = new JPanel();
                    panel.setLayout(new GridLayout(4, 1)); 

                    panel.add(new JLabel("ID: " + schedule.getId()));
                    panel.add(new JLabel("ID Subject: " + schedule.getIdSubject()));
                    panel.add(new JLabel("ID Student: " + schedule.getIdStudent()));
                    panel.add(new JLabel("ID Teacher: " + schedule.getIdTeacher()));
                    panel.add(new JLabel("Time Start: " + schedule.getTimeStart()));
                    panel.add(new JLabel("Time End: " + schedule.getTimeEnd()));
                    panel.add(new JLabel("Day: " + schedule.getDay()));

                    JOptionPane.showMessageDialog(
                            this,
                            panel,
                            "Details of a Schedule",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "No schedule was found with the provided ID.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Schedule ID must be an integer.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private void updateSchedule() {
        String input = JOptionPane.showInputDialog(this, "Insert ID of the Schedule to update:");

        if (input != null && !input.isEmpty()) {
            try {
                int scheduleId = Integer.parseInt(input);

                Schedule scheduleToUpdate = scheduleDAO.getSchedule(scheduleId);

                if (scheduleToUpdate != null) {
                    String newStartTimeInput = JOptionPane.showInputDialog(this, "Start Time (HH:MM:SS):");
                    String newEndTimeInput = JOptionPane.showInputDialog(this, "End Time (HH:MM:SS):");
                    String newDay = JOptionPane.showInputDialog(this, "Day:");

                    if (newStartTimeInput != null && !newStartTimeInput.isEmpty() &&
                        newEndTimeInput != null && !newEndTimeInput.isEmpty()) {
                        Time newStartTime = Time.valueOf(newStartTimeInput);
                        Time newEndTime = Time.valueOf(newEndTimeInput);

                        scheduleToUpdate.setTimeStart(newStartTime);
                        scheduleToUpdate.setTimeEnd(newEndTime);
                        scheduleToUpdate.setDay(newDay);

                        scheduleDAO.updateSchedule(scheduleToUpdate);

                        JOptionPane.showMessageDialog(
                                this,
                                "The Schedule has been successfully updated.",
                                "Success!",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(
                                this,
                                "Please enter valid new start and end times.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "No schedule found with ID: " + scheduleId,
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Schedule ID must be an integer.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private void deleteSchedule() {
        String input = JOptionPane.showInputDialog(this, "Insert ID of the Schedule to delete:");

        if (input != null && !input.isEmpty()) {
            try {
                int scheduleId = Integer.parseInt(input);

                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete Schedule with ID " + scheduleId + "?",
                        "Confirm Deletion",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    scheduleDAO.deleteSchedule(scheduleId);

                    JOptionPane.showMessageDialog(
                            this,
                            "The schedule has been successfully deleted.",
                            "Success!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Schedule ID must be an integer.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}

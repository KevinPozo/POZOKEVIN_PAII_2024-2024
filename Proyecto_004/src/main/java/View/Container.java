package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Container extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public Container() {
        setTitle("App Base de Datos MySQL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(900, 100, 400, 600);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.black);
        setContentPane(contentPane);
        
        // Utilizar un BoxLayout con orientación vertical
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        
        // Agregar espacio vertical
        contentPane.add(Box.createVerticalGlue());
        
        // Crear botones
        JButton btnStudent = new JButton("Student");
        JButton btnTeacher = new JButton("Teacher");
        JButton btnSchedule = new JButton("Schedule");
        JButton btnSubject = new JButton("Subject");
        
        // Alinear los botones al centro
        btnStudent.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnTeacher.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSchedule.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSubject.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Agregar acciones a los botones
        btnStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	StudentPanel studentWindow = new StudentPanel();
                studentWindow.setVisible(true);
                setVisible(false);
            }
        });
        
        btnTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Acción para el botón Teacher");
            }
        });
        
        btnSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Acción para el botón Schedule");
            }
        });
        
        btnSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Acción para el botón Subject");
            }
        });
        
        // Agregar botones al panel
        contentPane.add(btnStudent);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10))); 
        contentPane.add(btnTeacher);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10))); 
        contentPane.add(btnSchedule);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10))); 
        contentPane.add(btnSubject);
        
        // Agregar espacio vertical
        contentPane.add(Box.createVerticalGlue());
    }

}

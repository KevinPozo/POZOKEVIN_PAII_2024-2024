/**
 * @author KevinPozo
 * Title: Contenedores
 * 
 * 
 * */

package Deber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplicacionDibujo extends JFrame {
    private JButton botonTriangulo;
    private JButton botonCuadrado;
    private JButton botonCirculo;
    private PanelDibujo panelDibujo;

    public AplicacionDibujo() {
        setTitle("App Dibujo Java Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Creamos los botones
        botonTriangulo = new JButton("Triángulo");
        botonCuadrado = new JButton("Cuadrado");
        botonCirculo = new JButton("Círculo");

        // Creamos el panel de dibujo
        panelDibujo = new PanelDibujo();

        // Asignamos los action listeners a los botones
        botonTriangulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDibujo.establecerFigura(PanelDibujo.Figura.TRIANGULO);
            }
        });

        botonCuadrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDibujo.establecerFigura(PanelDibujo.Figura.CUADRADO);
            }
        });

        botonCirculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDibujo.establecerFigura(PanelDibujo.Figura.CIRCULO);
            }
        });

        // Creamos un panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonTriangulo);
        panelBotones.add(botonCuadrado);
        panelBotones.add(botonCirculo);

        // Configuramos el layout del JFrame
        setLayout(new BorderLayout());
        add(panelBotones, BorderLayout.NORTH);
        add(panelDibujo, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AplicacionDibujo().setVisible(true);
            }
        });
    }
}




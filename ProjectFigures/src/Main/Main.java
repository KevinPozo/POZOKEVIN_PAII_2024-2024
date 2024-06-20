/**
 *
 * @author KevinPozo
 * Title: Programación Funcional y Funciones de Orden Superior.
 *
 *
 * */
package Main;

import View.ShapePanel;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Figures (Lambda) ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        ShapePanel panel = new ShapePanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}

/**
 * @author KevinPozo
 * Title: Contenedores
 * 
 * 
 * */

package Deber;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Deber.PanelDibujo.Figura;

public class PanelDibujo extends JPanel {
    public enum Figura {
        TRIANGULO, CUADRADO, CIRCULO
    }

    private Figura figuraActual;

    public PanelDibujo() {
        figuraActual = null;
    }

    public void establecerFigura(Figura figura) {
        figuraActual = figura;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (figuraActual != null) {
            int width = getWidth();
            int height = getHeight();

            switch (figuraActual) {
                case TRIANGULO:
                    // Dibujamos un triángulo centrado
                	// Rellenamos con diferentes colores
                    g.setColor(Color.RED);
                    int[] xPoints = {width / 2 - 50, width / 2 + 50, width / 2};
                    int[] yPoints = {height / 2 + 50, height / 2 + 50, height / 2 - 50};
                    g.fillPolygon(xPoints, yPoints, 3);
                    break;
                case CUADRADO:
                    // Dibujamos un cuadrado centrado 
                	// Rellenamos con diferentes colores
                    g.setColor(Color.GREEN);
                    g.fillRect(width / 2 - 50, height / 2 - 50, 100, 100);
                    break;
                case CIRCULO:
                    // Dibujamos un círculo centrado 
                	// Rellenamos con diferentes colores
                    g.setColor(Color.BLUE);
                    g.fillOval(width / 2 - 50, height / 2 - 50, 100, 100);
                    break;
            }
        }
    }


}
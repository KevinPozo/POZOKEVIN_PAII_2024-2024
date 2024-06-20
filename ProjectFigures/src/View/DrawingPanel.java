/**
 *
 * @author KevinPozo
 * Title: Programación Funcional y Funciones de Orden Superior.
 *
 *
 * */
package View;

import Controller.GraphicsController;
import Model.ICircleForm;
import Model.ISquareForm;
import Model.ITriangleForm;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class DrawingPanel extends JPanel {
    private String shape = "";
    private ICircleForm circleForm;
    private ISquareForm squareForm;
    private ITriangleForm triangleForm;
    private GraphicsController graphicsController;

    public DrawingPanel(GraphicsController graphicsController) {
        this.graphicsController = graphicsController;
    }

    public void setShape(String shape) {
        this.shape = shape;
        repaint();
    }

    public void setCircleForm(ICircleForm circleForm) {
        this.circleForm = circleForm;
    }

    public void setSquareForm(ISquareForm squareForm) {
        this.squareForm = squareForm;
    }

    public void setTriangleForm(ITriangleForm triangleForm) {
        this.triangleForm = triangleForm;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        drawShape(g);
    }

    private void drawShape(Graphics g) {
        switch (shape) {
            case "Circle":
                if (circleForm != null) {
                    graphicsController.functionCircle(circleForm, g);
                }
                break;
            case "Triangle":
                if (triangleForm != null) {
                    graphicsController.functionTriangle(triangleForm, g);
                }
                break;
            case "Square":
                if (squareForm != null) {
                    graphicsController.functionSquare(squareForm, g);
                }
                break;
        }
    }
}

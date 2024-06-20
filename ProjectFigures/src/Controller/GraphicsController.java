/**
 *
 * @author KevinPozo
 * Title: Programación Funcional y Funciones de Orden Superior.
 *
 *
 * */
package Controller;

import Model.ICircleForm;
import Model.ISquareForm;
import Model.ITriangleForm;

import java.awt.*;

public class GraphicsController {
    public void functionSquare(ISquareForm square, Graphics g){
        square.drawSquare(g);
    }
    public void functionCircle(ICircleForm circle, Graphics g){
        circle.drawCircle(g);
    }
    public void functionTriangle(ITriangleForm triangle, Graphics g){
        triangle.drawTriangle(g);
    }
}

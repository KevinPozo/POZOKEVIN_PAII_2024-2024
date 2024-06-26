/**
 * 
 * @author KevinPozo
 * Title: Inversión de Dependencia y Responsabilidad Única.
 * 
 * 
 * */
package Game;

import java.awt.Color;
import java.awt.Graphics;

import Interfaces.IDrawable;

public class Line implements IDrawable {
    private int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE); 
        g.drawLine(x1, y1, x2, y2);
    }

}

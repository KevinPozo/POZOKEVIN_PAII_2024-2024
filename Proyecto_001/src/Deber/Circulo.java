/**
 * 
 * @author KevinPozo
 * Title: Contenedores
 * 
 * 
 * */
package Deber;

import javax.swing.JPanel;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Circulo {
	private GLAutoDrawable drawable;
	private boolean dibujarCirculo;

	// Constructor que acepta un GLAutoDrawable como argumento
	public Circulo(GLAutoDrawable drawable) {
		this.drawable = drawable;
		this.dibujarCirculo = false;
	}

	public void dibujarCirculo() {
		// Limpiamos el dibujo anterior
		limpiarDibujo(drawable);
		dibujarCirculo = true;
		// Volvemos a dibujar el panel
		drawable.display();
	}

	public void dibujar(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();

		if (dibujarCirculo) {
			// Lógica creación de un Circulo
			int numSegments = 100;
			gl.glBegin(GL2.GL_TRIANGLE_FAN);
			gl.glColor3f(0.0f, 1.0f, 0.0f);

			// Centro del círculo
			gl.glVertex2f(0.0f, 0.0f);

			// Calculamos los vértices del círculo
			for (int i = 0; i <= numSegments; i++) {
				double angle = 2.0 * Math.PI * i / numSegments;
				float x = (float) Math.cos(angle);
				float y = (float) Math.sin(angle);
				gl.glVertex2f(x, y);
			}

			gl.glEnd();
		}
	}

	public void limpiarDibujo(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();
		// Color del área de dibujo
		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
	}
}
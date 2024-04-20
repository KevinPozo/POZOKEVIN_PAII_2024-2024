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

public class Cuadrado {
	private GLAutoDrawable drawable;
	private boolean dibujarCuadrado;

	// Constructor que acepta un GLAutoDrawable como argumento
	public Cuadrado(GLAutoDrawable drawable) {
		this.drawable = drawable;
		this.dibujarCuadrado = false;
	}

	public void dibujarCuadrado() {
		// Limpiamos el dibujo anterior
		limpiarDibujo(drawable);
		dibujarCuadrado = true;
		// Volvemos a dibujar el panel
		drawable.display();
	}

	public void dibujar(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();

		if (dibujarCuadrado) {
			// Lógica creación de un cuadrado
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(0.0f, 0.0f, 1.0f);
			gl.glVertex2f(-0.5f, 0.5f);
			gl.glVertex2f(0.5f, 0.5f);
			gl.glVertex2f(0.5f, -0.5f);
			gl.glVertex2f(-0.5f, -0.5f);
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
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

public class Triangulo {
	private GLAutoDrawable drawable;
	private boolean dibujarTriangulo;

	// Constructor que acepta un GLAutoDrawable como argumento
	public Triangulo(GLAutoDrawable drawable) {
		this.drawable = drawable;
		this.dibujarTriangulo = false;
	}

	public void dibujarTriangulo() {
		// Limpiamos el dibujo anterior
		limpiarDibujo(drawable);
		dibujarTriangulo = true;
		// Dibujamos de nuevo el panel
		drawable.display();
	}

	public void dibujar(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();

		if (dibujarTriangulo) {
			// Lógica para dibujar un Triangulo

			gl.glBegin(GL2.GL_TRIANGLES);
			gl.glColor3f(1.0f, 0.0f, 0.0f);
			// Creamos los vertices
			gl.glVertex2f(0.0f, 0.8f);
			gl.glVertex2f(-0.8f, -0.8f);
			gl.glVertex2f(0.8f, -0.8f);
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

/**
 * 
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
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.*;

// Clase Main (JFrame):
public class Main extends JFrame {

	// Panel de dibuja de figura OpenGL
	private GLJPanel glPanel;
	// Instancia de las Clases: Triangulo, Cuadrado y Circulo
	private Triangulo triangulo;
	private Cuadrado cuadrado;
	private Circulo circulo;

	public Main() {
		// Nombre de la ventana
		setTitle("Dibujando figuras con JOGL");
		// Tamaño ventana
		setSize(600, 400);
		// Cerrar Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creamos el panel de dibujo OpenGL
		glPanel = new GLJPanel();
		glPanel.addGLEventListener(new GLEventListener() {
			@Override
			public void init(GLAutoDrawable drawable) {
			}

			@Override
			public void dispose(GLAutoDrawable drawable) {
			}

			@Override
			public void display(GLAutoDrawable drawable) {
				// Dibujamos las figuras
				GL2 gl = drawable.getGL().getGL2();
				gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
				gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

				if (triangulo != null) {
					triangulo.dibujar(drawable);
				}
				if (cuadrado != null) {
					cuadrado.dibujar(drawable);
				}
				if (circulo != null) {
					circulo.dibujar(drawable);
				}
			}

			@Override
			public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
			}
		});
		// Centramos el panel
		getContentPane().add(glPanel, BorderLayout.CENTER);

		// Creamos panel para los botones
		JPanel buttonPanel = new JPanel(new FlowLayout());
		// Posición del panel
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		// Creamos botón para dibujar un triángulo
		JButton triangleButton = new JButton("Triángulo");
		triangleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Verificamos si el objeto triangulo es nulo
				if (triangulo == null) {
					// Si es nulo, creamos una nueva instancia
					triangulo = new Triangulo(glPanel);
				}
				// Dibujamos el triángulo y actualizamos el panel
				triangulo.dibujarTriangulo();
				glPanel.repaint();
			}
		});
		// Agregamos el botón al panel
		buttonPanel.add(triangleButton);

		// Creamos botón para dibujar un cuadrado
		JButton squareButton = new JButton("Cuadrado");
		squareButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Verificamos si el objeto cuadrado es nulo
				if (cuadrado == null) {
					// Si es nulo, creamos una nueva instancia
					cuadrado = new Cuadrado(glPanel);
				}
				// Dibujar el cuadrado y actualizamos el panel
				cuadrado.dibujarCuadrado();
				glPanel.repaint();
			}
		});
		// Agregamos el botón al panel
		buttonPanel.add(squareButton);

		// Creamos botón para dibujar un círculo
		JButton circleButton = new JButton("Círculo");
		circleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Verificamos si el objeto circulo es nulo
				if (circulo == null) {
					// Si es nulo, creamos una nueva instancia
					circulo = new Circulo(glPanel);
				}
				// Dibujamos el círculo y actualizamos el panel
				circulo.dibujarCirculo();
				glPanel.repaint();
			}
		});
		// Agregamos el botón al panel
		buttonPanel.add(circleButton);

		// Creamos botón para borrar la figura actual
		JButton clearButton = new JButton("Borrar Figura");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Borramos la figura actual
				triangulo = null;
				cuadrado = null;
				circulo = null;

				// Actualizamos el panel
				glPanel.repaint();
			}
		});
		// Agregamos el botón al panel
		buttonPanel.add(clearButton);

		// Mostramos la Ventana
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}
}

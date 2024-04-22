/**
 * 
 * @author KevinPozo
 * Title: Inversion de Dependencia
 * 
 * 
 * */
package Figuras;

import InterfaceDibujo.InterfaceDibujo;

public class Figura {
	// Inversion de Dependencia
	// Creamos una clase donde se va a crear la figura
	// perteneciente a su clase que implemente la interface
	// "InterfaceDibujo"
public Figura(InterfaceDibujo ie) {
	ie.dibujar();
}
}

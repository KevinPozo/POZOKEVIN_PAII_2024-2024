/**
 * 
 * @author KevinPozo
 * Title: Inversion de Dependencia
 * 
 * 
 * */
package Figuras;

import InterfaceDibujo.InterfaceDibujo;

public class Triangulo implements InterfaceDibujo{
	// Creamos un Triangulo:
	@Override
	public void dibujar() {
		System.out.println("Dibujando un Triangulo...");
	}

}

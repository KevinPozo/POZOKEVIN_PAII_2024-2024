/**
 * 
 * @author KevinPozo
 * Title: Inversion de Dependencia
 * 
 * 
 * */
package Figuras;

import InterfaceDibujo.InterfaceDibujo;

public class Cuadrado implements InterfaceDibujo{
	// Creamos un cuadrado:
	@Override
	public void dibujar() {
		System.out.println("Dibujando un Cuadrado...");
	}

}

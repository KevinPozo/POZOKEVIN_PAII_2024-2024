/**
 * 
 * @author KevinPozo
 * Title: Inversion de Dependencia
 * 
 * 
 * */
package Figuras;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Creamos las figuras:
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese una opción: ");
		System.out.println("Crear: \n1)Triangulo \n2)Cuadrado \n3)Circulo");
		System.out.print(">> opcion: ");
		int opcion = entrada.nextInt();
		if(opcion==1) {
			Figura fig1 = new Figura(new Triangulo());
		}else if(opcion==2) {
			Figura fig2 = new Figura(new Cuadrado());
		}else if(opcion==3){
			Figura fig3 = new Figura(new Circulo());
		}else {
			System.out.println("Opcion incorrecta");
		}
		
	}

}

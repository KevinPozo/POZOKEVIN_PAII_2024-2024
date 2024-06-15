/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB;

import ec.edu.uce.ProyectoRelacionesDDBB.Controller.ManyToMany.ManyToManyExample;
import ec.edu.uce.ProyectoRelacionesDDBB.Controller.ManyToOne.ManyToOneExample;
import ec.edu.uce.ProyectoRelacionesDDBB.Controller.OneToMany.OneToManyExample;
import ec.edu.uce.ProyectoRelacionesDDBB.Controller.OneToOne.OneToOneExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ProyectoRelacionesDdbbApplication implements CommandLineRunner {
	@Autowired
	private OneToOneExample oneToOneExample;
	@Autowired
	private OneToManyExample oneToManyExample;
	@Autowired
	private ManyToOneExample manyToOneExample;
	@Autowired
	private ManyToManyExample manyToManyExample;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoRelacionesDdbbApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Choose an example to run:");
			System.out.println("1. OneToOne Example");
			System.out.println("2. OneToMany Example");
			System.out.println("3. ManyToOne Example");
			System.out.println("4. ManyToMany Example");
			System.out.println("5. Exit!");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
				case 1:
					oneToOneExample.runExample();
					break;
				case 2:
					oneToManyExample.runExample();
					break;
				case 3:
					manyToOneExample.runExample();
					break;
				case 4:
					manyToManyExample.runExample();
					break;
				default:
					System.exit(0);
					break;
			}
		}
	}
}

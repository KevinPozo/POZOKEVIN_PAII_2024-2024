/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Controller.ManyToMany;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.HealthcareProvider;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Specialty;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Service.HealthcareProviderService;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ManyToManyExample {

    private final HealthcareProviderService healthcareProviderService;
    private final SpecialtyService specialtyService;
    private final Scanner scanner;

    @Autowired
    public ManyToManyExample(HealthcareProviderService healthcareProviderService, SpecialtyService specialtyService) {
        this.healthcareProviderService = healthcareProviderService;
        this.specialtyService = specialtyService;
        this.scanner = new Scanner(System.in);
    }

    public void runExample() {
        while (true) {
            printMenu();

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createHealthcareProvider();
                    break;
                case 2:
                    listAllHealthcareProviders();
                    break;
                case 3:
                    getHealthcareProviderById();
                    break;
                case 4:
                    updateHealthcareProvider();
                    break;
                case 5:
                    deleteHealthcareProvider();
                    break;
                case 6:
                    createSpecialty();
                    break;
                case 7:
                    listAllSpecialties();
                    break;
                case 8:
                    getSpecialtyById();
                    break;
                case 9:
                    updateSpecialty();
                    break;
                case 10:
                    deleteSpecialty();
                    break;
                case 11:
                    assignSpecialtyToProvider();
                    break;
                case 12:
                    listProvidersBySpecialty(); // Nuevo caso para listar por especialidad
                    break;
                case 13:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 13.");
            }
        }
    }

    private void printMenu() {
        System.out.println("ManyToMany Example - Choose an operation:");
        System.out.println("1. Create Healthcare Provider");
        System.out.println("2. List All Healthcare Providers");
        System.out.println("3. Get Healthcare Provider by ID");
        System.out.println("4. Update Healthcare Provider");
        System.out.println("5. Delete Healthcare Provider");
        System.out.println("6. Create Specialty");
        System.out.println("7. List All Specialties");
        System.out.println("8. Get Specialty by ID");
        System.out.println("9. Update Specialty");
        System.out.println("10. Delete Specialty");
        System.out.println("11. Assign Specialty to Healthcare Provider");
        System.out.println("12. List Healthcare Providers by Specialty");
        System.out.println("13. Back to Main Menu");
    }

    private void listProvidersBySpecialty() {
        listAllSpecialties();
        System.out.println("Enter Specialty ID to list Healthcare Providers:");
        Long specialtyId = Long.parseLong(scanner.nextLine());

        Specialty specialty = specialtyService.getSpecialtyById(specialtyId);
        if (specialty == null) {
            System.out.println("Specialty with ID " + specialtyId + " not found.");
            return;
        }

        List<HealthcareProvider> healthcareProviders = healthcareProviderService.getHealthcareProvidersBySpecialty(specialty);
        if (healthcareProviders.isEmpty()) {
            System.out.println("No Healthcare Providers found for Specialty: " + specialty.getName());
        } else {
            System.out.println("Healthcare Providers for Specialty: " + specialty.getName());
            healthcareProviders.forEach(System.out::println);
        }
    }

    private void createHealthcareProvider() {
        System.out.println("Enter Healthcare Provider Name:");
        String name = scanner.nextLine();

        HealthcareProvider healthcareProvider = new HealthcareProvider(null, name);
        healthcareProviderService.createHealthcareProvider(healthcareProvider);
        System.out.println("Healthcare Provider created successfully!");
    }

    private void listAllHealthcareProviders() {
        List<HealthcareProvider> healthcareProviders = healthcareProviderService.getAllHealthcareProviders();
        healthcareProviders.forEach(System.out::println);
    }

    private void getHealthcareProviderById() {
        System.out.println("Enter Healthcare Provider ID:");
        Long id = Long.parseLong(scanner.nextLine());
        HealthcareProvider healthcareProvider = healthcareProviderService.getHealthcareProviderById(id);
        if (healthcareProvider != null) {
            System.out.println(healthcareProvider);
        } else {
            System.out.println("Healthcare Provider with ID " + id + " not found.");
        }
    }

    private void updateHealthcareProvider() {
        System.out.println("Enter Healthcare Provider ID:");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println("Enter Healthcare Provider Name:");
        String name = scanner.nextLine();

        HealthcareProvider healthcareProvider = new HealthcareProvider(id, name);
        healthcareProviderService.updateHealthcareProvider(healthcareProvider);
        System.out.println("Healthcare Provider updated successfully!");
    }

    private void deleteHealthcareProvider() {
        System.out.println("Enter Healthcare Provider ID:");
        Long id = Long.parseLong(scanner.nextLine());
        healthcareProviderService.deleteHealthcareProvider(id);
        System.out.println("Healthcare Provider deleted successfully!");
    }

    private void createSpecialty() {
        System.out.println("Enter Specialty Name:");
        String name = scanner.nextLine();

        Specialty specialty = new Specialty(null, name);
        specialtyService.createSpecialty(specialty);
        System.out.println("Specialty created successfully!");
    }

    private void listAllSpecialties() {
        List<Specialty> specialties = specialtyService.getAllSpecialties();
        specialties.forEach(System.out::println);
    }

    private void getSpecialtyById() {
        System.out.println("Enter Specialty ID:");
        Long id = Long.parseLong(scanner.nextLine());
        Specialty specialty = specialtyService.getSpecialtyById(id);
        if (specialty != null) {
            System.out.println(specialty);
        } else {
            System.out.println("Specialty with ID " + id + " not found.");
        }
    }

    private void updateSpecialty() {
        System.out.println("Enter Specialty ID:");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println("Enter Specialty Name:");
        String name = scanner.nextLine();

        Specialty specialty = new Specialty(id, name);
        specialtyService.updateSpecialty(specialty);
        System.out.println("Specialty updated successfully!");
    }

    private void deleteSpecialty() {
        System.out.println("Enter Specialty ID:");
        Long id = Long.parseLong(scanner.nextLine());
        specialtyService.deleteSpecialty(id);
        System.out.println("Specialty deleted successfully!");
    }

    private void assignSpecialtyToProvider() {
        listAllHealthcareProviders();
        System.out.println("Enter Healthcare Provider ID to assign Specialty:");
        Long providerId = Long.parseLong(scanner.nextLine());

        listAllSpecialties();
        System.out.println("Enter Specialty ID to assign to Healthcare Provider:");
        Long specialtyId = Long.parseLong(scanner.nextLine());

        Specialty specialty = specialtyService.getSpecialtyById(specialtyId);
        HealthcareProvider healthcareProvider = healthcareProviderService.getHealthcareProviderById(providerId);

        if (specialty == null) {
            System.out.println("Specialty with ID " + specialtyId + " not found.");
            return;
        }

        if (healthcareProvider == null) {
            System.out.println("Healthcare Provider with ID " + providerId + " not found.");
            return;
        }

        healthcareProvider.getSpecialties().add(specialty);
        healthcareProviderService.updateHealthcareProvider(healthcareProvider);
        System.out.println("Specialty assigned to Healthcare Provider successfully!");
    }
}

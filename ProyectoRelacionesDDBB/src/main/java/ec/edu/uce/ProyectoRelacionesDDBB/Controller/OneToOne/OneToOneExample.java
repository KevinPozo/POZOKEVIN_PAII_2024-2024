/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Controller.OneToOne;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Doctor;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Office;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Service.DoctorService;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class OneToOneExample {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private OfficeService officeService;

    public void runExample() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("OneToOne Example - Choose an operation:");
            System.out.println("1. Create Doctor");
            System.out.println("2. List All Doctors");
            System.out.println("3. Get Doctor by ID");
            System.out.println("4. Update Doctor");
            System.out.println("5. Delete Doctor");
            System.out.println("6. Create Office");
            System.out.println("7. List All Offices");
            System.out.println("8. Get Office by ID");
            System.out.println("9. Update Office");
            System.out.println("10. Delete Office");
            System.out.println("11. Back to Main Menu");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createDoctor(scanner);
                    break;
                case 2:
                    listAllDoctors();
                    break;
                case 3:
                    getDoctorById(scanner);
                    break;
                case 4:
                    updateDoctor(scanner);
                    break;
                case 5:
                    deleteDoctor(scanner);
                    break;
                case 6:
                    createOffice(scanner);
                    break;
                case 7:
                    listAllOffices();
                    break;
                case 8:
                    getOfficeById(scanner);
                    break;
                case 9:
                    updateOffice(scanner);
                    break;
                case 10:
                    deleteOffice(scanner);
                    break;
                case 11:
                    return;
            }
        }
    }

    private void createDoctor(Scanner scanner) {
        System.out.println("Enter Doctor Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Doctor Specialty:");
        String specialty = scanner.nextLine();

        listAllOffices();

        System.out.println("Enter Office ID or enter 0 to skip:");
        Long officeId = Long.parseLong(scanner.nextLine());

        Office office = null;
        if (officeId != 0) {
            office = officeService.getOfficeById(officeId);
            if (office == null) {
                System.out.println("Office with ID " + officeId + " not found. Skipping office association.");
            }
        }

        Doctor doctor = new Doctor(null, name, specialty, office);
        doctorService.createDoctor(doctor);
        System.out.println("Doctor created successfully!");
    }


    private void listAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        doctors.forEach(System.out::println);
    }

    private void getDoctorById(Scanner scanner) {
        System.out.println("Enter Doctor ID:");
        Long id = Long.parseLong(scanner.nextLine());
        Doctor doctor = doctorService.getDoctorById(id);
        System.out.println(doctor);
    }

    private void updateDoctor(Scanner scanner) {
        System.out.println("Enter Doctor ID:");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println("Enter Doctor Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Doctor Specialty:");
        String specialty = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, specialty, null);
        doctorService.updateDoctor(doctor);
        System.out.println("Doctor updated successfully!");
    }

    private void deleteDoctor(Scanner scanner) {
        System.out.println("Enter Doctor ID:");
        Long id = Long.parseLong(scanner.nextLine());
        doctorService.deleteDoctor(id);
        System.out.println("Doctor deleted successfully!");
    }

    private void createOffice(Scanner scanner) {
        System.out.println("Enter Room Number:");
        String roomNumber = scanner.nextLine();
        System.out.println("Enter Building:");
        String building = scanner.nextLine();

        listAllDoctors();

        System.out.println("Enter Doctor ID or enter 0 to skip:");
        Long doctorId = Long.parseLong(scanner.nextLine());

        Doctor doctor = null;
        if (doctorId != 0) {
            doctor = doctorService.getDoctorById(doctorId);
            if (doctor == null) {
                System.out.println("Doctor with ID " + doctorId + " not found. Skipping doctor association.");
            }
        }

        Office office = new Office(null, roomNumber, building, doctor);
        officeService.createOffice(office);
        System.out.println("Office created successfully!");
    }


    private void listAllOffices() {
        List<Office> offices = officeService.getAllOffices();
        offices.forEach(System.out::println);
    }

    private void getOfficeById(Scanner scanner) {
        System.out.println("Enter Office ID:");
        Long id = Long.parseLong(scanner.nextLine());
        Office office = officeService.getOfficeById(id);
        System.out.println(office);
    }

    private void updateOffice(Scanner scanner) {
        System.out.println("Enter Office ID:");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println("Enter Room Number:");
        String roomNumber = scanner.nextLine();
        System.out.println("Enter Building:");
        String building = scanner.nextLine();

        Office office = new Office(id, roomNumber, building, null);
        officeService.updateOffice(office);
        System.out.println("Office updated successfully!");
    }

    private void deleteOffice(Scanner scanner) {
        System.out.println("Enter Office ID:");
        Long id = Long.parseLong(scanner.nextLine());
        officeService.deleteOffice(id);
        System.out.println("Office deleted successfully!");
    }
}

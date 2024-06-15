/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Controller.OneToMany;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToMany.Hospital;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToMany.Patient;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToMany.Service.HospitalService;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToMany.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class OneToManyExample {

    private final HospitalService hospitalService;
    private final PatientService patientService;
    private final Scanner scanner;

    @Autowired
    public OneToManyExample(HospitalService hospitalService, PatientService patientService) {
        this.hospitalService = hospitalService;
        this.patientService = patientService;
        this.scanner = new Scanner(System.in);
    }

    public void runExample() {
        while (true) {
            printMenu();

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createHospital();
                    break;
                case 2:
                    listAllHospitals();
                    break;
                case 3:
                    getHospitalById();
                    break;
                case 4:
                    updateHospital();
                    break;
                case 5:
                    deleteHospital();
                    break;
                case 6:
                    createPatient();
                    break;
                case 7:
                    listAllPatients();
                    break;
                case 8:
                    getPatientById();
                    break;
                case 9:
                    updatePatient();
                    break;
                case 10:
                    deletePatient();
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 11.");
            }
        }
    }

    private void printMenu() {
        System.out.println("OneToMany Example - Choose an operation:");
        System.out.println("1. Create Hospital");
        System.out.println("2. List All Hospitals");
        System.out.println("3. Get Hospital by ID");
        System.out.println("4. Update Hospital");
        System.out.println("5. Delete Hospital");
        System.out.println("6. Create Patient");
        System.out.println("7. List All Patients");
        System.out.println("8. Get Patient by ID");
        System.out.println("9. Update Patient");
        System.out.println("10. Delete Patient");
        System.out.println("11. Back to Main Menu");
    }

    private void createHospital() {
        System.out.println("Enter Hospital Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Hospital Localization:");
        String localization = scanner.nextLine();

        Hospital hospital = new Hospital(null,name, localization);
        hospitalService.createHospital(hospital);
        System.out.println("Hospital created successfully!");
    }

    private void listAllHospitals() {
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        hospitals.forEach(hospital -> {
            System.out.println(hospital);
            if (!hospital.getPatients().isEmpty()) {
                System.out.println("Patients:");
                hospital.getPatients().forEach(System.out::println);
            } else {
                System.out.println("No patients in this hospital.");
            }
            System.out.println();
        });
    }

    private void getHospitalById() {
        System.out.println("Enter Hospital ID:");
        Long id = Long.parseLong(scanner.nextLine());
        Hospital hospital = hospitalService.getHospitalById(id);
        if (hospital != null) {
            System.out.println(hospital);
        } else {
            System.out.println("Hospital with ID " + id + " not found.");
        }
    }

    private void updateHospital() {
        System.out.println("Enter Hospital ID:");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println("Enter Hospital Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Hospital Localization:");
        String localization = scanner.nextLine();

        Hospital hospital = new Hospital(id, name, localization);
        hospitalService.updateHospital(hospital);
        System.out.println("Hospital updated successfully!");
    }

    private void deleteHospital() {
        System.out.println("Enter Hospital ID:");
        Long id = Long.parseLong(scanner.nextLine());
        hospitalService.deleteHospital(id);
        System.out.println("Hospital deleted successfully!");
    }

    private void createPatient() {
        System.out.println("Enter Patient Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Patient Age:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Patient Status:");
        String status = scanner.nextLine();

        listAllHospitals();

        System.out.println("Enter Hospital ID:");
        Long hospitalId = Long.parseLong(scanner.nextLine());

        Hospital hospital = hospitalService.getHospitalById(hospitalId);
        if (hospital == null) {
            System.out.println("Hospital with ID " + hospitalId + " not found. Patient creation aborted.");
            return;
        }

        Patient patient = new Patient(null,name, age, status);
        patient.setHospital(hospital);
        patientService.createPatient(patient);
        System.out.println("Patient created successfully!");
    }

    private void listAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        patients.forEach(System.out::println);
    }

    private void getPatientById() {
        System.out.println("Enter Patient ID:");
        Long id = Long.parseLong(scanner.nextLine());
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            System.out.println(patient);
        } else {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }

    private void updatePatient() {
        System.out.println("Enter Patient ID:");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println("Enter Patient Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Patient Age:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Patient Status:");
        String status = scanner.nextLine();

        Patient patient = new Patient(id, name, age, status);
        patientService.updatePatient(patient);
        System.out.println("Patient updated successfully!");
    }

    private void deletePatient() {
        System.out.println("Enter Patient ID:");
        Long id = Long.parseLong(scanner.nextLine());
        patientService.deletePatient(id);
        System.out.println("Patient deleted successfully!");
    }
}

/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Controller.ManyToOne;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne.MedicalRecord;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne.Person;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne.Service.MedicalRecordService;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ManyToOneExample {

    private final PersonService personService;
    private final MedicalRecordService medicalRecordService;
    private final Scanner scanner;

    @Autowired
    public ManyToOneExample(PersonService personService, MedicalRecordService medicalRecordService) {
        this.personService = personService;
        this.medicalRecordService = medicalRecordService;
        this.scanner = new Scanner(System.in);
    }

    public void runExample() {
        while (true) {
            printMenu();

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createPerson();
                    break;
                case 2:
                    listAllPersons();
                    break;
                case 3:
                    getPersonById();
                    break;
                case 4:
                    updatePerson();
                    break;
                case 5:
                    deletePerson();
                    break;
                case 6:
                    createMedicalRecord();
                    break;
                case 7:
                    listAllMedicalRecords();
                    break;
                case 8:
                    getMedicalRecordById();
                    break;
                case 9:
                    updateMedicalRecord();
                    break;
                case 10:
                    deleteMedicalRecord();
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 11.");
            }
        }
    }

    private void printMenu() {
        System.out.println("ManyToOne Example - Choose an operation:");
        System.out.println("1. Create Person");
        System.out.println("2. List All Persons");
        System.out.println("3. Get Person by ID");
        System.out.println("4. Update Person");
        System.out.println("5. Delete Person");
        System.out.println("6. Create Medical Record");
        System.out.println("7. List All Medical Records");
        System.out.println("8. Get Medical Record by ID");
        System.out.println("9. Update Medical Record");
        System.out.println("10. Delete Medical Record");
        System.out.println("11. Back to Main Menu");
    }

    private void createPerson() {
        System.out.println("Enter Person Name:");
        String name = scanner.nextLine();

        Person person = new Person(null, name);
        personService.createPerson(person);
        System.out.println("Person created successfully!");
    }

    private void listAllPersons() {
        List<Person> persons = personService.getAllPersons();
        persons.forEach(System.out::println);
    }

    private void getPersonById() {
        System.out.println("Enter Person ID:");
        Long id = Long.parseLong(scanner.nextLine());
        Person person = personService.getPersonById(id);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Person with ID " + id + " not found.");
        }
    }

    private void updatePerson() {
        System.out.println("Enter Person ID:");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println("Enter Person Name:");
        String name = scanner.nextLine();

        Person person = new Person(id, name);
        personService.updatePerson(person);
        System.out.println("Person updated successfully!");
    }

    private void deletePerson() {
        System.out.println("Enter Person ID:");
        Long id = Long.parseLong(scanner.nextLine());
        personService.deletePerson(id);
        System.out.println("Person deleted successfully!");
    }

    private void createMedicalRecord() {
        System.out.println("Enter Medical Record Description:");
        String description = scanner.nextLine();

        listAllPersons();

        System.out.println("Enter Person ID for Medical Record:");
        Long personId = Long.parseLong(scanner.nextLine());

        Person person = personService.getPersonById(personId);
        if (person == null) {
            System.out.println("Person with ID " + personId + " not found. Medical Record creation aborted.");
            return;
        }

        MedicalRecord medicalRecord = new MedicalRecord(null, description, person);
        medicalRecordService.createMedicalRecord(medicalRecord);
        System.out.println("Medical Record created successfully!");
    }

    private void listAllMedicalRecords() {
        List<MedicalRecord> medicalRecords = medicalRecordService.getAllMedicalRecords();
        medicalRecords.forEach(System.out::println);
    }

    private void getMedicalRecordById() {
        System.out.println("Enter Medical Record ID:");
        Long id = Long.parseLong(scanner.nextLine());
        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecordById(id);
        if (medicalRecord != null) {
            System.out.println(medicalRecord);
        } else {
            System.out.println("Medical Record with ID " + id + " not found.");
        }
    }

    private void updateMedicalRecord() {
        System.out.println("Enter Medical Record ID:");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println("Enter Medical Record Description:");
        String description = scanner.nextLine();

        MedicalRecord medicalRecord = new MedicalRecord(id, description, null);
        medicalRecordService.updateMedicalRecord(medicalRecord);
        System.out.println("Medical Record updated successfully!");
    }

    private void deleteMedicalRecord() {
        System.out.println("Enter Medical Record ID:");
        Long id = Long.parseLong(scanner.nextLine());
        medicalRecordService.deleteMedicalRecord(id);
        System.out.println("Medical Record deleted successfully!");
    }
}

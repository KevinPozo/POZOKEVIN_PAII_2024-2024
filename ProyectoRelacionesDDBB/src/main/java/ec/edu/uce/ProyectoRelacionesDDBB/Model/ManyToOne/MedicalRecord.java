/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @ManyToOne
    private Person person;


    public MedicalRecord() {
    }

    public MedicalRecord(Long id, String description, Person person) {
        this.id = id;
        this.description = description;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", person=" + (person != null ? person.getName() : null) +
                '}';
    }
}

/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "specialties")
    private Set<HealthcareProvider> healthcareProviders;

    public Specialty() {
    }

    public Specialty(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<HealthcareProvider> getHealthcareProviders() {
        return healthcareProviders;
    }

    public void setHealthcareProviders(Set<HealthcareProvider> healthcareProviders) {
        this.healthcareProviders = healthcareProviders;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

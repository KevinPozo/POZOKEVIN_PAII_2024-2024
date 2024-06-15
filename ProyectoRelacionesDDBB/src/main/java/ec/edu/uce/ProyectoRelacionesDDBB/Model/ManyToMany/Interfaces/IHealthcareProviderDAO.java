/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Interfaces;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.HealthcareProvider;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Specialty;

import java.util.List;

public interface IHealthcareProviderDAO {
    List<HealthcareProvider> getAllHealthcareProviders();
    HealthcareProvider createHealthcareProvider(HealthcareProvider healthcareProvider);
    HealthcareProvider updateHealthcareProvider(HealthcareProvider healthcareProvider);
    HealthcareProvider getHealthcareProviderById(Long id);
    void deleteHealthcareProvider(Long id);
    List<HealthcareProvider> getHealthcareProvidersBySpecialty(Specialty specialty);
}

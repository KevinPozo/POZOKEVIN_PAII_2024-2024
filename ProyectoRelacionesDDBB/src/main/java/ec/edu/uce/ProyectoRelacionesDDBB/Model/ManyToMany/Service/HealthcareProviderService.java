/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Service;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.HealthcareProvider;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Interfaces.IHealthcareProviderDAO;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HealthcareProviderService {

    private final IHealthcareProviderDAO healthcareProviderDAO;

    @Autowired
    public HealthcareProviderService(IHealthcareProviderDAO healthcareProviderDAO) {
        this.healthcareProviderDAO = healthcareProviderDAO;
    }

    public List<HealthcareProvider> getAllHealthcareProviders() {
        return healthcareProviderDAO.getAllHealthcareProviders();
    }

    public HealthcareProvider createHealthcareProvider(HealthcareProvider healthcareProvider) {
        return healthcareProviderDAO.createHealthcareProvider(healthcareProvider);
    }

    public HealthcareProvider updateHealthcareProvider(HealthcareProvider healthcareProvider) {
        return healthcareProviderDAO.updateHealthcareProvider(healthcareProvider);
    }

    public HealthcareProvider getHealthcareProviderById(Long id) {
        return healthcareProviderDAO.getHealthcareProviderById(id);
    }

    public void deleteHealthcareProvider(Long id) {
        healthcareProviderDAO.deleteHealthcareProvider(id);
    }

    public List<HealthcareProvider> getHealthcareProvidersBySpecialty(Specialty specialty) {
        return healthcareProviderDAO.getHealthcareProvidersBySpecialty(specialty);
    }
}

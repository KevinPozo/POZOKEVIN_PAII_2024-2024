/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Repository;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.HealthcareProvider;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Interfaces.IHealthcareProviderDAO;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Specialty;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class HealthcareProviderDAO implements IHealthcareProviderDAO {

    private final EntityManager entityManager;

    @Autowired
    public HealthcareProviderDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<HealthcareProvider> getAllHealthcareProviders() {
        TypedQuery<HealthcareProvider> query = entityManager.createQuery("SELECT hp FROM HealthcareProvider hp", HealthcareProvider.class);
        return query.getResultList();
    }

    @Override
    public HealthcareProvider createHealthcareProvider(HealthcareProvider healthcareProvider) {
        entityManager.persist(healthcareProvider);
        return healthcareProvider;
    }

    @Override
    public HealthcareProvider updateHealthcareProvider(HealthcareProvider healthcareProvider) {
        return entityManager.merge(healthcareProvider);
    }

    @Override
    public HealthcareProvider getHealthcareProviderById(Long id) {
        return entityManager.find(HealthcareProvider.class, id);
    }

    @Override
    public void deleteHealthcareProvider(Long id) {
        HealthcareProvider healthcareProvider = getHealthcareProviderById(id);
        if (healthcareProvider != null) {
            entityManager.remove(healthcareProvider);
        }
    }

    @Override
    public List<HealthcareProvider> getHealthcareProvidersBySpecialty(Specialty specialty) {
        TypedQuery<HealthcareProvider> query = entityManager.createQuery(
                "SELECT hp FROM HealthcareProvider hp JOIN hp.specialties s WHERE s = :specialty", HealthcareProvider.class);
        query.setParameter("specialty", specialty);
        return query.getResultList();
    }
}

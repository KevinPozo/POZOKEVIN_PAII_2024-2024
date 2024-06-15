/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Repository;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.HealthcareProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthcareProviderRepository extends JpaRepository<HealthcareProvider,Long> {
}

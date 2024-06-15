/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Repository;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Interfaces.ISpecialtyDAO;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecialtyDAO implements ISpecialtyDAO {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Override
    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty getSpecialtyById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty createSpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public Specialty updateSpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void deleteSpecialty(Long id) {
        specialtyRepository.deleteById(id);
    }
}

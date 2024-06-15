/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Service;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Interfaces.ISpecialtyDAO;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpecialtyService {

    private final ISpecialtyDAO specialtyDAO;

    @Autowired
    public SpecialtyService(ISpecialtyDAO specialtyDAO) {
        this.specialtyDAO = specialtyDAO;
    }

    public List<Specialty> getAllSpecialties() {
        return specialtyDAO.getAllSpecialties();
    }

    public Specialty createSpecialty(Specialty specialty) {
        return specialtyDAO.createSpecialty(specialty);
    }

    public Specialty updateSpecialty(Specialty specialty) {
        return specialtyDAO.updateSpecialty(specialty);
    }

    public Specialty getSpecialtyById(Long id) {
        return specialtyDAO.getSpecialtyById(id);
    }

    public void deleteSpecialty(Long id) {
        specialtyDAO.deleteSpecialty(id);
    }
}

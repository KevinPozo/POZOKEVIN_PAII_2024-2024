/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Interfaces;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToMany.Specialty;

import java.util.List;

public interface ISpecialtyDAO {
    Specialty createSpecialty(Specialty specialty);
    Specialty updateSpecialty(Specialty specialty);
    void deleteSpecialty(Long id);
    Specialty getSpecialtyById(Long id);
    List<Specialty> getAllSpecialties();
}

/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToMany.Interfaces;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToMany.Hospital;

import java.util.List;

public interface IHospitalDAO {
    List<Hospital> getAllHospitals();
    Hospital getHospitalById(Long id);
    Hospital saveHospital(Hospital hospital);
    Hospital updateHospital(Hospital hospital);
    void deleteHospital(Long id);
}

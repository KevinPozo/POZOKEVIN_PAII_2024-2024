/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToMany.Repository;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToMany.Hospital;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToMany.Interfaces.IHospitalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HospitalDAO implements IHospitalDAO {
    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital getHospitalById(Long id) {
        return hospitalRepository.findById(id).orElse(null);
    }

    @Override
    public Hospital saveHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public Hospital updateHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public void deleteHospital(Long id) {
        hospitalRepository.deleteById(id);
    }
}

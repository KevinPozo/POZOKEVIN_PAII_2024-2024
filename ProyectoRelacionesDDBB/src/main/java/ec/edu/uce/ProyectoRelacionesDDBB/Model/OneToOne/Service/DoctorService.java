/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Service;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Doctor;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Repository.DoctorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService {
    @Autowired
    private DoctorDAO doctorDAO;

    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorDAO.saveDoctor(doctor);
    }

    public Doctor updateDoctor(Doctor doctor) {
        return doctorDAO.updateDoctor(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return doctorDAO.getDoctorById(id);
    }

    public void deleteDoctor(Long id) {
        doctorDAO.deleteDoctor(id);
    }
}

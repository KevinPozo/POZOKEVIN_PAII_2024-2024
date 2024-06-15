/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Interfaces;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Doctor;

import java.util.List;

public interface IDoctorDAO {
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Long id);
    Doctor saveDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor);
    void deleteDoctor(Long id);
}

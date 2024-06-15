/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToMany.Interfaces;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToMany.Patient;

import java.util.List;

public interface IPatientDAO {
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient savePatient(Patient patient);
    Patient updatePatient(Patient patient);
    void deletePatient(Long id);
}

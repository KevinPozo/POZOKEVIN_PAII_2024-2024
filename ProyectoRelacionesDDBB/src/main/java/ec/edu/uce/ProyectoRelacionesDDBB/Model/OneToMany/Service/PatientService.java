/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToMany.Service;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToMany.Patient;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToMany.Repository.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientDAO patientDAO;

    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    public Patient createPatient(Patient patient) {
        return patientDAO.savePatient(patient);
    }

    public Patient updatePatient(Patient patient) {
        return patientDAO.updatePatient(patient);
    }

    public Patient getPatientById(Long id) {
        return patientDAO.getPatientById(id);
    }

    public void deletePatient(Long id) {
        patientDAO.deletePatient(id);
    }
}

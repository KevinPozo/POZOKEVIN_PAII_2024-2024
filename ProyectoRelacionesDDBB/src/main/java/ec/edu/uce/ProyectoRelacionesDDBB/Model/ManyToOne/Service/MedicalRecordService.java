/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne.Service;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne.Interfaces.IMedicalRecordDAO;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicalRecordService {

    private final IMedicalRecordDAO medicalRecordDAO;

    @Autowired
    public MedicalRecordService(IMedicalRecordDAO medicalRecordDAO) {
        this.medicalRecordDAO = medicalRecordDAO;
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordDAO.getAllMedicalRecords();
    }

    public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordDAO.saveMedicalRecord(medicalRecord);
    }

    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordDAO.updateMedicalRecord(medicalRecord);
    }

    public MedicalRecord getMedicalRecordById(Long id) {
        return medicalRecordDAO.getMedicalRecordById(id);
    }

    public void deleteMedicalRecord(Long id) {
        medicalRecordDAO.deleteMedicalRecord(id);
    }
}

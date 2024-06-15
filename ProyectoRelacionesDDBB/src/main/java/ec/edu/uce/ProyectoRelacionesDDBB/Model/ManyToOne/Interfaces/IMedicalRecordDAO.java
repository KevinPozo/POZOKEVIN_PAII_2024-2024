/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne.Interfaces;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne.MedicalRecord;

import java.util.List;

public interface IMedicalRecordDAO {
    List<MedicalRecord> getAllMedicalRecords();
    MedicalRecord getMedicalRecordById(Long id);
    MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord);
    MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord);
    void deleteMedicalRecord(Long id);
}

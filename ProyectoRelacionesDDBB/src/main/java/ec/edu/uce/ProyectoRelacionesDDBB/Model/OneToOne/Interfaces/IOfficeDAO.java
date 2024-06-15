/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Interfaces;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Office;

import java.util.List;

public interface IOfficeDAO {
    List<Office> getAllOffices();
    Office getOfficeById(Long id);
    Office saveOffice(Office office);
    Office updateOffice(Office office);
    void deleteOffice(Long id);
}

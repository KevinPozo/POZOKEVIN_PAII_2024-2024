/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Service;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Office;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Repository.OfficeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfficeService {
    @Autowired
    private OfficeDAO officeDAO;

    public List<Office> getAllOffices() {
        return officeDAO.getAllOffices();
    }

    public Office createOffice(Office office) {
        return officeDAO.saveOffice(office);
    }

    public Office updateOffice(Office office) {
        return officeDAO.updateOffice(office);
    }

    public Office getOfficeById(Long id) {
        return officeDAO.getOfficeById(id);
    }

    public void deleteOffice(Long id) {
        officeDAO.deleteOffice(id);
    }
}

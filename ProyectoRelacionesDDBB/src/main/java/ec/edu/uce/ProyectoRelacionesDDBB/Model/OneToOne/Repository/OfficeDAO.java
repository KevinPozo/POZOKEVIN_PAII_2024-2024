/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Repository;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Interfaces.IOfficeDAO;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OfficeDAO implements IOfficeDAO {
    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    @Override
    public Office getOfficeById(Long id) {
        return officeRepository.findById(id).orElse(null);
    }

    @Override
    public Office saveOffice(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public Office updateOffice(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }
}

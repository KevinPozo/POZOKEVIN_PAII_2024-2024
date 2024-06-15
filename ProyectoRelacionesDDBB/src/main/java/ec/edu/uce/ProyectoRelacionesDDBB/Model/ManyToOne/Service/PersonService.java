/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne.Service;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne.Interfaces.IPersonDAO;
import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService {

    private final IPersonDAO personDAO;

    @Autowired
    public PersonService(IPersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    public Person createPerson(Person person) {
        return personDAO.savePerson(person);
    }

    public Person updatePerson(Person person) {
        return personDAO.updatePerson(person);
    }

    public Person getPersonById(Long id) {
        return personDAO.getPersonById(id);
    }

    public void deletePerson(Long id) {
        personDAO.deletePerson(id);
    }
}

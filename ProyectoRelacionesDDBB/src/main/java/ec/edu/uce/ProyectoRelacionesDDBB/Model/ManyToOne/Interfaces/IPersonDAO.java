/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne.Interfaces;

import ec.edu.uce.ProyectoRelacionesDDBB.Model.ManyToOne.Person;

import java.util.List;

public interface IPersonDAO {
    List<Person> getAllPersons();
    Person getPersonById(Long id);
    Person savePerson(Person person);
    Person updatePerson(Person person);
    void deletePerson(Long id);
}

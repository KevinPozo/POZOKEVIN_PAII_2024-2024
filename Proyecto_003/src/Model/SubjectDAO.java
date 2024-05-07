/**
 * 
 * @author KevinPozo
 * Title: Inversión de Dependencia y DAO.
 * 
 * 
 * */

package Model;

public interface SubjectDAO {
	public void create(Subject subject);

	public Subject read(int id);

	public void delete(Subject subject);

	public void update(Subject subject);
}

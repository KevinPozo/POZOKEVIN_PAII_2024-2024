/**
 * 
 * @author KevinPozo
 * Title: Inversión de Dependencia y DAO.
 * 
 * 
 * */

package Model;

public interface ScheduleDAO {
	public void create(Schedule schedule);

	public Schedule read(int id);

	public void delete(Schedule schedule);

	public void update(Schedule schedule);
}

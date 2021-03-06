package pt.upacademy.stockManagementProject.business;

import java.util.Collection;
import pt.upacademy.stockManagementProject.models.Entity;


public interface EntityBusinessInterface <T extends Entity> {
	
	T get (long id);
	
	Collection<T> consultAll ();	
	
	Collection<Long> getAllIds ();
	
	long save (T entity) throws Exception;
	
	void update (T entity) throws Exception;
	
	void delete (long id);
	
	boolean isEmpty ();

	

}

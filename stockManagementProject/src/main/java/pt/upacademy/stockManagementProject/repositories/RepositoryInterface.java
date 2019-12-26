package pt.upacademy.stockManagementProject.repositories;

import java.util.Collection;


public interface RepositoryInterface<T> {

	public T consultEntity (Long Id);
	
	public Collection<Long> getAllIds ();
	
	public void removeEntity (Long iD);
	
	public boolean isEmpty ();
	
	public T editEntity (T newEnt);
	
	public Long createEnt (T newEnt);
}

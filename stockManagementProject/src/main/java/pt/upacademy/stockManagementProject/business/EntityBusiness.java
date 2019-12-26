package pt.upacademy.stockManagementProject.business;

import java.util.Collection;

import pt.upacademy.stockManagementProject.models.Entity;
import pt.upacademy.stockManagementProject.repositories.EntityRepository;

public class EntityBusiness <R extends EntityRepository <E>, E extends Entity> implements EntityBusinessInterface <E> {

protected R repository;
	
	@Override
	public E get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<E> consultAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Long> getAllIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long save(E entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(E entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

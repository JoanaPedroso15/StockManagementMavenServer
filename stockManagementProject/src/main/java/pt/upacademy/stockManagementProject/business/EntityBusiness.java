package pt.upacademy.stockManagementProject.business;

import java.util.Collection;

import pt.upacademy.stockManagementProject.models.Entity;
import pt.upacademy.stockManagementProject.repositories.EntityRepository;

public abstract class EntityBusiness <R extends EntityRepository <E>, E extends Entity> implements EntityBusinessInterface <E> {

protected R repository;
	
	@Override
	public E get(long id) {
		validate(id);
		return repository.consultEntity (id);
	}

	@Override
	public Collection<E> consultAll() {
		return repository.consultAll();
	}

	@Override
	public Collection<Long> getAllIds() {
		return repository.getAllIds();
	}

	@Override
	public long save(E entity) throws Exception {
		repository.createEnt (entity);
	    return entity.getID();
	}

	@Override
	public void update(E entity) throws Exception {
		repository.editEntity(entity);
		
	}

	@Override
	public void delete(long id) {
		repository.removeEntity(id);
		
	}

	@Override
	public boolean isEmpty() {
		return repository.isEmpty();
	}
	
	public void validate (long Id) throws IllegalArgumentException {
		if (repository.consultEntity (Id) == null) {
			throw new IllegalArgumentException (String.format("No %s with ID %d", getEntityClassName(), Id));
		}
	}

	protected abstract String getEntityClassName();

}

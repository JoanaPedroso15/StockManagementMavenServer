package pt.upacademy.stockManagementProject.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import pt.upacademy.stockManagementProject.models.Entity;


public abstract class EntityRepository <T extends Entity> implements RepositoryInterface <T>{
	
	Map <Long, T> linkedHashMap = new HashMap <Long, T>();
	Long currentId = (long) 1;

private Long nextId () {
		return currentId++;
		}

	
	public Long createEnt (T newEnt) {
		newEnt.setID(currentId);
		nextId();
		linkedHashMap.put(newEnt.getID(), newEnt);
		return newEnt.getID();
	}
	
	public Collection<T> consultAll (){
		return linkedHashMap.values();
	}
	
	public Collection <Long> getAllIds (){
		return linkedHashMap.keySet();
	}
	
	public T consultEntity (Long Id) {
		return linkedHashMap.get (Id);
	}
	
	
	public void removeEntity (Long iD) {
		T ent = consultEntity(iD);
		linkedHashMap.remove(iD, ent);
	}
	
	public boolean isEmpty () {
		return (linkedHashMap.size() == 0) ? true:false; 
	}
	
	
public T editEntity (T newEnt) {
	long idEnt = newEnt.getID();
	linkedHashMap.replace(idEnt, newEnt);
	return newEnt;
	
}
	
	

}

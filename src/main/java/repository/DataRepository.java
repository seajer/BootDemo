package repository;

import java.util.Set;

import entity.DomainObject;

public interface DataRepository<V extends DomainObject> {

	void persist(V object);
	
	void delete(V object);
	
	Set<String> getRandomData();
}

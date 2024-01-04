package shared;

import java.util.List;

public interface AbstractCrud <T>{

	List<T> readAll();
	
	void insert(T t);
	
	T readById(int id);
	
	void update(T t);
	
	void delete(int id);
}

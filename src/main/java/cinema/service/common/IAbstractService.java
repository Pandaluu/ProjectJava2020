package cinema.service.common;

import java.util.List;

public abstract interface IAbstractService <T> {
	
	public List<T> findAll();
	public T findOne(Integer id); 
	public boolean deleteById(Integer id);
	public boolean delete (T t);
	public T save (T t);
}
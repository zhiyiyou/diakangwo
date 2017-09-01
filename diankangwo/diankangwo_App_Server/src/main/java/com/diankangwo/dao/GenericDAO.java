package com.diankangwo.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 泛型DAO的基本操作
 *
 * @param <T>
 */
public interface GenericDAO<T> {
	T get(Serializable id);
	
	List<T> getAll();
	
	void save(T entity);
	
	void remove(T entity);
	
	void removeById(Serializable id);
	
	void update(T entity);
}

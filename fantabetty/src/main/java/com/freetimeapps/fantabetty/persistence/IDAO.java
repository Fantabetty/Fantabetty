package com.freetimeapps.fantabetty.persistence;

import java.util.List;

import com.freetimeapps.fantabetty.model.ModelObject;
import com.googlecode.objectify.Key;

public interface IDAO<T extends ModelObject<T>> {

	public T find(Long id);
	public void delete(Long id);

	public T find(String id);
	public void delete(String id);

	public T find(Key<T> key);
	public void delete(T t);

	public Key<T> key(T t);
	public List<Key<T>> key(List<T> list);

	public List<T> findAll();
	public List<T> findAll(List<Key<T>> keys);

	public T persist(T t);
}
package com.freetimeapps.fantabetty.persistence;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.freetimeapps.fantabetty.model.ModelObject;
import com.freetimeapps.fantabetty.model.Player;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

public abstract class AbstractDAO<T extends ModelObject<T>> implements IDAO<T> {

	static {
		ObjectifyService.register(Player.class);
	}

	private final Class<T> clazz;

	public AbstractDAO(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public T find(Long id) {
		return ofy().load().type(clazz).id(id).now();
	}

	@Override
	public T find(String id) {
		return ofy().load().type(clazz).id(id).now();
	}

	@Override
	public T find(Key<T> key) {
		return ofy().load().key(key).now();
	}

	@Override
	public Key<T> key(T t) {
		return Key.create(t);
	}

	@Override
	public List<T> findAll() {
		return ofy().load().type(clazz).list();
	}

	@Override
	public List<T> findAll(List<Key<T>> keys) {
		if (keys == null) {
			return null;
		}
		final Map<Key<T>, T> map = ofy().load().keys(keys);
		final List<T> list = new ArrayList<T>();
		for (final T t : map.values()) {
			list.add(t);
		}
		return list;
	}

	@Override
	public List<Key<T>> key(List<T> list) {
		if (list == null) {
			return null;
		}
		final List<Key<T>> keys = new ArrayList<Key<T>>(list.size());
		for (final T t : list) {
			final Key<T> key = Key.create(t);
			keys.add(key);
		}
		return keys;
	}

	@Override
	public T persist(T t) {
		ofy().save().entity(t).now();
		return t;
	}
	
	@Override
	public void delete(T t) {
		ofy().delete().entity(t).now();
	}
	
	@Override
	public void delete(Long id) {
		ofy().delete().type(clazz).id(id).now();
	}
	
	@Override
	public void delete(String id) {
		ofy().delete().type(clazz).id(id).now();
	}
}
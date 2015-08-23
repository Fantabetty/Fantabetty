package com.freetimeapps.fantabetty.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.freetimeapps.fantabetty.model.Player;
import com.googlecode.objectify.Key;

public class PlayerMockDAO implements IDAO<Player>{

	private Map<Long, Player> store;
	
	public PlayerMockDAO() {
		store = new HashMap<Long, Player>();
		
		Player p = new Player();
		p.setName("Valerio");
		p.setNickname("Ricchielli");
		
		store.put(80L, p);
	}
	
	@Override
	public Player find(Long id) {
		return store.get(id);
	}

	@Override
	public void delete(Long id) {
		store.remove(id);
	}

	@Override
	public Player find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player find(Key<Player> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Player t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Key<Player> key(Player t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Key<Player>> key(List<Player> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> findAll() {
		return new ArrayList<Player>(store.values());
	}

	@Override
	public List<Player> findAll(List<Key<Player>> keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player persist(Player t) {
		return store.put(t.getId(), t);
	}

}

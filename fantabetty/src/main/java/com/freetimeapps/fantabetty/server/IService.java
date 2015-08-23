package com.freetimeapps.fantabetty.server;

import java.util.List;

import javax.ws.rs.core.Response;

public interface IService<T> {

	public T get(String id);
	public Response get();

	public String persist(String body);

	public String delete(String id);
	public void update(String body);
}

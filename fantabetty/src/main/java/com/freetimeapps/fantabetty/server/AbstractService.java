package com.freetimeapps.fantabetty.server;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.freetimeapps.fantabetty.model.ModelObject;
import com.freetimeapps.fantabetty.persistence.IDAO;
import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.GsonBuilder;

public abstract class AbstractService<T extends ModelObject<T>> implements IService<T>{
	Logger logger = Logger.getLogger("Service");

	@Inject
	private IDAO<T> dao;
	private final Class<T> clazz;

	public AbstractService(Class<T> clazz) {
		this.clazz = clazz;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public T get(@PathParam("id") String id) {
		logger.fine("Call" + clazz.getSimpleName() + "Service : /get/" + id);
		T p = dao.find(Long.valueOf(id));
		return p;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response get() {
		logger.fine("Call" + clazz.getSimpleName() + "Service : /getAll");
		Object[] list =dao.findAll().toArray();
		return Response.status(200).entity(list).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public String persist(String body) {
		logger.fine("Call" + clazz.getSimpleName() + "Service : /persist");
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		final T create = gson.fromJson(body, clazz);
		dao.persist(create);
		return create.getId().toString();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void update(String body) {
		logger.fine("Call" + clazz.getSimpleName() + "Service : /update");
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		final T update = gson.fromJson(body, clazz);
		T found = dao.find(update.getId());
		found.setAs(update);
		dao.persist(found);
	}
	
	@DELETE
	@Path("{id}")
	@Override
	public String delete(@PathParam("id") String id) {
		logger.fine("Call" + clazz.getSimpleName() + "Service : /delete/" + id);
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		T find = dao.find(id);
		dao.delete(id);
		return gson.toJson(find);
	}
}
package com.freetimeapps.fantabetty.model;

import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.OnSave;
import com.googlecode.objectify.annotation.Unindex;

public abstract class ModelObject<T> {

	@Id
	private Long id;
	
	@Unindex
	private Integer version;
	
	public Long getId() {
		return id;
	}

	public Integer getVersion() {
		return version;
	}
	
	@OnSave
	public void updateVersion() {
		if (version == null) {
			version = Integer.valueOf(0);
		}
		version++;
	}

	public abstract void setAs(T obj);
}

package com.freetimeapps.fantabetty.model;

public class Player extends ModelObject<Player>{

	private String name;
	private String nickname;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public void setAs(Player obj) {
		// TODO Auto-generated method stub
	}
}

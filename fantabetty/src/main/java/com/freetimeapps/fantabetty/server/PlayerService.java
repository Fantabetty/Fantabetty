package com.freetimeapps.fantabetty.server;

import javax.ws.rs.Path;

import com.freetimeapps.fantabetty.model.Player;

@Path("/players")
public class PlayerService extends AbstractService<Player>{

	public PlayerService() {
		super(Player.class);
	}
}

package com.freetimeapps.fantabetty.module;

import com.freetimeapps.fantabetty.model.Player;
import com.freetimeapps.fantabetty.persistence.IDAO;
import com.freetimeapps.fantabetty.persistence.PlayerMockDAO;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.googlecode.objectify.ObjectifyFilter;

public class FantabettyModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(ObjectifyFilter.class).in(Singleton.class);

		bind(new TypeLiteral<IDAO<Player>>() {
			}).to(PlayerMockDAO.class);
		
//		bind(new TypeLiteral<IDAO<Player>>() {
//		}).to(PlayerDAO.class);
//		bind(new TypeLiteral<IService<Player>>() {
//		}).to(PlayerService.class);
//		
//		bind(new TypeLiteral<IDAO<Game>>() {
//		}).to(GameDAO.class);
//		bind(new TypeLiteral<IService<Game>>() {
//		}).to(GameService.class);
//		
//		bind(new TypeLiteral<IDAO<MatchParticipation>>() {
//		}).to(MatchDAO.class);
//		bind(new TypeLiteral<IService<MatchParticipation>>() {
//		}).to(MatchService.class);
	}
}
package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Passageiro;

public class PassageiroDAOImpl extends GenericDAOImpl<Passageiro, Integer> {

	public PassageiroDAOImpl(EntityManager em) {
		super(em);
	}

}

package br.com.fiap.nac.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.nac.dao.ApartamentoDAO;
import br.com.fiap.nac2.entity.Apartamento;

public class ApartamentoDAOImpl extends GenericDAOImpl<Apartamento, Integer> implements ApartamentoDAO {

	public ApartamentoDAOImpl(EntityManager em) {
		super(em);
	}

}

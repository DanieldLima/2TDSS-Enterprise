package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Pagamento;

public class PagamentoDAOImpl extends GenericDAOImpl<Pagamento, Integer> {

	public PagamentoDAOImpl(EntityManager em) {
		super(em);
	}

}

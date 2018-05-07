package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.VeiculoDAO;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.KeyNotFoundException;

public class VeiculoDAOImpl extends GenericDAOImpl<Veiculo, Integer> implements VeiculoDAO {

	public VeiculoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Veiculo> buscarPrTodosVeiculosValorMinimoDoAno(int ano) {
		return em.createQuery("from Veiculo v where v.ano <= :a", Veiculo.class)
				.setParameter("a", ano).getResultList();
	}
}

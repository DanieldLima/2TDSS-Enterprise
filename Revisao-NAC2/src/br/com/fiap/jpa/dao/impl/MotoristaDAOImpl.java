package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.MotoristaDAO;
import br.com.fiap.jpa.entity.Motorista;

public class MotoristaDAOImpl extends GenericDAOImpl<Motorista, Integer> implements MotoristaDAO {

	public MotoristaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Motorista> buscarMotoristaPorNome(String nome) {
		return em.createQuery("from Motorista m where m.nome like :m", Motorista.class)
				.setParameter("m", "%" + nome + "%")
				.setMaxResults(50)
				.getResultList();
	}

}

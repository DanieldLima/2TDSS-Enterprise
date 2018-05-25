package br.com.fiap.nac.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.nac.dao.ApartamentoDAO;
import br.com.fiap.nac2.entity.Apartamento;
import br.com.fiap.nac2.entity.Locacao;

public class ApartamentoDAOImpl extends GenericDAOImpl<Apartamento, Integer> implements ApartamentoDAO {

	public ApartamentoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Apartamento> buscaPorDescricao(String descricao) {
		TypedQuery<Apartamento> query = em.createQuery("from Apartamento a where a.detalhes like :descApartamento", Apartamento.class)
				.setParameter("descApartamento", "%" + descricao + "%");
		
		return query.getResultList();
	}

}

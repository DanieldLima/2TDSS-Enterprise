package br.com.fiap.nac.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.nac.dao.LocacaoDAO;
import br.com.fiap.nac2.entity.Locacao;

public class LocacaoDAOImpl extends GenericDAOImpl<Locacao, Integer> implements LocacaoDAO {

	public LocacaoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Locacao> listarProdutosDataInicio(Calendar inicio, Calendar fim) {
		return em.createQuery("from Locacao l where l.dataInicio between :p1 and :p2", Locacao.class)
				.setParameter("p1", inicio).setParameter("p2", fim).getResultList();
	}

	@Override
	public long contarQuantidadeDeLocacoesIdCliente(int codigo) {
		return em.createQuery("select count(l) from Locacao l where l.cliente.codigo = :id", Long.class)
				.setParameter("id", codigo).getSingleResult();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Override
	public long contarQuantidadePorCliente(int idCliente) {
		return em.createQuery("select count(r) from "
				+ "Reserva r where r.cliente.id = :codigo"
				,Long.class).setParameter("codigo", idCliente)
				.getSingleResult();
	}*/

}

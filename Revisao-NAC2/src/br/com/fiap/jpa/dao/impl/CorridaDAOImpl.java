package br.com.fiap.jpa.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.CorridaDAO;
import br.com.fiap.jpa.entity.Corrida;
import br.com.fiap.jpa.entity.Motorista;

public class CorridaDAOImpl extends GenericDAOImpl<Corrida, Integer> implements CorridaDAO {

	public CorridaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Corrida> buscarTodasAsCorridasPorIntervaloDeDatas(Calendar inicio, Calendar fim) {
		return em.createQuery("from Corrida c where c.dataCorrida bettwen :i and f", Corrida.class)
				.setParameter("i", inicio)
				.setParameter("f", fim)
				.setMaxResults(30)
				.getResultList();
	}

	@Override
	public List<Corrida> buscarTodasCorridasDeUmMotorista(Motorista motorista) {
		return em.createQuery("from Corrida c where c.motorista :m", Corrida.class)
				.setParameter("m", motorista).getResultList();
	}

	@Override
	public long quantidadeDeCorridasDeUmPassageiro(int id) {
		return em.createQuery("select count(c) Corrida c where c.passageiro.id :c ", Long.class)
				.setParameter("c", id).getSingleResult();
	}

	@Override
	public List<Corrida> buscarTodasCorridasPorNomePassageiro(String nome) {
		return em.createQuery("from Corrida c where c.passageiro.nome like :n", Corrida.class)
				.setParameter("n", "%" + nome + "%")
				.setMaxResults(40)
				.getResultList();
	}

	@Override
	public long somarTodosOsValoresDePagamentosDeUmPassageiro(int id) {
		return em.createQuery("select sum(c) Corrida c.pagamento.valor :v", Long.class)
				.setParameter("v", id).getSingleResult();
	}

	@Override
	public long quantidadeCorridasDeUmMotoristaPorPeriodoDatas(int id, Calendar inicio, Calendar fim) {
		return em.createQuery("from count(c) Corrida c where c.motorista.carteira :m and c.data between :i and :f", Long.class)
				.setParameter("c", id)
				.setParameter("i", inicio)
				.setParameter("f", fim)
				.getSingleResult();
	}

	@Override
	public List<Corrida> buscarOsMaioresValoresDeCorridasPorPassageiro(int id) {
		return em.createQuery("from Corrida c where c.passageiro.id = :p order by c.valor desc", Corrida.class)
				.setParameter("p", id)
				.setMaxResults(10)
				.getResultList();
	}

	@Override
	public List<Corrida> buscarCorridasEntrePassageiroMotorista(int codigoPassageiro, int codigoMotorista) {
		return em.createQuery("from Corrida c where c.passageiro.id :p and c.motorista.carteira = :m", Corrida.class)
				.setParameter("p", codigoPassageiro)
				.setParameter("m", codigoMotorista)
				.getResultList();
	}

}

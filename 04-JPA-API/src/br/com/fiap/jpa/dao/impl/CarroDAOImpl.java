package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.CarroDAO;
import br.com.fiap.jpa.entity.Carro;

public class CarroDAOImpl implements CarroDAO {

	private EntityManager em;
	
	public CarroDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void create(Carro carro) {
		em.persist(carro);
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

	@Override
	public void update(Carro carro) {
		em.merge(carro);
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

	@Override
	public void delete(int codigo) {
		Carro carro = em.find(Carro.class,codigo);
		em.remove(carro);
		em.getTransaction().begin();
		em.getTransaction().commit();
	}

	@Override
	public Carro find(int codigo) {
		return em.find(Carro.class, codigo);
	}

	
	
}
package br.com.fiap.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;

public class GenericDAOImpl<T, K> implements GenericDAO<T , K> {
	
	protected EntityManager em;
	
	private Class<T> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		classe = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];		
	}

	@Override
	public void create(T entity) {
		em.persist(entity);
		
	}

	@Override
	public void update(T entity) {
		em.merge(entity);
		
	}

	@Override
	public T find(K id) {
		return em.find(classe, id);
	}

	@Override
	public void delete(K id) throws KeyNotFoundException {
		T entity = find(id);
		if (entity == null)
			throw new KeyNotFoundException();
		em.remove(entity);
		
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException("Erro ao tentar gravar os dados no banco!");
		}
		
	}

	@Override
	public List<T> list() {
		return em.createQuery("from " + classe.getName(), classe).getResultList();
	}

}

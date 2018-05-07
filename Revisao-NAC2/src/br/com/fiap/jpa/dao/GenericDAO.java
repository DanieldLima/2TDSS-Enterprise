package br.com.fiap.jpa.dao;

import java.util.List;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;

public interface GenericDAO<T, K> {
	
	void create(T entity);
	
	void update(T entity);
	
	T find(K id);
	
	void delete(K id) throws KeyNotFoundException;
	
	void commit() throws CommitException;
	
	List<T> list();

}

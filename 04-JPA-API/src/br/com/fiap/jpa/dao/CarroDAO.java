package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Carro;

public interface CarroDAO {

	void create(Carro carro);
	void update(Carro carro);
	void delete(int codigo);
	Carro find(int codigo);
	
}
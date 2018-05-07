package br.com.fiap.jpa.dao;

import java.util.List;

import br.com.fiap.jpa.entity.Motorista;

public interface MotoristaDAO extends GenericDAO<Motorista, Integer> {
	
	List<Motorista> buscarMotoristaPorNome(String nome);
}

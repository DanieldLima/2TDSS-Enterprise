package br.com.fiap.jpa.dao;

import java.util.List;

import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.KeyNotFoundException;

public interface VeiculoDAO extends GenericDAO<Veiculo, Integer> {
	
	List<Veiculo> buscarPrTodosVeiculosValorMinimoDoAno(int ano);

}

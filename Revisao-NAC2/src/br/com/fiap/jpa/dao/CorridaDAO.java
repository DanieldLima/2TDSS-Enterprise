package br.com.fiap.jpa.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.jpa.entity.Corrida;
import br.com.fiap.jpa.entity.Motorista;

public interface CorridaDAO extends GenericDAO<Corrida, Integer> {
	
	List<Corrida> buscarTodasAsCorridasPorIntervaloDeDatas(Calendar inicio, Calendar fim);
	
	List<Corrida> buscarTodasCorridasDeUmMotorista(Motorista motorista);
	
	long quantidadeDeCorridasDeUmPassageiro(int id);
	
	List<Corrida> buscarTodasCorridasPorNomePassageiro(String nome);
	
	long somarTodosOsValoresDePagamentosDeUmPassageiro(int id);
	
	long quantidadeCorridasDeUmMotoristaPorPeriodoDatas(int id, Calendar inicio, Calendar fim);
	
	List<Corrida> buscarOsMaioresValoresDeCorridasPorPassageiro(int id);
	
	List<Corrida> buscarCorridasEntrePassageiroMotorista(int codigoPassageiro, int codigoMotorista);
	
}

package br.com.fiap.jpa.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.VeiculoDAO;
import br.com.fiap.jpa.dao.impl.VeiculoDAOImpl;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ConsoleView {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em =  factory.createEntityManager();
		
		VeiculoDAO veiculoDao = new VeiculoDAOImpl(em);
		//Veiculo veiculo1 = new Veiculo("JEEP", "ABC-4589", "Preto", 2019);
		Veiculo veiculo2 = new Veiculo("FIAT", "CBD-1234", "Vermelho", 2018);
		
		try {
			veiculoDao.create(veiculo2);
			veiculoDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		List<Veiculo> veiculo = veiculoDao.buscarPrTodosVeiculosValorMinimoDoAno(2018);
		for (Veiculo veiculo3 : veiculo) {
			System.out.println(veiculo3.getAno());
		}
		
		
		
		
	}

}

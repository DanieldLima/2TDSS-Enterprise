package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManagerFactory fabrica =
			EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Listar as cidades
		//Cria o DAO
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		//Busca as cidades
		System.out.println("LISTAR CIDADES");
		List<Cidade> lista = cidadeDao.listar();
		//Exibe o nome e o estado
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " +
					cidade.getUf());
		}
		
		System.out.println("BUSCAR POR NOME");
		lista = cidadeDao.buscarPorNome("Lon");
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " +
					cidade.getUf());
		}
		
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		List<Cliente> clientes = clienteDao.listar();
		System.out.println("LISTAR OS CLIENTES");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		//Pesquisa o transporte pelo código
		Transporte transporte = transporteDao.pesquisar(1);
		//Pesquisa os pacotes pelo objeto transporte
		List<Pacote> pacotes =
				pacoteDao.pesquisarPorTransporte(transporte);
		//Exibir a descrição dos pacotes
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
		}
		
		clientes = clienteDao.pesquisarPorEstado("BA");
		System.out.println("BUSCAR CLIENTE POR ESTADO");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		clientes = clienteDao.pesquisarPorDiasReserva(10);
		System.out.println("BUSCAR CLIENTE POR DIAS RESERVA");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		em.close();
		fabrica.close();
	}

}




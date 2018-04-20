package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;
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
		lista = cidadeDao.buscarPorNome("lon");
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
		
		//Cria as datas para a pesquisa
		Calendar inicio = new GregorianCalendar(2015,Calendar.MAY,1);
		Calendar fim = new GregorianCalendar(2018,Calendar.MAY,2);
		//Pesquisa os pacotes por datas
		pacotes = pacoteDao.buscarPorDatas(inicio, fim);
		System.out.println("BUSCAR PACOTES POR DATAS");
		//Exibe os pacotes
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
		}
		
		//Pesquisa os clientes
		clientes = clienteDao.buscar("a", "a");
		System.out.println("BUSCAR CLIENTE POR NOME E CIDADE");
		//Exibir os clientes
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome() + " " +
					cliente.getEndereco().getCidade().getNome());
		}
		//Parametro para pesquisar os clientes por estado
		List<String> estados = new ArrayList<>();
		estados.add("SP");
		estados.add("PR");
		//Pesquisar os clientes
		clientes = clienteDao.buscarPorEstados(estados);
		System.out.println("BUSCAR CLIENTE POR ESTADOS");
		//Exibir os clientes
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome() + " " +
					cliente.getEndereco().getCidade().getUf());
		}
		
		
		//Criar a ReservaDAO
		ReservaDAO reservaDao = new ReservaDAOImpl(em);
		//Exibir a quantidade de reservas
		System.out.println("Reservas: " + 
						reservaDao.contarQuantidade());
		
		//Exibir a média dos preços dos pacotes
		System.out.println("Preços: " + 
						pacoteDao.calcularMediaPreco());
		
		//Exibir a quantidade de reserva do cliente X
		System.out.println("Reservas do cliente: "
				+ reservaDao.contarQuantidadePorCliente(2));
		
		//Exibir a quantidade de pacotes com transporte
		System.out.println("Pacotes com transportes: "
				+ pacoteDao.contarPorTransporte());
		
		//Exibir a quantidade de reserva dentro de um período
		Calendar inicio1 = new GregorianCalendar(2015,
										Calendar.JANUARY,1);
		System.out.println("Reservas: " + 
				reservaDao.contarPorDatas(inicio1, fim));
		
		//Contar a quantidade de reseva por estado do cliente
		System.out.println("Reservas Estado: " +
				reservaDao.contarPorEstadoCliente("PR"));
		
		//Exibir os pacotes por destino
		pacotes = pacoteDao.buscarPorDestino("al");
		System.out.println("BUSCAR PACOTES POR DESTINO");
		//Exibe os pacotes
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
		}
		
		em.close();
		fabrica.close();
	}

}




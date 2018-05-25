package br.com.fiap.nac2.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.nac.dao.ApartamentoDAO;
import br.com.fiap.nac.dao.LocacaoDAO;
import br.com.fiap.nac.dao.impl.ApartamentoDAOImpl;
import br.com.fiap.nac.dao.impl.LocacaoDAOImpl;
import br.com.fiap.nac.singleton.EntityManagerFactorySingleton;
import br.com.fiap.nac2.entity.Apartamento;
import br.com.fiap.nac2.entity.Locacao;

public class TesteBusca {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		
		System.out.println("\nBuscar todas as locações que possuem a data de inicio entre duas datas\n");
		LocacaoDAO locacaoDAO = new LocacaoDAOImpl(em);
		Calendar inicio = new GregorianCalendar(2017,Calendar.MAY,1);
		Calendar fim = new GregorianCalendar(2012,Calendar.MAY,2);
		
		List<Locacao> locacoes = locacaoDAO.listarProdutosDataInicio(inicio, fim);
		for (Locacao locacao : locacoes) {
			System.out.println(locacao.getCliente().getNome());
		}
		
		
		System.out.println("\nContar a quantidade de locações pelo código do cliente\n");
		System.out.println("Locações " + locacaoDAO.contarQuantidadeDeLocacoesIdCliente(1));
		
		ApartamentoDAO apDAO = new ApartamentoDAOImpl(em);
		List<Apartamento> aps = apDAO.buscaPorDescricao("e");
		for (Apartamento apartamento : aps) {
			System.out.println(apartamento.getDetalhes());
		}
		
		
		
		
		em.close();
		factory.close();
		
	}

}

package br.com.fiap.jpa.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.NotaFiscalDAO;
import br.com.fiap.jpa.dao.impl.NotaFiscalDAOImpl;
import br.com.fiap.jpa.entity.Imposto;
import br.com.fiap.jpa.entity.ItemPedido;
import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) throws CommitException {

		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();

		Pedido ped = new Pedido(new GregorianCalendar(2018, Calendar.MARCH, 16), "TESTE");

		ItemPedido item = new ItemPedido("Camiseta branca", 50);
		ped.adicionarItem(item);
		item = new ItemPedido("Camiseta preta", 55);
		ped.adicionarItem(item);
		item = new ItemPedido("Camiseta azul", 60.5);
		ped.adicionarItem(item);

		NotaFiscal nf = new NotaFiscal(new GregorianCalendar(2018, Calendar.MARCH, 16), 50, ped);

		//Cria os impostos 
		Imposto imposto1 = new Imposto();
		imposto1.setDescricao("ICMS");
		imposto1.setValor(0.08);

		Imposto imposto2 = new Imposto();
		imposto2.setDescricao("IOF");
		imposto2.setValor(0.06);
		
		//Cria a lista de impostos
		List<Imposto> impostos = new ArrayList<>();
		impostos.add(imposto1);
		impostos.add(imposto2);
	
		NotaFiscalDAO nfDAO = new NotaFiscalDAOImpl(em);

		nfDAO.inserir(nf);
		nfDAO.commit();

		em.close();
		emf.close();

	}

}

package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.NotaFiscalDAO;
import br.com.fiap.jpa.dao.PedidoDAO;
import br.com.fiap.jpa.dao.impl.NotaFiscalDAOImpl;
import br.com.fiap.jpa.dao.impl.PedidoDAOImpl;
import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
			EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		PedidoDAO dao = new PedidoDAOImpl(em);
		NotaFiscalDAO nDao = new NotaFiscalDAOImpl(em);
		//Pesquisa o pedido
//		Pedido pedido = dao.pesquisar(2);
//		System.out.println(pedido.getDescricao());
//		System.out.println(pedido.getNota().getValor());
		
		NotaFiscal nota = nDao.pesquisar(1);
		System.out.println(nota.getValor());
		
		//System.out.println(nota.getPedido().getDescricao());
		
		
		em.close();
		fabrica.close();
	}
	
}

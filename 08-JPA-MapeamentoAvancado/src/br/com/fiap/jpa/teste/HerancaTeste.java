package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.PessoaDAO;
import br.com.fiap.jpa.dao.impl.PessoaDAOImpl;
import br.com.fiap.jpa.entity.Pessoa;
import br.com.fiap.jpa.entity.PessoaFisica;
import br.com.fiap.jpa.entity.PessoaJuridica;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class HerancaTeste {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		
		PessoaDAO dao = new PessoaDAOImpl(em);
		
		Pessoa pessoa = new Pessoa("Daniel Lima", "Rua de teste para a Herança");
		PessoaFisica pf =  new PessoaFisica("Sofia Grasielly", "Rua de teste para a Herança 2", "2365749-85", "5647987-9");
		PessoaJuridica pj = new PessoaJuridica("Daniel Antonio", "Rua de teste para a Herança 3", "56564216-32", "455456-4");

		try {			
			dao.inserir(pessoa);
			dao.inserir(pf);
			dao.inserir(pj);
			dao.commit();
			
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		factory.close();
	}
	

}

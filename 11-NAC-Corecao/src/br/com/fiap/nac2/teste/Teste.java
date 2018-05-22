package br.com.fiap.nac2.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.nac.dao.LocacaoDAO;
import br.com.fiap.nac.dao.impl.LocacaoDAOImpl;
import br.com.fiap.nac.singleton.EntityManagerFactorySingleton;
import br.com.fiap.nac2.entity.Apartamento;
import br.com.fiap.nac2.entity.Cliente;
import br.com.fiap.nac2.entity.Locacao;
import br.com.fiap.nac2.entity.Sexo;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();

		Cliente cliente = new Cliente("Teste 1", Calendar.getInstance(), Sexo.MASCULINO);
		Apartamento apartamento = new Apartamento("Av. Teste", "Teste detalhes", null);

		Locacao locacao = new Locacao(Calendar.getInstance(), Calendar.getInstance());
		locacao.setApartamento(apartamento);
		locacao.setCliente(cliente);

		LocacaoDAO dao = new LocacaoDAOImpl(em);

		try {
			dao.cadastrar(locacao);
			dao.salvar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		em.close();
		factory.close();

	}

}

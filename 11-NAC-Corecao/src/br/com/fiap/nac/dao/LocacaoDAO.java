package br.com.fiap.nac.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.nac2.entity.Locacao;

public interface LocacaoDAO extends GenericDAO<Locacao, Integer> {
	
	List<Locacao> listarProdutosDataInicio(Calendar inicio, Calendar fim);
	
	long contarQuantidadeDeLocacoesIdCliente(int codigoCliente);

}

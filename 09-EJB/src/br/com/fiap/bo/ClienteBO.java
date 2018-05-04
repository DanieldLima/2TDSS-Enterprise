package br.com.fiap.bo;

import javax.ejb.Local;

@Local
public interface ClienteBO {
	
	double calcularImpostoRenda(double rendimento);

}

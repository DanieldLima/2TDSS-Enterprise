package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PAGAMENTO")
@SequenceGenerator(name = "pagamento", sequenceName = "SQ_T_PAGAMENTO", allocationSize = 1)
public class Pagamento {

	@Id
	@Column(name = "cd_pagamento")
	@GeneratedValue(generator = "pagamento", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "dt_pagamento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataPagamento;

	@Column(name = "vl_pagamento", nullable = false)
	private double valor;

	@Column(name = "ds_forma_pagamento", nullable = false)
	private FormaPagamento formaPagamento;
	
	@OneToOne
	@JoinColumn(name="cd_corrida")
	private Corrida corrida;

	public Pagamento() {
		super();
	}

	public Pagamento(Calendar dataPagamento, float pagamento, FormaPagamento formaPagamento) {
		super();
		this.dataPagamento = dataPagamento;
		this.valor = pagamento;
		this.formaPagamento = formaPagamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public double getPagamento() {
		return valor;
	}

	public void setPagamento(float pagamento) {
		this.valor = pagamento;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	

}

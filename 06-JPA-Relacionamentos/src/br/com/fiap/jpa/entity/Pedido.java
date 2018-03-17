package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PEDIDO")
@SequenceGenerator(name="pedido",sequenceName="SQ_T_PEDIDO",allocationSize=1)
public class Pedido {

	@Id
	@Column(name="cd_pedido")
	@GeneratedValue(generator="pedido",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="dt_pedido",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@Column(name="ds_pedido",nullable=false,length=200)
	private String descricao;
	
	@OneToOne(mappedBy="pedido")
	private NotaFiscal nota;
	
	public Pedido(Calendar data, String descricao) {
		super();
		this.data = data;
		this.descricao = descricao;
	}

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public NotaFiscal getNota() {
		return nota;
	}

	public void setNota(NotaFiscal nota) {
		this.nota = nota;
	}
	
}

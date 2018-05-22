package br.com.fiap.nac2.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "NAC_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "SQ_NAC_CLIENTE", allocationSize = 1)
public class Cliente {

	@Id
	@Column(name = "codigo")
	@GeneratedValue(generator = "cliente", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(nullable = false, length = 150)
	private String nome;

	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	@Enumerated(EnumType.ORDINAL)
	private Sexo sexo;

	@OneToMany(mappedBy = "cliente")
	private List<Locacao> locacoes;

	public Cliente() {
		super();
	}

	public Cliente(String nome, Calendar dataNascimento, Sexo sexo) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

}

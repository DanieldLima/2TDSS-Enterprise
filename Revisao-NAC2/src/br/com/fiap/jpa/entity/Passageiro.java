package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PASSAGEIRO")
@SequenceGenerator(name = "passageiro", sequenceName = "SQ_T_PASSAGEIRO", allocationSize = 1)
public class Passageiro {

	@Id
	@GeneratedValue(generator = "passageiro", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_passageiro")
	private int id;

	@Column(name = "nm_passageiro", nullable = false, length = 100)
	private String nome;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	@Column(name = "ds_genero")
	private Genero genero;

	@OneToMany(mappedBy = "passageiro")
	private List<Corrida> corridas;

	public Passageiro() {
		super();
	}

	public Passageiro(String nome, Calendar dataNascimento, Genero genero, List<Corrida> corridas) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.corridas = corridas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}

}

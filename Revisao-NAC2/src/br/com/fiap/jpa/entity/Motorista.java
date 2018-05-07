package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_MOTORISTA")
public class Motorista {

	@Id
	@Column(name = "nr_carteira")
	private int carteira;

	@Column(name = "nm_motorista", nullable = false, length = 150)
	private String nome;

	@Column(name = "td_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNacimento;

	@Lob
	@Column(name = "fl_carteira")
	private byte[] foto;

	@Column(name = "ds_genero")
	@Enumerated(EnumType.STRING)
	private Genero genero;

	@OneToMany(mappedBy = "motorista")
	private List<Corrida> corridas;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinTable(name = "T_VEICULO_MOTORISTA", joinColumns = @JoinColumn(name = "cd_veiculo"), inverseJoinColumns = @JoinColumn(name = "cd_motorista"))
	private List<Veiculo> veiculos;

	public Motorista() {
		super();
	}

	public Motorista(String nome, Calendar dataNacimento, byte[] foto, Genero genero, List<Corrida> corridas,
			List<Veiculo> veiculos) {
		super();
		this.nome = nome;
		this.dataNacimento = dataNacimento;
		this.foto = foto;
		this.genero = genero;
		this.corridas = corridas;
		this.veiculos = veiculos;
	}

	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public int getCarteira() {
		return carteira;
	}

	public void setCarteira(int carteira) {
		this.carteira = carteira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(Calendar dataNacimento) {
		this.dataNacimento = dataNacimento;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}

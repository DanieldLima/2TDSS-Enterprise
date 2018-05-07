package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_CORRIDA")
@SequenceGenerator(name = "corrida", sequenceName = "SQ_T_CORRIDA", allocationSize = 1)
public class Corrida {

	@Id
	@Column(name = "cd_corrida")
	@GeneratedValue(generator = "corrida", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "ds_origem", length = 150)
	private String origem;

	@Column(name = "ds_destino", length = 150)
	private String destino;

	@Column(name = "dt_corrida")
	@Temporal(TemporalType.DATE)
	private Calendar dataCorrida;

	@Column(name = "vl_corrida", nullable = false)
	private double valor;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "cd_motorista")
	private Motorista motorista;
	
	@ManyToOne
	@JoinColumn(name="cd_passageiro")
	private Passageiro passageiro;
	
	@OneToOne(mappedBy="corrida", cascade=CascadeType.PERSIST)
	private Pagamento pagamento;	

	public Corrida() {
		super();
	}

	public Corrida(String origem, String destino, Calendar dataCorrida, float valor) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.dataCorrida = dataCorrida;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Calendar getDataCorrida() {
		return dataCorrida;
	}

	public void setDataCorrida(Calendar dataCorrida) {
		this.dataCorrida = dataCorrida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

}

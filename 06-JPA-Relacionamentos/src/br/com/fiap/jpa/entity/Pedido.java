package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="T_PEDIDO")
@SequenceGenerator(name="pedido", sequenceName="SQ_T_PEDIDO", allocationSize=1)
public class Pedido {
	
	@Id
	@Column(name="cd_pedido")
	@GeneratedValue(generator="pedido", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_pedido", nullable=false)
	private Calendar data;
	
	@Column(name="ds_pedido", nullable=false, length=200)
	private String descricao;
	
<<<<<<< HEAD
	@OneToOne(mappedBy="pedido",fetch=FetchType.LAZY)
	private NotaFiscal nota;
	
	@OneToMany(mappedBy="pedido",cascade=CascadeType.PERSIST)
=======
	@OneToOne(mappedBy="pedido", fetch=FetchType.LAZY)
	private NotaFiscal nota;
	
	@OneToMany(mappedBy="pedido", cascade=CascadeType.PERSIST)
>>>>>>> 42e2becb2e6cc0b442350c0b0abd3d48ed14b293
	private List<ItemPedido> itens = new ArrayList<>();
	
	public void adicionarItem(ItemPedido item) {
		itens.add(item);
		item.setPedido(this);
<<<<<<< HEAD
	}
	
	public Pedido(Calendar data, String descricao) {
		super();
		this.data = data;
		this.descricao = descricao;
=======
>>>>>>> 42e2becb2e6cc0b442350c0b0abd3d48ed14b293
	}

	public Pedido() {
		super();
	}

	public Pedido(Calendar data, String descricao) {
		super();
		this.data = data;
		this.descricao = descricao;
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

<<<<<<< HEAD
	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
=======
	public List<ItemPedido> getItemPedido() {
		return itens;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itens = itemPedido;
>>>>>>> 42e2becb2e6cc0b442350c0b0abd3d48ed14b293
	}
	
	

}

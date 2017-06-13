package br.com.tt.petshop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="atendimento")
public class Atendimento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id; 
	
	@Column(name="data_agendamento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAgendamento;
	
	@ManyToOne
	@JoinColumn(name="id_unidade", nullable=false, foreignKey=@ForeignKey(name="FK_UNIDADE"))
	private Unidade unidade;
	
	@ManyToOne
	@JoinColumn(name="id_pagamento")
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name="id_cliente", nullable=false)
	private Cliente cliente;
	
	@ManyToMany
	@JoinTable(name="ATENDIMENTO_PRODUTO",
			foreignKey=@ForeignKey(name="ID_ATD"),
			inverseForeignKey=@ForeignKey(name="ID_PRD"))
	private List<Produto> produtos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}

package br.com.tt.petshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="unidade")
public class Unidade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id; 
	
	@Column(name="nome", nullable=false, length=200)
	private String nome;
	
	@Column(name="telefone")
	private String telefone;
	
	@OneToMany(mappedBy="unidade")
	private List<Cliente> clientes;
	
	@OneToMany(mappedBy="unidade")
	private List<Atendimento> Atendimentos;
	
	@OneToMany(mappedBy="unidade")
	private List<Produto> produtos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Atendimento> getAtendimentos() {
		return Atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		Atendimentos = atendimentos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}

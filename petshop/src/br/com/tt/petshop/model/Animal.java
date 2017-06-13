package br.com.tt.petshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/* 1º Estratégia - SINGLE_TABLE */
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="TIPO", discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue("ANIMAL")
//@Table(name="ANIMAL_SINGLE")
//@Entity

/* 2º Estratégia - TABLE_PER_CLASS */
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Table(name="ANIMAL_CLASS")
//@MappedSuperclass

/* 3º Estratégia - JOINED */
@Inheritance(strategy=InheritanceType.JOINED)
@Entity
@Table(name="ANIMAL_JOINED")

public class Animal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
}

package br.com.tt.petshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/* 1� Estrat�gia - SINGLE_TABLE */
//@DiscriminatorValue("PEIXE")

/* 2� Estrat�gia - TABLE_PER_CLASS */
//@Table(name="PEIXE_CLASS")

/* 3� Estrat�gia - JOINED */
@Table(name="PEIXE_JOINED")
@PrimaryKeyJoinColumn(name="id_animal")

@Entity
public class Peixe extends Animal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="agua_salgada")
	private Boolean aguaSalgada;

	public Boolean getAguaSalgada() {
		return aguaSalgada;
	}

	public void setAguaSalgada(Boolean aguaSalgada) {
		this.aguaSalgada = aguaSalgada;
	}
}

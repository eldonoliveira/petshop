package br.com.tt.petshop.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/* 1� Estrat�gia - SINGLE_TABLE */
@DiscriminatorValue("REPTIL")

/* 2� Estrat�gia - TABLE_PER_CLASS */
//@Table(name="REPTIL_CLASS")

/* 3� Estrat�gia - JOINED */
@Table(name="REPTIL_JOINED")
@PrimaryKeyJoinColumn(name="id_animal")

@Entity
public class Reptil extends Animal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="peconhento")
	private Boolean peconhento;

	public Boolean getPeconhento() {
		return peconhento;
	}

	public void setPeconhento(Boolean peconhento) {
		this.peconhento = peconhento;
	}
	
}

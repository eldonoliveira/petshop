package br.com.tt.petshop.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/* 1� Estrat�gia - SINGLE_TABLE */
@DiscriminatorValue("MAMIFERO")

/* 2� Estrat�gia - TABLE_PER_CLASS */
//@Table(name="MAMIFERO_CLASS")

/* 3� Estrat�gia - JOINED */
@Table(name="MAMIFERO_JOINED")
@PrimaryKeyJoinColumn(name="id_animal")

@Entity
public class Mamifero extends Animal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

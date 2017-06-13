package br.com.tt.petshop.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="PetshopDS")
	protected EntityManager em;
	
}

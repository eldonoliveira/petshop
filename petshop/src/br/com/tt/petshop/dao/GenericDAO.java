package br.com.tt.petshop.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;

public abstract class GenericDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="PetshopDS")
	protected EntityManager em;
	
	public Session getHibernateSession(){
		
		/* Expor o provider... no caso o Hibernate. */
		return em.unwrap(SessionImpl.class);
	}
	
}

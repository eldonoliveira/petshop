package br.com.tt.petshop.dao;

import javax.ejb.Stateless;

import br.com.tt.petshop.model.Animal;

@Stateless
public class AnimalDAO extends GenericDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//C
	
	//R
	
	//U
	public void salvar(Animal animal){
		em.persist(animal);
	}
	
	//D
	public void remover(Animal animal){
		em.persist(animal);
	}
	

}

package br.com.tt.petshop.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.tt.petshop.model.Cliente;

@Stateless
public class ClienteDAO extends GenericDAO {

	private static final long serialVersionUID = 1L;
	
	public List<Cliente> list(){
		
		Query query = em.createNamedQuery("cliente.list");
		
		return query.getResultList();
	}
	
	public List<Cliente> findByNome(String nome){
		Query query = em.createNamedQuery("cliente.findByNome");
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}
	
	public Cliente findById (Long id){
		Query query= em.createQuery("select c from Cliente c where c.id = :id");
		query.setParameter("id", id);
				
		return (Cliente) query.getSingleResult();
	}

}

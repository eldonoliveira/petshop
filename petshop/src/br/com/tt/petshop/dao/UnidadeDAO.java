package br.com.tt.petshop.dao;

import javax.ejb.Stateless;

import br.com.tt.petshop.model.Unidade;

@Stateless
public class UnidadeDAO extends GenericDAO{
	private static final long serialVersionUID = 1L;
	
	public void salvar(Unidade unid){
		em.persist(unid);
	}
	
	public Unidade buscar(Long id){
		return em.find(Unidade.class, id);
	}
	
	public Unidade atualizar(Unidade unid){
		return em.merge(unid);
	}
	
	public void remover(Unidade unid){
		em.remove(unid);
		return ;
	}
}

package br.com.tt.petshop.service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.com.tt.petshop.dao.AnimalDAO;
import br.com.tt.petshop.dao.UnidadeDAO;
import br.com.tt.petshop.model.Mamifero;
import br.com.tt.petshop.model.Reptil;
import br.com.tt.petshop.model.Unidade;

@Singleton
@Startup
public class Service implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UnidadeDAO unidadeDAO;
	
	public void salvar(Unidade unid){
		unidadeDAO.salvar(unid);
	}
	
	public void testeSalvarUm(){
		Unidade novaUnidade = new Unidade();
		novaUnidade.setNome("Unidade Cristovao Colombo");
		novaUnidade.setTelefone("(51) 3344-1111");
		
		this.salvar(novaUnidade);
	}
	
	public void buscaUnidadeUm(){
		Unidade unid = unidadeDAO.buscar(1L);
		System.out.println("Unidade: "+unid.getNome());
		
		unid.setNome("Unidade Farrapos "+getDataHora());
		unidadeDAO.atualizar(unid);
		
		Unidade novaUnidade = new Unidade();
		novaUnidade.setNome("Unidade Cristovao Colombo");
		novaUnidade.setTelefone("(51) 3344-1111");
		unidadeDAO.atualizar(novaUnidade);
		
		//novaUnidade = unidadeDAO.buscar(7L);
		//unidadeDAO.remover(novaUnidade);
	}
	
	private String getDataHora(){
		return new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime());
	}
	
	@Inject
	private AnimalDAO animalDAO;
	@PostConstruct
	public void testeAnimal(){
		Mamifero a1 = new Mamifero();
		a1.setNome("Brutus");
		animalDAO.salvar(a1);
		
		Reptil a2 = new Reptil();
		a2.setNome("Rex");
		a2.setPeconhento(true);
		animalDAO.salvar(a2);
	}
	
}

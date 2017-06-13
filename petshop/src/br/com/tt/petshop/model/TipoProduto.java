package br.com.tt.petshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipo_produto")
public class TipoProduto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id; 
	
	@Column(name="descricao", nullable=false)
	private String descricao;
	
	@Column(name="valor", nullable=false)
	private Float valor;
	
	@OneToMany(mappedBy="tipoProduto")
	private List<Produto> produtos;

}

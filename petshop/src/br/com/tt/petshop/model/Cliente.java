package br.com.tt.petshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="cliente.list", query="select distinct c from Cliente c join fetch c.unidade left join fetch c.atendimentos"),
	@NamedQuery(name="cliente.findByNome", query="select distinct c from Cliente c join fetch c.unidade left join fetch c.atendimentos where c.nome like :nome ")
	}
)

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id; 
	
	@Column(name="cpf", nullable=false)
	private String cpf;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefone")
	private String telefone;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_unidade", nullable=false)
	private Unidade unidade;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY, cascade={CascadeType.MERGE, CascadeType.PERSIST})
	private List<Atendimento> atendimentos;

//	@OneToMany(mappedBy="cliente")
//	private List<Animal> animais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

}

package br.com.fiorilli.proj04.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cidade database table.
 * 
 */
@Entity
@Table(name="cidade")
@NamedQuery(name="CidadeEntity.findAll", query="SELECT c FROM CidadeEntity c")
public class CidadeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String estado;

	private String nome;

	//bi-directional many-to-one association to FornecedorEntity
	@OneToMany(mappedBy="cidade")
	private List<FornecedorEntity> fornecedors;

	//bi-directional many-to-one association to UsuarioEntity
	@OneToMany(mappedBy="cidade")
	private List<UsuarioEntity> usuarios;

	public CidadeEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
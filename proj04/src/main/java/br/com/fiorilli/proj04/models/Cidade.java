package br.com.fiorilli.proj04.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cidade database table.
 * 
 */
@Entity
@NamedQuery(name="Cidade.findAll", query="SELECT c FROM Cidade c")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String estado;

	private String nome;

	//bi-directional many-to-one association to Fornecedor
	@OneToMany(mappedBy="cidade")
	private List<Fornecedor> fornecedors;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="cidade")
	private List<Usuario> usuarios;

	public Cidade() {
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

	public List<Fornecedor> getFornecedors() {
		return this.fornecedors;
	}

	public void setFornecedors(List<Fornecedor> fornecedors) {
		this.fornecedors = fornecedors;
	}

	public Fornecedor addFornecedor(Fornecedor fornecedor) {
		getFornecedors().add(fornecedor);
		fornecedor.setCidade(this);

		return fornecedor;
	}

	public Fornecedor removeFornecedor(Fornecedor fornecedor) {
		getFornecedors().remove(fornecedor);
		fornecedor.setCidade(null);

		return fornecedor;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setCidade(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setCidade(null);

		return usuario;
	}

}
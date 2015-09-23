package br.com.fiorilli.proj04.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fornecedor database table.
 * 
 */
@Entity
@NamedQuery(name="Fornecedor.findAll", query="SELECT f FROM Fornecedor f")
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cnpj;

	@Column(name="nome_fantasia")
	private String nomeFantasia;

	@Column(name="razao_social")
	private String razaoSocial;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	private Cidade cidade;

	public Fornecedor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
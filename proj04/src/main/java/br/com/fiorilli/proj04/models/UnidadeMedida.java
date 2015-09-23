package br.com.fiorilli.proj04.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the unidade_medida database table.
 * 
 */
@Entity
@Table(name="unidade_medida")
@NamedQuery(name="UnidadeMedida.findAll", query="SELECT u FROM UnidadeMedida u")
public class UnidadeMedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descricao;

	private String sigla;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="unidadeMedida")
	private List<Product> products;

	public UnidadeMedida() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setUnidadeMedida(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setUnidadeMedida(null);

		return product;
	}

}
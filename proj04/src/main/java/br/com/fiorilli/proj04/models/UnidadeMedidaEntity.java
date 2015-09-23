package br.com.fiorilli.proj04.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the unidade_medida database table.
 * 
 */
@Entity
@Table(name="unidade_medida")
@NamedQuery(name="UnidadeMedidaEntity.findAll", query="SELECT u FROM UnidadeMedidaEntity u")
public class UnidadeMedidaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descricao;

	private String sigla;

	public UnidadeMedidaEntity() {
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

}
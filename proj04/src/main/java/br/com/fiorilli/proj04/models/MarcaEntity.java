package br.com.fiorilli.proj04.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the marca database table.
 * 
 */
@Entity
@Table(name="marca")
@NamedQuery(name="MarcaEntity.findAll", query="SELECT m FROM MarcaEntity m")
public class MarcaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private boolean ativo;

	private String descricao;

	private String nome;

	public MarcaEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
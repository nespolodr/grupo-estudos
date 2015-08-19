package br.com.fiorilli.estudos.agenda;

import java.util.Date;

public class Nota {

	private static int geradorId = 0;

	public long id;

	private String titulo;
	private String descricao;
	private Date data;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public static int gerarProximoId(){
		return ++geradorId;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", data=" + data + "]";
	}
	
	
}

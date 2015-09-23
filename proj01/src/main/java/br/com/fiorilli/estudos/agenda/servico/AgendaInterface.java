package br.com.fiorilli.estudos.agenda.servico;

import java.util.List;

import br.com.fiorilli.estudos.agenda.modelo.Nota;

public interface AgendaInterface {

	public Nota inserir(Nota nota);

	public Nota alterar(Nota nota);

	public List<Nota> listar();

	public void remover(Nota nota);

}

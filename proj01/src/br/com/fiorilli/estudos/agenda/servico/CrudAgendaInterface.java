package br.com.fiorilli.estudos.agenda.servico;

import br.com.fiorilli.estudos.agenda.modelo.Agenda;
import br.com.fiorilli.estudos.agenda.modelo.Nota;

public interface CrudAgendaInterface {

	public Nota inserir();

	public void alterar(Agenda agenda);

	public void listar(Agenda agenda);

	public void remover(Agenda agenda);

}

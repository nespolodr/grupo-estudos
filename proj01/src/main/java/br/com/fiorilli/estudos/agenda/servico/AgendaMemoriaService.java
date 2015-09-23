package br.com.fiorilli.estudos.agenda.servico;

import java.util.List;

import br.com.fiorilli.estudos.agenda.modelo.Nota;
import br.com.fiorilli.estudos.agenda.repo.EntityManager;
import br.com.fiorilli.estudos.agenda.repo.EntityManagerMemoria;

public class AgendaMemoriaService implements AgendaInterface {

	private EntityManager entityManager = new EntityManagerMemoria();

	@Override
	public Nota inserir(Nota nota) {
		return entityManager.persist(nota);
	}

	@Override
	public Nota alterar(Nota nota) {
		return entityManager.merge(nota);
	}

	@Override
	public List<Nota> listar() {
		return entityManager.listAll();
	}

	@Override
	public void remover(Nota nota) {
		entityManager.remove(nota);
	}
}

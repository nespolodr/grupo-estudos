package br.com.fiorilli.estudos.agenda.servico;

import java.util.List;

import br.com.fiorilli.estudos.agenda.modelo.Nota;
import br.com.fiorilli.estudos.agenda.repo.EntityManager;
import br.com.fiorilli.estudos.agenda.repo.EntityManagerDisco;

public class AgendaDiscoService implements AgendaInterface {

	private EntityManager entityManager = new EntityManagerDisco();

	@Override
	public Nota inserir(Nota nota) {
		Nota inserir = entityManager.persist(nota);
		return inserir;
	}

	@Override
	public Nota alterar(Nota nota) {
		return entityManager.merge(nota);
	}

	@Override
	public List<Nota> listar() {
		List<Nota> listar = entityManager.listAll();
		listar.forEach(s -> System.out.println(s));
		return listar;
	}

	@Override
	public void remover(Nota nota) {
		entityManager.remove(nota);
	}
}

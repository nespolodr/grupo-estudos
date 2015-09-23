package br.com.fiorilli.estudos.agenda.repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.fiorilli.estudos.agenda.modelo.Agenda;
import br.com.fiorilli.estudos.agenda.modelo.Nota;

public class EntityManagerMemoria implements EntityManager {

	private Agenda agenda;

	public EntityManagerMemoria() {
		agenda = new Agenda();
		agenda.setNotas(new ArrayList<>());
	}

	@Override
	public Nota persist(Nota novaNota) {
		agenda.getNotas().add(novaNota);
		return novaNota;
	}

	@Override
	public List<Nota> listAll() {
		return agenda.getNotas();
	}

	@Override
	public Nota merge(Nota nota) {
		for (Nota n : agenda.getNotas()) {
			if (n.getId() == nota.getId()) {
				n = nota;
			}
		}
		return nota;
	}

	@Override
	public void remove(Nota nota) {
		for (Iterator<Nota> it = agenda.getNotas().iterator(); it.hasNext();) {
			Nota n = it.next();
			if (n.getId() == nota.getId()) {
				it.remove();
				return;
			}
		}
	}

	@Override
	public Nota find(long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Método não implementado ainda");
	}
}

package br.com.fiorilli.estudos.agenda.repo;

import java.util.List;

import br.com.fiorilli.estudos.agenda.modelo.Nota;

public interface EntityManager {
	
	public abstract Nota find(long id);

	public abstract Nota persist(Nota novaNota);

	public abstract List<Nota> listAll();

	public abstract Nota merge(Nota nota);

	public abstract void remove(Nota nota);

}
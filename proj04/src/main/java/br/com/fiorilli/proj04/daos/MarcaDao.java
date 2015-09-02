package br.com.fiorilli.proj04.daos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.fiorilli.proj04.models.MarcaEntity;

public class MarcaDao {

	@Inject
	private EntityManager manager;

	public List<MarcaEntity> buscarTudoDeMarca() {
		
		return manager.createQuery(" select m from MarcaEntity m ",
				MarcaEntity.class).getResultList();
	}

}

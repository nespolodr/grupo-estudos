package br.com.fiorilli.proj04.daos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.fiorilli.proj04.models.MarcaEntity;

public class MarcaDao {

	@Inject
	private EntityManager manager;

	public List<MarcaEntity> buscarTudoDeMarca() {

		return manager.createQuery(" select m from MarcaEntity m ",
				MarcaEntity.class).getResultList();
	}

	public void insert(MarcaEntity marca) {

		EntityTransaction transaction = manager.getTransaction();
		try {

			transaction.begin();

			manager.persist(marca);

			transaction.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (transaction.isActive())
				transaction.rollback();
		}

	}

	public void alterar(MarcaEntity marca) {
		
		


		EntityTransaction transaction = manager.getTransaction();
		try {

			transaction.begin();

			manager.merge(marca);

			transaction.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (transaction.isActive())
				transaction.rollback();
		}

	}

	public void excluir(MarcaEntity marcaSelecionada) {
		
		EntityTransaction transaction = manager.getTransaction();
		try {

			transaction.begin();


			manager.remove(manager.merge(marcaSelecionada));

			transaction.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (transaction.isActive())
				transaction.rollback();
		}
		
	}

}

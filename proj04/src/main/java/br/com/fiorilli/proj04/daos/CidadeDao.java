package br.com.fiorilli.proj04.daos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.fiorilli.proj04.models.CidadeEntity;

public class CidadeDao {
	@Inject
	private EntityManager manager;

	public List<CidadeEntity> buscarTudoDeCidade() {

		return manager.createQuery(" select c from CidadeEntity c ",
				CidadeEntity.class).getResultList();
	}
	
	public void insert(CidadeEntity cidade) {

		EntityTransaction transaction = manager.getTransaction();
		try {

			transaction.begin();

			manager.persist(cidade);

			transaction.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (transaction.isActive())
				transaction.rollback();
		}

	}
	
	public void alterar(CidadeEntity cidade) {
		
		EntityTransaction transaction = manager.getTransaction();
		try {

			transaction.begin();

			manager.merge(cidade);

			transaction.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (transaction.isActive())
				transaction.rollback();
		}

	}
	
	public void excluir(CidadeEntity cidadeSelecionada) {
		
		EntityTransaction transaction = manager.getTransaction();
		try {

			transaction.begin();


			manager.remove(manager.merge(cidadeSelecionada));

			transaction.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (transaction.isActive())
				transaction.rollback();
		}
		
	}
}

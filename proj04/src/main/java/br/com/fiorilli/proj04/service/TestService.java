package br.com.fiorilli.proj04.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.fiorilli.proj04.daos.ProductDao;

@ApplicationScoped
public class TestService {

	@Inject
	private ProductDao productDao;

	public String test() {
		System.out.println(productDao.all());
		return "Teste";
	}
}

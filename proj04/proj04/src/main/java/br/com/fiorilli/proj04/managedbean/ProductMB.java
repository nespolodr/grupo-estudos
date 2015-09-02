package br.com.fiorilli.proj04.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.fiorilli.proj04.service.TestService;

@ManagedBean
@ViewScoped
public class ProductMB implements Serializable {

	@Inject
	private TestService service;

	private static final long serialVersionUID = 1L;

	public String getTeste() {
		return "Teste ok";
	}

	public String callEejb() {
		String hello = service.test();
		return hello;
	}

}

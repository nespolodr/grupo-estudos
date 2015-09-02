package br.com.fiorilli.proj04.managedbean;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.fiorilli.proj04.models.MarcaEntity;
import br.com.fiorilli.proj04.service.MarcasService;
import br.com.fiorilli.proj04.service.TestService;

@ManagedBean
@ViewScoped
public class ProductMB implements Serializable {

	@Inject
	private TestService service;
	
	@Inject
	private MarcasService servicoDeMarcas;

	private static final long serialVersionUID = 1L;

	public String getTeste() {
		return "Teste ok";
	}

	public String callEejb() {
		String hello = service.test();
		return hello;
	}
	
	public String buscarMarcas(){
		
		List<MarcaEntity> resultado = servicoDeMarcas.listarTodasAsMarcas();
		
		String resultadoFinal = "";
		
		for(MarcaEntity marca : resultado)
		{
			resultadoFinal = resultadoFinal + marca.getNome() + "\n";
		}
		
		return resultadoFinal;
	}

}

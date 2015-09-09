package br.com.fiorilli.proj04.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.fiorilli.proj04.models.MarcaEntity;
import br.com.fiorilli.proj04.service.MarcasService;

@ManagedBean
@ViewScoped
public class MarcaMB implements Serializable {

	@Inject
	private MarcasService marcaService;

	private static final long serialVersionUID = 1L;

	private MarcaEntity marca = new MarcaEntity();

	public MarcaEntity getMarca() {
		return marca;
	}

	public void setMarca(MarcaEntity marca) {
		this.marca = marca;
	}

	public void salvarMarca() {

		// SALVAR no banco!!

		marcaService.salvarMarca(marca);
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO, "Sucesso",
				"registro salvo com sucesso");

		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		facesMessage.setDetail("Outra mensagem");

		System.out.println("nome: " + marca.getNome());
		marca = new MarcaEntity();
	}
}

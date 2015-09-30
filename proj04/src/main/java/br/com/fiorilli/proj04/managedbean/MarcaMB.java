package br.com.fiorilli.proj04.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.fiorilli.proj04.models.MarcaEntity;
import br.com.fiorilli.proj04.service.MarcasService;

@ManagedBean
@ViewScoped
public class MarcaMB implements Serializable {

	@Inject
	private MarcasService marcaService;

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{loginMB}")
	private LoginMB loginMB;

	@PostConstruct
	public void validarUsuarioLogado() throws IOException {

		if (loginMB != null && StringUtils.isNotBlank(loginMB.getUsuario())) {
			// ok
			System.out.println("USUARIO LOGADO!!!!");
		} else {

			String path = FacesContext.getCurrentInstance()
					.getExternalContext().getApplicationContextPath();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(path + "/" + "login.xhtml?sessaoExpirada=true");
		}
	}

	public LoginMB getLoginMB() {
		return loginMB;
	}

	public void setLoginMB(LoginMB loginMB) {
		this.loginMB = loginMB;
	}

	private List<MarcaEntity> listaMarcas;

	private MarcaEntity marca = new MarcaEntity();

	public MarcaEntity getMarca() {
		return marca;
	}

	public void setMarca(MarcaEntity marca) {
		this.marca = marca;
	}

	public void salvarMarca() throws IOException {

		// SALVAR no banco!!

		marcaService.salvarMarca(marca);
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO, "Sucesso",
				"registro salvo com sucesso");

		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		facesMessage.setDetail("Outra mensagem");

		System.out.println("nome: " + marca.getNome());
		marca = new MarcaEntity();

		String path = FacesContext.getCurrentInstance().getExternalContext()
				.getApplicationContextPath();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect(path + "/" + "listarMarcas.xhtml");
	}

	public void editarMarca() throws IOException {

		marcaService.alterarMarca(marca);

		String path = FacesContext.getCurrentInstance().getExternalContext()
				.getApplicationContextPath();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect(path + "/" + "listarMarcas.xhtml");
	}

	public List<MarcaEntity> getListaMarcas() {

		List<MarcaEntity> marcasDoBanco = marcaService.listarTodasAsMarcas();

		listaMarcas = marcasDoBanco;

		return listaMarcas;
	}

	public void excluirMarca(MarcaEntity marcaSelecionada) {
		marcaService.excluirMarca(marcaSelecionada);
	}

	public void setListaMarcas(List<MarcaEntity> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}

	public void selecionar(MarcaEntity marcaSelecionada) {
		marca = marcaSelecionada;
	}
}

package br.com.fiorilli.proj04.managedbean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String USUARIO_VALIDO = "FIORILLI";
	private static final String SENHA_VALIDO = "123";

	private String usuario;
	private String senha;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void logar() {

		if (USUARIO_VALIDO.equals(usuario) && SENHA_VALIDO.equals(senha)) {

			String path = FacesContext.getCurrentInstance()
					.getExternalContext().getApplicationContextPath();
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect(path + "/" + "listarMarcas.xhtml");
			} catch (IOException e) {
				FacesMessage facesMessage = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Falha",
						"erro interno do servidor");
				FacesContext.getCurrentInstance()
						.addMessage(null, facesMessage);
			}
		} else {

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha",
							"Usuario ou senha invalida"));
		}

	}
}

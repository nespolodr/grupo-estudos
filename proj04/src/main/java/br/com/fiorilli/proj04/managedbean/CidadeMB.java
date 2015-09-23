package br.com.fiorilli.proj04.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.fiorilli.proj04.models.CidadeEntity;
import br.com.fiorilli.proj04.service.CidadeService;

@ManagedBean
@SessionScoped
public class CidadeMB implements Serializable {

	@Inject
	private CidadeService cidadeService;
	
	private static final long serialVersionUID = 1L;
	
	private List<CidadeEntity> listaCidades;
	
	
	private CidadeEntity cidade = new CidadeEntity();

	public CidadeEntity getCidade() {
		if(cidade ==  null)
			cidade = new CidadeEntity();
		return cidade;
	}

	public void setCidade(CidadeEntity cidade) {
		this.cidade = cidade;
	}
	
	public void inserir() throws IOException
	{
		cidade = new CidadeEntity();

		String path = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
		FacesContext.getCurrentInstance().getExternalContext().redirect(path + "/" + "manutencaoCidade.xhtml");
	}

	public List<CidadeEntity> getListaCidades() {
		
		List<CidadeEntity> cidadeDoBanco = cidadeService.listarTodasAsCidade();
		
		listaCidades = cidadeDoBanco;
		
		return listaCidades;
	}

	public void setListaCidades(List<CidadeEntity> listaCidades) {
		this.listaCidades = listaCidades;
	}
	
	public void excluirCidade(CidadeEntity cidadeSelecionada)
	{
		cidadeService.excluirCidade(cidadeSelecionada);
		cidade = new CidadeEntity();
	}

	public void selecionar(CidadeEntity cidadeSelecionada)
	{
		cidade = cidadeSelecionada;
	}

	public void editarCidade() throws IOException{

		cidadeService.alterarCidade(cidade);
		
		String path = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
		FacesContext.getCurrentInstance().getExternalContext().redirect(path + "/" + "listarCidades.xhtml");
	}
	
	public void salvarCidade() throws IOException {

		// SALVAR no banco!!

		cidadeService.salvarCidade(cidade);
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO, "Sucesso",
				"registro salvo com sucesso");

		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		facesMessage.setDetail("Outra mensagem");

		System.out.println("nome: " + cidade.getNome());
		cidade = new CidadeEntity();
		
		String path = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
		FacesContext.getCurrentInstance().getExternalContext().redirect(path + "/" + "listarCidades.xhtml");
	}
}

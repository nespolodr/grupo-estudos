package br.com.fiorilli.proj04.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.fiorilli.proj04.daos.CidadeDao;
import br.com.fiorilli.proj04.models.CidadeEntity;

@ApplicationScoped
public class CidadeService {

	@Inject
	private CidadeDao cidadeDao;
	
	public List<CidadeEntity> listarTodasAsCidade(){
		
		List<CidadeEntity> resultado = cidadeDao.buscarTudoDeCidade();
		
		return resultado;
		
	}
	
	public void salvarCidade(CidadeEntity cidade) {
		
		if(cidade != null)
		{
			cidadeDao.insert(cidade);
		}
		
	}
	
	public void alterarCidade(CidadeEntity cidade) {
		cidadeDao.alterar(cidade);
		
	}
	
	public void excluirCidade(CidadeEntity cidadeSelecionada) {
		
		if(cidadeSelecionada != null)
		{
			cidadeDao.excluir(cidadeSelecionada);
		}
		
	}

}

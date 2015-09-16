package br.com.fiorilli.proj04.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.fiorilli.proj04.daos.MarcaDao;
import br.com.fiorilli.proj04.models.MarcaEntity;

@ApplicationScoped
public class MarcasService {

	@Inject
	private MarcaDao marcaDao;
	
	public List<MarcaEntity> listarTodasAsMarcas(){
		
		List<MarcaEntity> resultado = marcaDao.buscarTudoDeMarca();
		
		return resultado;
		
	}

	public void salvarMarca(MarcaEntity marca) {
		
		if(marca != null)
		{
			if(marca.getAtivo() == true)
			{
				marcaDao.insert(marca);
			}
		}
		
	}

	public void alterarMarca(MarcaEntity marca) {
		marcaDao.alterar(marca);
		
	}

	public void excluirMarca(MarcaEntity marcaSelecionada) {
		
		if(marcaSelecionada != null)
		{
			marcaDao.excluir(marcaSelecionada);
		}
		
	}
	
}

package br.com.fiorilli.proj04.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fiorilli.estudos.agenda.modelo.Nota;
import br.com.fiorilli.estudos.agenda.servico.AgendaDiscoService;
import br.com.fiorilli.estudos.agenda.servico.AgendaInterface;
import br.com.fiorilli.proj04.models.MarcaEntity;

@ManagedBean
@ViewScoped
public class AgendaMB {

	private AgendaInterface service;

	private List<Nota> listaNota;

	@PostConstruct
	public void init() {

		// AQUI VOCE ALTERA ENTRE DISCO E MEMORIA
		service = new AgendaDiscoService();
		// service = new AgendaMemoriaService();
	}

	public List<Nota> getListaNota() {

		listaNota = service.listar();
		return listaNota;
	}

	public void setListaNota(List<Nota> listaNota) {
		this.listaNota = listaNota;
	}
}

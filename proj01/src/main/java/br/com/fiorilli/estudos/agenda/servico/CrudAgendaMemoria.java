package br.com.fiorilli.estudos.agenda.servico;

import java.util.Date;
import java.util.Scanner;

import br.com.fiorilli.estudos.agenda.modelo.Agenda;
import br.com.fiorilli.estudos.agenda.modelo.Nota;

public class CrudAgendaMemoria implements CrudAgendaInterface {

	private Scanner scan;

	public CrudAgendaMemoria() {
		scan = new Scanner(System.in);
	}

	@Override
	public Nota inserir() {
		System.out.println("Vou inserir nota na agenda");

		Nota nota = new Nota();

		System.out.print("Digite o titulo da nota:");
		nota.setTitulo(scan.next());

		System.out.print("Digite o descrição da nota:");
		nota.setDescricao(scan.next());

		nota.setId(Nota.gerarProximoId());
		nota.setData(new Date());

		return nota;
	}

	@Override
	public void alterar(Agenda agenda) {
		System.out.println("Vou alterar nota na agenda");

		listar(agenda);

		Nota notaParaAlterar = null;

		System.out.print("Digite qual nota você quer alterar:");
		int idParaAlterar = scan.nextInt();

		for (int i = 0; i < agenda.getNotas().size(); i++) {
			Nota notaAtual = agenda.getNotas().get(i);
			if (notaAtual.getId() == idParaAlterar) {
				notaParaAlterar = notaAtual;
				break;
			}
		}

		System.out.print("Digite o novo titulo da nota:");
		notaParaAlterar.setTitulo(scan.next());

		System.out.print("Digite a nova descrição da nota:");
		notaParaAlterar.setDescricao(scan.next());

	}

	@Override
	public void listar(Agenda agenda) {
		System.out.println("Vou listar as notas da agenda");

		agenda.getNotas().forEach(s -> System.out.println(s));
	}

	@Override
	public void remover(Agenda agenda) {
		System.out.println("Vou remover nota na agenda");

		listar(agenda);

		System.out.print("Digite qual nota você quer remover:");
		int idParaRemover = scan.nextInt();

		for (Nota nota : agenda.getNotas()) {
			if (nota.getId() == idParaRemover) {
				agenda.getNotas().remove(nota);
				break;
			}
		}
	}
}

package br.com.fiorilli.estudos.agenda;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.fiorilli.estudos.agenda.modelo.Agenda;
import br.com.fiorilli.estudos.agenda.modelo.Nota;
import br.com.fiorilli.estudos.agenda.servico.CrudAgendaArquivoTexto;
import br.com.fiorilli.estudos.agenda.servico.CrudAgendaInterface;
import br.com.fiorilli.estudos.agenda.servico.CrudAgendaMemoria;

public class MainClass {

	public static void main(String[] args) {

		Agenda agenda = new Agenda();
		ArrayList<Nota> notas = new ArrayList<>();
		agenda.setNotas(notas);

		Scanner scan = new Scanner(System.in);

//		CrudAgendaInterface crud = new CrudAgendaMemoria();
		CrudAgendaInterface crud = new CrudAgendaArquivoTexto();

		loop1: while (true) {
			System.out.println("Escolha uma opção: ");
			System.out.println("[1] Listar");
			System.out.println("[2] Inserir");
			System.out.println("[3] Alterar");
			System.out.println("[4] Excluir");
			System.out.println("[0] Sair");

			int valorDigitado = scan.nextInt();

			loop2: switch (valorDigitado) {
			case 1:
			case 5:
				crud.listar(agenda);
				break;
			case 2:
				Nota inserir = crud.inserir();
				notas.add(inserir);
				break;
			case 3:
				crud.alterar(agenda);
				break;
			case 4:
				crud.remover(agenda);
				break;
			case 0:
				System.exit(0);
				break;
			case 99:
				break loop1;
			default:
				System.out.println("Opção Inválida");
				break;
			}

		}
		scan.close();
	}

}

package br.com.fiorilli.estudos.agenda;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import br.com.fiorilli.estudos.cadeira.Cadeira;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("oiii");

		Cadeira cadeira = new Cadeira();

		System.out.println(cadeira);

		Agenda agenda = new Agenda();
		ArrayList<Nota> notas = new ArrayList<>();
		agenda.setNotas(notas);

		Scanner scan = new Scanner(System.in);

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
				listar(agenda);
				break;
			case 2:
				Nota inserir = inserir(scan);
				notas.add(inserir);
				break;
			case 3:
				alterar(scan);
				break;
			case 4:
				remover();
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

	private static void alterar(Scanner scan) {
		System.out.println("Vou alterar nota na agenda");

	}

	private static void remover() {
		System.out.println("Vou remover nota na agenda");

	}

	private static Nota inserir(Scanner scan) {
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

	private static void listar(Agenda agenda) {
		System.out.println("Vou listar as notas da agenda");

		agenda.getNotas().forEach(s -> System.out.print(s));
	}

}

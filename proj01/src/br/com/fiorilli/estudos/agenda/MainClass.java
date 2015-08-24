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
				alterar(scan, agenda);
				break;
			case 4:
				remover(scan, agenda);
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

	private static void alterar(Scanner scan, Agenda agenda) {
		System.out.println("Vou alterar nota na agenda");
		
		listar(agenda);
		
		Nota notaParaAlterar = null;

		System.out.print("Digite qual nota você quer alterar:");
		int idParaAlterar = scan.nextInt();
		
		for(int i = 0; i < agenda.getNotas().size() ; i++)
		{
			Nota notaAtual = agenda.getNotas().get(i);
			if(notaAtual.getId() == idParaAlterar)
			{
				notaParaAlterar = notaAtual;
				break;
			}
		}
		
		
		System.out.print("Digite o novo titulo da nota:");
		notaParaAlterar.setTitulo(scan.next());

		System.out.print("Digite a nova descrição da nota:");
		notaParaAlterar.setDescricao(scan.next());

	}

	private static void remover(Scanner scan, Agenda agenda) {
		System.out.println("Vou remover nota na agenda");

		listar(agenda);

		System.out.print("Digite qual nota você quer remover:");
		int idParaRemover = scan.nextInt();
		
		for(Nota nota : agenda.getNotas())
		{
			if(nota.getId() == idParaRemover)
			{
				agenda.getNotas().remove(nota);
				break;
			}
		}
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

		agenda.getNotas().forEach(s -> System.out.println(s));
	}

}

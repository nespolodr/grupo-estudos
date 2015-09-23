package br.com.fiorilli.estudos.agenda;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.fiorilli.estudos.agenda.modelo.Nota;
import br.com.fiorilli.estudos.agenda.servico.AgendaDiscoService;
import br.com.fiorilli.estudos.agenda.servico.AgendaInterface;

/**
 * Classe que executa a agenda com interface em CONSOLE
 */
public class MainClass {

	private AgendaInterface service;
	private Scanner scan;

	/**
	 * Construtor do programa.
	 */
	public MainClass() {
		scan = new Scanner(System.in);

		// AQUI VOCE ALTERA ENTRE DISCO E MEMORIA
		service = new AgendaDiscoService();
		// service = new AgendaMemoriaService();
	}

	public static void main(String[] args) {
		MainClass main = new MainClass();
		main.executarPrograma();
	}

	/**
	 * Método principal do programa <br/>
	 * INTERFACE: CONSOLE
	 */
	private void executarPrograma() {

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
				listar(service);
				break;
			case 2:
				inserir(service);
				break;
			case 3:
				alterar(service);
				break;
			case 4:
				remover(service);
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

	public void inserir(AgendaInterface service) {
		System.out.println("Vou inserir nota na agenda");

		Nota nota = new Nota();

		System.out.print("Digite o titulo da nota:");
		nota.setTitulo(scan.next());

		System.out.print("Digite o descrição da nota:");
		nota.setDescricao(scan.next());

		nota.setId(Nota.gerarProximoId());
		nota.setData(new Date());

		service.inserir(nota);
	}

	public void alterar(AgendaInterface service) {
		System.out.println("Vou alterar nota na agenda");

		List<Nota> listar = this.listar(service);

		Nota notaParaAlterar = null;

		System.out.print("Digite qual nota você quer alterar:");
		int idParaAlterar = scan.nextInt();

		for (int i = 0; i < listar.size(); i++) {
			Nota notaAtual = listar.get(i);
			if (notaAtual.getId() == idParaAlterar) {
				notaParaAlterar = notaAtual;
				break;
			}
		}

		System.out.print("Digite o novo titulo da nota:");
		notaParaAlterar.setTitulo(scan.next());

		System.out.print("Digite a nova descrição da nota:");
		notaParaAlterar.setDescricao(scan.next());

		service.alterar(notaParaAlterar);
	}

	public List<Nota> listar(AgendaInterface service) {
		System.out.println("Vou listar as notas da agenda");

		List<Nota> listar = service.listar();

		listar.forEach(s -> System.out.println(s));
		return listar;
	}

	public void remover(AgendaInterface service) {
		System.out.println("Vou remover nota na agenda");

		List<Nota> listar = this.listar(service);

		System.out.print("Digite qual nota você quer remover:");
		int idParaRemover = scan.nextInt();

		Nota notaParaRemover = null;
		for (Nota nota : listar) {
			if (nota.getId() == idParaRemover) {
				notaParaRemover = nota;
				break;
			}
		}

		service.remover(notaParaRemover);
	}
}

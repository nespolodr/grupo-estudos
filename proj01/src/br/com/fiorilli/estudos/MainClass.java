package br.com.fiorilli.estudos;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("oiii");

		Cadeira cadeira = new Cadeira();

		System.out.println(cadeira);

		Agenda agenda = new Agenda();
		ArrayList<Nota> notas = new ArrayList<>();
		agenda.setNotas(notas);

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("Escolha uma opção: ");
			System.out.println("[1] Listar");
			System.out.println("[2] Inserir");
			System.out.println("[3] Alterar");
			System.out.println("[4] Excluir");
			System.out.println("[0] Sair");

			int valorDigitado = scan.nextInt();

			switch (valorDigitado) {
			case 1:
				listar();
				break;
			case 2:
				inserir();
				break;
			case 3:
				alterar();
				break;
			case 4:
				remover();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}
		}
	}

	private static void alterar() {
		// TODO Auto-generated method stub

	}

	private static void remover() {
		// TODO Auto-generated method stub

	}

	private static void inserir() {
		// TODO Auto-generated method stub

	}

	private static void listar() {
		// TODO Auto-generated method stub

	}

}

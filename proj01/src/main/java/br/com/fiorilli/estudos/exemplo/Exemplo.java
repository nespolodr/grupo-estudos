package br.com.fiorilli.estudos.exemplo;

import java.util.Arrays;
import java.util.List;

public class Exemplo {

	public Exemplo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new Exemplo().exemploFor();
	}

	private void exemploFor() {
		Integer[] valores = { 2, 3, 4, 63, 3, 4, 6, 7, 8 };

		// qualquer versao - for comum
		for (int i = 0; i < valores.length; i++) {
			System.out.println(valores[i]);

		}

		// java 1.5 enhanced for
		for (int i : valores) {
			System.out.println(i);
		}

		// java 1.8 - lambda
		List<Integer> teste = Arrays.asList(valores);
		teste.forEach(s -> System.out.println(s));
	}
}

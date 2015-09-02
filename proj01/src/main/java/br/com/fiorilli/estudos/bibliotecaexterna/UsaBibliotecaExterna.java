package br.com.fiorilli.estudos.bibliotecaexterna;

import org.apache.commons.lang3.StringUtils;

public class UsaBibliotecaExterna {
	public static void main(String[] args) {

		String teste = "Hoje eh segunda-feira";
		
		String left = StringUtils.left(teste, 10);

		System.out.println(teste);
		System.out.println(left);
	}
}

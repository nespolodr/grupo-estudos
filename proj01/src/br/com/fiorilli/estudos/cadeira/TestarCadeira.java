package br.com.fiorilli.estudos.cadeira;

public class TestarCadeira {

	public TestarCadeira() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cadeira cadeira = new Cadeira("vermelho", "escritorio");
		cadeira.quemSouEu();
		
		Poltrona poltrona = new Poltrona("vermelho", "escritorio", true);
		poltrona.quemSouEu();
		
		((Cadeira)poltrona).quemSouEu();
	}

}

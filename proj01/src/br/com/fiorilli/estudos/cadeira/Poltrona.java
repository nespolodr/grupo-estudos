package br.com.fiorilli.estudos.cadeira;

public class Poltrona extends Cadeira {

	private Boolean reclinavel;
	private Boolean esquenta;

	public Poltrona(String cor, String tipo, boolean reclinavel, boolean esquenta) {
		this(cor, tipo, reclinavel);
		this.esquenta = esquenta;
	}

	public Poltrona(String cor, String tipo, boolean reclinavel) {
		super(cor, tipo);
		this.reclinavel = reclinavel;
		super.getCor();

	}

	public Poltrona() {
	}

	@Override
	public void quemSouEu() {
		// TODO Auto-generated method stub
		super.quemSouEu();

		System.out.println("e também EU sou uma poltrona");
	}

	public Boolean getEsquenta() {
		return esquenta;
	}

	public void setEsquenta(Boolean esquenta) {
		this.esquenta = esquenta;
	}

	public Boolean getReclinavel() {
		return reclinavel;
	}

	public void setReclinavel(Boolean reclinavel) {
		this.reclinavel = reclinavel;
	}

}

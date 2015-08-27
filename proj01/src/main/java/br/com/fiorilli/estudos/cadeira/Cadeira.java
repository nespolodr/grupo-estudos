package br.com.fiorilli.estudos.cadeira;

public class Cadeira {

	public Cadeira(String cor, String tipo) {
		this.cor = cor;
		this.tipo = tipo;
	}

	public Cadeira() {
		// TODO Auto-generated constructor stub
	}

	public void quemSouEu(){
		System.out.println("Eu sou uma cadeira");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Cadeira [pes=" + pes + ", cor=" + cor + ", tipo=" + tipo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadeira other = (Cadeira) obj;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	private int pes;
	private String cor;
	private String tipo;

	public int getPes() {
		return pes;
	}

	public void setPes(int pes) {
		this.pes = pes;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}

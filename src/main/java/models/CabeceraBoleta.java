package models;

public class CabeceraBoleta {
	private String numbol;
	private int codcli;
	private String fechabol;
	@Override
	public String toString() {
		return "CabeceraBoleta [numbol=" + numbol + ", codcli=" + codcli + ", fechabol=" + fechabol + "]";
	}
	public String getNumbol() {
		return numbol;
	}
	public void setNumbol(String numbol) {
		this.numbol = numbol;
	}
	public int getCodcli() {
		return codcli;
	}
	public void setCodcli(int codcli) {
		this.codcli = codcli;
	}
	public String getFechabol() {
		return fechabol;
	}
	public void setFechabol(String fechabol) {
		this.fechabol = fechabol;
	}


}

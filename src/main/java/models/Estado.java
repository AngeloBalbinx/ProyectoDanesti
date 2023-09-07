package models;

public class Estado {
	private int codestado;
	private String descripcion;
	@Override
	public String toString() {
		return "Estado [codestado=" + codestado + ", descripcion=" + descripcion + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public int getCodestado() {
		return codestado;
	}
	public void setCodestado(int codestado) {
		this.codestado = codestado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}

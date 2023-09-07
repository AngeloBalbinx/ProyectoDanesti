package models;

public class TipoUsuario {
	private int idtipo;
	private String descripcion;
	@Override
	public String toString() {
		return "TipoUsuario [idtipo=" + idtipo + ", descripcion=" + descripcion + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public int getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}

package models;

public class CajaProducto {
	private int codcaja;
	private String descripcion;
	private int codproveedor;
	@Override
	public String toString() {
		return "CajaProducto [codcaja=" + codcaja + ", descripcion=" + descripcion + ", codproveedor=" + codproveedor
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public int getCodcaja() {
		return codcaja;
	}
	public void setCodcaja(int codcaja) {
		this.codcaja = codcaja;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCodproveedor() {
		return codproveedor;
	}
	public void setCodproveedor(int codproveedor) {
		this.codproveedor = codproveedor;
	}


}

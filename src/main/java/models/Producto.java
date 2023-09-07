package models;

public class Producto {
	private String codprod;
	private String nombre;
	private String descripcion;
	private int codcaja;
	private double precio;
	private int stock;
	private int estado;
	private String descripEstado;
	@Override
	public String toString() {
		return "Producto [codprod=" + codprod + ", nombre=" + nombre + ", descripcion=" + descripcion + ", codcaja="
				+ codcaja + ", precio=" + precio + ", stock=" + stock + ", estado=" + estado + "]";
	}
	public String getCodprod() {
		return codprod;
	}
	public void setCodprod(String codprod) {
		this.codprod = codprod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCodcaja() {
		return codcaja;
	}
	public void setCodcaja(int codcaja) {
		this.codcaja = codcaja;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getDescripEstado() {
		return descripEstado;
	}
	public void setDescripEstado(String descripEstado) {
		this.descripEstado = descripEstado;
	}

}

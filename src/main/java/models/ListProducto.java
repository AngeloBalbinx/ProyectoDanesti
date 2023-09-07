package models;

public class ListProducto {
	private String codprod;
	private String nombre;
	private String descripcion;
	private double precio;
	private int stock;
	private String desc_estado;
	private String desc_categ;
	@Override
	public String toString() {
		return "ListProducto [codprod=" + codprod + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + ", stock=" + stock + ", desc_estado=" + desc_estado + ", desc_categ=" + desc_categ + "]";
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
	public String getDesc_estado() {
		return desc_estado;
	}
	public void setDesc_estado(String desc_estado) {
		this.desc_estado = desc_estado;
	}
	public String getDesc_categ() {
		return desc_categ;
	}
	public void setDesc_categ(String desc_categ) {
		this.desc_categ = desc_categ;
	}


}

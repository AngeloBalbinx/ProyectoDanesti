package models;

public class Venta {
	private int item;
	private int codcli;
	private int codvend;
	private String codprod;
	private String numbol;
	private String descripcion;
	private String fechabol;
	private double precio;
	private int cant;
	private double subtotal;
	private double monto;
	private int estado;
	@Override
	public String toString() {
		return "Venta [item=" + item + ", codcli=" + codcli + ", codvend=" + codvend + ", codprod=" + codprod
				+ ", numbol=" + numbol + ", descripcion=" + descripcion + ", fechabol=" + fechabol + ", precio="
				+ precio + ", cant=" + cant + ", subtotal=" + subtotal + ", monto=" + monto + ", estado=" + estado
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public int getCodcli() {
		return codcli;
	}
	public void setCodcli(int codcli) {
		this.codcli = codcli;
	}
	public int getCodvend() {
		return codvend;
	}
	public void setCodvend(int codvend) {
		this.codvend = codvend;
	}
	public String getCodprod() {
		return codprod;
	}
	public void setCodprod(String codprod) {
		this.codprod = codprod;
	}
	public String getNumbol() {
		return numbol;
	}
	public void setNumbol(String numbol) {
		this.numbol = numbol;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechabol() {
		return fechabol;
	}
	public void setFechabol(String fechabol) {
		this.fechabol = fechabol;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}


}

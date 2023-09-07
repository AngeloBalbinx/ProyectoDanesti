package models;

public class DetalleBoleta {
	private String codprod;
	private double preciovta;
	private int cantidad;
	private String nombre;
	private String descripcion;
	private double importe;
	@Override
	public String toString() {
		return "DetalleBoleta [codprod=" + codprod + ", preciovta=" + preciovta + ", cantidad=" + cantidad + ", nombre="
				+ nombre + ", descripcion=" + descripcion + ", importe=" + importe + "]";
	}
	public String getCodprod() {
		return codprod;
	}
	public void setCodprod(String codprod) {
		this.codprod = codprod;
	}
	public double getPreciovta() {
		return preciovta;
	}
	public void setPreciovta(double preciovta) {
		this.preciovta = preciovta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}





}

package interfaces;

import java.util.ArrayList;

import models.ListProducto;
import models.Producto;



public interface ProductoInterface {
	public int registrar(Producto p);
	public int actualizar(Producto p);
	public int eliminar(Producto p);
	public Producto listarCodigo(String cod);
	public ArrayList<Producto> listado();
	public ArrayList<Producto> reportListado();
	void exportListado(String filePath);
	public Producto buscar(String codigo);
	public int actualizarStock(String cod,int stock);
	public Producto buscarP(String codigo);
	public ArrayList<ListProducto> listadoProd();
}

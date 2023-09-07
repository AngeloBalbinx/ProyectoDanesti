package interfaces;

import java.util.ArrayList;

import models.CabeceraBoleta;
import models.DetalleBoleta;
import models.Venta;

public interface VentaInterface {
	public String generaNumBoleta();
	public int realizarVenta(CabeceraBoleta cab, ArrayList<DetalleBoleta> det);
	public int guardarCabBol(Venta ve);
	public int guardarDetalleBol(Venta venta);
}

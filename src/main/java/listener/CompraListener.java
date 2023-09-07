package listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import models.DetalleBoleta;
import models.Venta;

/**
 * Application Lifecycle Listener implementation class CompraListener
 *
 */
@WebListener
public class CompraListener implements HttpSessionListener {

    /**
     * Default constructor.
     */
    public CompraListener() {

    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    @Override
	public void sessionCreated(HttpSessionEvent arg0)  {
    	   System.out.println("Id de sesion a crear: " + arg0.getSession().getId());
           ArrayList<DetalleBoleta> carro = new ArrayList<>();
           double subTotalVenta = 0;
           int cantArticulos = 0;
           arg0.getSession().setAttribute("carro", carro);
           arg0.getSession().setAttribute("subTotalVenta", subTotalVenta);
           arg0.getSession().setAttribute("cantArticulos", cantArticulos);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    @Override
	public void sessionDestroyed(HttpSessionEvent arg0)  {
    	System.out.println("Id de sesion a eliminar: " + arg0.getSession().getId());
    	List<Venta>lista= new ArrayList<>();
    	lista.clear();

    }

}

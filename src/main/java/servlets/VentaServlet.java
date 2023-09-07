package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import models.CabeceraBoleta;
import models.DetalleBoleta;
import models.Producto;
import models.Usuario;

/**
 * Servlet implementation class VentaServlet
 */
@WebServlet(name = "venta", description = "Finaliza la venta por parte del cliente", urlPatterns = { "/venta" })
public class VentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingresó al Servlet de Venta");
		// Servlet que controla varios procesos
		String option = request.getParameter("option");
		switch (option) {
		case "agregar":
			agregarCompra(request, response);
			break;
		case "eliminar":
			eliminarCompra(request, response);
			break;
		case "finalizar":
			finalizarCompra(request, response);
		default:
		}

	}

	private void finalizarCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al servlet venta");
		CabeceraBoleta c = new CabeceraBoleta();

		Usuario u = (Usuario) request.getSession().getAttribute("u");
		if (u == null) {
			request.setAttribute("mensaje", "<script>swal('Mensaje','Para finalizar la compra, debe ingresar a su cuenta','error');</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		c.setCodcli(u.getCodigo());
//		c.setFecha_bol(getServletInfo());
//		c.setNum_bol(getServletInfo());

		@SuppressWarnings("unchecked")
		ArrayList<DetalleBoleta> carro = (ArrayList<DetalleBoleta>) request.getSession().getAttribute("carro");

		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		int ok = fabrica.getVentaDAO().realizarVenta(c, carro);

		if(ok == 0) {
			request.setAttribute("mensaje", "<script>swal('Mensaje','Error en la venta','error');</script>");
			request.getRequestDispatcher("carritocompra.jsp").forward(request, response);
		} else {
			request.setAttribute("mensaje", "<script>swal('Mensaje','Venta realizada exitosamente','success');</script>");
			request.getRequestDispatcher("carritocompra.jsp").forward(request, response);

			request.getSession().setAttribute("carro", new ArrayList<DetalleBoleta>());
			request.getSession().setAttribute("subTotalVenta", 0.0);
			request.getSession().setAttribute("cantArticulos", 0);
		}
	}

	private void eliminarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String codigo = request.getParameter("codigo");
		@SuppressWarnings("unchecked")
		ArrayList<DetalleBoleta> carro = (ArrayList<DetalleBoleta>) request.getSession().getAttribute("carro");
		double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
		int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");
		for (DetalleBoleta d : carro) {
			if (d.getCodprod().equals(codigo)) {
				// actualizamos
				cantArticulos -= d.getCantidad();
				subTotalVenta -= d.getImporte();
				carro.remove(d);


				break;
			}
		}
		request.getSession().setAttribute("carro", carro);
		request.getSession().setAttribute("subTotalVenta", subTotalVenta);
		request.getSession().setAttribute("cantArticulos", cantArticulos);
		response.sendRedirect("carritocompra.jsp");

	}

	private void agregarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// leer los datos del producto seleccionado para "agregarlo" al carro de compra
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		// la información del producto enviado como atributo de sesion
		Producto p = (Producto) request.getSession().getAttribute("p");
		// agregar al carro de compra el producto seleccionado y su cantidad
		DetalleBoleta d = new DetalleBoleta();
		d.setCodprod(p.getCodprod());
		d.setNombre(p.getNombre());
		d.setDescripcion(p.getDescripcion());
		d.setPreciovta(p.getPrecio());
		d.setCantidad(cantidad);
		d.setImporte(d.getCantidad() * d.getPreciovta());

		@SuppressWarnings("unchecked")
		ArrayList<DetalleBoleta> carro = (ArrayList<DetalleBoleta>) request.getSession().getAttribute("carro");
		double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
		int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");

		carro.add(d);
		subTotalVenta += d.getImporte();
		cantArticulos += d.getCantidad();

		request.getSession().setAttribute("carro", carro);
		request.getSession().setAttribute("subTotalVenta", subTotalVenta);
		request.getSession().setAttribute("cantArticulos", cantArticulos);
		response.sendRedirect("carritocompra.jsp");

	}

}

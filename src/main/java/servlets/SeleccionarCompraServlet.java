package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import models.Producto;

/**
 * Servlet implementation class SeleccionarCompraServlet
 */
@WebServlet(name = "add", description = "Selecciona el producto que el cliente quiere comprar", urlPatterns = { "/add" })
public class SeleccionarCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeleccionarCompraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró en el Servlet de AgregarSeleccionado");
		// capturar el código del producto seleccionado en el catálogo
		String codigo = request.getParameter("codigo");
		// obtener un obj de Producto y enviarlo como atributo de sesión -- > pag compra
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		Producto p = fabrica.getProductoDAO().buscar(codigo);
		request.getSession().setAttribute("p", p);
		response.sendRedirect("formulariocompra.jsp");
	}

}

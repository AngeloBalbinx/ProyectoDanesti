package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import models.ListProducto;

/**
 * Servlet implementation class CatalogoServlet
 */
@WebServlet(name = "verCatalogo", description = "Permite al usuario seguir añadiendo más productos", urlPatterns = { "/verCatalogo" })
public class CatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al servlet Catalogo");

		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ArrayList<ListProducto> catalogo = fabrica.getProductoDAO().listadoProd();

		request.setAttribute("lstProductos", catalogo);
		request.getRequestDispatcher("catalogo.jsp").forward(request, response);
	}

}

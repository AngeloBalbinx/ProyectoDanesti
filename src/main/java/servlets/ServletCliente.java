package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import models.Producto;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet(description = "Controla las vistas del cliente", urlPatterns = { "/servletcliente" })
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menu = request.getParameter("menu");
		String accion = request.getParameter("accion");
		if(menu.equals("Inicio")) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if(menu.equals("Catalogo")) {
			switch(accion) {
			case "Listar":
				DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				ArrayList<Producto> lstProductos = fabrica.getProductoDAO().listado();
				request.setAttribute("lstProductos", lstProductos);
				request.getRequestDispatcher("catalogo.jsp").forward(request, response);
				break;

	}

}
		}}


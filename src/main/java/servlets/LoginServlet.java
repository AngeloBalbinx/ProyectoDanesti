package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import models.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "ingreso", description = "Valida datos del login", urlPatterns = { "/ingreso" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("txtUsuario");
		String clave = request.getParameter("txtClave");
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		Usuario u = fabrica.getUsuarioDAO().validarAcceso(usuario, clave);

		if (u!=null) {

			System.out.println("Id de la session:" + request.getSession().getId());

			request.getSession().setAttribute("u", u); // envia el atributo a nivel de session
			request.setAttribute("mensaje", "<script>swal('Mensaje','Bienvenido','success');</script>");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}else {

			request.setAttribute("mensaje", "<script>swal('Mensaje','Usuario o clave incorrecto','error');</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}


}

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
 * Servlet implementation class RegistroServlet
 */
@WebServlet(name = "registro", description = "Registro de un nuevo usuario", urlPatterns = { "/registro" })
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		switch(accion) {
		case "Registrar":
			registrar(request,response);
		}
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje = "";
		String url;
		String nombre = request.getParameter("txtNombre");
		String ape = request.getParameter("txtApellido");
		String usr = request.getParameter("txtUsuario");
		String clave = request.getParameter("txtClave");
		String fnac = request.getParameter("txtFnac");

		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.setApellido(ape);
		u.setUsuario(usr);
		u.setClave(clave);
		u.setFnacim(fnac);


		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		int ok = fabrica.getClienteDAO().registrar(u);
		//salida
		if (ok == 0) {
			mensaje += "<script>swal('Error al registrar los datos','Revisar los campos', 'error');</script>";
			url = "registro.jsp";
		}else {
			mensaje = "<script>swal('Registro del usuario exitoso','Ya puede ingresar al sistema !', 'success');</script>";
			url = "login.jsp";
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

}

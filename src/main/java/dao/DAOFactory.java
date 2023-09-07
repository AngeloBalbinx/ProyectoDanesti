package dao;



import interfaces.CajaProductoInterface;
import interfaces.ClienteInterface;
import interfaces.EstadoInterface;
import interfaces.ProductoInterface;
import interfaces.TipoUsuarioInterface;
import interfaces.UsuarioInterface;
import interfaces.VentaInterface;


// clase encargada de construir los accesos a las BD
public abstract class DAOFactory {
		public static final int MYSQL = 1;
		public static final int SQL = 2;

		// creamos metodos para "encapsular" al implementacion

		public abstract UsuarioInterface getUsuarioDAO();
		public abstract TipoUsuarioInterface getTipoUsuarioDAO();
		public abstract ProductoInterface getProductoDAO();
		public abstract CajaProductoInterface getCajaProductoDAO();
		public abstract EstadoInterface getEstadoDAO();
		public abstract VentaInterface getVentaDAO();
		public abstract ClienteInterface getClienteDAO();

		// "constructor" static de la clase
		public static DAOFactory getDAOFactory(int qdb) {
			switch (qdb) {
			case MYSQL: {
				return new MySQLDAOFactory();
			}case SQL: {
				return new SQLDAOFactory();
			}
			default:
				return null;
			}

		}

}

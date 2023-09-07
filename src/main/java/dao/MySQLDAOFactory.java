package dao;



import interfaces.CajaProductoInterface;
import interfaces.ClienteInterface;
import interfaces.EstadoInterface;
import interfaces.ProductoInterface;
import interfaces.TipoUsuarioInterface;
import interfaces.UsuarioInterface;
import interfaces.VentaInterface;
import mantenimientos.GestionCajaProductoMySQL;
import mantenimientos.GestionClienteMySQL;
import mantenimientos.GestionEstadoMySQL;
import mantenimientos.GestionProductoMySQL;
import mantenimientos.GestionTipoUsuarioMySQL;
import mantenimientos.GestionUsuarioMySQL;
import mantenimientos.GestionVentaMySQL;


public class MySQLDAOFactory extends DAOFactory {




	@Override
	public UsuarioInterface getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new GestionUsuarioMySQL();
	}




	@Override
	public TipoUsuarioInterface getTipoUsuarioDAO() {
		// TODO Auto-generated method stub
		return new GestionTipoUsuarioMySQL();
	}




	@Override
	public ProductoInterface getProductoDAO() {
		// TODO Auto-generated method stub
		return new GestionProductoMySQL();
	}




	@Override
	public CajaProductoInterface getCajaProductoDAO() {
		// TODO Auto-generated method stub
		return new GestionCajaProductoMySQL();
	}




	@Override
	public EstadoInterface getEstadoDAO() {
		// TODO Auto-generated method stub
		return new GestionEstadoMySQL();
	}




	@Override
	public VentaInterface getVentaDAO() {
		// TODO Auto-generated method stub
		return new GestionVentaMySQL();
	}




	@Override
	public ClienteInterface getClienteDAO() {
		// TODO Auto-generated method stub
		return new GestionClienteMySQL();
	}






}

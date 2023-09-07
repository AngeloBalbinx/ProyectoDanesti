package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.UsuarioInterface;
import models.Usuario;
import utils.MySQLConexion;

public class GestionUsuarioMySQL implements UsuarioInterface {

	@Override
	public Usuario validarAcceso(String usuario, String clave) {
		Usuario u = null;

		// Plantilla --> búsqueda
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_usuarios where usuario=? and clave=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, clave);
			rs = pst.executeQuery();
			// pasar el contenido del "rs" a la variable
			while (rs.next()) {// lee el contenido de cada fila
				u = new Usuario();
				u.setCodigo(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setUsuario(rs.getString(4));
				u.setClave(rs.getString(5));
				u.setFnacim(rs.getString(6));
				u.setIdtipo(rs.getInt(7));

			}

		} catch (Exception e) {
			System.out.println("Error en validarAcceso: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return u;
	}

	@Override
	public int registrar(Usuario u) {
		int rs =0;

		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_usuarios values(null,?,?,?,?,?,?);";
			pst = con.prepareStatement(sql);
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido());
			pst.setString(3, u.getUsuario());
			pst.setString(4, u.getClave());
			pst.setString(5, u.getFnacim());
			pst.setInt(6, u.getIdtipo());
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en registrar:" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int actualizar(Usuario u) {
		int rs =0;

		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "update tb_usuarios set nombre = ?,apellido= ?,usuario = ?,clave= ?,fnacim=?,idtipo=? where codigo= ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido());
			pst.setString(3, u.getUsuario());
			pst.setString(4, u.getClave());
			pst.setString(5, u.getFnacim());
			pst.setInt(6, u.getIdtipo());
			pst.setInt(7, u.getCodigo());
			rs = pst.executeUpdate();

				} catch (Exception e) {
					System.out.println("Error en actualizar:" + e.getMessage());
				} finally {
					MySQLConexion.closeConexion(con);
				}
		return rs;
	}

	@Override
	public int eliminar(int cod) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "delete from tb_usuarios where codigo ="+cod;
			pst = con.prepareStatement(sql);
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en eliminar:" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public ArrayList<Usuario> listado() {
		ArrayList<Usuario> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySQLConexion.getConexion();
			String sql = "select * from tb_usuarios";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setCodigo(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setUsuario(rs.getString(4));
				u.setClave(rs.getString(5));
				u.setFnacim(rs.getString(6));
				u.setIdtipo(rs.getInt(7));
				lista.add(u);

			}

		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

	@Override
	public ArrayList<Usuario> reportListado() {
		ArrayList<Usuario> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst =null;
		ResultSet rs=null;

		try {

			con=MySQLConexion.getConexion();
			String sql="SELECT u.codigo, u.nombre, u.apellido, u.usuario, u.clave, u.fnacim, t.descripcion AS tipo FROM tb_usuarios u JOIN tb_tipos t ON u.idTipo = t.idTipo;";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			while (rs.next()) {

				Usuario u = new Usuario();
				u.setCodigo(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setUsuario(rs.getString(4));
				u.setClave(rs.getString(5));
				u.setFnacim(rs.getString(6));
				u.setDescripTipo(rs.getString(7));
				lista.add(u);
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia "+e.getMessage());
		} finally {
			try {
				if(pst !=null)pst.close();
				if(rs !=null)rs.close();
				if(con !=null)con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar "+e2.getMessage());
			}
		}

		return lista;
	}

	@Override
	public Usuario listarCodigo(int cod) {
		Usuario u = new Usuario();
		String sql = "select * from tb_usuarios where codigo="+cod;

			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setUsuario(rs.getString(4));
				u.setClave(rs.getString(5));
				u.setFnacim(rs.getString(6));
				u.setIdtipo(rs.getInt(7));

			}

		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return u;
	}

	@Override
	public Usuario buscar(int codigo) {
		Usuario u = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_usuarios where codigo = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, codigo);
			rs = pstm.executeQuery();

			// pasar el contenido del "rs" a la variable
			while (rs.next()) { //lee el contenido de cada fila
				u = new Usuario();
				u.setCodigo(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setUsuario(rs.getString(4));
				u.setClave(rs.getString(5));
				u.setFnacim(rs.getString(6));
				u.setIdtipo(rs.getInt(7));
			}

		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucción SQL - Buscar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return u;
	}


}

package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import interfaces.ClienteInterface;
import models.Usuario;
import utils.MySQLConexion;

public class GestionClienteMySQL implements ClienteInterface {

	@Override
	public int registrar(Usuario u) {
		int rs =0;

		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_usuarios values(null,?,?,?,?,?,default);";
			pst = con.prepareStatement(sql);
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido());
			pst.setString(3, u.getUsuario());
			pst.setString(4, u.getClave());
			pst.setString(5, u.getFnacim());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en registrar:" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

}

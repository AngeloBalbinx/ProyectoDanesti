package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.TipoUsuarioInterface;
import models.TipoUsuario;
import utils.MySQLConexion;

public class GestionTipoUsuarioMySQL implements TipoUsuarioInterface {

	@Override
	public ArrayList<TipoUsuario> listado() {
		ArrayList<TipoUsuario> lista = new ArrayList<>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM tb_tipos";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				TipoUsuario t = new TipoUsuario();
				t.setIdtipo(rs.getInt(1));
				t.setDescripcion(rs.getString(2));

				lista.add(t);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}

}

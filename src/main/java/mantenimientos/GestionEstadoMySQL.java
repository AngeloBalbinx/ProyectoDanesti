package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.EstadoInterface;
import models.Estado;
import utils.MySQLConexion;

public class GestionEstadoMySQL implements EstadoInterface {

	@Override
	public ArrayList<Estado> listado() {
		ArrayList<Estado> lista = new ArrayList<>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_estado";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				Estado e = new Estado();
				e.setCodestado(rs.getInt(1));
				e.setDescripcion(rs.getString(2));

				lista.add(e);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}


}

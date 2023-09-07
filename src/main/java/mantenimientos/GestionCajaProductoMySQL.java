package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.CajaProductoInterface;
import models.CajaProducto;
import utils.MySQLConexion;


public class GestionCajaProductoMySQL implements CajaProductoInterface{

	@Override
	public ArrayList<CajaProducto> listado() {
		ArrayList<CajaProducto> lista = new ArrayList<>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_caja";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				CajaProducto cp = new CajaProducto();
				cp.setCodcaja(rs.getInt(1));
				cp.setDescripcion(rs.getString(2));
				cp.setCodproveedor(rs.getInt(3));
				lista.add(cp);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}

}

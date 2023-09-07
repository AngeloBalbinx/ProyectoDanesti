package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.VentaInterface;
import models.CabeceraBoleta;
import models.DetalleBoleta;
import models.Venta;
import utils.MySQLConexion;

public class GestionVentaMySQL implements VentaInterface{
	int r;
	@Override
	public String generaNumBoleta() {
String codigo = "B0001";

		// Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select substr(max(NUMBOL),2) from tb_cab_boleta";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {
				codigo = String.format("B%04d", rs.getInt(1) + 1);
			}
		} catch (Exception e) {
			System.out.println("Error en generaNumBoleta : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return codigo;
	}

	@Override
	public int realizarVenta(CabeceraBoleta cab, ArrayList<DetalleBoleta> det) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
		try {
			con = MySQLConexion.getConexion();

			con.setAutoCommit(false);
			cab.setNumbol(generaNumBoleta());
			String sql1 = "insert into tb_cab_boleta values (?,?,curdate())";
			pst1 = con.prepareStatement(sql1);
			pst1.setString(1, generaNumBoleta());
			pst1.setInt(2, cab.getCodcli());
			rs = pst1.executeUpdate();

			String sql2 = "insert into tb_detalle_boleta values (?,?,?,?)";
			String sql3 = "update tb_producto set stock = stock - ? where codprod = ?";
			for (DetalleBoleta d : det) {
				pst2 = con.prepareStatement(sql2);
				pst2.setString(1, cab.getNumbol());
				pst2.setString(2, d.getCodprod());
				pst2.setInt(3, d.getCantidad());
				pst2.setDouble(4, d.getPreciovta());
				rs += pst2.executeUpdate();

				pst3 = con.prepareStatement(sql3);
				pst3.setInt(1, d.getCantidad());
				pst3.setString(2, d.getCodprod());

				rs += pst3.executeUpdate();
			}

			con.commit();
		} catch (Exception e) {
			System.out.println("Error en registrar : " + e.getMessage());
			rs = 0;
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("Error al cerrar : " + e1.getMessage());
			}
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int guardarCabBol(Venta ve) {
		String sql="insert into tb_cab_boleta values(?,?,curdate())";
		Connection con = null;
		PreparedStatement pst = null;


		try {
			con = MySQLConexion.getConexion();
			pst=con.prepareStatement(sql);
			pst.setString(1, ve.getNumbol());
			pst.setInt(2, ve.getCodcli());
			pst.executeUpdate();
			r=1;
		} catch (Exception e) {
			System.out.println("Error al Guardar CabBol: " + e.getMessage());
		}
		return r;
	}


	@Override
	public int guardarDetalleBol(Venta venta) {

	    Connection con = null;
	    PreparedStatement pst = null;
	    int r=0;
	    String sql ="insert into tb_detalle_boleta values(?,?,?,?)";
	    try {
	        con = MySQLConexion.getConexion();
	        pst = con.prepareStatement(sql);
	        pst.setString(1, venta.getNumbol());
	        pst.setString(2, venta.getCodprod());
	        pst.setInt(3, venta.getCant());
	        pst.setDouble(4, venta.getPrecio());
	        pst.executeUpdate();
	        r = 1;

	    } catch (Exception e) {
	        System.out.println("Error al Guardar DetBol: " + e.getMessage());
	    } finally {
	        // Cerrar los recursos (pst y con) aquí si es necesario
	    }
	    return r;
	}

}

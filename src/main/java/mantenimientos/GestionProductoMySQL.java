package mantenimientos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import interfaces.ProductoInterface;
import models.ListProducto;
import models.Producto;
import utils.MySQLConexion;

public class GestionProductoMySQL implements ProductoInterface{
int r;
	@Override
	public int registrar(Producto p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_producto values (?,?, ?, ?, ?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getCodprod());
			pst.setString(2, p.getNombre());
			pst.setString(3, p.getDescripcion());
			pst.setInt(4, p.getCodcaja());
			pst.setDouble(5, p.getPrecio());
			pst.setInt(6, p.getStock());
			pst.setInt(7, p.getEstado());
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en registrar:" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int actualizar(Producto p) {
		int rs =0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "update tb_producto set  nombre=?,descripcion = ?, codcaja = ?,precio = ?,stock = ?,estado=? where codprod= ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getDescripcion());
			pst.setInt(3, p.getCodcaja());
			pst.setDouble(4, p.getPrecio());
			pst.setInt(5, p.getStock());
			pst.setInt(6, p.getEstado());
			pst.setString(7, p.getCodprod());
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en actualizar:" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
return rs;
	}

	@Override
	public int eliminar(Producto p) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "delete from tb_producto where codprod =?";
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getCodprod());
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en eliminar:" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public ArrayList<Producto> listado() {
		ArrayList<Producto> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySQLConexion.getConexion();
			String sql = "select * from tb_producto";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				Producto p = new Producto();
				p.setCodprod(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setCodcaja(rs.getInt(4));
				p.setPrecio(rs.getDouble(5));
				p.setStock(rs.getInt(6));
				p.setEstado(rs.getInt(7));
				lista.add(p);

			}

		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

	@Override
    public ArrayList<Producto> reportListado() {
        ArrayList<Producto> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySQLConexion.getConexion();
            String sql = "SELECT p.codprod, p.nombre, p.descripcion, p.precio, p.stock, e.descripcion AS estado_descripcion FROM tb_producto p JOIN tb_estado e ON p.estado = e.codestado;";
            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setCodprod(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setDescripEstado(rs.getString(6));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error en listado: " + e.getMessage());
        } finally {
            MySQLConexion.closeConexion(con);
        }
        return lista;
    }

    @Override
    public void exportListado(String filePath) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            ArrayList<Producto> lista = reportListado();

            for (Producto producto : lista) {
                Paragraph paragraph = new Paragraph();
                paragraph.add("Código: " + producto.getCodprod());
                paragraph.add("\nNombre: " + producto.getNombre());
                paragraph.add("\nDescripción: " + producto.getDescripcion());
                paragraph.add("\nPrecio: " + producto.getPrecio());
                paragraph.add("\nStock: " + producto.getStock());
                paragraph.add("\nEstado: " + producto.getDescripEstado());
                paragraph.add("\n\n");
                document.add(paragraph);
            }
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
	@Override
	public Producto buscar(String codigo) {
		Producto p = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_producto where codprod=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			rs = pst.executeQuery();

			while (rs.next()) {
				p = new Producto();
				p.setCodprod(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setCodcaja(rs.getInt(4));
				p.setPrecio(rs.getDouble(5));
				p.setStock(rs.getInt(6));
				p.setEstado(rs.getInt(7));

			}

		} catch (Exception e) {
			System.out.println("Error en buscar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return p;
	}

	@Override
	public Producto listarCodigo(String cod) {
		Producto p = new Producto();
		String sql = "select * from tb_producto where codprod="+cod;

			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				p.setCodprod(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setCodcaja(rs.getInt(4));
				p.setPrecio(rs.getDouble(5));
				p.setStock(rs.getInt(6));
				p.setEstado(rs.getInt(7));

			}

		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return p;
	}

	@Override
	public int actualizarStock(String cod, int stock) {
		String sql="update tb_producto set stock=stock+? where codprod=?";
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement(sql);
			pst.setInt(1, stock);
			pst.setString(2, cod);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en actualizar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return r;
	}

	@Override
	public Producto buscarP(String codigo) {
		Producto p = new Producto();
		String sql = "select * from tb_producto where codprod="+codigo;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				p.setCodprod(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setCodcaja(rs.getInt(4));
				p.setPrecio(rs.getDouble(5));
				p.setStock(rs.getInt(6));
				p.setEstado(rs.getInt(7));

			}

		} catch (Exception e) {

		} finally {
			MySQLConexion.closeConexion(con);
		}
		return p;
	}

	@Override
	public ArrayList<ListProducto> listadoProd() {
		ArrayList<ListProducto> catalogo = new ArrayList<>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "call proc_listarProd()";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				ListProducto p = new ListProducto();
				p.setCodprod(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setDesc_categ(rs.getString(4));
				p.setPrecio(rs.getDouble(5));
				p.setStock(rs.getInt(6));
				p.setDesc_estado(rs.getString(7));

				catalogo.add(p);
			}

		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return catalogo;
	}


}

package servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import dao.DAOFactory;
import mantenimientos.GestionProductoMySQL;
import mantenimientos.GestionUsuarioMySQL;
import mantenimientos.GestionVentaMySQL;
import models.Producto;
import models.Usuario;
import models.Venta;




/**
 * Servlet implementation class ControladorVistas
 */
@WebServlet(name = "controlador", description = "Controla las vistas", urlPatterns = { "/controlador" })
public class ControladorVistas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Usuario u = new Usuario();
       GestionUsuarioMySQL gu = new GestionUsuarioMySQL();
       GestionProductoMySQL gp = new GestionProductoMySQL();
       Producto p = new Producto();
       int cod;
       String codigo;
       Venta v = new Venta();
       List<Venta>lista= new ArrayList<>();
       int item;
       String codprod;
       String desc;
       double precio;
       int cant;
       double subTotal;
       double totalPagar;
       String numbol=null;
       GestionVentaMySQL gv = new GestionVentaMySQL();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorVistas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menu = request.getParameter("menu");
		String accion = request.getParameter("accion");
		if(menu.equals("Inicio")) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if(menu.equals("Producto")) {
			switch(accion) {
			case "Listar":
				DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				ArrayList<Producto> lstProductos = fabrica.getProductoDAO().listado();
				request.setAttribute("lstProductos", lstProductos);
				request.getRequestDispatcher("producto.jsp").forward(request, response);
				break;
			case "Registrar":
				String cod = request.getParameter("txtCodigo");
				String nom = request.getParameter("txtNombre");
				String desc = request.getParameter("txtDescripcion");
				int cc=  Integer.parseInt(request.getParameter("cboTamanio"));
				double pre = Double.parseDouble(request.getParameter("txtPrecio"));
				int stock = Integer.parseInt(request.getParameter("txtStock"));
				int est = Integer.parseInt(request.getParameter("cboEstado"));

				Producto p = new Producto();
				p.setCodprod(cod);
				p.setNombre(nom);
				p.setDescripcion(desc);
				p.setCodcaja(cc);
				p.setPrecio(pre);
				p.setStock(stock);
				p.setEstado(est);

				fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				int ok = fabrica.getProductoDAO().registrar(p);

				if (ok == 0) {
					request.setAttribute("mensaje", "<div class='alert alert-danger'role='alert'>"
							+ "Error al registrar producto" + p.getCodprod() + "! </div>");
				} else {
					request.setAttribute("mensaje", "<div class='alert alert-success'role='alert'>" + "Producto "
							+ p.getNombre() + " Registrado! </div>");
				}
				request.getRequestDispatcher("controlador?menu=Producto&accion=Listar").forward(request, response);
				break;
			case "Actualizar":
				 cod = request.getParameter("txtCodigo");
				 nom = request.getParameter("txtNombre");
				 desc = request.getParameter("txtDescripcion");
				 cc=  Integer.parseInt(request.getParameter("cboTamanio"));
				 pre = Double.parseDouble(request.getParameter("txtPrecio"));
				 stock = Integer.parseInt(request.getParameter("txtStock"));
				 est = Integer.parseInt(request.getParameter("cboEstado"));

				 p = new Producto();
				 p.setCodprod(cod);
				 p.setNombre(nom);
				 p.setDescripcion(desc);
				 p.setCodcaja(cc);
				 p.setPrecio(pre);
				 p.setStock(stock);
				 p.setEstado(est);

				 fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				 ok = fabrica.getProductoDAO().actualizar(p);

				if (ok==0) {
					request.setAttribute("mensaje", "<div class='alert alert-danger'role='alert'>"
							+ "Error al actualizar producto" + p.getCodprod() + "! </div>");
				}else {
					request.setAttribute("mensaje", "<div class='alert alert-success'role='alert'>"
							+ "Producto " + p.getNombre() + " Actualizado! </div>");
				}
				request.getRequestDispatcher("controlador?menu=Producto&accion=Listar").forward(request, response);
				break;

			case "Eliminar":

					codigo = request.getParameter("cod");
					p = new Producto();
					p.setCodprod(codigo);
					 fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
					 ok = fabrica.getProductoDAO().eliminar(p);

					if (ok==0) {
						request.setAttribute("mensaje", "<script>swal('Error al eliminar el producto','Inténtelo de nuevo', 'error');</script>");
					}else {
						request.setAttribute("mensaje", "<script>swal('Producto eliminado!','', 'success');</script>");
					}
					request.getRequestDispatcher("controlador?menu=Producto&accion=Listar").forward(request, response);
					break;
			case "Editar":
				cod = request.getParameter("cod");
				fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				p = fabrica.getProductoDAO().buscar(cod);

				request.setAttribute("p", p);
				request.getRequestDispatcher("controlador?menu=Producto&accion=Listar").forward(request, response);
				break;


			}

		}
		if(menu.equals("Usuario")) {
			switch(accion) {
			case "Listar":
				DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				ArrayList<Usuario> lstUsuarios = fabrica.getUsuarioDAO().listado();
				request.setAttribute("lstUsuarios", lstUsuarios);
				request.getRequestDispatcher("usuario.jsp").forward(request, response);
				break;

			case "Registrar":

				String nombre = request.getParameter("txtNombre");
				String ape = request.getParameter("txtApellido");
				String usr = request.getParameter("txtUsuario");
				String clave = request.getParameter("txtClave");
				String fnac = request.getParameter("txtFnac");
				int tipo= Integer.parseInt(request.getParameter("cboTipo"));

				Usuario u = new Usuario();
				u.setNombre(nombre);
				u.setApellido(ape);
				u.setUsuario(usr);
				u.setClave(clave);
				u.setFnacim(fnac);
				u.setIdtipo(tipo);


				int ok = gu.registrar(u);
				//salida
				if (ok == 0) {
					request.setAttribute("mensaje",
							"<div class ='alert alert-danger' role='alert'>"
							+ "Error al registrar usuario " + u.getCodigo() + " !</div>");
				}else {
					request.setAttribute("mensaje",
							"<div class ='alert alert-success' role='alert'>"
							+ "Usuario " + u.getNombre() + " Registrado!</div>");
				}
				request.getRequestDispatcher("controlador?menu=Usuario&accion=Listar").forward(request, response);
				break;
			case "Editar":
				cod = Integer.parseInt(request.getParameter("cod"));
				u = gu.listarCodigo(cod);
				request.setAttribute("u", u);
				request.getRequestDispatcher("controlador?menu=Usuario&accion=Listar").forward(request, response);
				break;




			case "Actualizar":

				nombre = request.getParameter("txtNombre");
				ape = request.getParameter("txtApellido");
				usr = request.getParameter("txtUsuario");
				clave = request.getParameter("txtClave");
				fnac = request.getParameter("txtFnac");
				tipo= Integer.parseInt(request.getParameter("cboTipo"));

				//proceso --> actualizar el producto en su tabla
				u = new Usuario();
				u.setNombre(nombre);
				u.setApellido(ape);
				u.setUsuario(usr);
				u.setClave(clave);
				u.setFnacim(fnac);
				u.setIdtipo(tipo);
				u.setCodigo(cod);


				fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				ok = fabrica.getUsuarioDAO().actualizar(u);


				if (ok == 0) {
					request.setAttribute("mensaje",
							"<div class ='alert alert-danger' role='alert'>"
							+ "Error al actualizar el usuario " + u.getCodigo() + " !</div>");
				}else {
					request.setAttribute("mensaje",
							"<div class ='alert alert-success' role='alert'>"
							+ "Usuario " + u.getNombre() + " Actualizado!</div>");
				}
				request.getRequestDispatcher("controlador?menu=Usuario&accion=Listar").forward(request, response);


				break;
			case "Eliminar":
				cod = Integer.parseInt(request.getParameter("cod"));
				u = new Usuario();
				u.setCodigo(cod);
				fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				 ok = fabrica.getUsuarioDAO().eliminar(cod);
				//salida
				if (ok==0) {
					request.setAttribute("mensaje", "<script>swal('Error al eliminar el usuario','Inténtelo de nuevo', 'error');</script>");
				}else {
					request.setAttribute("mensaje", "<script>swal('Usuario Eliminado','', 'success');</script>");

				}

				request.getRequestDispatcher("controlador?menu=Usuario&accion=Listar").forward(request, response);

				break;
			default:
				throw new AssertionError();
			}
		}

		if(menu.equals("Reporte")) {
			switch(accion) {
			
			case "reportes":
				DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				ArrayList<Usuario> lstUsuarios = fabrica.getUsuarioDAO().reportListado();
				request.setAttribute("lstUsuarios", lstUsuarios);
				ArrayList<Producto> lstProductos = fabrica.getProductoDAO().reportListado();
				request.setAttribute("lstProductos", lstProductos);
				request.getRequestDispatcher("reportes.jsp").forward(request, response);
				break;

			case "exportarUsu":
			    // Obtener la lista de usuarios del atributo almacenado en el caso "reportes"
			    DAOFactory fabricaExport = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			    ArrayList<Usuario> lstUsuariosExport = fabricaExport.getUsuarioDAO().reportListado();

			    try {
			        // Crear documento PDF
			        Document document = new Document();
			        ByteArrayOutputStream baos = new ByteArrayOutputStream();
			        PdfWriter.getInstance(document, baos);

			        // Abrir documento
			        document.open();

			        // Agregar título al documento
			        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
			        Paragraph title = new Paragraph("Lista de Usuarios", titleFont);
			        title.setAlignment(Element.ALIGN_CENTER);
			        title.setSpacingBefore(20);
			        document.add(title);

			        // Crear tabla para los usuarios
			        PdfPTable table = new PdfPTable(7);
			        table.setWidthPercentage(100);
			        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
			        table.getDefaultCell().setBorderWidthBottom(0.5f);
			        table.getDefaultCell().setPadding(8);
			        Font cellFont = new Font(Font.FontFamily.HELVETICA, 10);

			        // Agregar encabezados de columna
			        PdfPCell headerCell = new PdfPCell(new Phrase("Código", cellFont));
			        headerCell.setBorder(Rectangle.BOTTOM);
			        table.addCell(headerCell);
			        headerCell = new PdfPCell(new Phrase("Nombre", cellFont));
			        headerCell.setBorder(Rectangle.BOTTOM);
			        table.addCell(headerCell);
			        headerCell = new PdfPCell(new Phrase("Apellido", cellFont));
			        headerCell.setBorder(Rectangle.BOTTOM);
			        table.addCell(headerCell);
			        headerCell = new PdfPCell(new Phrase("Usuario", cellFont));
			        headerCell.setBorder(Rectangle.BOTTOM);
			        table.addCell(headerCell);
			        headerCell = new PdfPCell(new Phrase("Clave", cellFont));
			        headerCell.setBorder(Rectangle.BOTTOM);
			        table.addCell(headerCell);
			        headerCell = new PdfPCell(new Phrase("F.Nacimiento", cellFont));
			        headerCell.setBorder(Rectangle.BOTTOM);
			        table.addCell(headerCell);
			        headerCell = new PdfPCell(new Phrase("Tipo", cellFont));
			        headerCell.setBorder(Rectangle.BOTTOM);
			        table.addCell(headerCell);

			        // Agregar filas de datos
			        for (Usuario usuario : lstUsuariosExport) {
			            PdfPCell cell = new PdfPCell(new Phrase(String.valueOf(usuario.getCodigo()), cellFont));
			            cell.setBorder(Rectangle.BOTTOM);
			            table.addCell(cell);
			            cell = new PdfPCell(new Phrase(usuario.getNombre(), cellFont));
			            cell.setBorder(Rectangle.BOTTOM);
			            table.addCell(cell);
			            cell = new PdfPCell(new Phrase(usuario.getApellido(), cellFont));
			            cell.setBorder(Rectangle.BOTTOM);
			            table.addCell(cell);
			            cell = new PdfPCell(new Phrase(usuario.getUsuario(), cellFont));
			            cell.setBorder(Rectangle.BOTTOM);
			            table.addCell(cell);
			            cell = new PdfPCell(new Phrase(usuario.getClave(), cellFont));
			            cell.setBorder(Rectangle.BOTTOM);
			            table.addCell(cell);
			            cell = new PdfPCell(new Phrase(usuario.getFnacim(), cellFont));
			            cell.setBorder(Rectangle.BOTTOM);
			            table.addCell(cell);
			            cell = new PdfPCell(new Phrase(usuario.getDescripTipo(), cellFont));
			            cell.setBorder(Rectangle.BOTTOM);
			            table.addCell(cell);
			        }

			        // Agregar tabla al documento
			        document.add(table);

			        // Cerrar documento
			        document.close();

			        // Enviar archivo PDF como respuesta
			        String filename = "usuarios.pdf";
			        response.setContentType("application/pdf");
			        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"; filename*=UTF-8''" + filename);
			        response.setContentLength(baos.size());
			        ServletOutputStream outputStream = response.getOutputStream();
			        baos.writeTo(outputStream);
			        outputStream.flush();
			        outputStream.close();
			    } catch (DocumentException e) {
			        e.printStackTrace();
			        // Manejar el error apropiadamente
			    } catch (IOException e) {
			        e.printStackTrace();
			        // Manejar el error apropiadamente
			    }
			    break;
			case "exportarPro":
			    // Obtener la lista de productos del atributo almacenado en el caso "reportes"
			    DAOFactory fabricaExportPro = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			    ArrayList<Producto> lstProductosExportPro = fabricaExportPro.getProductoDAO().reportListado();

			    try {
			        // Crear documento PDF
			        Document document = new Document();
			        ByteArrayOutputStream baos = new ByteArrayOutputStream();
			        PdfWriter.getInstance(document, baos);

			        // Abrir documento
			        document.open();

			        // Agregar título al documento
			        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
			        Paragraph title = new Paragraph("Lista de Productos", titleFont);
			        title.setAlignment(Element.ALIGN_CENTER);
			        title.setSpacingBefore(20);
			        document.add(title);

			        // Crear tabla para los productos
			        PdfPTable table = new PdfPTable(6);
			        table.setWidthPercentage(100);
			        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
			        table.getDefaultCell().setBorderWidthBottom(0.5f);
			        table.getDefaultCell().setPadding(8);
			        Font cellFont = new Font(Font.FontFamily.HELVETICA, 10);

			        // Agregar encabezados de columna
			        PdfPCell headerCell = new PdfPCell(new Phrase("Código", cellFont));
			        headerCell.setBorder(Rectangle.BOTTOM);
			        table.addCell(headerCell);
			        headerCell = new PdfPCell(new Phrase("Nombre", cellFont));
			        headerCell.setBorder(Rectangle.BOTTOM);
			        table.addCell(headerCell);
			        headerCell = new PdfPCell(new Phrase("Descripción", cellFont));
			        headerCell.setBorder(Rectangle.BOTTOM);
			        table.addCell(headerCell);
			        headerCell = new PdfPCell(new Phrase("Precio", cellFont));
			        headerCell.setBorder(Rectangle.BOTTOM);
			        table.addCell(headerCell);
			        headerCell = new PdfPCell(new Phrase("Stock", cellFont));
			        headerCell.setBorder(Rectangle.BOTTOM);
			        table.addCell(headerCell);
			        headerCell = new PdfPCell(new Phrase("Estado", cellFont));
			        headerCell.setBorder(Rectangle.BOTTOM);
			        table.addCell(headerCell);

			        // Agregar filas de datos
			        for (Producto producto : lstProductosExportPro) {
			            PdfPCell cell = new PdfPCell(new Phrase(producto.getCodprod(), cellFont));
			            cell.setBorder(Rectangle.BOTTOM);
			            table.addCell(cell);
			            cell = new PdfPCell(new Phrase(producto.getNombre(), cellFont));
			            cell.setBorder(Rectangle.BOTTOM);
			            table.addCell(cell);
			            cell = new PdfPCell(new Phrase(producto.getDescripcion(), cellFont));
			            cell.setBorder(Rectangle.BOTTOM);
			            table.addCell(cell);
			            cell = new PdfPCell(new Phrase(String.valueOf(producto.getPrecio()), cellFont));
			            cell.setBorder(Rectangle.BOTTOM);
			            table.addCell(cell);
			            cell = new PdfPCell(new Phrase(String.valueOf(producto.getStock()), cellFont));
			            cell.setBorder(Rectangle.BOTTOM);
			            table.addCell(cell);
			            cell = new PdfPCell(new Phrase(producto.getDescripEstado(), cellFont));
			            cell.setBorder(Rectangle.BOTTOM);
			            table.addCell(cell);
			        }

			        // Agregar tabla al documento
			        document.add(table);

			        // Cerrar documento
			        document.close();

			        // Enviar archivo PDF como respuesta
			        String filename = "productos.pdf";
			        response.setContentType("application/pdf");
			        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"; filename*=UTF-8''" + filename);
			        response.setContentLength(baos.size());
			        ServletOutputStream outputStream = response.getOutputStream();
			        baos.writeTo(outputStream);
			        outputStream.flush();
			        outputStream.close();
			    } catch (DocumentException e) {
			        e.printStackTrace();
			        // Manejar el error apropiadamente
			    } catch (IOException e) {
			        e.printStackTrace();
			        // Manejar el error apropiadamente
			    }
			    break;
			}
		}


		if(menu.equals("NuevaVenta")) {
			numbol= gv.generaNumBoleta();
			request.setAttribute("nBol", numbol);
			switch (accion) {

			case "BuscarCliente":
				int codigo = Integer.parseInt(request.getParameter("codigocliente"));

				u.setCodigo(codigo);
				DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				u = fabrica.getUsuarioDAO().buscar(codigo);

				request.setAttribute("u", u);

				request.setAttribute("p", p);

				break;
			case "BuscarProducto":
				String cp =request.getParameter("codigoproducto");

				p.setCodprod(cp);
				fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				p = fabrica.getProductoDAO().buscar(cp);
				request.setAttribute("u", u);
				request.setAttribute("p", p);
				request.setAttribute("lista", lista);
				request.setAttribute("totalPagar", totalPagar);

				break;
			case "Agregar":

			    totalPagar = 0.0;

			    int ultimoItem = 0;
			    if (!lista.isEmpty()) {
			        ultimoItem = lista.get(lista.size() - 1).getItem();
			    }

			    codprod = request.getParameter("codigoproducto"); // Obtener el valor del parámetro directamente
			    System.out.println("codprod: " + codprod);
			    desc = request.getParameter("nombreproducto");
			    precio = Double.parseDouble(request.getParameter("precio"));
			    cant = Integer.parseInt(request.getParameter("cant"));
			    subTotal = precio * cant;

			    v = new Venta();
			    v.setItem(ultimoItem + 1);
			    v.setCodprod(codprod);
			    v.setDescripcion(desc);
			    v.setPrecio(precio);
			    v.setCant(cant);
			    v.setSubtotal(subTotal);
			    lista.add(v);

			    for (Venta element : lista) {
			        totalPagar += element.getSubtotal();
			    }
			    request.setAttribute("u", u);
			    request.setAttribute("p", p);
			    request.setAttribute("lista", lista);
			    request.setAttribute("totalPagar", totalPagar);

			    break;


			case "GenerarVenta":
				System.out.println("Entró al proceso finalizar compra");

				//GUardar cabbol
				v.setCodcli(u.getCodigo());
				v.setNumbol(numbol);
				v.setFechabol(v.getFechabol());
			    int ok1=gv.guardarCabBol(v);

				//Guardar detbol
			    for (Venta element : lista) {
			    	Venta detalleVenta= new Venta();
			    	detalleVenta.setNumbol(numbol);
			    	detalleVenta.setCodprod(element.getCodprod());
			    	detalleVenta.setCant(element.getCant());
			    	detalleVenta.setPrecio(element.getPrecio());

			    	int ok2 =gv.guardarDetalleBol(detalleVenta);
			        System.out.println("Registrando producto: " + detalleVenta.getCodprod());

			    	System.out.println("Tamaño de la lista: " + lista.size());

			    	if(ok1==0 && ok2==0) {
						request.setAttribute("mensaje", "<script>swal('Mensaje','Inténtelo de nuevo','error');</script>");
						request.getRequestDispatcher("registrarventa.jsp").forward(request, response);
						request.setAttribute("lista", lista);
						request.setAttribute("totalPagar", totalPagar);

					}else {
						request.setAttribute("mensaje", "<script>swal('Mensaje','Venta realizada exitosamente','success');</script>");
						request.getRequestDispatcher("registrarventa.jsp").forward(request, response);
						request.setAttribute("lista", lista);
						request.setAttribute("totalPagar", totalPagar);
					}
			    }
			    		//Actualizaciòn del stock
				for (Venta element : lista) {

				Producto pr = new Producto();

				int cantidad = element.getCant();
				String codprod = element.getCodprod();
				GestionProductoMySQL gp = new GestionProductoMySQL();
				pr =gp.buscarP(codprod);
				int sac= pr.getStock()-cantidad;
				gp.actualizarStock(codprod, sac);


}

				break;
			case "Eliminar":

				int index=-1;
				for (int i = 0; i < lista.size(); i++) {
				    Venta venta = lista.get(i);
				    if (venta.getCodprod().equals(codprod)) {
				    	System.out.println("codprod: " + codprod);
				        index = i; // Encontrado, asignar el índice
				        break; // Salir del bucle
				    }
				}

				if (index >= 0 && index < lista.size()) {
			        Venta ventaEliminada = lista.remove(index);
			        totalPagar -= ventaEliminada.getSubtotal();

			  	  for (int i = index; i < lista.size(); i++) {
				        Venta venta = lista.get(i);
				        venta.setItem(venta.getItem() - 1); // Disminuir en 1 el número del producto

				    }


			    }

				totalPagar = 0.0;
				for (Venta element : lista) {
				    totalPagar += element.getSubtotal();

				}



				request.setAttribute("u", u);
				request.setAttribute("p", p);
				request.setAttribute("lista", lista);
				request.setAttribute("totalPagar", totalPagar);


				break;
			}



		request.getRequestDispatcher("registrarventa.jsp").forward(request, response);

		}
	}
}





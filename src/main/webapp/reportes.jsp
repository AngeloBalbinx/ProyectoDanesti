<%@page import="models.TipoUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAOFactory"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<header class="contenedor-header">
	<jsp:include page="header.jsp"></jsp:include>
</header>
<body>
	<div class="text-center">
		<br>
		<h1 class="h3 mb-3 font-weight-normal">Reporte de usuarios</h1>
		<br>
		<table class="table table-hover" id="tablaUsuarios">
			<thead>
				<tr>
					<th>Codigo</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Usuario</th>
					<th>Clave</th>
					<th>F.Nacimiento</th>
					<th>Tipo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${lstUsuarios }">
					<tr>
						<td>${u.getCodigo()}</td>
						<td>${u.getNombre()}</td>
						<td>${u.getApellido()}</td>
						<td>${u.getUsuario()}</td>
						<td>${u.getClave()}</td>
						<td>${u.getFnacim()}</td>
						<td>${u.getDescripTipo()}</td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<hr name="separador de reportes">
		
		<form action="controlador" method="GET">
    		<input type="hidden" name="menu" value="Reporte">
    		<input type="hidden" name="accion" value="exportarUsu">
   			<button class="btn btn-outline-success" type="submit">Exportar usuarios en pdf</button>
		</form>
		
		<hr name="separador de reportes">

		<div class="px-4 text-center">
			<h1 class="h3 mb-3 font-weight-normal">Reporte de productos</h1>
			<table class="table table-hover">
				<thead>
					<tr>
						<th></th>
						<th>Codigo</th>
						<th>Nombre</th>
						<th>Descripcion</th>
						<th>Precio</th>
						<th>Stock</th>
						<th>Estado</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${lstProductos}">
						<tr>
							<td></td>
							<td>${p.getCodprod()}</td>
							<td>${p.getNombre()}</td>
							<td>${p.getDescripcion()}</td>
							<td>${p.getPrecio()}</td>
							<td>${p.getStock()}</td>
							<td>${p.getDescripEstado()}</td>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
			
			<hr name="separador de reportes">
		
		<form action="controlador" method="GET">
    		<input type="hidden" name="menu" value="Reporte">
    		<input type="hidden" name="accion" value="exportarPro">
   			<button class="btn btn-outline-success" type="submit">Exportar productos en pdf</button>
		</form>
		
		<hr name="separador de reportes">
</body>
<footer class="contenedor-footer">
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</html>
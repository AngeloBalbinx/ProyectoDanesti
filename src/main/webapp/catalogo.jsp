<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link href="./css/estiloscatalogo.css" rel="stylesheet">
</head>
<header class="contenedor-header">
		<jsp:include page="header.jsp"></jsp:include>
	</header>
<body>
	<div class="gifcontitulo">
	<img src="./img/pizzagif.gif" alt="Descripción del GIF">
		<h2>Catálogo de productos</h2>
		
	</div>
		<hr class="orange-hr">
	<div class="container">
		<div class="row" style="margin-bottom: 20px;margin-top: 20px">
			<fmt:setLocale value="es_PE"/>
				<c:forEach var="p" items="${lstProductos }">
				<div class="col-lg-4 col-md-6 col-sm-12 mb-4">
				<div class="card" >
				<div class="titulo text-center">
					<label>${p.nombre}</label>
				</div>
				<div class="card-body">
					<img alt="" src="./img/productos/${p.codprod}.jpg" width="200" height="180">
					<div class="price">
					<span>Precio:</span>
					<i><fmt:formatNumber type="currency" value="${p.precio}"></fmt:formatNumber></i>
					</div>
				</div>
				<div class="descripcion text-center" style="margin-bottom: 10px;">
					<label>${p.descripcion }</label>
					<div>
					<form action="add" method="post">
					<input name ="codigo" value="${p.codprod}"type ="hidden">
					<button type="submit" name="btnAccion" value="add"class="btn btn-outline-primary">
					<img src="./img/agregarcarrito.png" style="width: 30px"alt="Descripción del GIF">
					Seleccione
					</button>
					
					</form>
					
					</div>
				</div>
			</div>
			</div>
			</c:forEach>			
		</div>
	
	</div>
</body>
<footer class="contenedor-footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</html>
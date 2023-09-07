<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-success">

		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item">
				<a style="margin-left:10px;border:none" class="btn btn-outline-light" href="index.jsp"target="_self">
				<img src="./img/logodanesti2.png" alt="Logo Danesti"  width="30px"style="vertical-align: middle; margin-right: 5px;">
				Danesti</a>
				</li>
		<c:if test="${u.idtipo==3}">
		<li class="nav-item active">
  				<a style="margin-left:10px;border:none" class="btn btn-outline-light" href="index.jsp" target="_self">
   				 <img src="./img/home.png" alt="Logo Home" width="30" style="vertical-align: middle; margin-right: 5px;">
   				 Inicio<span class="sr-only">(current)</span>
  				</a>
				</li>
			<li class="nav-item">
				<a style="margin-left:10px;border:none" class="btn btn-outline-light" href="servletcliente?menu=Catalogo&accion=Listar"target="_self">
				<img src="./img/catalogo.png" alt="Logo Catalogo" width="30" style="vertical-align: middle; margin-right: 5px;">
				Catálogo
				</a>
				</li>
			<li class="nav-item">
				<a style="margin-left:10px;border:none" class="btn btn-outline-light" href="resenias.jsp"target="_self">
				<img src="./img/reseñas.png" alt="Logo Reseñas" width="30" style="vertical-align: middle; margin-right: 5px;">
				Reseñas
				</a>
				</li>
		
		</c:if>		
			
		<c:if test="${u.idtipo==1}">
		
		<li class="nav-item">
				<a style="margin-left:10px;border:none" class="btn btn-outline-light" href="controlador?menu=Producto&accion=Listar"target="_self">
				<img src="./img/pizza.png" alt="Logo Pizza" width="30" style="vertical-align: middle; margin-right: 5px;">
				Producto
				</a>
				</li>
				<li class="nav-item">
				<a style="margin-left:10px;border:none" class="btn btn-outline-light" href="controlador?menu=Usuario&accion=Listar"target="_self">
				<img src="./img/usuario.png" alt="Logo Usuario" width="30" style="vertical-align: middle; margin-right: 5px;">
				Usuario</a>
				</li>
					<li class="nav-item">
				<a style="margin-left:10px;border:none" class="btn btn-outline-light" href="controlador?menu=Reporte&accion=reportes"target="_self">
				<img src="./img/reportes.png" alt="Logo Reporte" width="30" style="vertical-align: middle; margin-right: 5px;">
				Reportes</a>
				</li>
		
		
		</c:if>
				<c:if test="${u.idtipo==2 }">
				<li class="nav-item">
				<a style="margin-left:10px;border:none" class="btn btn-outline-light" href="registrarventa.jsp"target="_self">
				<img src="./img/venta.png" alt="Logo Venta" width="30" style="vertical-align: middle; margin-right: 5px;">
				Nueva Venta</a>
				</li>
				</c:if>
				</ul>
				<ul class="navbar-nav ml-auto">
				<li class="nav-item" >
				<form action="logout"method="post" >
					<button name="accion" value="salir" class="btn btn-danger float-right" >
					<img src="./img/salir.png" alt="Logo Salir" width="30" style="vertical-align: middle; margin-right: 5px;">
					Salir del sistema
					</button>
					
				</form>
				</li>
			</ul>
			
		</div>
	</nav>
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
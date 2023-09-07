<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de compra</title>
<link rel="stylesheet" href="./css/estilosformcompra.css">
</head>
<header class="contenedor-header">
		<jsp:include page="header.jsp"></jsp:include>
	</header>
<body>

<div class="container">
	<div class="gifcontitulo">
	<img src="./img/pizzagif.gif" alt="Descripción del GIF">
	<h1 class="titulo">Formulario de compra</h1>
	</div>
	
	<div class="row">
		<div class="col-md-4">
			<img src="img/productos/${p.codprod}.jpg" class="img-reluciente"style="width:100%;height:80%;margin-top:50px;border-radius: 10px;" alt="Imagen del producto seleccionado">
		</div>
		<div class="col-md-8">
	<form action="venta" method="post">
		<div class="form-group row" style="margin-top:50px;">
			<label for="codigo" class="col-sm-2 col-form-label">Código:</label>
			<div class="col-sm-2">
				<input type="text" value="${p.codprod }"readonly="readonly"class="form-control" id="codigo" placeholder="Ingrese el código">
			</div>
		</div>
		<div class="form-group row">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre:</label>
			<div class="col-sm-4">
				<input type="text" value="${p.nombre }"readonly="readonly"class="form-control" id="nombre" placeholder="Ingrese el nombre">
			</div>
		</div>
		<div class="form-group row">
			<label for="descripcion" class="col-sm-2 col-form-label">Descripción:</label>
			<div class="col-sm-10">
				 <textarea readonly="readonly" class="form-control descripcion-grande" id="descripcion" placeholder="Ingrese la descripción">${p.descripcion}
  				</textarea>
			</div>
		</div>
		<div class="form-group row">
			<label for="precio" class="col-sm-2 col-form-label">Precio:</label>
			<div class="col-sm-2">
				<input type="text" value="S/.${p.precio }"readonly="readonly"class="form-control" id="precio" placeholder="Ingrese el precio">
			</div>
		</div>
		<div class="form-group row">
			 <label for="cantidad" class="col-sm-3 col-form-label">Cantidad a comprar:</label>
			<div class="col-sm-2">
				<input type="number" name="cantidad"class="form-control" value="1"id="cantidad" >
			</div>
		</div>
		<button type="submit" name="option"value="agregar"class="btn btn-outline-primary botonpe" style="margin-bottom:10px;">
		<img src=img/agregarcarrito.png style="width:30px;">
		Agregar al carrito</button>
	</form>
</div>
</div>
</div>

</body>
<footer class="contenedor-footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
	
</html>
<%@page import="models.Estado"%>
<%@page import="models.CajaProducto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producto</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>	
</head>
<header class="contenedor-header">
		<jsp:include page="header.jsp"></jsp:include>
	</header>

<body>

<div class="d-flex">

<div class="card col-sm-3">
<div class="card-body">
<form action="controlador?menu=Producto" method="post">
<div class="form-group">
	<label>Código</label>
	<input type="text" name="txtCodigo" value="${p.getCodprod()}"class="form-control"/>
	
</div>
<div class="form-group">
	<label>Nombre</label>
	<input type="text" name="txtNombre"value="${p.getNombre()}" class="form-control"/>
</div>
<div class="form-group">
	<label>Descripción</label>
	<input type="text" name="txtDescripcion"value="${p.getDescripcion()}" class="form-control"/>
</div>
<div class="form-group">
	<label for="inputState">Tamaño :</label> <select id="inputState"
		class="form-control" name="cboTamanio">
		<option value="0" selected>Seleccione el tamaño...</option>
	<%
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ArrayList<CajaProducto> lstCajas = fabrica.getCajaProductoDAO().listado();

	request.setAttribute("lstCajas", lstCajas);
	%>
	<c:forEach items="${lstCajas}" var="c">
	<c:if test="${c.getCodcaja() == p.codcaja}">
	<option value="${c.getCodcaja()}" selected="selected">${c.getDescripcion() }</option>
	</c:if>
	<c:if test="${c.getCodcaja() != p.codcaja}">
	<option value="${c.getCodcaja()}">${c.getDescripcion()}</option>
	</c:if>
	</c:forEach>
	</select>
</div>
<div class="form-group">
	<label>Precio</label>
	<input type="text" name="txtPrecio" value="${p.getPrecio() }"class="form-control"/>
</div>
<div class="form-group">
	<label>Stock</label>
	<input type="text" name="txtStock" value="${p.getStock() }"class="form-control"/>
</div>
<div class="form-group">
	<label for="inputState">Estado :</label> <select id="inputState"
		class="form-control" name="cboEstado">
		<option value="0" selected>Seleccione el estado...</option>
	<%
	fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ArrayList<Estado> lstEstados = fabrica.getEstadoDAO().listado();

	request.setAttribute("lstEstados", lstEstados);
	%>
	<c:forEach items="${lstEstados}" var="c">
	<c:if test="${c.getCodestado() == p.estado}">
	<option value="${c.getCodestado()}" selected="selected">${c.getDescripcion()}</option>
	</c:if>
	<c:if test="${c.getCodestado() != p.estado}">
	<option value="${c.getCodestado()}">${c.getDescripcion()}</option>
	</c:if>
	</c:forEach>
	</select>
</div>

${mensaje }

<button type="submit" name="accion" value="Registrar" class="btn btn-primary">
    <img src="./img/registrar.png" alt="Icono Registrar" width="30" style="vertical-align: middle; margin-right: 5px;">
    Registrar
</button>

<button type="submit" name="accion" value="Actualizar" class="btn btn-warning">
    <img src="./img/actualizar.png" alt="Icono Actualizar" width="30" style="vertical-align: middle; margin-right: 5px;">
    Actualizar
</button>



</form>
</div>
</div>
<div class="col-sm-6">
<table class="table table-hover">
<thead>
<tr>
<th></th>
<th>Codigo</th>
<th>Nombre</th>
<th>Descripcion</th>
<th>Codcaja</th>
<th>Precio</th>
<th>Stock</th>
<th>Estado</th>
<th style="text-align: center;">Acciones</th>
</tr>
</thead>
<tbody>
<c:forEach var="p" items="${lstProductos}">
<tr>
<td>

<img src="img/productos/${p.codprod}.jpg" class="img-reluciente"style="width:150px;height:150px;border-radius: 10px;" alt="Imagen del producto">
</td>
<td>${p.getCodprod()}</td>
<td>${p.getNombre()}</td>
<td>${p.getDescripcion()}</td>
<td>${p.getCodcaja()}</td>
<td>${p.getPrecio()}</td>
<td>${p.getStock()}</td>
<td>${p.getEstado()}</td>

<td>
<div class=" d-flex">
<a class="btn btn-info" href="controlador?menu=Producto&accion=Editar&cod=${p.getCodprod()}">
<img src="./img/editar.png" alt="Logo Editar" width="30" style="vertical-align: middle; margin-right: 5px;">
Editar</a>
<div style="margin-left: 10px;">
<a class="btn btn-danger"href="controlador?menu=Producto&accion=Eliminar&cod=${p.getCodprod()}">
<img src="./img/eliminar.png" alt="Logo Eliminar" width="30" style="vertical-align: middle; margin-right: 5px;">
Eliminar</a>

</div>

</div>
</td>

</tr>
</c:forEach>


</tbody>
</table>
</div>

</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
<footer class="contenedor-footer">
		<jsp:include page="footer.jsp"></jsp:include>
</footer>
</html>
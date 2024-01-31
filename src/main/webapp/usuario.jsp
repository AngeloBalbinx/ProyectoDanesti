<%@page import="models.TipoUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuario</title>
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
<form action="controlador?menu=Usuario" method="post">
<div class="form-group">
	<label>Nombre</label>
	<input type="text" name="txtNombre" value="${usu.getNombre() }"class="form-control"/>
</div>
<div class="form-group">
	<label>Apellido</label>
	<input type="text" name="txtApellido"value="${usu.getApellido() }" class="form-control"/>
</div>
<div class="form-group">
	<label>Usuario</label>
	<input type="text" name="txtUsuario"value="${usu.getUsuario() }" class="form-control"/>
</div>
<div class="form-group">
	<label>Clave</label>
	<input type="password" name="txtClave" value="${usu.getClave() }"class="form-control"/>
</div>
<div class="form-group">
	<label>F.Nacimiento</label>
	<input type="date" name="txtFnac" value="${usu.getFnacim() }"class="form-control"/>
</div>
<div class="form-group">
	<label for="inputState">Tipo :</label> <select id="inputState"
		class="form-control" name="cboTipo">
		<option value="0" selected>Seleccione tipo...</option>
	<%
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ArrayList<TipoUsuario> lstTipos = fabrica.getTipoUsuarioDAO().listado();

	request.setAttribute("lstTipos", lstTipos);
	%>
	<c:forEach items="${lstTipos }" var="c">
	<c:if test="${c.getIdtipo() == usu.idtipo}">
	<option value="${c.getIdtipo()}" selected="selected">${c.getDescripcion() }</option>
	</c:if>
	<c:if test="${c.getIdtipo() != usu.idtipo}">
	<option value="${c.getIdtipo() }">${c.getDescripcion() }</option>
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
<th>Codigo</th>
<th>Nombre</th>
<th>Apellido</th>
<th>Usuario</th>
<th>Clave</th>
<th>F.Nacimiento</th>
<th>Tipo</th>
<th style="text-align: center;" >Acciones</th>
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
<td>${u.getIdtipo()}</td>
<td>
<div class="d-flex">
<a class="btn btn-info" href="controlador?menu=Usuario&accion=Editar&cod=${u.getCodigo()}">
<img src="./img/editar.png" alt="Logo Editar" width="30" style="vertical-align: middle; margin-right: 5px;">
Editar</a>
<div style="margin-left: 10px;" >
<a class="btn btn-danger"href="controlador?menu=Usuario&accion=Eliminar&cod=${u.getCodigo()}">
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
<footer class="contenedor-footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>
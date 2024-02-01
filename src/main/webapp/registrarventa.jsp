<%@page import="models.Venta"%>
<%@page import="java.util.List"%>
<%@page import="models.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas</title>
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
<div class="col-sm-5">
<div class="card">

<form action="controlador?menu=NuevaVenta" method="post">
<div class="card-body">
<div class="form-group">
<label>Datos del Cliente</label>
</div>
<div class="form-group d-flex">
<div class="col-sm-6 d-flex" >
	<select id="inputState"
		class="form-control" name="codigocliente">
		<option value="0">Seleccione el codigo...</option>
	<%
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ArrayList<Usuario> lstUsuarios = fabrica.getUsuarioDAO().listado();

	request.setAttribute("lstUsuarios", lstUsuarios);
    Usuario usuarioSeleccionado = (Usuario) request.getAttribute("usu");
    for (Usuario c : lstUsuarios) {
        %>
        <option value="<%=c.getCodigo()%>" <%= (usuarioSeleccionado != null && c.getCodigo() == usuarioSeleccionado.getCodigo()) ? "selected" : "" %>>
            <%= c.getCodigo() %>
        </option>
        <%
    }

	%>
<c:forEach items="${lstUsuarios}" var="c">
    <c:if test="${not empty c.getCodigo()}">
        <option value="${c.getCodigo()}">${c.getCodigo()}</option>
    </c:if>
</c:forEach>
	</select>

<input type="submit" name="accion"value="BuscarCliente" class="btn btn-outline-dark"/>
</div>

<div class="col-sm-6">
<input type="text" name="nombrecliente" readonly="readonly" value="${usu.getNombre()} ${usu.getApellido()}" placeholder="Datos Cliente"class="form-control"/>
</div>

</div>
<div class="form-group">
<label>Datos del Producto</label>
</div>
<div class="form-group d-flex">
<div class="col-sm-7 d-flex" >
<input type="text" name="codigoproducto" value="${p.getCodprod()}" class="form-control" placeholder="Código"/>
<input type="submit" name="accion"value="BuscarProducto" class="btn btn-outline-dark"/>
</div>

<div class="col-sm-5">
<input type="text" name="nombreproducto"  readonly="readonly" value="${p.getNombre()}"  placeholder="Datos Producto"class="form-control"/>
</div>
</div>

<div class="form-group d-flex">
<div class="col-sm-6 d-flex" >
<input type="text" name="precio" readonly="readonly" value="${p.getPrecio()}"class="form-control" placeholder="S/.0.00"/>

</div>
<div class="col-sm-3">
<input type="number" value="1" name="cant"value="Buscar" class="form-control"/>
</div>

<div class="col-sm-3">
<input type="text" name="stock" readonly="readonly" placeholder="Stock"value="${p.getStock()}" class="form-control"/>
</div>
</div>
<div class="form-group">
<button type="submit" name="accion" value="Agregar" class="btn btn-outline-primary">
    <img src="./img/agregarproducto.png" alt="Icono Agregar" width="30" style="vertical-align: middle; margin-right: 5px;">
   	Agregar
</button>

</div>
</div>
${mensaje }
</form>
</div>
</div>

<div class="col-sm-7">
<div class="card">
<div class="card-body">
<div class="d-flex col-sm-6 ml-auto">
<label class="text-right mt-2 col-sm-7">N°Boleta</label>
<input type="text" name="NroBoleta" readonly="readonly" value="${nBol}"class="form-control">
</div>
<br>
<table class="table table-hover">
<thead>
<tr>
<th>Nro</th>
<th>Codigo</th>
<th>Producto</th>
<th>Precio</th>
<th>Cantidad</th>
<th>Subtotal</th>
<th style="padding-left: 34px;">Acción</th>
</tr>
</thead>
<tbody>
<c:forEach var="list" items="${lista}">
<tr>
<td>${list.getItem()}</td>
<td>${list.getCodprod()}</td>
<td>${list.getDescripcion()}</td>
<td>${list.getPrecio()}</td>
<td>${list.getCant()}</td>
<td>${list.getSubtotal()}</td>
<td class="d-flex">



   <form action="controlador" method="post">
    <input type="hidden" name="menu" value="NuevaVenta">
    <input type="hidden" name="accion" value="Eliminar">
    <button type="submit" class="btn btn-danger" style="margin-left: 10px; padding-left: 5px; position: relative;">
        <span style="display: inline-block; vertical-align: middle; margin-left: 5px;">
            <img src="./img/eliminar.png" alt="Icono Eliminar" width="30">
        </span>
        
        <span style="display: inline-block; vertical-align: middle;">
            Eliminar
        </span>
    </button>
</form>




</td>
</tr>

</c:forEach>

</tbody>
</table>
</div>
<div class="card-footer d-flex">
<div class="col-sm-6">
	<a href="controlador?menu=NuevaVenta&accion=GenerarVenta" class="btn btn-success">
	 <img src="./img/generarventa.png" alt="Icono Generar Venta" width="30" style="vertical-align: middle; margin-right: 5px;">
	Generar Venta</a>
	<form action="logout"method="post" style="display:inline-flex;" >
					
					
	<button type="submit" name="accion" value="Cancelar" class="btn btn-danger">
    <img src="./img/cancelar.png" alt="Icono Registrar" width="30" style="vertical-align: middle; margin-right: 5px;">
    Cancelar
	</button>				
	
	</form>
</div>
<div class="col-sm-2 ml-auto">
<input type="text" name="txtTotal" readonly="readonly"value="S/. ${totalPagar}" class="form-control">
</div>
</div>

</div>

</div>


</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<footer class="contenedor-footer" style="margin-top:115px;">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>
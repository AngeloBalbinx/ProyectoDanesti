<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<head>
<meta charset="ISO-8859-1">
<title>Carrito de Compras</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link href="./css/estiloscarritocompra.css" rel="stylesheet">
</head>
<header class="contenedor-header">
		<jsp:include page="header.jsp"></jsp:include>
	</header>
<body >
		<c:if test="${carro.size() == 0}">
			<div class="container text-center">
				<h1 class="text-center titulo">Carrito de compras</h1>
				<img src="./img/carrocompra.png" width="100">
				<br>
				<p class="card-title">Su carrito está vacio :(</p>
				
				<a href="verCatalogo" class="btn btn-outline-primary" style="margin-bottom:229px">
    			<img src="./img/agregarproducto.png" alt="Icono Agregar" width="30" style="float:left; margin-right: 5px;">
    			Continuar comprando
				</a>
			</div>
		</c:if>
		<c:if test="${carro.size() > 0}">
		<div class="container">
  <div class="row">
    <div class="col-md-8">
      <!-- Contenido principal -->
      <div class="gifcontitulo">
      <img src="./img/pizzagif.gif" alt="Descripción del GIF">
       <h1>Carrito de compras</h1>
      </div>
     
      <c:forEach items="${carro}" var="d">
        <div class="card" style="margin-bottom: 15px;">
          <div class="card-body">
            <div class="row">
              <div class="col-md-4 imagen">
                <img src="./img/productos/${d.codprod}.jpg" style="width: 300px; height: 300px;" alt="">
              </div>
              <div class="col-md-8">
                <div class="datos" style="margin-left:100px;">
                  <h2>${d.nombre}</h2>
                  <p>${d.descripcion}</p>
                       <p>
                    <fmt:setLocale value="es_PE" />
                    <fmt:formatNumber type="currency" value="${d.importe}"></fmt:formatNumber>
                  </p>
                   <p>${d.cantidad}&nbsp;unidad(es)</p>
                </div>
                
             
                 
                   
                  
                  <form action="venta" method="post">
                    <input type="hidden" name="codigo" value="${d.codprod}">
                    <button id="btneliminar" type="submit" class="btn btn-outline-danger" value="eliminar" name="option" style="margin-left:100px;">
                      <img src="./img/eliminar2.png" style="width: 30px;" alt="imagen eliminar">
                      Eliminar
                    </button>
                  </form>
                
              </div>
            </div>
          </div>
        </div>
      </c:forEach>
	<div style="display:flex;justify-content: center;flex-direction: row-reverse;">
	
	<a href="verCatalogo" style="width:100%;"class="btn btn-outline-info">
      <img src="./img/seguircomprando.png" style="width: 30px;" alt="imagen eliminar">
      Continuar comprando 
      </a>
	
	</div>	
      
    </div>

    <div class="col-md-4" >
      <!-- Aside -->
      <div class="card aside">
        <h3>Resumen de tu pedido</h3>
        <p>Subtotal:
          <fmt:setLocale value="es_PE" />
          <fmt:formatNumber type="currency" value="${subTotalVenta}"></fmt:formatNumber>
        </p>
        <p>Envio: S/. 10.00</p>
        <p class="rojo">Total a pagar:
          <fmt:setLocale value="es_PE" />
          <fmt:formatNumber type="currency" value="${subTotalVenta + 10.00}"></fmt:formatNumber>
        </p>
		<img src="./img/comprasegura.gif" class="imagen2">
        <form action="venta" method="post">
          <button type="submit" class="btn btn-dark" value="finalizar" name="option">Finalizar Compra</button>
        </form>
      </div>
    </div>
  </div>
</div>
			
		</c:if>
		${mensaje }
</body>
<footer class="contenedor-footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.min.js"></script>
	
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Reseñas</title>

<link href="./css/estilosresenias.css" rel="stylesheet">

</head>
<header class="contenedor-header">
		<jsp:include page="header.jsp"></jsp:include>
	</header>

<body>
	<div class="gifcontitulo">
	<img src="./img/pizzagif.gif" alt="Descripción del GIF">
		<h2>Reseñas de clientes</h2>
		
	</div>
		
		<hr class="orange-hr">
		<div id="reviews-container"></div>
		
	
	  <script src="./js/resenias.js"></script>
</body>
<footer class="contenedor-footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
	
</html>
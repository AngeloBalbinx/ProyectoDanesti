<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

<link href="./css/estilosindex.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<header class="contenedor-header">
		<jsp:include page="header.jsp"></jsp:include>
	</header>
<body>
<div class="carousel">
  <div class="slides">
    <img src="./img/pizzacarousel1.png" alt="Imagen 1 Carousel">
    <img src="./img/pizzacarousel2.png" alt="Imagen 2 Carousel">
    <img src="./img/pizzacarousel3.png" alt="Imagen 3 Carousel">

  </div>
  <div class="controls">
    <button class="prev">&#10094;</button>
    <button class="next">&#10095;</button>
  </div>
</div>
<div class="cont">
<div class="card">
    <img src="./img/equipodanesti.jpg" alt="Imagen del card">
    <div class="card-content">
      <h2 class="card-title">Acerca de nosotros </h2>
      <p class="card-text">Bienvenidos a nuestra pizzer�a, donde la pasi�n por la pizza se combina con los mejores ingredientes y un ambiente acogedor. Desde nuestro inicio, nos hemos comprometido a ofrecer a nuestros clientes las pizzas m�s deliciosas y aut�nticas que puedan encontrar.</p>
      <p class="card-text">Ven y �nete a nosotros en nuestra pizzer�a, donde cada bocado es un viaje a Italia y cada encuentro es una celebraci�n de la buena comida y la buena compa��a. �Esperamos verte pronto y compartir nuestra pasi�n por la pizza contigo!</p>
    </div>
  </div>
  <div class="card">
    <img src="./img/misiondanesti.jpg" alt="Imagen del card">
    <div class="card-content">
      <h2 class="card-title">Misi�n</h2>
        <p class="card-text">En nuestra pizzer�a, tenemos una visi�n clara: ser reconocidos como el lugar preferido de los amantes de la pizza en nuestra comunidad y m�s all�. Nos esforzamos por convertirnos en una referencia en calidad, sabor y servicio excepcional.</p>
    <br>
    <p class="card-text">Queremos ser conocidos por nuestras pizzas �nicas, elaboradas con ingredientes frescos y de alta calidad. Nos esforzamos por crear combinaciones de sabores innovadoras que deleiten a nuestros clientes y los hagan volver por m�s.</p>
    </div>
  </div>
  <div class="card">
    <img src="./img/visiondanesti.png" alt="Imagen del card">
    <div class="card-content">
      <h2 class="card-title">Visi�n</h2>
  <p class="card-text">En nuestra pizzer�a, nuestra misi�n es ofrecer a nuestros clientes una experiencia excepcional de sabor, calidad y servicio. Nos esforzamos por crear las mejores pizzas, utilizando ingredientes frescos y aut�nticos, combinados con t�cnicas tradicionales y creativas de preparaci�n.</p>
    <p class="card-text">Nos comprometemos a brindar un servicio amable y atento, asegur�ndonos de que cada visita a nuestra pizzer�a sea placentera y satisfactoria. Valoramos a nuestros clientes y nos esforzamos por superar sus expectativas en cada interacci�n.</p>
 
    </div>
  </div>
</div>
<script src="./js/carousel.js"></script>
</body>
<footer class="contenedor-footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</html>
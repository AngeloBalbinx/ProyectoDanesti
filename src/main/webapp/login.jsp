<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link href="./css/estiloslogin.css" rel="stylesheet">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>

<body>
	<div class="box">
		<span class="borderLine"> </span>
		<form action="ingreso" method="post">
			<h2>Bienvenido</h2>
			<img src="./img/logodanesti.png" alt="Logo Danesti" width="180" />
			<div class="inputBox">
				<input type="text" name="txtUsuario"required="required"> <span>Usuario</span>
				<i></i>
			</div>
			<div class="inputBox">
				<input type="password" name="txtClave" required="required"> <span>Contraseña</span>
				<i></i>
			</div>
			<br>
			<div class="links">
			<p class="newusr" >Nuevo usuario?<a href="registro.jsp">Registrarse</a></p>
				
			</div>
			<br>
			<input type="submit" name="accion" value="Ingresar">
			<br>
			${mensaje}
		</form>
	</div>
</body>
</html>
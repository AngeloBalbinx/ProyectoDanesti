<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registro</title>
<link href="./css/estilosregistro.css" rel="stylesheet">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>

<body>
	<div class="box">
		<span class="borderLine"> </span>
		<form action="registro" method="post">
			<h2>Registro de usuario</h2>
			<img src="./img/logodanesti.png" alt="Logo Danesti" width="180" />
			
			<div class="inputBox">
				<input type="text" name="txtNombre" required="required"> <span>Nombre</span>
				<i></i>
			</div>
			<div class="inputBox">
				<input type="text" name="txtApellido"required="required"> <span>Apellido</span>
				<i></i>
			</div>
			<div class="inputBox">
				<input type="text" name="txtUsuario"required="required"> <span>Usuario</span>
				<i></i>
			</div>
			<div class="inputBox">
				<input type="password" name="txtClave" required="required"> <span>Contraseña</span>
				<i></i>
			</div>
				<div class="inputBox">
				<input id="fecha"type="date" name="txtFnac" placeholder=""required="required"> <span>F.Nacimiento</span>
				<i></i>
			</div>
			<br>
			<div class="links">
			<p class="newusr">Ya tiene cuenta?<a href="login.jsp">Ingresar</a></p>
				<p></p>
			</div>
			<br>
			<input type="submit" name="accion" value="Registrar">
			<br>
			${mensaje}
		</form>
	</div>
	<script src="./js/correciones.js"></script>
</body>
</html>
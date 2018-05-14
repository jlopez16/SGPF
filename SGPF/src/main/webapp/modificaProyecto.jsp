<%@page import="unam.mx.SGPF.model.Proyecto"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifica Proyecto</title>
<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0">
<!--===============================================================================================-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inconsolata">
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	<header>
		<div class="container">
			<h1>Sistema Gestor de Procesos Funcionales</h1>
		</div>
	</header>
	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h1>Modifica el Proyecto</h1>
			</div>
			<div class="table-responsive">
				<%
					Proyecto p = (Proyecto) session.getAttribute("proy");
				%>
				<form action="actualizaRproyectO" method="POST">
					<table class="table">
						<tbody>
							<tr>
								<td>Id:</td>
								<td><input type="hidden" name="idProyecto"
									value="<%=p.getIdproyecto()%>"> <%=p.getIdproyecto()%></td>
							</tr>
							<tr>
								<td>Nombre:</td>
								<td><input type="text" name="nombreProyecto"
									value="<%=p.getNomProy()%>" required></td>
							</tr>
						</tbody>
					</table>
					<input class="btn btn-outline-info" type="submit" value="Guardar" />
					<form action="BuscaProyecto" method="POST">
						<input type="hidden" name="idProyecto"
							value="<%=p.getIdproyecto()%>"> 
						<input class="btn btn-outline-info" 
							type="submit" value="Cancelar">
					</form>
				</form>
			</div>
		</section>
	</div>


	<script src="js/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>

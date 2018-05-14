<%@page import="unam.mx.SGPF.model.InterUP"%>
<%@page import="java.util.List"%>
<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de proyectos</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Inconsolata">
<link rel="stylesheet" href="css/estilos.css">
</head>
<%
        List<InterUP> inters = (List<InterUP>) session.getAttribute("inters");
        int tipoUsuario = Integer.parseInt(session.getAttribute("tipoUsuario").toString());
    %>

<body>
	<header>
		<div class="container">
			<h1>Sistema Gestor de Procesos Funcionales</h1>
		</div>
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<!-- 
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarTogglerDemo02"
					aria-controls="navbarTogglerDemo02" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				 -->


				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active">
						 <%if(tipoUsuario==1){%>
                        <a class="nav-link" href="crudCatalogos.jsp">
                           Modificar Catálogos
                        </a>
                    <% } %>
							
						</li>
						<li class="nav-item active">
                                                    <%if(tipoUsuario == 1){%>
                        <a class="nav-link" href="gestionUsuarios">
                            Gestionar Usuarios
                        </a>
                    <% } %>
						</li>
						<li class="nav-item active">
							<%
								if (tipoUsuario == 1 || tipoUsuario == 2) {
							%> <a class="nav-link" href="agregarProyecto.jsp">Nuevo
								Proyecto</a> <%
 	}
 %>
						</li>
					</ul>
					<form class="col-md-2" action="cerrarSesion" method="post">
						<input class="btn btn-outline-success my-2 my-sm-0" type="submit"
							value="Cerrar Sesión">
					</form>
				</div>
			</nav>
		</div>
	</header>

	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h1>Proyectos</h1>
			</div>

			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">Nombre Proyecto</th>
							<th scope="col">Estado</th>
						</tr>
					</thead>
					<tbody>
						<%
								for (InterUP inter : inters) {
									Proyecto p = inter.getIdproyecto();
							%>
						<tr>
							<td><a
								href="BuscaProyecto?idProyecto=<%=p.getIdproyecto()%>"><%=p.getNomProy()%></a></td>
							<td><%=p.getEstatus()%></td>
						</tr>
						<%
								}
							%>
					
					<tbody>
				</table>
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

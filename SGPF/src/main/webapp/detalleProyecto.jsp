<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page import="unam.mx.SGPF.model.ProcesoFuncional"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalles proyecto</title>
<meta name="viewport"
	content="width=device-width,user-scalable=no, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0">
<!--===============================================================================================-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Inconsolata">
<link rel="stylesheet" href="css/estilos.css">
</head>
<%
     List<ProcesoFuncional> pfs = (List<ProcesoFuncional>) session.getAttribute("procFunc");
  	 Proyecto p = (Proyecto) session.getAttribute("proy"); 
         int tipoUsuario = Integer.parseInt(session.getAttribute("tipoUsuario").toString());
  %>
<body>
	<header>
		<div class="container">
			<h1>Sistema Gestor de Procesos Funcionales</h1>
		</div>
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active">
							<%if(tipoUsuario!=3 && p.getEstatus()==1){%> 
								<a class="nav-link" href="modificaProyecto.jsp">Modificar Proyecto</a> 
							<% } %>
						</li>
						<li class="nav-item activ">
							<% if(tipoUsuario!=3){%>
							<form action="eliminaProyecto" method="post">
								<input type="hidden" name="idProyecto"
									value="<%=p.getIdproyecto()%>"> 
								<input class="nav-link myclass " style="color: rgba(0,0,0,.9);border-style:none;background-color:transparent; cursor:pointer; cursor: hand;"
									type="submit" value="Cambiar Estatus" />
							</form>
							<% } %>
						</li>
						<li class="nav-item active">
							<a class="nav-link" href="agregaPF.jsp">Agregar PF</a>
						</li>
					</ul>
					
					<a class="btn btn-outline-success my-2 my-sm-0" href="proyectos.jsp">Back to Projects</a>

				</div>
			</nav>
		</div>
	</header>

	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h1>Detalle proyecto</h1>
			</div>
			<div class="table-responsive ">
				<table class="table ">
					<thead>
					</thead>
					<tbody>
						<tr>
							<th scope="col">Nombre Proyecto</th>
							<td><%=p.getNomProy()%></td>
						</tr>
					<tbody>
				</table>
			</div>

		</section>
	</div>
	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h3>Procesos funcionales del proyecto</h3>
			</div>
			<div class="table-responsive">
				<table class="table ">
					<!-- 
					<thead>
							<tr>
								<th scope="col">Nombre Proyecto</th>
								<th scope="col">Año</th>
								<th scope="col">Duración</th>
							</tr>
						</thead>
					 -->
					<thead>
					</thead>
					<tbody>
						<%
							for (ProcesoFuncional inter : pfs) {
						%>
						<tr>
							<th>Nombre del Proceso Funcional:</th>
							<td><a
								href="BuscaProcesoFuncional?idprocesoFuncional=<%=inter.getIdprocesoFuncional()%>"><%=inter.getNomPF()%></a></td>
							<td>
								<form action="eliminaPF" method="post">
									<input type="hidden" name="idPF"
										value="<%=inter.getIdprocesoFuncional()%>"> <input
										class="btn btn-outline-info" type="submit" value="Eliminar">
								</form>
							</td>
						</tr>

						<%
							}
						%>
					
					<tbody>
				</table>
			</div>
		</section>
	</div>

</body>
</html>

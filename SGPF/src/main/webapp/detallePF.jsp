<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page import="unam.mx.SGPF.model.ProcesoFuncional"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="unam.mx.SGPF.model.SubProceso"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Detalle Proceso Funcional</title>
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

<body>
	<%
		ProcesoFuncional detalle = (ProcesoFuncional) session.getAttribute("pfDetalle");
		List<SubProceso> spList = (List<SubProceso>) session.getAttribute("subProc");
		int tipoUsuario = Integer.parseInt(session.getAttribute("tipoUsuario").toString());
		Proyecto p = (Proyecto) session.getAttribute("proy");
	%>
	<header>
		<div class="container">
			<h1>Sistema Gestor de Procesos Funcionales</h1>
		</div>
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active">
							<%
								if (tipoUsuario != 3 && p.getEstatus() == 1) {
							%> <a class="nav-link" href="modifyPF.jsp">Modificar PF</a> <%
 	}
 %>
						</li>
						<li class="nav-item active">
							<%
								if (tipoUsuario != 3 && p.getEstatus() == 1) {
							%>
							<form action="agregarActividad" method="post">
								<input type="hidden" name="idProcesoFuncional"
									value="<%=detalle.getIdprocesoFuncional()%>"> <input class="nav-link myclass " style="color: rgba(0,0,0,.9);border-style:none;background-color:transparent; cursor:pointer; cursor: hand;"
									type="submit" value="Agregar Actividad" />
							</form> <%
 	}
 %>

						</li>
						<li class="nav-item active"></li>
					</ul>

					<a class="btn btn-outline-success my-2 my-sm-0"
						href="detalleProyecto.jsp">Back to Detail</a>

				</div>
			</nav>
		</div>
	</header>
	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h1>Detalle de Proceso Funcional</h1>
			</div>
			<div class="table-responsive ">
				<table class="table ">
					<tbody>
						<tr>
							<th scope="col">Nombre Proceso Funcional:</th>
							<td><%=detalle.getNomPF()%></td>
						</tr>
						<tr>
							<th scope="col">Descripción:</th>
							<td><%=detalle.getDescripcion()%></td>
						</tr>
						<tr>
							<th scope="col">Evento desencadenante</th>
							<td><%=detalle.geteventoDes()%></td>
						</tr>
					<tbody>
				</table>
			</div>
		</section>
	</div>
	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h2>Lista de Actividades</h2>
			</div>
			<div class="table-responsive">
				<form action="agregarActividad" method="post">
					<input type="hidden" name="idProcesoFuncional"
						value="<%=detalle.getIdprocesoFuncional()%>"> <input
						class="btn btn-outline-info" type="submit"
						value="Agregar Actividad" />
				</form>
				<table class="table ">

					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Actividad</th>
							<th scope="col">Usuario funcional</th>
							<th scope="col">Acción</th>
							<th scope="col">Descripción</th>
							<th scope="col">Grupo de datos</th>
							<th scope="col" colspan="2">Opciones</th>
						</tr>
					</thead>

					<tbody>
						<%
							for (SubProceso inter : spList) {
								UsuarioFuncional uf = new UsuarioFuncional();
								Accion acc = new Accion();
								GrupoDato gd = new GrupoDato();
								uf = inter.getIdusuarioFuncional();
								acc = inter.getIdaccion();
								gd = inter.getIdgrupoDato();
						%>
							<tr>
							<%
								if (inter.getIndice() == 1) {
							%>
								<td><%=inter.getIdsubProceso()%></td>
								<td><%=inter.getActividad()%></td>
								<td><%=uf.getNomUF()%></td>
								<td><%=acc.getNomAccion()%></td>
								<td><%=inter.getDescripcion()%></td>
								<td><%=gd.getNomGD()%></td>		
								<%
							 	if (tipoUsuario != 3 && p.getEstatus() == 1) {
								%>
								<td>
									<form action="modActividad" method="POST">
										<input type="hidden" name="idSubProceso" value="<%=inter.getIdsubProceso()%>"/> 
										<input class="btn btn-outline-info" type="submit" value="Modificar" />
									</form> 
								</td>
								<td>
									<form action="addSubProceso" method="POST">
										<input type="hidden" name="idSubProceso" value="<%=inter.getIdsubProceso()%>" /> 
										<input class="btn btn-outline-info" type="submit" value="Agregar SP" />
									</form> 
								</td>
								<td>
									<%
									if (inter.getActividad() == "Inicio de Proceso Funcional" && inter.getIndice() == 1) {
									%>
									<form action="eliActividad" method="POST">
										<input type="hidden" name="idSubProceso"value="<%=inter.getIdsubProceso()%>" /> 
										<input class="btn btn-outline-info" type="submit" value="Eliminar" />
									</form> 
									<%
									}
									%> 
								</td>
								<%
								}
								%>
							<%
							} else {
							%>
							<td><%=inter.getIdsubProceso()%></td>
							<td></td>
							<td><%=uf.getNomUF()%></td>
							<td><%=acc.getNomAccion()%></td>
							<td><%=inter.getDescripcion()%></td>
							<td><%=gd.getNomGD()%></td>
							<td></td>
							<td>
								<%if(tipoUsuario!=3&&p.getEstatus()==1){%>
								<form action="eliSubproceso" method="POST">
									<input type="hidden" name="idSubProceso"
										value="<%=inter.getIdsubProceso()%>" /> <input
										class="btn btn-outline-info" type="submit" value="Eliminar SP" />
								</form> <% } %>
							</td>
							<%
								}
							%>
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

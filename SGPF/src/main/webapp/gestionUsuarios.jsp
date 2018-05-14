<%@page import="unam.mx.SGPF.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Usuarios</title>
        <% List<Usuario> usuarios = (List<Usuario>) session.getAttribute("CatalogoUsuarios"); %>
    </head>
    <body>
        <h1>Gestión de Usuarios!</h1>
        <table border="1">
            <tr>
                <td>
                    Nombre 
                </td>
                <td>
                    Tipo usuario
                </td>
            </tr>
            <%for(Usuario usuario : usuarios){%>
            <tr>
                <td>
                    <%=usuario.getNomUsuario()%>
                </td>
                <td>
                    <%if(usuario.getUsuTipo1()!=null){%>Administrador
                    <%}else{if(usuario.getUsuTipo2()!=null){%>Gestor de Proyecto
                    <%}else{if(usuario.getUsuTipo3()!=null){%>Consultor
                    <%}else{%> = Inactivo = <%}}}%>
                </td>
                <td>
                    <a href="modificarUsuario?idUsuario=<%=usuario.getIdusuario()%>">
                        <input type="submit" value="Modificar">
                    </a>
                </td>
            </tr>
            <%}%>
            <tr>
                <td>
                    <a href="proyectos.jsp">
                        <input type="submit" value="Regresar">
                    </a>
                </td>
                <td>
                    <a href="agregarUsuario.jsp">
                        <input type="submit" value="Agregar Usuario">
                    </a>
                </td>
            </tr>
        </table>
    </body>
</html>

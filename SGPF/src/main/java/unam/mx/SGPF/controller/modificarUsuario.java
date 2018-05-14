package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.Usuario;
import unam.mx.SGPF.model.controller.UsuarioJpaController;

public class modificarUsuario extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        UsuarioJpaController ujpa = new UsuarioJpaController(EntityProvider.provider());
        Usuario usuario = ujpa.findUsuario(idUsuario);
        HttpSession session = request.getSession(true);
        session.setAttribute("usuarioMod", usuario);
        response.sendRedirect("modificarUsuario.jsp");
    }
}

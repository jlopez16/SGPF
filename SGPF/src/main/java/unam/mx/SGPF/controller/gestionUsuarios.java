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

public class gestionUsuarios extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioJpaController ujpa = new UsuarioJpaController(EntityProvider.provider());
        List<Usuario> usuarios = ujpa.findUsuarioEntities();
        HttpSession session = request.getSession(true);
        session.setAttribute("CatalogoUsuarios", usuarios);
        response.sendRedirect("gestionUsuarios.jsp");
    }
}

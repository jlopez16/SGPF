package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.UsuarioFuncionalJpaController;

public class modificaUF extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int IdUF = Integer.parseInt(request.getParameter("idUF"));
        UsuarioFuncionalJpaController ufjpa = new UsuarioFuncionalJpaController(EntityProvider.provider());
        UsuarioFuncional UF = ufjpa.findUsuarioFuncional(IdUF);
        
        HttpSession session = request.getSession(true);
        session.setAttribute("usuarioFuncionalMod", UF);
        
        response.sendRedirect("modificaUF.jsp");
       
    }
}

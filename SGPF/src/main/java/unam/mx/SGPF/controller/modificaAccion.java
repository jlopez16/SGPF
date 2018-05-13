package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.controller.AccionJpaController;

public class modificaAccion extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int IdAccion = Integer.parseInt(request.getParameter("idAccion"));
        AccionJpaController ajpa = new AccionJpaController(EntityProvider.provider());
        Accion accion = ajpa.findAccion(IdAccion);
        
        HttpSession session = request.getSession(true);
        session.setAttribute("accionMod", accion);
        
        response.sendRedirect("modificaAccion.jsp");
       
    }
}

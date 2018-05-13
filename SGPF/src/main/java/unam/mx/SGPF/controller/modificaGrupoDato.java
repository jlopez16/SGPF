package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.controller.AccionJpaController;
import unam.mx.SGPF.model.controller.GrupoDatoJpaController;

public class modificaGrupoDato extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idGrupoDato = Integer.parseInt(request.getParameter("idGrupoDato"));
        GrupoDatoJpaController gdjpa = new GrupoDatoJpaController(EntityProvider.provider());
        GrupoDato grupoDato = gdjpa.findGrupoDato(idGrupoDato);
        
        HttpSession session = request.getSession(true);
        session.setAttribute("grupoDatoMod", grupoDato);
        
        response.sendRedirect("modificaGrupoDato.jsp");
       
    }
}

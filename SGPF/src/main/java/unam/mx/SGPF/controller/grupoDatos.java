package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.controller.GrupoDatoJpaController;

public class grupoDatos extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	HttpSession session = request.getSession(true);
		
	GrupoDatoJpaController gdjpa = new GrupoDatoJpaController(EntityProvider.provider());
	List<GrupoDato> gd = gdjpa.findGrupoDatoEntities();
	session.setAttribute("grupoDatos",gd);
		
	response.sendRedirect("grupoDatos.jsp");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	HttpSession session = request.getSession(true);
		
	GrupoDatoJpaController gdjpa = new GrupoDatoJpaController(EntityProvider.provider());
	List<GrupoDato> gd = gdjpa.findGrupoDatoEntities();
	session.setAttribute("grupoDatos",gd);
		
	response.sendRedirect("grupoDatos.jsp");
    }
}

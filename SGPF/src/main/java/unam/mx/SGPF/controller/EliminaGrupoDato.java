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

public class EliminaGrupoDato extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		 
	Integer idGD = Integer.parseInt(request.getParameter("idGrupoDato"));
	    	
	GrupoDatoJpaController gdjpa = new GrupoDatoJpaController(EntityProvider.provider());
	GrupoDato gd = gdjpa.findGrupoDato(idGD);
        short a=1;
        if(gd.getActivo()==0)
            gd.setActivo(a);
        else{
            a=0;
            gd.setActivo(a);
        }
                
	try {
	    gdjpa.edit(gd);
	}catch(Exception e) {
	    e.printStackTrace();
	}
	HttpSession session = request.getSession(true);
			
	List<GrupoDato> grupoDatos = gdjpa.findGrupoDatoEntities();
	session.setAttribute("grupoDatos",grupoDatos);
	response.sendRedirect("grupoDatos.jsp");
    }
}

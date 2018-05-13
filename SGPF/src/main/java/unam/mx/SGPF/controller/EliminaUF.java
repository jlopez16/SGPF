package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.UsuarioFuncionalJpaController;

public class EliminaUF extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
	Integer idUF = Integer.parseInt(request.getParameter("idUF"));
	    	
	UsuarioFuncionalJpaController ufjpa = new UsuarioFuncionalJpaController(EntityProvider.provider());
	UsuarioFuncional uf = ufjpa.findUsuarioFuncional(idUF);
        short a=1;
        if(uf.getActivo()==0)
            uf.setActivo(a);
        else{
            a=0;
            uf.setActivo(a);
        }
        try {
            ufjpa.edit(uf);
	}catch(Exception e) {
	    e.printStackTrace();
	}
	HttpSession session = request.getSession(true);
			
	List<UsuarioFuncional> ufs = ufjpa.findUsuarioFuncionalEntities();
	session.setAttribute("usuarioFuncional",ufs);
	response.sendRedirect("usuarioFuncional.jsp");
    }
}

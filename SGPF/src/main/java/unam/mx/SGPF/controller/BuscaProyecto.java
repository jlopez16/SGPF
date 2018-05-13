/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.Proyecto;
import unam.mx.SGPF.model.Usuario;
import unam.mx.SGPF.model.controller.InterUPJpaController;
import unam.mx.SGPF.model.controller.ProcesoFuncionalJpaController;
import unam.mx.SGPF.model.controller.ProyectoJpaController;

public class BuscaProyecto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Integer idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
    	ProyectoJpaController pjpa = new ProyectoJpaController(EntityProvider.provider());
    	Proyecto p = pjpa.findProyecto(idProyecto);
    	
        HttpSession session = request.getSession(true);
        
        ////////
    	ProcesoFuncionalJpaController pfjpa = new ProcesoFuncionalJpaController(EntityProvider.provider());
    	List<ProcesoFuncional> pf = pfjpa.findPFByIdProyectoActivo(idProyecto);
        session.setAttribute("procFunc", pf);
        ////
        
        session.setAttribute("proy", p);
        response.sendRedirect("detalleProyecto.jsp");
    }
   
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Integer idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
    	ProyectoJpaController pjpa = new ProyectoJpaController(EntityProvider.provider());
    	Proyecto p = pjpa.findProyecto(idProyecto);
    	
        HttpSession session = request.getSession(true);
        
        ////////
    	ProcesoFuncionalJpaController pfjpa = new ProcesoFuncionalJpaController(EntityProvider.provider());
    	List<ProcesoFuncional> pf = pfjpa.findPFByIdProyectoActivo(idProyecto);
        session.setAttribute("procFunc", pf);
        ////
        
        session.setAttribute("proy", p);
        response.sendRedirect("detalleProyecto.jsp");
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.controller.ProcesoFuncionalJpaController;


public class actualizarPF extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	//VARIABLES QUE PROVIENEN DEL FORM modificaPF.jsp
        String redireccion = "";
        int idPF = Integer.parseInt(request.getParameter("idProcesoFuncional"));
        
        String nombrePF = request.getParameter("nombreProcesoFuncional");
        String descripcionPF=request.getParameter("descripcionPF");
        String eventoDes=request.getParameter("eventoDes");
        
        //OBTENER EL OBJETO PF PARA OBTENER IDPROY
        HttpSession session = request.getSession(true);
        ProcesoFuncional detalle = (ProcesoFuncional) session.getAttribute("pfDetalle");

        ProcesoFuncionalJpaController pfjpa = new ProcesoFuncionalJpaController(EntityProvider.provider());

        ProcesoFuncional pf= pfjpa.findProcesoFuncional(idPF);
        pf.setNomPF(nombrePF);
        pf.setDescripcion(descripcionPF);
        pf.seteventoDes(eventoDes);
        
        try {
            pfjpa.edit(pf);
            session.setAttribute("pfDetalle", pf);
        } catch (Exception e) {
            e.printStackTrace();
            redireccion = "modificaPF.jsp";
            return;
        } finally {
            redireccion = "detallePF.jsp";
            response.sendRedirect(redireccion);
        }
    }

}

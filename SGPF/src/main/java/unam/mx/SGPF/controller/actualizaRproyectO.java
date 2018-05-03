/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.Proyecto;
import unam.mx.SGPF.model.Usuario;
import unam.mx.SGPF.model.controller.InterUPJpaController;
import unam.mx.SGPF.model.controller.ProyectoJpaController;

/**
 *
 * @author jlope
 */
public class actualizaRproyectO extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String redireccion = "";
        String nombreProy = request.getParameter("nombreProyecto");
        int idProy = Integer.parseInt(request.getParameter("idProyecto"));
        System.out.println("Get parameter = " + request.getParameter("idProyecto") + " y id es: " + idProy);
        HttpSession session = request.getSession(true);
        Usuario u = (Usuario) session.getAttribute("usuario");

        ProyectoJpaController pjpa = new ProyectoJpaController(EntityProvider.provider());
        short a = 1;
        BigDecimal big = new BigDecimal(0.24);
        Proyecto p = pjpa.findProyecto(idProy);
        p.setNomProy(nombreProy);
        try {
            pjpa.edit(p);
            InterUPJpaController ijpa = new InterUPJpaController(EntityProvider.provider());
            List<InterUP> inters = ijpa.getProyectosUsuario(u);
            // Apuntador al objeto u
            session.setAttribute("usuario", u);
            session.setAttribute("inters", inters);
        } catch (Exception e) {
            e.printStackTrace();
            redireccion = "modificaProyecto.jsp";
            return;
        } finally {
            redireccion = "proyectos.jsp";
            response.sendRedirect(redireccion);
        }
    }

}

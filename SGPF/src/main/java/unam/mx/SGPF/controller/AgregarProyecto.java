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
public class AgregarProyecto extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String redireccion = "";
        String nombreProy = request.getParameter("nombreProyecto");
        HttpSession session = request.getSession(true);
        Usuario u = (Usuario) session.getAttribute("usuario");
        InterUPJpaController ijpa = new InterUPJpaController(EntityProvider.provider());

        System.out.println("Nombre proyecto: " + nombreProy);
        ProyectoJpaController pjpa = new ProyectoJpaController(EntityProvider.provider());
        short a = 1;
        BigDecimal big = new BigDecimal(0.24);
        Proyecto newProyecto = new Proyecto(nombreProy, "2015", a, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, a, 1, a, a, nombreProy, big, nombreProy, nombreProy, nombreProy, nombreProy, nombreProy, nombreProy, nombreProy, nombreProy, nombreProy, nombreProy, a, nombreProy, nombreProy, nombreProy, nombreProy, nombreProy, nombreProy);
        try {
            pjpa.create(newProyecto);
            // FIXME: Esta evaluación monousuario y no considera los problemas de concurrencia.
            newProyecto = pjpa.findLastProyecto();
            InterUP up = new InterUP();
            up.setIdproyecto(newProyecto);
            up.setIdusuario(u);
            ijpa.create(up);
            List<InterUP> inters = ijpa.getProyectosUsuario(u);
            // Apuntador al objeto u
            session.setAttribute("usuario", u);
            session.setAttribute("inters", inters);
        } catch (Exception e) {
            e.printStackTrace();
            redireccion = "agregarProyecto.jsp";
            return;
        } finally {
            redireccion = "proyectos.jsp";
            response.sendRedirect(redireccion);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

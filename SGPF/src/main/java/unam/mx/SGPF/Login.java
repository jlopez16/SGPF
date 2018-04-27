/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.Usuario;
import unam.mx.SGPF.model.controller.UsuarioJpaController;

/**
 *
 * @author pancha
 */
public class Login extends HttpServlet {
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
    	//Aquí recibe los parámetros del formulario de inicio de sesión 
        String usuario = request.getParameter("uname");
        String pass = request.getParameter("psw");
        
        //Clase de metodos para el crud
        //Objeto que establece la conexión ujpa de tabla USUARIO
        UsuarioJpaController ujpa = new UsuarioJpaController(EntityProvider.provider());
        Usuario u = ujpa.getUsuarioByUserAndPass(usuario, pass);
        
        //Objeto que establece la sesión 
        HttpSession session = request.getSession(true);
        
        //Apuntador al objeto u
        session.setAttribute("usuario", u);
        response.sendRedirect("proyectos.jsp");
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

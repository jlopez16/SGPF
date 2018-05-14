package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.Usuario;
import unam.mx.SGPF.model.controller.UsuarioJpaController;

public class agregarUsuario extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nomUsuario = request.getParameter("nomUsuario");
        String pwdUsuario = request.getParameter("pwdUsuario");
        short usuTipo = Short.parseShort(request.getParameter("usuTipo"));
        Short aux=1;
        Usuario usuario = new Usuario();
        UsuarioJpaController ujpa = new UsuarioJpaController(EntityProvider.provider());
        usuario.setNomUsuario(nomUsuario);
        usuario.setPwdUsuario(pwdUsuario);
        switch (usuTipo) {
            case 1:
                usuario.setUsuTipo1(aux);
                break;
            case 2:
                usuario.setUsuTipo2(aux);
                break;
            case 3:
                usuario.setUsuTipo3(aux);
                break;
        }
        try{
        ujpa.create(usuario);
        }catch(Exception e){
        }finally{
            response.sendRedirect("gestionUsuarios");
        }
    }
}

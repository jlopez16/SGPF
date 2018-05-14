package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.Usuario;
import unam.mx.SGPF.model.controller.UsuarioJpaController;

public class modificaUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
        String nomUsuario = request.getParameter("nomUsuario");
        String pwdUsuario = request.getParameter("pwdUsuario");
        short usuTipo = Short.parseShort(request.getParameter("usuTipo"));
        String eliminaUsuario = request.getParameter("eliminaUsuario");
        Short aux=1;
        UsuarioJpaController ujpa = new UsuarioJpaController(EntityProvider.provider());
        Usuario usuario = ujpa.findUsuario(IdUsuario);
        usuario.setNomUsuario(nomUsuario);
        usuario.setPwdUsuario(pwdUsuario);
        if(eliminaUsuario==null){
            if(usuTipo==1){
                usuario.setUsuTipo1(aux);
                usuario.setUsuTipo2(null);
                usuario.setUsuTipo3(null);
            } 
            else{
                if(usuTipo==2){
                    usuario.setUsuTipo1(null);
                    usuario.setUsuTipo2(aux);
                    usuario.setUsuTipo3(null);
                }
                else{
                    usuario.setUsuTipo1(null);
                    usuario.setUsuTipo2(null);
                    usuario.setUsuTipo3(aux);
                }
            }
        }else{
            usuario.setUsuTipo1(null);
            usuario.setUsuTipo2(null);
            usuario.setUsuTipo3(null);
        }
            
        try{
            ujpa.edit(usuario);
        }catch(Exception e){
        
        }finally{
            HttpSession session = request.getSession(true);
            response.sendRedirect("gestionUsuarios");
        }
    }
}

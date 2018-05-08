package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.controller.ProcesoFuncionalJpaController;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;
import java.util.List;
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.AccionJpaController;
import unam.mx.SGPF.model.controller.GrupoDatoJpaController;
import unam.mx.SGPF.model.controller.UsuarioFuncionalJpaController;

public class agregandoActividad extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	//VARIABLES QUE PROVIENEN DEL FORM modificaPF.jsp
        String redireccion = "";
        String NombreActividad = request.getParameter("actividad");
        String descripcionActividad = request.getParameter("descripcion");
        int idUsuarioFuncional = Integer.parseInt(request.getParameter("usuarioFuncional"));
        int idAccion = Integer.parseInt(request.getParameter("accion"));
        int idGrupoDatos = Integer.parseInt(request.getParameter("grupoDatos"));
        String flujoAl_ = request.getParameter("flujoAl");
        
        //OBTENER EL OBJETO PF PARA OBTENER IDPROY
        HttpSession session = request.getSession(true);
        ProcesoFuncional detalle = (ProcesoFuncional) session.getAttribute("pfDetalle");

        SubProceso aux = new SubProceso();
        aux.setActividad(NombreActividad);
        aux.setDescripcion(descripcionActividad);
        aux.setIdprocesoFuncional(detalle);
        
        SubProcesoJpaController subPjpa = new SubProcesoJpaController(EntityProvider.provider());
        List<SubProceso> subProceso = subPjpa.findSPByActividad(NombreActividad);
        if(subProceso.size()==0)
            aux.setIndice(1);
        else
            aux.setIndice(subProceso.size()+1);
        short b = 0;
        if (flujoAl_==null)
            b=1;
        aux.setFlujoAl(b);
        
        UsuarioFuncionalJpaController usuarioFuncional = new UsuarioFuncionalJpaController(EntityProvider.provider());
        UsuarioFuncional MiUsuarioFuncional = usuarioFuncional.findUsuarioFuncional(idUsuarioFuncional);
        aux.setIdusuarioFuncional(MiUsuarioFuncional);
        
        AccionJpaController accion = new AccionJpaController(EntityProvider.provider());
        Accion MiAccion = accion.findAccion(idAccion);
        aux.setIdaccion(MiAccion);
        
        GrupoDatoJpaController grupoDatos = new GrupoDatoJpaController(EntityProvider.provider());
        GrupoDato MiGrupoDato = grupoDatos.findGrupoDato(idGrupoDatos);
        aux.setIdgrupoDato(MiGrupoDato);
        
        try {
            subPjpa.create(aux);
        } catch (Exception e) {
            redireccion = "addActividad.jsp";
            return;
        } finally {
            redireccion = "detallePF.jsp";
            ProcesoFuncional PF = (ProcesoFuncional) session.getAttribute("pfDetalle");
        
            ProcesoFuncionalJpaController pfjpa = new ProcesoFuncionalJpaController(EntityProvider.provider());
            ProcesoFuncional pfDetalle = pfjpa.findProcesoFuncional(PF.getIdprocesoFuncional());
            session.setAttribute("pfDetalle", pfDetalle);
        
            SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
            List<SubProceso> sp = spjpa.findSPByIDPForder(PF.getIdprocesoFuncional());
            session.setAttribute("subProc", sp);
            response.sendRedirect(redireccion);
        }
    }
}

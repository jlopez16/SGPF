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
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.AccionJpaController;
import unam.mx.SGPF.model.controller.GrupoDatoJpaController;
import unam.mx.SGPF.model.controller.ProcesoFuncionalJpaController;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;
import unam.mx.SGPF.model.controller.UsuarioFuncionalJpaController;

public class modificandoActividad extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String redireccion = "";
        HttpSession session = request.getSession(true);
        SubProceso subProcesoMod = (SubProceso) session.getAttribute("subProcesoMod");
        String OldActividad = subProcesoMod.getActividad();
        String NombreActividad = request.getParameter("actividad");
        String descripcionActividad = request.getParameter("descripcion");
        int idUsuarioFuncional = Integer.parseInt(request.getParameter("usuarioFuncional"));
        int idAccion = Integer.parseInt(request.getParameter("accion"));
        int idGrupoDatos = Integer.parseInt(request.getParameter("grupoDatos"));
        String flujoAl_ = request.getParameter("flujoAl");
        
        short b = 0;
        if (flujoAl_=="1")
            b=1;
        subProcesoMod.setFlujoAl(b);
        subProcesoMod.setDescripcion(descripcionActividad);
        
        UsuarioFuncionalJpaController usuarioFuncional = new UsuarioFuncionalJpaController(EntityProvider.provider());
        UsuarioFuncional MiUsuarioFuncional = usuarioFuncional.findUsuarioFuncional(idUsuarioFuncional);
        subProcesoMod.setIdusuarioFuncional(MiUsuarioFuncional);
        
        AccionJpaController accion = new AccionJpaController(EntityProvider.provider());
        Accion MiAccion = accion.findAccion(idAccion);
        subProcesoMod.setIdaccion(MiAccion);
        
        GrupoDatoJpaController GrupoDato = new GrupoDatoJpaController(EntityProvider.provider());
        GrupoDato MiGrupoDato = GrupoDato.findGrupoDato(idGrupoDatos);
        subProcesoMod.setIdgrupoDato(MiGrupoDato);
        
        subProcesoMod.setActividad(NombreActividad);
        
        try{
            SubProcesoJpaController aux = new SubProcesoJpaController(EntityProvider.provider());
            List<SubProceso> ListSubProcesos = aux.findSPByActividad(OldActividad);
            aux.edit(subProcesoMod);
            for(SubProceso iterador : ListSubProcesos){
                subProcesoMod = iterador;
                subProcesoMod.setActividad(NombreActividad);
                //subProcesoMod.setIdsubProceso(iterador.getIdsubProceso());
                aux.edit(subProcesoMod);
            }
            
        }catch(Exception e){
            redireccion="modificaActividad.jsp";
            return;
        }
        finally{
            redireccion="detallePF.jsp";
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

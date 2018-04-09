/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bc.EmpleadoFacadeLocal;
import be.Empleado;
import be.GrupoUsuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author argos
 */
@ManagedBean
@SessionScoped
public class ManagedBeanLogin implements Serializable {

    @EJB
    private EmpleadoFacadeLocal empleadoFacade;
    private Empleado objetoEmpleado;
    int admin_ = 0;

    public ManagedBeanLogin() {
        objetoEmpleado = new Empleado();
    }

    public int getAdmin_() {
        return admin_;
    }

    public void setAdmin_(int admin_) {
        this.admin_ = admin_;
    }

    public Empleado getObjetoEmpleado() {
        return objetoEmpleado;
    }

    public void setObjetoEmpleado(Empleado objetoEmpleado) {
        this.objetoEmpleado = objetoEmpleado;
    }

    
    public String traerDatosPersonal(String user_) {
        String resultado_ = "";
        try {
            if (user_ != null) {
                if (objetoEmpleado.getIdEmpleado() == null) {
                    objetoEmpleado = empleadoFacade.buscarTerminoExacto("usuario", user_, "idEmpleado", 0).get(0);
                    resultado_ = objetoEmpleado.getNombreEmpleado();

                    for (GrupoUsuario gu : objetoEmpleado.getGrupoUsuarioList()) {
                        if (gu.getGrupo().getNombreGrupo().equals("administrador")) {
                            admin_ = 1;
                        }
                    }

                } else {
                    resultado_ = objetoEmpleado.getNombreEmpleado();

                }
            } else {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado_;
    }
}

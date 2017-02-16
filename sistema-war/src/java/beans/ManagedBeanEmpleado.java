
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bc.EmpleadoFacadeLocal;
import bc.GrupoUsuarioFacadeLocal;
import be.Empleado;
import be.Grupo;
import be.GrupoUsuario;
import be.TipoEmpleado;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 **Copyright 2011 Yury Daniel Zavaleta De la Cruz Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
@ManagedBean
@SessionScoped
public class ManagedBeanEmpleado implements Serializable {

    @EJB
    private GrupoUsuarioFacadeLocal grupoUsuarioFacade;
    @EJB
    private EmpleadoFacadeLocal empleadoFacade;
    private Empleado empleado;
    private List<Empleado> lista;
    private List<SelectItem> empleadoItems = new LinkedList<SelectItem>();
    private HashMap<Integer, Empleado> myempleados = new HashMap<Integer, Empleado>();

    public List<SelectItem> getEmpleados_VendedorItems() {
        lista = new ArrayList<Empleado>();
        empleadoItems = new LinkedList<SelectItem>();
        lista = empleadoFacade.findAll();
        for (Empleado p : lista) {
            myempleados.put(p.getIdEmpleado(), p);
            empleadoItems.add(new SelectItem(p, p.getNombreEmpleado()));
        }
        return empleadoItems;
    }

    public Empleado getEmpleado(Integer id) {
        return (Empleado) myempleados.get(id);

    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<SelectItem> getEmpleadoItems() {
        return empleadoItems;
    }

    public void setEmpleadoItems(List<SelectItem> empleadoItems) {
        this.empleadoItems = empleadoItems;
    }

    public HashMap<Integer, Empleado> getMyempleados() {
        return myempleados;
    }

    public void setMyempleados(HashMap<Integer, Empleado> myempleados) {
        this.myempleados = myempleados;
    }

    public List<Empleado> getLista_Empleados() {

        try {
            lista = new LinkedList<Empleado>();
            List<Empleado> lista_temp = new LinkedList<Empleado>();
            lista_temp = empleadoFacade.findAll();
            for (int i = lista_temp.size() - 1; i >= 0; i--) {

                lista.add(lista_temp.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public String Nuevo() {
        empleado = new Empleado();

        empleado.setTipoEmpleado(new TipoEmpleado(1));
        return "nuevo_empleado";
    }

    public void newObject() {
        empleado = new Empleado();

        empleado.setTipoEmpleado(new TipoEmpleado(1));

    }

    public String crear() {

        try {

            empleadoFacade.create(empleado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "empleados?faces-redirect=true";

    }

    public void crearNew() {

        try {


            empleado.setEstadoExistencia(1);
            empleadoFacade.create(empleado);
            GrupoUsuario objetoGrupoUsuario = new GrupoUsuario();
            objetoGrupoUsuario.setEmpleado(empleado);
            // de momento usamos este por defecto
            objetoGrupoUsuario.setGrupo(new Grupo(1));
            grupoUsuarioFacade.create(objetoGrupoUsuario);
            FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }


    }

    public String Volver_TipoCliente() {
        return "index?faces-redirect=true";
    }

    public String edicion() {
        return "editar_empleado";
    }

    public String editar() {

        try {
            empleadoFacade.edit(empleado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "empleados?faces-redirect=true";
    }

    public void editarNew() {

        try {
            empleadoFacade.edit(empleado);
            FacesMessage msg = new FacesMessage("EDITADO CON EXITO", "CORRECTO");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }


    }
}

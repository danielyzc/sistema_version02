
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.ConductorFacadeLocal;
import be.Conductor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
 * @author root : Zavaleta De la Cruz Yury Daniel
 * Copyright 2011 Zavaleta De la Cruz Yury Daniel

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */




@ManagedBean
@SessionScoped
public class ManagedBeanConductor implements Serializable{
   @EJB
    private ConductorFacadeLocal conductorFacade;
private List<Conductor> lista;
private Conductor conductor;
 private List<SelectItem> condcutorItems = new LinkedList<SelectItem>();
private HashMap<Integer, Conductor> myconductores = new HashMap<Integer,Conductor>();

    public ManagedBeanConductor() {
   lista = new LinkedList<Conductor>();
   conductor = new Conductor();
    }

    public List<SelectItem> getCondcutorItems() {
          lista = new ArrayList<Conductor>();
        condcutorItems = new LinkedList<SelectItem>();
        lista = conductorFacade.findAll();
        for(Conductor p: lista){
        myconductores.put(p.getIdConductor(), p);
        condcutorItems.add(new SelectItem(p, p.getNombre()));
        }
        return condcutorItems;
    }

    public void setCondcutorItems(List<SelectItem> condcutorItems) {
        this.condcutorItems = condcutorItems;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public List<Conductor> getLista() {
        try {
            lista=new LinkedList<Conductor>();
     List<Conductor> lista_temp= new LinkedList<Conductor>();
     lista_temp =conductorFacade.findAll();
          for(int i=lista_temp.size()-1;i>=0;i--){
         
             lista.add(lista_temp.get(i));
                  }
        } catch (Exception e) {
        }
        return lista;
    }

    public void setLista(List<Conductor> lista) {
        this.lista = lista;
    }

    public HashMap<Integer, Conductor> getMyconductores() {
        return myconductores;
    }

    public void setMyconductores(HashMap<Integer, Conductor> myconductores) {
        this.myconductores = myconductores;
    }


     public String Nuevo(){
 conductor = new Conductor();
 conductor.setFechaRegistro( new Date());
 return "nuevo_conductor";
 }

public void newObject(){
   conductor = new Conductor();
 conductor.setFechaRegistro( new Date());
    
    }
     public String Edicion(){
  return "editar_conductor";
 }

    public String crear(){
     try {
     conductorFacade.create(conductor);
     } catch (Exception e) {
    e.printStackTrace();
     }
return "conductores?faces-redirect=true";
 }
    
    public void crearNew(){
     try {
     conductorFacade.create(conductor);
      FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
     } catch (Exception e) {
    e.printStackTrace();
    FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
     }

 }

    public String editar(){
     try {
     conductorFacade.edit(conductor);
     } catch (Exception e) {
    e.printStackTrace();
     }
return "conductores?faces-redirect=true";
 }
public void editarNew(){

    try {
  conductorFacade.edit(conductor);
        FacesMessage msg = new FacesMessage("EDITADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
  

}

    public String Volver_Conductor(){
return "index?faces-redirect=true";
     }

public Conductor getConductor(Integer id) {
           return (Conductor)myconductores.get(id);

    }
}

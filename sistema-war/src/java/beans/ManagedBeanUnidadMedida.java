/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.UnidadMedidaFacadeLocal;
import be.Proveedor;
import be.UnidadMedida;
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
public class ManagedBeanUnidadMedida implements Serializable{
    @EJB
    private UnidadMedidaFacadeLocal unidadMedidaFacade;
    private List<UnidadMedida> lista;
   private UnidadMedida unidad;

 private List<SelectItem> UnidadesItems = new LinkedList<SelectItem>();
private HashMap<Integer, UnidadMedida> myunidades = new HashMap<Integer,UnidadMedida>();

    public ManagedBeanUnidadMedida() {
    lista = new LinkedList<UnidadMedida>();
    unidad = new UnidadMedida();
    }

    public List<SelectItem> getUnidadesItems() {


        lista = new ArrayList<UnidadMedida>();
        UnidadesItems = new LinkedList<SelectItem>();
        lista = unidadMedidaFacade.findAll();
        for(UnidadMedida p: lista){
        myunidades.put(p.getIdUnidadMedida(), p);
            UnidadesItems.add(new SelectItem(p, p.getNombreUnidadMedida()));
        }
           
        return UnidadesItems;
    }

    public void setUnidadesItems(List<SelectItem> UnidadesItems) {
        this.UnidadesItems = UnidadesItems;
    }

    public HashMap<Integer, UnidadMedida> getMyunidades() {
        return myunidades;
    }

    public void setMyunidades(HashMap<Integer, UnidadMedida> myunidades) {
        this.myunidades = myunidades;
    }

    public UnidadMedida getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadMedida unidad) {
        this.unidad = unidad;
    }

    public List<UnidadMedida> getLista() {
         try {
        lista=new LinkedList<UnidadMedida>();
            List<UnidadMedida> lista_temp= new LinkedList<UnidadMedida>();
            lista_temp =unidadMedidaFacade.findAll();
          for(int i=lista_temp.size()-1;i>=0;i--){
            lista.add(lista_temp.get(i));
          }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista;
    }

public UnidadMedida getUnidadMedida(Integer id) {
           return (UnidadMedida) myunidades.get(id);

    }





public void newObject(){
 unidad = new UnidadMedida();
    
    }
public void crearNew(){

    try {
     unidadMedidaFacade.create(unidad);
                 FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    }

public String Nuevo(){
 unidad = new UnidadMedida();
 return "nueva_unidad";
 }


 public String crear(){
     try {
      unidadMedidaFacade.create(unidad);
     } catch (Exception e) {
    e.printStackTrace();
     }


return "unidades?faces-redirect=true";

 }

 public String editar(){
     try {
      unidadMedidaFacade.edit(unidad);
     } catch (Exception e) {
    e.printStackTrace();
     }


return "unidades?faces-redirect=true";

 }
 public void editarNew(){

    try {
       unidadMedidaFacade.edit(unidad);
        FacesMessage msg = new FacesMessage("EDITADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
  

}

  public String Volver_Venta(){
return "index?faces-redirect=true";
     }

  public String editar_unidad(){
 return "editar_unidades_medida";
 }

}

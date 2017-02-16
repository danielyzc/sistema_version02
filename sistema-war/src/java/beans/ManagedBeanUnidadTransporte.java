/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.UnidadTransporteFacadeLocal;
import be.UnidadTransporte;
import be.ZonaCiudad;
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
public class ManagedBeanUnidadTransporte implements Serializable{
    @EJB
    private UnidadTransporteFacadeLocal unidadTransporteFacade;
private List<UnidadTransporte> lista;
private UnidadTransporte unidadtransporte;
 private List<SelectItem> unidadesItems = new LinkedList<SelectItem>();
private HashMap<Integer, UnidadTransporte> myunidades = new HashMap<Integer,UnidadTransporte>();

    public ManagedBeanUnidadTransporte() {
 lista = new LinkedList<UnidadTransporte>();
 unidadtransporte = new UnidadTransporte();
             }

    public List<UnidadTransporte> getLista() {
        try {
          lista=new LinkedList<UnidadTransporte>();
            List<UnidadTransporte> lista_temp= new LinkedList<UnidadTransporte>();
            lista_temp =unidadTransporteFacade.findAll();
          for(int i=lista_temp.size()-1;i>=0;i--){
            lista.add(lista_temp.get(i));
          }
        } catch (Exception e) {
        }
        return lista;
    }

    public void setLista(List<UnidadTransporte> lista) {
        this.lista = lista;
    }

    public HashMap<Integer, UnidadTransporte> getMyunidades() {
        return myunidades;
    }

    public void setMyunidades(HashMap<Integer, UnidadTransporte> myunidades) {
        this.myunidades = myunidades;
    }

    public List<SelectItem> getUnidadesItems() {

         lista = new ArrayList<UnidadTransporte>();
        unidadesItems = new LinkedList<SelectItem>();
        lista = unidadTransporteFacade.findAll();

        
        for(UnidadTransporte p: lista){
        myunidades.put(p.getIdUnidadTransporte(), p);
            unidadesItems.add(new SelectItem(p, p.getMarca()));
        }
         return unidadesItems;
    }

    public void setUnidadesItems(List<SelectItem> unidadesItems) {
        this.unidadesItems = unidadesItems;
    }

    public UnidadTransporte getUnidadtransporte() {
        return unidadtransporte;
    }

    public void setUnidadtransporte(UnidadTransporte unidadtransporte) {
        this.unidadtransporte = unidadtransporte;
    }

    
    public void newObject(){
unidadtransporte = new UnidadTransporte();
 unidadtransporte.setFechaRegistro(new Date());
    
    }
public void crearNew(){

    try {

         unidadTransporteFacade.create(unidadtransporte);
                 FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   

}
    public String Nueva(){
 unidadtransporte = new UnidadTransporte();
 unidadtransporte.setFechaRegistro(new Date());
 return "nueva_unidad_transporte";
 }


    public String crear(){
     try {
         unidadTransporteFacade.create(unidadtransporte);
     } catch (Exception e) {
    e.printStackTrace();
     }
return "unidades_transporte?faces-redirect=true";

 }

        public String editar(){
     try {
         unidadTransporteFacade.edit(unidadtransporte);
     } catch (Exception e) {
    e.printStackTrace();
     }
return "unidades_transporte?faces-redirect=true";

 }
public void editarNew(){

    try {
     unidadTransporteFacade.edit(unidadtransporte);
        FacesMessage msg = new FacesMessage("EDITADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
  

}
    public String Volver_Unidad(){
return "index?faces-redirect=true";
     }


    public String Edicion(){
return "editar_unidad_transporte";
     }

    public UnidadTransporte getUnidadTrasporte(Integer id) {
           return (UnidadTransporte) myunidades.get(id);

    }
}

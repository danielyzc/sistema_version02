
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.TipoProductoFacadeLocal;
import be.TipoCliente;
import be.TipoProducto;
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
 **Copyright  2011 Yury Daniel Zavaleta De la Cruz
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and  limitations under the License.
 */




@ManagedBean
@SessionScoped
public class ManagedBeanTipoProducto implements Serializable {
       @EJB
   private  TipoProductoFacadeLocal tipoProductoFacade ;
       private List<TipoProducto> lista;

       private List<SelectItem> tipoProductosItems = new LinkedList<SelectItem>();
private HashMap<Integer, TipoProducto> mytipoProductos = new HashMap<Integer,TipoProducto>();
private TipoProducto tipo;
    public ManagedBeanTipoProducto() {
        tipo = new TipoProducto();
    }
public List<TipoProducto> getLista_tipo_Producto(){
    try {
       lista=new LinkedList<TipoProducto>();
            List<TipoProducto> lista_temp= new LinkedList<TipoProducto>();
            lista_temp =tipoProductoFacade.findAll();
          for(int i=lista_temp.size()-1;i>=0;i--){
            lista.add(lista_temp.get(i));
          }
    } catch (Exception e) {
        e.printStackTrace();
    }
return lista;
}
 public TipoProducto getTipoProducto(Integer id) {
           return (TipoProducto) mytipoProductos.get(id);

    }

    public HashMap<Integer, TipoProducto> getMytipoProductos() {
        return mytipoProductos;
    }

    public void setMytipoProductos(HashMap<Integer, TipoProducto> mytipoProductos) {
        this.mytipoProductos = mytipoProductos;
    }

    public List<SelectItem> getTipoProductosItems() {




        lista = new ArrayList<TipoProducto>();
        tipoProductosItems = new LinkedList<SelectItem>();
        lista = tipoProductoFacade.findAll();
        for(TipoProducto p: lista){
        mytipoProductos.put(p.getIdTipoProducto(), p);
            tipoProductosItems.add(new SelectItem(p, p.getNombreTipoProducto()));
        }
        return tipoProductosItems;

    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public void setTipoProductosItems(List<SelectItem> tipoProductosItems) {
        this.tipoProductosItems = tipoProductosItems;
    }

    public void newObject(){
tipo = new TipoProducto();
    
    }
public void crearNew(){

    try {
    tipoProductoFacade.create(tipo);
                 FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   

}
    public String Nuevo(){
tipo = new TipoProducto();
return "nuevo_tipo_productos";
}
public String crear(){
    try {
        tipoProductoFacade.create(tipo);
    } catch (Exception e) {
    e.printStackTrace();
    }
 return "tipo_productos?faces-redirect=true";
}

 public String Volver_TipoProductos(){
return "index?faces-redirect=true";
     }

 public String editar(){
 return "editar_tipo_producto";
 }
 public String edicion(){
     try {
         tipoProductoFacade.edit(tipo);
     } catch (Exception e) {
     e.printStackTrace();
     }
      return "tipo_productos?faces-redirect=true";
 }

 public void editarNew(){

    try {
        tipoProductoFacade.edit(tipo);
        FacesMessage msg = new FacesMessage("EDITADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
  

}
 
}

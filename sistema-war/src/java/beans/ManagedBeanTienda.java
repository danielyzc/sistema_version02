
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.TiendaFacadeLocal;
import be.Negocio;
import be.Tienda;
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
public class ManagedBeanTienda implements  Serializable{
    @EJB
   private  TiendaFacadeLocal tiendaFacade ;
private Tienda tienda ;
 private List<Tienda> lista ;
private List<SelectItem> tiendasItems = new LinkedList<SelectItem>();
private HashMap<Integer, Tienda> mytiendas = new HashMap<Integer,Tienda>();
    public ManagedBeanTienda() {
        tienda = new Tienda();
        lista = new LinkedList<Tienda>();
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public List<SelectItem> getTiendasItems() {
        lista = new ArrayList<Tienda>();
        tiendasItems = new LinkedList<SelectItem>();
        lista = tiendaFacade.findAll();
        for(Tienda p: lista){
        mytiendas.put(p.getIdTienda(), p);
            tiendasItems.add(new SelectItem(p, p.getNombreTienda()));
        }
        return tiendasItems;
    }

    public Tienda getTienda(Integer id) {
    return (Tienda) mytiendas.get(id);
     }


    public void setTiendasItems(List<SelectItem> tiendasItems) {
        this.tiendasItems = tiendasItems;
    }

    public HashMap<Integer, Tienda> getMytiendas() {
        return mytiendas;
    }

    public void setMytiendas(HashMap<Integer, Tienda> mytiendas) {
        this.mytiendas = mytiendas;
    }


public List<Tienda>  getLista_Tiendas(){

    try {
  lista=new LinkedList<Tienda>();
      List<Tienda> lista_temp= new LinkedList<Tienda>();
                   lista_temp =tiendaFacade.findAll();
          for(int i=lista_temp.size()-1;i>=0;i--){
            lista.add(lista_temp.get(i));
          }

    } catch (Exception e) {
    }
return lista;
}


public String Nueva(){
tienda = new Tienda();
tienda.setNegocio(new Negocio(1));
return "nuevo_almacen";
}
public void newObject(){
tienda = new Tienda();
tienda.setNegocio(new Negocio(1));

}

public void crearNew(){

    try {
        tiendaFacade.create(tienda);
         FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
  
   
}
public String crear(){

    try {
        tiendaFacade.create(tienda);
       
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "almacenes?faces-redirect=true";
   
}


public String edicion(){
return "editar_tienda";
}
public String editar(){

    try {
        tiendaFacade.edit(tienda);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "almacenes?faces-redirect=true";

}

public void editarNew(){

    try {
        tiendaFacade.edit(tienda);
        FacesMessage msg = new FacesMessage("EDITADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
  

}


  public String Volver_Tienda(){
return "index?faces-redirect=true";
     }
}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.ProveedorFacadeLocal;
import bc.TipoProveedorFacadeLocal;
import be.Proveedor;
import be.TipoProveedor;
import java.io.Serializable;
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
public class ManagedBeanProveedor implements Serializable{
  
    @EJB
    private ProveedorFacadeLocal proveedorFacade;

    private Proveedor proveedor;
    private List<Proveedor> lista;


  private List<SelectItem> proveedoresItems = new LinkedList<SelectItem>();
 private HashMap<Integer, Proveedor> myproveedores = new HashMap<Integer,Proveedor>();


        public ManagedBeanProveedor() {
        proveedor = new Proveedor();
        lista = new LinkedList<Proveedor>();
    }

    public HashMap<Integer, Proveedor> getMyproveedores() {
        return myproveedores;
    }

    public void setMyproveedores(HashMap<Integer, Proveedor> myproveedores) {
        this.myproveedores = myproveedores;
    }

    public List<SelectItem> getProveedoresItems() {
        return proveedoresItems;
    }

    public void setProveedoresItems(List<SelectItem> proveedoresItems) {
        this.proveedoresItems = proveedoresItems;
    }


    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

public List<Proveedor> getListaProveedores(){
    try {
        lista=new LinkedList<Proveedor>();
      List<Proveedor> lista_temp= new LinkedList<Proveedor>();
                   lista_temp =proveedorFacade.findAll();
          for(int i=lista_temp.size()-1;i>=0;i--){
            lista.add(lista_temp.get(i));
          }
    } catch (Exception e) {
    e.printStackTrace();
    }
    return lista;
}
public void newObject(){
proveedor = new Proveedor();
    
    }
public void crearNew(){

    try {
       proveedorFacade.create(proveedor);
                 FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    }
public String Nuevo(){
proveedor = new Proveedor();
return "nuevo_proveedor";
}


public String crear(){
    try {
        proveedorFacade.create(proveedor);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "proveedores?faces-redirect=true";
}

public String editando(){
    try {
        proveedorFacade.edit(proveedor);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "proveedores?faces-redirect=true";
}
public void editarNew(){

    try {
      proveedorFacade.edit(proveedor);
        FacesMessage msg = new FacesMessage("EDITADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
  

}

public String crear2(){
    try {
        proveedorFacade.create(proveedor);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "compras?faces-redirect=true";
}



public String Volver(){
return "index?faces-redirect=true";
}

    

    
 public Proveedor getDevuelve_Proveedor(Integer id) {
    return (Proveedor) myproveedores.get(id);
     }


public List<Proveedor> completar_filtrado_Proveedores(String nombre) {
  lista = new LinkedList<Proveedor>();
            for(Proveedor p : proveedorFacade.findAll()){
                 myproveedores.put(p.getIdProveedor(), p);
    if (p.getNombre().toUpperCase().indexOf(nombre.toUpperCase())!=-1){
    lista.add(p);

    }
    }
       return lista;
    }

 public String edicion(){
return "editar_proveedor";
    }
}

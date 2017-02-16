
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.TipoClienteFacadeLocal;
import be.ColorProducto;
import be.EstadoProducto;
import be.MaterialProducto;
import be.ModeloProducto;
import be.PrecioProducto;
import be.Producto;
import be.TallaProducto;
import be.TipoCliente;
import be.UbicacionFisica;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class ManagedBeanTipoCliente implements Serializable{
    @EJB
    private TipoClienteFacadeLocal tipoClienteFacade;


    private TipoCliente tipo_cliente;
    private List<TipoCliente> lista ;
    private List<SelectItem> tipoclientesItems = new LinkedList<SelectItem>();
private HashMap<Integer, TipoCliente> mytipoclientes = new HashMap<Integer,TipoCliente>();
    public ManagedBeanTipoCliente() {
        tipo_cliente= new TipoCliente();
        lista= new LinkedList<TipoCliente>();
    }

    public TipoCliente getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(TipoCliente tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public HashMap<Integer, TipoCliente> getMytipoclientes() {
        return mytipoclientes;
    }

    public void setMytipoclientes(HashMap<Integer, TipoCliente> mytipoclientes) {
        this.mytipoclientes = mytipoclientes;
    }

    public List<SelectItem> getTipoclientesItems() {
        
        lista = new LinkedList<TipoCliente>();
        tipoclientesItems = new LinkedList<SelectItem>();
        lista = tipoClienteFacade.findAll();
        for(TipoCliente p: lista){
        mytipoclientes.put(p.getIdTipoCliente(), p);
            tipoclientesItems.add(new SelectItem(p, p.getNombreTipoCliente()));
        }
       return tipoclientesItems;
    }

    public void setTipoclientesItems(List<SelectItem> tipoclientesItems) {
        this.tipoclientesItems = tipoclientesItems;
    }

 public TipoCliente getTipoCliente(Integer id) {
           return (TipoCliente) mytipoclientes.get(id);

    }

 public List<TipoCliente> getListaTipoCliente(){
 
     try {
           lista=new LinkedList<TipoCliente>();
            List<TipoCliente> lista_temp= new LinkedList<TipoCliente>();
            lista_temp =tipoClienteFacade.findAll();
          for(int i=lista_temp.size()-1;i>=0;i--){
            lista.add(lista_temp.get(i));
          }
     } catch (Exception e) {
     }
return lista;
 }

 public void newObject(){
tipo_cliente = new TipoCliente();
    
    }
public void crearNew(){

    try {
    tipoClienteFacade.create(tipo_cliente);
                 FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   

}

  public String Nuevo(){
tipo_cliente = new TipoCliente();
    return "nuevo_tipo_cliente";
    }


  public String Editar(){
    return "editar_tipo_cliente";
    }

  public String crear(){

    try {
                tipoClienteFacade.create(tipo_cliente);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "tipo_clientes?faces-redirect=true";

}

  public String editar(){

    try {
                tipoClienteFacade.edit(tipo_cliente);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "tipo_clientes?faces-redirect=true";

}

  public void editarNew(){

    try {
        tipoClienteFacade.edit(tipo_cliente);
        FacesMessage msg = new FacesMessage("EDITADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
  

}
  

   public String Volver_TipoCliente(){
return "index?faces-redirect=true";
     }
}

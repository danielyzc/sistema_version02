
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.CanjeOrdenCompraFacadeLocal;
import bc.OrdenCompraFacadeLocal;
import be.CanjeOrdenCompra;
import be.EstadoCanjeOrdenCompra;
import be.EstadoFacturacionOrdenCompra;
import be.FacturaCompra;
import be.OrdenCompra;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;
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
public class ManagedBeanCanjeOrdenCompra implements Serializable{
    @EJB
    private CanjeOrdenCompraFacadeLocal canjeOrdenCompraFacade;
       @EJB
    private OrdenCompraFacadeLocal ordenCompraFacade;
private  CanjeOrdenCompra canjeordencompra;
private List<CanjeOrdenCompra> lista;

    public ManagedBeanCanjeOrdenCompra() {
        canjeordencompra = new CanjeOrdenCompra();
        lista = new LinkedList<CanjeOrdenCompra>();
    }

    public CanjeOrdenCompra getCanjeordencompra() {
        return canjeordencompra;
    }

    public void setCanjeordencompra(CanjeOrdenCompra canjeordencompra) {
        this.canjeordencompra = canjeordencompra;
    }

    
    
    public void newObject(OrdenCompra o){
  canjeordencompra = new CanjeOrdenCompra();
    canjeordencompra.setOrdenCompra(o);

   } 

public void crearNew(){

    try {
        canjeordencompra.setEstadoCanjeOrdenCompra(new EstadoCanjeOrdenCompra(1));
        canjeordencompra.setFechaCreacionCanje(new Date());
        canjeOrdenCompraFacade.create(canjeordencompra);
        OrdenCompra orden = new OrdenCompra();
        orden = canjeordencompra.getOrdenCompra();
        //orden= facturacompra.getOrdenCompra();
        orden.setEstadoFacturacionOrdenCompra(new EstadoFacturacionOrdenCompra(3));
        ordenCompraFacade.edit(orden);
         FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
  
   
}


    public String Nuevo(OrdenCompra o){
    canjeordencompra = new CanjeOrdenCompra();
    canjeordencompra.setOrdenCompra(o);
    return "nuevo_canje_orden";
    }
public String crear(){
    try {
        canjeordencompra.setEstadoCanjeOrdenCompra(new EstadoCanjeOrdenCompra(1));
        canjeordencompra.setFechaCreacionCanje(new Date());
       canjeOrdenCompraFacade.create(canjeordencompra);


   //    facturacompra.setFechaRecepcion(new Date());
        OrdenCompra orden = new OrdenCompra();
        orden = canjeordencompra.getOrdenCompra();
        //orden= facturacompra.getOrdenCompra();
        orden.setEstadoFacturacionOrdenCompra(new EstadoFacturacionOrdenCompra(3));
        ordenCompraFacade.edit(orden);
      //        lista.clear();


    } catch (Exception e) {
    }
    return "facturacion";
}

public List<CanjeOrdenCompra> getLista(){
    try {
        lista = canjeOrdenCompraFacade.findAll();
    } catch (Exception e) {
    }
    return lista;
}
public String Editar(){
return "editar_canje_orden_compra";
}

public String guardar(){
    try {
        canjeOrdenCompraFacade.edit(canjeordencompra);
    } catch (Exception e) {
    }

    return "letras?faces-redirect=true";

}
}

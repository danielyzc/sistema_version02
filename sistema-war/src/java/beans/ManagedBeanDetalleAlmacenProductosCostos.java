
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.DetalleAlmacenProductosCostosFacadeLocal;
import be.DetalleAlmacenProductosCostos;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
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
public class ManagedBeanDetalleAlmacenProductosCostos implements Serializable {
    @EJB
    private DetalleAlmacenProductosCostosFacadeLocal detalleAlmacenProductosCostosFacade;

    private DetalleAlmacenProductosCostos detalle;
     private List<DetalleAlmacenProductosCostos> lista;
    public ManagedBeanDetalleAlmacenProductosCostos() {
        detalle = new DetalleAlmacenProductosCostos();
        lista = new LinkedList<DetalleAlmacenProductosCostos>();
    }

    public DetalleAlmacenProductosCostos getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleAlmacenProductosCostos detalle) {
        this.detalle = detalle;
    }

    public List<DetalleAlmacenProductosCostos> getLista() {
        lista.clear();
      for(DetalleAlmacenProductosCostos d : detalleAlmacenProductosCostosFacade.findAll())
      {
      if(d.getEstadoProductoCostoAlmacen().getIdEstadoProductoCostoAlmacen()==1)
      {
      lista.add(d);
      }
      }
          return lista;
    }

    public void setLista(List<DetalleAlmacenProductosCostos> lista) {
        this.lista = lista;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Producto Seleccionado", ((DetalleAlmacenProductosCostos) event.getObject()).getProducto().getNombreProducto());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }



    public void destroyWorld(ActionEvent actionEvent){

        try {
             this.editar2();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acción ejecutada con éxito",  "Se ejecutó con éxito");
        FacesContext.getCurrentInstance().addMessage(null, message);

        } catch (Exception e) {
   e.printStackTrace();

   FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error en la Aplicación",  "Se ejecuto con exito");
        FacesContext.getCurrentInstance().addMessage(null, message);

        }



    }



    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Producto No seleccionado", ((DetalleAlmacenProductosCostos) event.getObject()).getProducto().getNombreProducto());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }



    public void onRowDblselect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
        Flash flash = context.getExternalContext().getFlash();
        flash.put("selectedCar", (DetalleAlmacenProductosCostos) event.getObject());

        handler.performNavigation("carDetail");
    }
public String editar()
    {
        try {
            detalleAlmacenProductosCostosFacade.edit(detalle);
        } catch (Exception e) {
        e.printStackTrace();
        }
        return "detalle_almacenes_costos?faces-redirect=true";
}


public void editar2()
    {
        try {
            detalleAlmacenProductosCostosFacade.edit(detalle);
        } catch (Exception e) {
        e.printStackTrace();
        }
        
}
}

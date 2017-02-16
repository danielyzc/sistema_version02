
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.DetalleAlmacenProductosFacadeLocal;
import be.DetalleAlmacenProductos;
import be.EstadoOrdenSalidaDetalleAlmacenProductos;
import be.StockProductoTiendaOrigen;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
public class ManagedBeanDetalleAlmacenProductos implements Serializable{
    @EJB
    private DetalleAlmacenProductosFacadeLocal detalleAlmacenProductosFacade;

    private DetalleAlmacenProductos detalle;
    private List<DetalleAlmacenProductos> lista;

     private List<SelectItem> detallesItems = new LinkedList<SelectItem>();
private HashMap<Integer, DetalleAlmacenProductos> mydetalles = new HashMap<Integer,DetalleAlmacenProductos>();

 private String fecha_vencimiento="";
  SimpleDateFormat fecha_vencimiento1 = new SimpleDateFormat("dd/MM/yyyy");
           StringBuilder cadena_fecha_vencimiento = new StringBuilder();

    public ManagedBeanDetalleAlmacenProductos() {
        detalle = new DetalleAlmacenProductos();
        lista = new LinkedList<DetalleAlmacenProductos>();
    }

    public DetalleAlmacenProductos getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleAlmacenProductos detalle) {
        this.detalle = detalle;
    }

    public List<DetalleAlmacenProductos> getLista() {
        return lista;
    }

    public void setLista(List<DetalleAlmacenProductos> lista) {
        this.lista = lista;
    }

    
    
    
    public void llenar_myDetalles(){
    try {

        
        for(DetalleAlmacenProductos p: detalleAlmacenProductosFacade.findAll()){

             mydetalles.put(p.getIdDetalleAlmacenProductos(), p);
           

        }
        
       
    } catch (Exception e) {
        e.printStackTrace();
    }

}
    public List<SelectItem> DetallesItems(StockProductoTiendaOrigen dt) {

          lista = new LinkedList<DetalleAlmacenProductos>();
        detallesItems = new LinkedList<SelectItem>();
        lista = detalleAlmacenProductosFacade.findAll();
        for(DetalleAlmacenProductos p: lista){

        if(p.getEstadoProductoCostoAlmacen().getIdEstadoProductoCostoAlmacen()==1 && p.getTienda().equals(dt.getTienda()) && p.getProducto().equals(dt.getProducto())){
            mydetalles.put(p.getIdDetalleAlmacenProductos(), p);
            cadena_fecha_vencimiento = new StringBuilder( fecha_vencimiento1.format( p.getFechaVencimiento() ) );

              // agregando la fecha y la ubicacion del elemento a agregar en la lista
            //  SE VA A MODIFICAR LA UBICACION
            detallesItems.add(new SelectItem(p,cadena_fecha_vencimiento.toString() + " : Cant("+p.getQuedaron() +")  -  " + p.getUbicacionFisica().getNombreUbicacionFisica()));
            }

        }

        return detallesItems;
    }

    public void setDetallesItems(List<SelectItem> detallesItems) {
        this.detallesItems = detallesItems;
    }

    public HashMap<Integer, DetalleAlmacenProductos> getMydetalles() {
        return mydetalles;
    }

    public void setMydetalles(HashMap<Integer, DetalleAlmacenProductos> mydetalles) {
        this.mydetalles = mydetalles;
    }

    public DetalleAlmacenProductos getDetalle(Integer id) {
           return (DetalleAlmacenProductos) mydetalles.get(id);

    }

}

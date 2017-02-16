
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.EstadoOrdenSalidaDetalleAlmacenProductosFacadeLocal;
import be.EstadoOrdenSalidaDetalleAlmacenProductos;
import java.io.Serializable;
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
public class ManagedBeanEstadoOrdenSalida implements Serializable{
    @EJB
    private EstadoOrdenSalidaDetalleAlmacenProductosFacadeLocal estadoOrdenSalidaDetalleAlmacenProductosFacade;

    
    private EstadoOrdenSalidaDetalleAlmacenProductos estado;
            private List<EstadoOrdenSalidaDetalleAlmacenProductos> lista ;
     private List<SelectItem> estadosalidasItems = new LinkedList<SelectItem>();
   private HashMap<Integer, EstadoOrdenSalidaDetalleAlmacenProductos> myestadoordencompras = new HashMap<Integer,EstadoOrdenSalidaDetalleAlmacenProductos>();

    public ManagedBeanEstadoOrdenSalida() {
        estado = new EstadoOrdenSalidaDetalleAlmacenProductos();
        lista = new LinkedList<EstadoOrdenSalidaDetalleAlmacenProductos>();
    }

    public List<SelectItem> getEstadosalidasItems() {

         lista = new LinkedList<EstadoOrdenSalidaDetalleAlmacenProductos>();
        estadosalidasItems = new LinkedList<SelectItem>();
        lista = estadoOrdenSalidaDetalleAlmacenProductosFacade.findAll();
        for(EstadoOrdenSalidaDetalleAlmacenProductos p: lista){


            myestadoordencompras.put(p.getIdEstadoOrdenSalidaDetalleAlmacenProductos(), p);
            estadosalidasItems.add(new SelectItem(p, p.getNombreEstado()));


        }

        return estadosalidasItems;
    }


     public EstadoOrdenSalidaDetalleAlmacenProductos getEstadoSalida(Integer id) {
           return (EstadoOrdenSalidaDetalleAlmacenProductos) myestadoordencompras.get(id);

    }

    public void setEstadosalidasItems(List<SelectItem> estadosalidasItems) {
        this.estadosalidasItems = estadosalidasItems;
    }

    public HashMap<Integer, EstadoOrdenSalidaDetalleAlmacenProductos> getMyestadoordencompras() {
        return myestadoordencompras;
    }

    public void setMyestadoordencompras(HashMap<Integer, EstadoOrdenSalidaDetalleAlmacenProductos> myestadoordencompras) {
        this.myestadoordencompras = myestadoordencompras;
    }



    public void llenar_myOrdenes(){
    try {

        for(EstadoOrdenSalidaDetalleAlmacenProductos p : estadoOrdenSalidaDetalleAlmacenProductosFacade.findAll()){
        myestadoordencompras.put(p.getIdEstadoOrdenSalidaDetalleAlmacenProductos(),p);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

}

}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.EstadoProductoCostoAlmacenFacadeLocal;
import be.EstadoProductoCostoAlmacen;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
public class ManagedBeanEstadoProductoCostoAlmacen implements Serializable{
    @EJB
  private  EstadoProductoCostoAlmacenFacadeLocal estadoProductoCostoAlmacenFacade;
private EstadoProductoCostoAlmacen estado;
 private List<EstadoProductoCostoAlmacen> lista;
  private List<SelectItem> estadoproductosItems = new LinkedList<SelectItem>();
private HashMap<Integer, EstadoProductoCostoAlmacen> myestadoproductos = new HashMap<Integer,EstadoProductoCostoAlmacen>();

    public ManagedBeanEstadoProductoCostoAlmacen() {
    estado = new EstadoProductoCostoAlmacen();
    lista = new LinkedList<EstadoProductoCostoAlmacen>();
    }

    public EstadoProductoCostoAlmacen getEstado() {
        return estado;
    }

    public void setEstado(EstadoProductoCostoAlmacen estado) {
        this.estado = estado;
    }

    public List<SelectItem> getEstadoproductosItems() {

        lista = new LinkedList<EstadoProductoCostoAlmacen>();
        estadoproductosItems = new LinkedList<SelectItem>();
        lista = estadoProductoCostoAlmacenFacade.findAll();
        for(EstadoProductoCostoAlmacen p: lista){
      myestadoproductos.put(p.getIdEstadoProductoCostoAlmacen(), p);
           estadoproductosItems.add(new SelectItem(p, p.getNombre()));

        }
       
        return estadoproductosItems;
    }

    public void setEstadoproductosItems(List<SelectItem> estadoproductosItems) {
        this.estadoproductosItems = estadoproductosItems;
    }

    public List<EstadoProductoCostoAlmacen> getLista() {
        return lista;
    }

    public void setLista(List<EstadoProductoCostoAlmacen> lista) {
        this.lista = lista;
    }

    public HashMap<Integer, EstadoProductoCostoAlmacen> getMyestadoproductos() {
        return myestadoproductos;
    }

    public void setMyestadoproductos(HashMap<Integer, EstadoProductoCostoAlmacen> myestadoproductos) {
        this.myestadoproductos = myestadoproductos;
    }

public EstadoProductoCostoAlmacen getEstadoProducto(Integer id) {
           return (EstadoProductoCostoAlmacen) myestadoproductos.get(id);

    }
}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.TipoServicioFacadeLocal;
import be.TipoServicio;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
public class ManagedBeanTipoServicio implements Serializable{
    @EJB
    private TipoServicioFacadeLocal tipoServicioFacade;
private TipoServicio tipo;

 private List<TipoServicio> lista;

       private List<SelectItem> tipoServiciosItems = new LinkedList<SelectItem>();
private HashMap<Integer, TipoServicio> mytipoServicios = new HashMap<Integer,TipoServicio>();


    public ManagedBeanTipoServicio() {
        tipo = new TipoServicio();
        lista = new LinkedList<TipoServicio>();
    }

    public List<TipoServicio> getLista() {
        try {
            lista = tipoServicioFacade.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void setLista(List<TipoServicio> lista) {
        this.lista = lista;
    }

    public HashMap<Integer, TipoServicio> getMytipoServicios() {
        return mytipoServicios;
    }

    public void setMytipoServicios(HashMap<Integer, TipoServicio> mytipoServicios) {
        this.mytipoServicios = mytipoServicios;
    }

    public TipoServicio getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    public List<SelectItem> getTipoServiciosItems() {
        return tipoServiciosItems;
    }

    public void setTipoServiciosItems(List<SelectItem> tipoServiciosItems) {
        this.tipoServiciosItems = tipoServiciosItems;
    }

    public String Nuevo(){
tipo = new TipoServicio();
return "nuevo_tipo_servicio";
}
public String crear(){
    try {
       tipoServicioFacade.create(tipo);
    } catch (Exception e) {
    e.printStackTrace();
    }
 return "tipo_servicio?faces-redirect=true";
}


public String Volver_TipoServicios(){
return "index?faces-redirect=true";
     }

 public String editar(){
 return "editar_tipo_servicio";
 }

 public String edicion(){
     try {
        tipoServicioFacade.edit(tipo);
     } catch (Exception e) {
     e.printStackTrace();
     }
      return "tipo_servicio?faces-redirect=true";
 }
}

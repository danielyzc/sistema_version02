
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.ProduccionAlmacenFacadeLocal;
import be.ProduccionAlmacen;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class ManagedBeanProduccionAlmacen implements Serializable{
    @EJB
    private ProduccionAlmacenFacadeLocal produccionAlmacenFacade;

    private List<ProduccionAlmacen> lista;
   private ProduccionAlmacen produccion;
private Date fecha_busqueda;
    public ManagedBeanProduccionAlmacen() {
        lista = new LinkedList<ProduccionAlmacen>();
        produccion = new ProduccionAlmacen();
        fecha_busqueda = new Date();
    }

    public  String nueva (){
        produccion = new ProduccionAlmacen();
        produccion.setFechaRegistro(new Date());
    return "nueva_produccion";
    }

     public  String producciones (){
     fecha_busqueda= new Date();
          return "producciones";
    }

    public Date getFecha_busqueda() {
        return fecha_busqueda;
    }

    public void setFecha_busqueda(Date fecha_busqueda) {
        this.fecha_busqueda = fecha_busqueda;
    }

    public List<ProduccionAlmacen> getLista() {
         lista.clear();
        try {
            for(ProduccionAlmacen p : produccionAlmacenFacade.findAll()){
                if(fecha_busqueda.equals(p.getFechaRegistro())){
                  lista.add(p);
                }

      }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void setLista(List<ProduccionAlmacen> lista) {
        this.lista = lista;
    }

    public ProduccionAlmacen getProduccion() {
        return produccion;
    }

    public void setProduccion(ProduccionAlmacen produccion) {
        this.produccion = produccion;
    }

 public  void FiltrarListaProduccionesFecha(){
         lista.clear();
        try {
            for(ProduccionAlmacen p : produccionAlmacenFacade.findAll()){
                if(fecha_busqueda.equals(p.getFechaRegistro())){
                  lista.add(p);
                }

      }
        } catch (Exception e) {
            e.printStackTrace();
        }
           }



  public String crear(){
     try {
      produccionAlmacenFacade.create(produccion);
     } catch (Exception e) {
    e.printStackTrace();
     }


return "producciones?faces-redirect=true";

 }

}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.TallaProductoFacadeLocal;
import be.TallaProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
public class ManagedBeanTallaProducto implements Serializable {
    @EJB
    private TallaProductoFacadeLocal tallaProductoFacade;
private List<TallaProducto> lista;

  private List<SelectItem> tallaProductosItems = new LinkedList<SelectItem>();
private HashMap<Integer, TallaProducto> mytallaProductos = new HashMap<Integer,TallaProducto>();
private TallaProducto talla;

    public ManagedBeanTallaProducto() {
        talla = new TallaProducto();
    }

    public List<TallaProducto> getLista_tallas(){
        try {
            lista = tallaProductoFacade.findAll();
        } catch (Exception e) {
        e.printStackTrace();
        }
    return lista;
    }

    public TallaProducto getTalla() {
        return talla;
    }

    public void setTalla(TallaProducto talla) {
        this.talla = talla;
    }

    public HashMap<Integer, TallaProducto> getMytallaProductos() {
        return mytallaProductos;
    }

    public void setMytallaProductos(HashMap<Integer, TallaProducto> mytallaProductos) {
        this.mytallaProductos = mytallaProductos;
    }

    public List<SelectItem> getTallaProductosItems() {
         lista = new ArrayList<TallaProducto>();
        tallaProductosItems = new LinkedList<SelectItem>();
        lista = tallaProductoFacade.findAll();
        for(TallaProducto p: lista){
        mytallaProductos.put(p.getIdTallaProducto(), p);
            tallaProductosItems.add(new SelectItem(p, p.getNombreTallaProducto()));
        }
        return tallaProductosItems;
    }

    public void setTallaProductosItems(List<SelectItem> tallaProductosItems) {
        this.tallaProductosItems = tallaProductosItems;
    }

     public TallaProducto getTallaProducto(Integer id) {
           return (TallaProducto) mytallaProductos.get(id);

    }

     public String nueva(){
     talla = new TallaProducto();
     return "nueva_talla";
     }

     public String nueva_ubicacion3(){
     talla = new TallaProducto();
     return "nueva_ubicacion3";
     }

     public String crear(){

         try {
             tallaProductoFacade.create(talla);
         } catch (Exception e) {
         e.printStackTrace();
         }

     return "ubicacion3?faces-redirect=true";
     }

      public String Volver_Ubicacion3(){
return "index?faces-redirect=true";
     }
}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.ModeloProductoFacadeLocal;
import be.ModeloProducto;
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
 **Copyright  2011 Yury Daniel Zavaleta De la Cruz  Licensed under the Apache License,
 * Version 2.0 (the "License");
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
public class ManagedBeanModeloProducto implements Serializable {
    @EJB
    private ModeloProductoFacadeLocal modeloProductoFacade;
private List<ModeloProducto> lista;
private ModeloProducto modelo;

  private List<SelectItem> modeloProductosItems = new LinkedList<SelectItem>();
private HashMap<Integer, ModeloProducto> mymodeloProductos = new HashMap<Integer,ModeloProducto>();

    public ManagedBeanModeloProducto() {
        lista = new LinkedList<ModeloProducto>();
        modelo = new ModeloProducto();
    }
public List<ModeloProducto>  getListaModelos(){
    try {
        lista = modeloProductoFacade.findAll();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista;
}

    public ModeloProducto getModelo() {
        return modelo;
    }

    public void setModelo(ModeloProducto modelo) {
        this.modelo = modelo;
    }


    public List<SelectItem> getModeloProductosItems() {


        lista = new ArrayList<ModeloProducto>();
        modeloProductosItems = new LinkedList<SelectItem>();
        lista = modeloProductoFacade.findAll();
        for(ModeloProducto p: lista){
        mymodeloProductos.put(p.getIdModeloProducto(), p);
            modeloProductosItems.add(new SelectItem(p, p.getNombreModeloProducto()));
        }
           return modeloProductosItems;


    }

    public void setModeloProductosItems(List<SelectItem> modeloProductosItems) {
        this.modeloProductosItems = modeloProductosItems;
    }

    public HashMap<Integer, ModeloProducto> getMytipoProductos() {
        return mymodeloProductos;
    }

    public void setMytipoProductos(HashMap<Integer, ModeloProducto> mytipoProductos) {
        this.mymodeloProductos = mytipoProductos;
    }

 public ModeloProducto getModeloProducto(Integer id) {
           return (ModeloProducto) mymodeloProductos.get(id);

    }

 public String Nuevo(){
 modelo = new ModeloProducto();
 return "nuevo_modelo_Producto";
 }

 public String Nuevo_Ubicacion1(){
 modelo = new ModeloProducto();
 return "nueva_ubicacion1";
 }
 public String crear(){
     try {
         modeloProductoFacade.create(modelo);
     } catch (Exception e) {
    e.printStackTrace();
     }


return "ubicacion1?faces-redirect=true";

 }

  public String Volver_Venta(){
return "index?faces-redirect=true";
     }

   public String Volver_Ubicacion1(){
return "index?faces-redirect=true";
     }
}

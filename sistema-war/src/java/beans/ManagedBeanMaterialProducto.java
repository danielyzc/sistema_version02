
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.MaterialProductoFacadeLocal;
import be.MaterialProducto;
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
 * Licensed under the Apache License,
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
public class ManagedBeanMaterialProducto implements Serializable {
     @EJB
  private  MaterialProductoFacadeLocal materialProductoFacade;
private List<MaterialProducto> lista;
  private List<SelectItem> materialProductosItems = new LinkedList<SelectItem>();
private HashMap<Integer, MaterialProducto> mymaterialProductos = new HashMap<Integer,MaterialProducto>();
private MaterialProducto material;
    public ManagedBeanMaterialProducto() {
        material = new MaterialProducto();
    }

    public List<MaterialProducto> getLista_materiales(){
        try {
            lista = materialProductoFacade.findAll();
        } catch (Exception e) {
        e.printStackTrace();
        }
    return lista;
    }

    public List<SelectItem> getMaterialProductosItems() {
          lista = new ArrayList<MaterialProducto>();
        materialProductosItems = new LinkedList<SelectItem>();
        lista = materialProductoFacade.findAll();
        for(MaterialProducto p: lista){
       mymaterialProductos.put(p.getIdMaterialProducto(), p);
            materialProductosItems.add(new SelectItem(p, p.getNombreMaterialProducto()));
        }
        return materialProductosItems;
    }

    public void setMaterialProductosItems(List<SelectItem> materialProductosItems) {
        this.materialProductosItems = materialProductosItems;
    }

    public HashMap<Integer, MaterialProducto> getMymaterialProductos() {
        return mymaterialProductos;
    }

    public void setMymaterialProductos(HashMap<Integer, MaterialProducto> mymaterialProductos) {
        this.mymaterialProductos = mymaterialProductos;
    }

    public MaterialProducto getTallaProducto(Integer id) {
           return (MaterialProducto) mymaterialProductos.get(id);

    }

    public String Nuevo(){
    material= new MaterialProducto();
    return "nuevo_material";
    }

    public MaterialProducto getMaterial() {
        return material;
    }

    public void setMaterial(MaterialProducto material) {
        this.material = material;
    }

    public String crear(){
        try {
            materialProductoFacade.create(material);
        } catch (Exception e) {
        e.printStackTrace();
        }
        return "accesorios";
    }
}

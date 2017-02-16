
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.ColorProductoFacadeLocal;
import be.ColorProducto;
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
public class ManagedBeanColorProducto implements Serializable{
    @EJB
    private ColorProductoFacadeLocal colorProductoFacade;
private List<ColorProducto> lista;
 private List<SelectItem> colorProductosItems = new LinkedList<SelectItem>();
private HashMap<Integer, ColorProducto> mycolorProductos = new HashMap<Integer,ColorProducto>();
private ColorProducto color ;
    public ManagedBeanColorProducto() {
        lista = new LinkedList<ColorProducto>();
        color = new ColorProducto();
    }
public List<ColorProducto> getLista_colore(){
    try {
        lista = colorProductoFacade.findAll();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista;
}

    public List<SelectItem> getColorProductosItems() {
         lista = new ArrayList<ColorProducto>();
       colorProductosItems = new LinkedList<SelectItem>();
        lista = colorProductoFacade.findAll();
        for(ColorProducto p: lista){
       mycolorProductos.put(p.getIdColorProducto(), p);
            colorProductosItems.add(new SelectItem(p, p.getNombreColorProducto()));
        }
        return colorProductosItems;
    }

    public ColorProducto getColor() {
        return color;
    }

    public void setColor(ColorProducto color) {
        this.color = color;
    }

    public void setColorProductosItems(List<SelectItem> colorProductosItems) {
        this.colorProductosItems = colorProductosItems;
    }

    public HashMap<Integer, ColorProducto> getMycolorProductos() {
        return mycolorProductos;
    }

    public void setMycolorProductos(HashMap<Integer, ColorProducto> mycolorProductos) {
        this.mycolorProductos = mycolorProductos;
    }

   

public ColorProducto getColorProducto(Integer id) {
           return (ColorProducto) mycolorProductos.get(id);

    }





public String nuevo_color(){
color = new ColorProducto();
return "nuevo_color";
}

public String Nueva_Ubicacion2(){
color = new ColorProducto();
return "nueva_ubicacion2";
}

 public String crear(){
     try {
         colorProductoFacade.create(color);
     } catch (Exception e) {
    e.printStackTrace();
     }

return "ubicacion2?faces-redirect=true";
 }

 public String Volver_Ubicacion2(){
return "index?faces-redirect=true";
     }

}



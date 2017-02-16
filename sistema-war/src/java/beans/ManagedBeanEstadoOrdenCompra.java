
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.EstadoOrdenCompraFacadeLocal;
import be.EstadoOrdenCompra;
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
 **Copyright  2011 Yury Daniel Zavaleta De la Cruz
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and  limitations under the License.
 */
@ManagedBean
@SessionScoped
public class ManagedBeanEstadoOrdenCompra implements Serializable{
    @EJB
    private EstadoOrdenCompraFacadeLocal estadoOrdenCompraFacade;
    private EstadoOrdenCompra estadoordencompra;
    private List<EstadoOrdenCompra> lista ;

    private List<SelectItem> estadoordencompraItems = new LinkedList<SelectItem>();
private HashMap<Integer, EstadoOrdenCompra> myestadoordencompras = new HashMap<Integer,EstadoOrdenCompra>();


    public ManagedBeanEstadoOrdenCompra() {
estadoordencompra = new EstadoOrdenCompra();
lista = new LinkedList<EstadoOrdenCompra>();
    }

    public EstadoOrdenCompra getEstadoordencompra() {
        return estadoordencompra;
    }

    public void setEstadoordencompra(EstadoOrdenCompra estadoordencompra) {
        this.estadoordencompra = estadoordencompra;
    }

    public List<SelectItem> getEstadoordencompraItems() {

          lista = new LinkedList<EstadoOrdenCompra>();
        estadoordencompraItems = new LinkedList<SelectItem>();
        lista = estadoOrdenCompraFacade.findAll();
        for(EstadoOrdenCompra p: lista){

        if(p.getIdEstadoOrdenCompra() < 3){
            myestadoordencompras.put(p.getIdEstadoOrdenCompra(), p);
            estadoordencompraItems.add(new SelectItem(p, p.getNombre()));
            }

        }
               return estadoordencompraItems;
    }

    public void setEstadoordencompraItems(List<SelectItem> estadoordencompraItems) {
        this.estadoordencompraItems = estadoordencompraItems;
    }

    public HashMap<Integer, EstadoOrdenCompra> getMyestadoordencompras() {
        return myestadoordencompras;
    }

    public void setMyestadoordencompras(HashMap<Integer, EstadoOrdenCompra> myestadoordencompras) {
        this.myestadoordencompras = myestadoordencompras;
    }


    public EstadoOrdenCompra getTipoCliente(Integer id) {
           return (EstadoOrdenCompra) myestadoordencompras.get(id);

    }

 public List<EstadoOrdenCompra> getListaEstadoOrdenCompra(){
 lista = new LinkedList<EstadoOrdenCompra>();
     try {
       lista =  estadoOrdenCompraFacade.findAll();
     } catch (Exception e) {
     }
return lista;
 }

  public String Nuevo(){
estadoordencompra = new EstadoOrdenCompra();
    return "nuevo_estado_orden_compra";
    }

  public String crear(){

    try {
                estadoOrdenCompraFacade.create(estadoordencompra);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "estado_orden_compra?faces-redirect=true";

}

   public String Volver_EstadoOrdenCompra(){
return "index?faces-redirect=true";
     }



}

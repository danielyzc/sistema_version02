
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.EstadoVentaFacadeLocal;
import be.EstadoVenta;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
public class ManagedBeanEstadoVenta implements Serializable{

    @EJB
    private EstadoVentaFacadeLocal estadoVentaFacade;
private EstadoVenta estadoventa;
 private List<EstadoVenta> lista ;

    private List<SelectItem> estadoventaItems = new LinkedList<SelectItem>();
private HashMap<Integer, EstadoVenta> myestadoventas = new HashMap<Integer,EstadoVenta>();


public ManagedBeanEstadoVenta() {
estadoventa = new EstadoVenta();
    }

    public EstadoVenta getEstadoventa() {
        return estadoventa;
    }

    public void setEstadoventa(EstadoVenta estadoventa) {
        this.estadoventa = estadoventa;
    }

    public List<SelectItem> getEstadoventaItems() {

          lista = new LinkedList<EstadoVenta>();
        estadoventaItems = new LinkedList<SelectItem>();
        lista = estadoVentaFacade.findAll();
        for(EstadoVenta p: lista){

        if (p.getIdEstadoVenta()< 3){
            myestadoventas.put(p.getIdEstadoVenta(), p);
            estadoventaItems.add(new SelectItem(p, p.getNombreTestadoVenta()));
            }

        }
        return estadoventaItems;
    }


    public List<SelectItem> getEstadoventa_serviciosItems() {

          lista = new LinkedList<EstadoVenta>();
        estadoventaItems = new LinkedList<SelectItem>();
        lista = estadoVentaFacade.findAll();
        for(EstadoVenta p: lista){

        if (p.getIdEstadoVenta()==4 || p.getIdEstadoVenta()==6 ){
            myestadoventas.put(p.getIdEstadoVenta(), p);
            estadoventaItems.add(new SelectItem(p, p.getNombreTestadoVenta()));
            }

        }
        return estadoventaItems;
    }







     public List<SelectItem> getEstadoventa_serviciosUPDATEItems() {

          lista = new LinkedList<EstadoVenta>();
        estadoventaItems = new LinkedList<SelectItem>();
        lista = estadoVentaFacade.findAll();
        for(EstadoVenta p: lista){

        if (p.getIdEstadoVenta()>3  ){
            myestadoventas.put(p.getIdEstadoVenta(), p);
            estadoventaItems.add(new SelectItem(p, p.getNombreTestadoVenta()));
            }

        }
        return estadoventaItems;
    }

    public void setEstadoventaItems(List<SelectItem> estadoventaItems) {
        this.estadoventaItems = estadoventaItems;
    }

    public HashMap<Integer, EstadoVenta> getMyestadoventas() {
        return myestadoventas;
    }

    public void setMyestadoventas(HashMap<Integer, EstadoVenta> myestadoventas) {
        this.myestadoventas = myestadoventas;
    }




    public EstadoVenta getEstadoVenta(Integer id) {
           return (EstadoVenta) myestadoventas.get(id);

    }

 public List<EstadoVenta> getListaEstadoVenta(){
 lista = new LinkedList<EstadoVenta>();
     try {
       lista =  estadoVentaFacade.findAll();
     } catch (Exception e) {
     }
return lista;
 }

  public String Nuevo(){
estadoventa = new EstadoVenta();
    return "nuevo_estado_venta";
    }

  public String crear(){

    try {
                estadoVentaFacade.create(estadoventa);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "estado_venta?faces-redirect=true";

}

   public String Volver_Estadoventa(){
return "index?faces-redirect=true";
     }



}

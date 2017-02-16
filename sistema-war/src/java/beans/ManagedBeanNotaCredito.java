
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.NotaCreditoFacadeLocal;
import bc.VentaFacadeLocal;
import be.NotaCredito;
import be.Venta;
import java.io.Serializable;
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
public class ManagedBeanNotaCredito implements Serializable{
    @EJB
    private VentaFacadeLocal ventaFacade;
    @EJB
    private NotaCreditoFacadeLocal notaCreditoFacade;
private Date fecha_busqueda;
private NotaCredito notacredito;
private List <NotaCredito> lista;
private int id_venta;
    public ManagedBeanNotaCredito() {
       notacredito = new NotaCredito();
       lista = new LinkedList<NotaCredito>();
       id_venta=0;
       fecha_busqueda = new Date();
    }

    public Date getFecha_busqueda() {
        return fecha_busqueda;
    }

    public void setFecha_busqueda(Date fecha_busqueda) {
        this.fecha_busqueda = fecha_busqueda;
    }

    public NotaCredito getNotacredito() {
        return notacredito;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }


    public void setNotacredito(NotaCredito notacredito) {
        this.notacredito = notacredito;
    }
    public void BuscarNota(){
        try {
for (Venta v : ventaFacade.findAll()){
if(v.getIdVenta() == id_venta){
notacredito.setVenta(v);
}
}
        } catch (Exception e) {
        }
    }


      public  void FiltrarListaNotasCreditoFecha(){
         lista.clear();
        try {
            for(NotaCredito p : notaCreditoFacade.findAll()){
                if(fecha_busqueda.equals(p.getFechaRegistro())){
                  lista.add(p);
                }
      }
        } catch (Exception e) {
            e.printStackTrace();
        }
           }

      public List<NotaCredito> getRetornaLista() {
        return lista;
    }
      public String Volver_NotaCredito(){
return "ventas?faces-redirect=true";
     }
      public String Nueva (){
      notacredito = new NotaCredito();
      return "nueva_nota";
      }


       public String Notas (){
           lista.clear();
      return "notas_credito";
      }
      public String Crear(){
      notacredito.setVenta(new Venta(id_venta));
      notacredito.setFechaRegistro(new Date());

          try {
              notaCreditoFacade.create(notacredito);
              lista.clear();
          } catch (Exception e) {
          }

      return "notas_credito?faces-redirect=true";
      }
}

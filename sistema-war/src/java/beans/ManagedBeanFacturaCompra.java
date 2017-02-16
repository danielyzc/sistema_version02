
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.FacturaCompraFacadeLocal;
import bc.OrdenCompraFacadeLocal;
import be.EstadoFacturacionOrdenCompra;
import be.FacturaCompra;
import be.Negocio;
import be.OrdenCompra;
import be.Tienda;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 **Copyright  2011 Yury Daniel Zavaleta De la Cruz
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 ** http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



@SessionScoped
@ManagedBean

public class ManagedBeanFacturaCompra implements Serializable{
    @EJB
    private OrdenCompraFacadeLocal ordenCompraFacade;
    @EJB
    private FacturaCompraFacadeLocal facturaCompraFacade;

private FacturaCompra facturacompra;
private   List<FacturaCompra> lista ;
private Date fecha_busqueda;

    public ManagedBeanFacturaCompra() {
    facturacompra = new FacturaCompra();
    lista = new LinkedList<FacturaCompra>();
    fecha_busqueda = new Date();
    }

    public FacturaCompra getFacturacompra() {
        return facturacompra;
    }

    public void setFacturacompra(FacturaCompra facturacompra) {
        this.facturacompra = facturacompra;
    }

    public List<FacturaCompra> getListafacturas(){
       lista = new LinkedList<FacturaCompra>();
     try {
       lista =  facturaCompraFacade.findAll();
     } catch (Exception e) {
     }
return lista;
 }

    public Date getFecha_busqueda() {
        return fecha_busqueda;
    }

    public void setFecha_busqueda(Date fecha_busqueda) {
        this.fecha_busqueda = fecha_busqueda;
    }


 public List<FacturaCompra> getRetornaLista() {
        return lista;
    }

     public  void FiltrarListaIngresosFecha(){
         lista.clear();
        try {
            for(FacturaCompra p : facturaCompraFacade.findAll()){
                if(fecha_busqueda.equals(p.getFechaRecepcion())){
                  lista.add(p);
                }


      }
        } catch (Exception e) {
            e.printStackTrace();
        }
           }


public void newObject(OrdenCompra o){
 facturacompra = new FacturaCompra();
 facturacompra.setOrdenCompra(o);

}

public void crearNew(){

    try {
       facturacompra.setFechaRecepcion(new Date());
        OrdenCompra orden = new OrdenCompra();
        orden= facturacompra.getOrdenCompra();
        orden.setEstadoFacturacionOrdenCompra(new EstadoFacturacionOrdenCompra(2));
        ordenCompraFacade.edit(orden);
        facturaCompraFacade.create(facturacompra);
        lista.clear();
         FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
  
   
}





  public String Nuevo(OrdenCompra o){

 facturacompra = new FacturaCompra();
 facturacompra.setOrdenCompra(o);
 return "nueva_facturacion";
 }


  public String Facturacion(){
     
 return "facturacion";
 }
  public String crear(){

    try {
       
        facturacompra.setFechaRecepcion(new Date());
        OrdenCompra orden = new OrdenCompra();
        orden= facturacompra.getOrdenCompra();
        orden.setEstadoFacturacionOrdenCompra(new EstadoFacturacionOrdenCompra(2));
        ordenCompraFacade.edit(orden);
        facturaCompraFacade.create(facturacompra);
        lista.clear();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "facturacion?faces-redirect=true";

}

   public String Volver_TipoCliente(){
return "index?faces-redirect=true";
     }

}

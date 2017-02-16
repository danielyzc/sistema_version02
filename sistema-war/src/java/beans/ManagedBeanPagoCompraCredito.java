
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.OrdenCompraFacadeLocal;
import bc.PagoCompraCreditoFacadeLocal;
import be.EstadoFacturacionOrdenCompra;
import be.EstadoOrdenCompra;
import be.FacturaCompra;
import be.OrdenCompra;
import be.PagoCompraCredito;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class ManagedBeanPagoCompraCredito implements Serializable{
    @EJB
    private OrdenCompraFacadeLocal ordenCompraFacade;
    @EJB
    private PagoCompraCreditoFacadeLocal pagoCompraCreditoFacade;

private PagoCompraCredito pagocompracredito;
private List<PagoCompraCredito> lista;
private BigDecimal total_pagos;
    public ManagedBeanPagoCompraCredito() {
    pagocompracredito = new PagoCompraCredito();
    lista = new LinkedList<PagoCompraCredito>();
    total_pagos = new BigDecimal(0);
    }

    public PagoCompraCredito getPagocompracredito() {
        return pagocompracredito;
    }

    public void setPagocompracredito(PagoCompraCredito pagocompracredito) {
        this.pagocompracredito = pagocompracredito;
    }

    

    public String Nuevo(OrdenCompra o){
  pagocompracredito.setOrdenCompra(o);
//pagoventacredito = new PagoVentaCredito();
return "nuevo_pago_compra";
}

    
    
public void newObject(OrdenCompra o){
pagocompracredito= new PagoCompraCredito();
pagocompracredito.setOrdenCompra(o);


}

public void crearNew(){

    try {
       OrdenCompra orden = new OrdenCompra();
        orden = pagocompracredito.getOrdenCompra();
        pagocompracredito.setFechaIngreso(new Date());
        pagoCompraCreditoFacade.create(pagocompracredito);

        orden.setTotalPagosCreditoOrdenCompra(orden.getTotalPagosCreditoOrdenCompra().add(pagocompracredito.getCantidad()));
        ordenCompraFacade.edit(orden);

       if((pagocompracredito.getOrdenCompra().getTotalPagosCreditoOrdenCompra().compareTo(pagocompracredito.getOrdenCompra().getTotalOrdenCompra())==0)  ||(pagocompracredito.getOrdenCompra().getTotalPagosCreditoOrdenCompra().compareTo(pagocompracredito.getOrdenCompra().getTotalOrdenCompra())==1)){

            
            orden.setEstadoOrdenCompra(new EstadoOrdenCompra(3));
            ordenCompraFacade.edit(orden);

        }
         FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
  
   
}
    
public String Crear(){
    try {
        OrdenCompra orden = new OrdenCompra();
        orden = pagocompracredito.getOrdenCompra();
        pagocompracredito.setFechaIngreso(new Date());
        pagoCompraCreditoFacade.create(pagocompracredito);

        orden.setTotalPagosCreditoOrdenCompra(orden.getTotalPagosCreditoOrdenCompra().add(pagocompracredito.getCantidad()));
        ordenCompraFacade.edit(orden);

       if((pagocompracredito.getOrdenCompra().getTotalPagosCreditoOrdenCompra().compareTo(pagocompracredito.getOrdenCompra().getTotalOrdenCompra())==0)  ||(pagocompracredito.getOrdenCompra().getTotalPagosCreditoOrdenCompra().compareTo(pagocompracredito.getOrdenCompra().getTotalOrdenCompra())==1)){

            
            orden.setEstadoOrdenCompra(new EstadoOrdenCompra(3));
            ordenCompraFacade.edit(orden);

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
     return "pagos_compras?faces-redirect=true";
}

public String Volver_PagoCompras(){
return "compras?faces-redirect=true";
     }
public BigDecimal getTotal_Pagos(){
total_pagos = new BigDecimal(0);
    for(PagoCompraCredito p : pagocompracredito.getOrdenCompra().getPagoCompraCreditoList())
    {
    total_pagos= total_pagos.add(p.getCantidad());
    }
    return total_pagos;
}

public BigDecimal getDebito(){
    
    if(pagocompracredito.getOrdenCompra()!=null){
       return pagocompracredito.getOrdenCompra().getTotalOrdenCompra().subtract(pagocompracredito.getOrdenCompra().getTotalPagosCreditoOrdenCompra());
  
        
    }else{
        return new BigDecimal(0);
    }
    
  
}

}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.PagoVentaCreditoFacadeLocal;
import bc.VentaFacadeLocal;
import be.Cliente;
import be.Empleado;
import be.EstadoVenta;
import be.Negocio;
import be.PagoVentaCredito;
import be.Tienda;
import be.Venta;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and  limitations under the License.
 */



@ManagedBean
@SessionScoped
public class ManagedBeanPagoVentaCredito implements Serializable{
    @EJB
    private VentaFacadeLocal ventaFacade;
    @EJB
    private PagoVentaCreditoFacadeLocal pagoVentaCreditoFacade;

private int vident=0;
    private PagoVentaCredito pagoventacredito;
private   List<PagoVentaCredito> lista ;
private BigDecimal total_pagos;
private BigDecimal total_pagos_seguimiento;
Cliente cliente ;
private Date fecha_inicio;
private Date fecha_fin;
    public ManagedBeanPagoVentaCredito() {
     pagoventacredito  = new PagoVentaCredito();
     lista = new LinkedList<PagoVentaCredito>();
     total_pagos = new BigDecimal(0);
     total_pagos_seguimiento = new BigDecimal(0);
     cliente = new Cliente();
     fecha_inicio = new Date();
     fecha_fin = new Date();

       }

    public BigDecimal getTotal_pagos_seguimiento() {
        return total_pagos_seguimiento;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   

    public PagoVentaCredito getPagoventacredito() {
        return pagoventacredito;
    }

    public void setPagoventacredito(PagoVentaCredito pagoventacredito) {
        this.pagoventacredito = pagoventacredito;
    }
public int getTest(){
return vident;
}


public void newObject(Venta v){
pagoventacredito.setVenta(v);
  pagoventacredito.setObservaciones("");
  pagoventacredito.setCantidad(new BigDecimal(0));

}

public void crearNew(){

    try {
        Venta ventaxD = new Venta();
        ventaxD = pagoventacredito.getVenta();
        pagoventacredito.setFechaIngreso(new Date());
     pagoVentaCreditoFacade.create(pagoventacredito);
     ventaxD.setTotalPagosCredito(ventaxD.getTotalPagosCredito().add(pagoventacredito.getCantidad()));
ventaFacade.edit(ventaxD);
if((pagoventacredito.getVenta().getTotalPagosCredito().compareTo(pagoventacredito.getVenta().getTotalVenta())==0)  ||(pagoventacredito.getVenta().getTotalPagosCredito().compareTo(pagoventacredito.getVenta().getTotalVenta())==1)){
    
   
    if (ventaxD.getEstadoVenta().getIdEstadoVenta() < 3){
         ventaxD.setEstadoVenta(new EstadoVenta(3));
    } else
    {

        if (ventaxD.getEstadoVenta().getIdEstadoVenta() == 7){
        ventaxD.setEstadoVenta(new EstadoVenta(8));
        }
 else
        {
ventaxD.setEstadoVenta(new EstadoVenta(9));
        }
// IMPORTANTE COLOCAR EL CODIGO DE WICH CASE AQUI , PARA SELECCIONAR LOS ESTADOS
// CORRESPONDIENTES
//switch case


    }


ventaFacade.edit(ventaxD);
        }
         FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
  
   
}

public String Nuevo(Venta v){
  pagoventacredito.setVenta(v);
  pagoventacredito.setObservaciones("");
  pagoventacredito.setCantidad(new BigDecimal(0));
//pagoventacredito = new PagoVentaCredito();
return "nuevo_cobro_venta";
}

public String Crear(){
    try {
        Venta ventaxD = new Venta();
        ventaxD = pagoventacredito.getVenta();
        pagoventacredito.setFechaIngreso(new Date());
     pagoVentaCreditoFacade.create(pagoventacredito);
     ventaxD.setTotalPagosCredito(ventaxD.getTotalPagosCredito().add(pagoventacredito.getCantidad()));
ventaFacade.edit(ventaxD);
if((pagoventacredito.getVenta().getTotalPagosCredito().compareTo(pagoventacredito.getVenta().getTotalVenta())==0)  ||(pagoventacredito.getVenta().getTotalPagosCredito().compareTo(pagoventacredito.getVenta().getTotalVenta())==1)){
    
   
    if (ventaxD.getEstadoVenta().getIdEstadoVenta() < 3){
         ventaxD.setEstadoVenta(new EstadoVenta(3));
    } else
    {

        if (ventaxD.getEstadoVenta().getIdEstadoVenta() == 7){
        ventaxD.setEstadoVenta(new EstadoVenta(8));
        }
 else
        {
ventaxD.setEstadoVenta(new EstadoVenta(9));
        }
// IMPORTANTE COLOCAR EL CODIGO DE WICH CASE AQUI , PARA SELECCIONAR LOS ESTADOS
// CORRESPONDIENTES
//switch case


    }


ventaFacade.edit(ventaxD);
        }


    } catch (Exception e) {
        e.printStackTrace();
    }
     return "cobros_ventas?faces-redirect=true";
}

public String Volver_CobroVentas(){
return "ventas?faces-redirect=true";
     }


public BigDecimal getDebito(){
    if(pagoventacredito.getVenta()!=null){
       return pagoventacredito.getVenta().getTotalVenta().subtract(pagoventacredito.getVenta().getTotalPagosCredito()); 
    }else{
        return new BigDecimal(0);
    }
    

}
public List<PagoVentaCredito> getListaFiltrada(){
    lista.clear();

    try {
        for (PagoVentaCredito p : pagoVentaCreditoFacade.findAll()){
             //  if(p.getVenta().getIdVenta()==2){
          lista.add(p);
               // }
                }
        }

    catch (Exception e) {
    e.printStackTrace();
    }
return lista;
}
public BigDecimal getTotal_Pagos(){
total_pagos = new BigDecimal(0);
    for(PagoVentaCredito p : pagoventacredito.getVenta().getPagoVentaCreditoList())
    {
    total_pagos= total_pagos.add(p.getCantidad());
    }
    return total_pagos;
}

public String Seguimiento(){
cliente = new Cliente();
lista = new LinkedList<PagoVentaCredito>();
return "seguimiento_pagos";
}


/*
 public void seguimiento_pagos(){
         lista.clear();
       total_pagos_seguimiento = new BigDecimal(0);
for ( PagoVentaCredito p : cliente.getVentaList())
{
    if(p.getVenta().getCliente().getNombreCliente().equals(cliente.getNombreCliente()) || (p.getFechaIngreso().after(fecha_inicio) && p.getFechaIngreso().before(fecha_fin)))
    {
    
    lista.add(p);
    total_pagos_seguimiento = total_pagos_seguimiento.add(p.getCantidad());
   }
}
//lista_entradas = ingresoProductoTiendaFacade.findAll();





     }
*/
    public List<PagoVentaCredito> getLista() {
        return lista;
    }

 
}

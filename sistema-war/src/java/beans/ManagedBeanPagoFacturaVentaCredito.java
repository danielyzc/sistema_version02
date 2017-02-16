
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.FacturaVentaFacadeLocal;
import bc.PagoFacturaVentaCreditoFacadeLocal;
import be.Cliente;
import be.EstadoVenta;
import be.FacturaVenta;
import be.PagoFacturaVentaCredito;
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
 * @author root : Zavaleta De la Cruz Yury Daniel
 * Copyright 2011 Zavaleta De la Cruz Yury Daniel

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
@ManagedBean
@SessionScoped
public class ManagedBeanPagoFacturaVentaCredito implements Serializable{
    @EJB
    private PagoFacturaVentaCreditoFacadeLocal pagoFacturaVentaCreditoFacade;
    @EJB
    private FacturaVentaFacadeLocal facturaVentaFacade;
    private int vident=0;
    private PagoFacturaVentaCredito pagoventacredito;
private   List<PagoFacturaVentaCredito> lista ;
private BigDecimal total_pagos;
private BigDecimal total_pagos_seguimiento;
Cliente cliente ;
private Date fecha_inicio;
private Date fecha_fin;

    public ManagedBeanPagoFacturaVentaCredito() {
pagoventacredito  = new PagoFacturaVentaCredito();
     lista = new LinkedList<PagoFacturaVentaCredito>();
     total_pagos = new BigDecimal(0);
     total_pagos_seguimiento = new BigDecimal(0);
     cliente = new Cliente();
     fecha_inicio = new Date();
     fecha_fin = new Date();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public List<PagoFacturaVentaCredito> getLista() {
        return lista;
    }

    public void setLista(List<PagoFacturaVentaCredito> lista) {
        this.lista = lista;
    }

    public PagoFacturaVentaCredito getPagoventacredito() {
        return pagoventacredito;
    }

    public void setPagoventacredito(PagoFacturaVentaCredito pagoventacredito) {
        this.pagoventacredito = pagoventacredito;
    }

    public BigDecimal getTotal_pagos() {
        return total_pagos;
    }

    public void setTotal_pagos(BigDecimal total_pagos) {
        this.total_pagos = total_pagos;
    }

    public BigDecimal getTotal_pagos_seguimiento() {
        return total_pagos_seguimiento;
    }

    public void setTotal_pagos_seguimiento(BigDecimal total_pagos_seguimiento) {
        this.total_pagos_seguimiento = total_pagos_seguimiento;
    }

    public int getVident() {
        return vident;
    }

    public void setVident(int vident) {
        this.vident = vident;
    }

public int getTest(){
return vident;
}








public void newObject(FacturaVenta v){
 pagoventacredito.setFacturaVenta(v);
  pagoventacredito.setObservaciones("");
  pagoventacredito.setCantidad(new BigDecimal(0));

}

public void crearNew(){

    try {
        FacturaVenta ventaxD = new FacturaVenta();
        ventaxD = pagoventacredito.getFacturaVenta();
        pagoventacredito.setFechaIngreso(new Date());
     pagoFacturaVentaCreditoFacade.create(pagoventacredito);
     ventaxD.setTotalPagosCredito(ventaxD.getTotalPagosCredito().add(pagoventacredito.getCantidad()));
facturaVentaFacade.edit(ventaxD);
if((pagoventacredito.getFacturaVenta().getTotalPagosCredito().compareTo(pagoventacredito.getFacturaVenta().getTotalVentaIncluidoIgv())==0)  ||(pagoventacredito.getFacturaVenta().getTotalPagosCredito().compareTo(pagoventacredito.getFacturaVenta().getTotalVentaIncluidoIgv())==1)){

ventaxD.setEstadoVenta(new EstadoVenta(3));
          facturaVentaFacade.edit(ventaxD);
        }

         FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
        e.printStackTrace();
         FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
  
   
}




public String Nuevo(FacturaVenta v){
  pagoventacredito.setFacturaVenta(v);
  pagoventacredito.setObservaciones("");
  pagoventacredito.setCantidad(new BigDecimal(0));
//pagoventacredito = new PagoVentaCredito();
return "nuevo_cobro_factura_venta";
}

public String Crear(){
    try {
       FacturaVenta ventaxD = new FacturaVenta();
        ventaxD = pagoventacredito.getFacturaVenta();
        pagoventacredito.setFechaIngreso(new Date());
     pagoFacturaVentaCreditoFacade.create(pagoventacredito);
     ventaxD.setTotalPagosCredito(ventaxD.getTotalPagosCredito().add(pagoventacredito.getCantidad()));
facturaVentaFacade.edit(ventaxD);
if((pagoventacredito.getFacturaVenta().getTotalPagosCredito().compareTo(pagoventacredito.getFacturaVenta().getTotalVentaIncluidoIgv())==0)  ||(pagoventacredito.getFacturaVenta().getTotalPagosCredito().compareTo(pagoventacredito.getFacturaVenta().getTotalVentaIncluidoIgv())==1)){

ventaxD.setEstadoVenta(new EstadoVenta(3));
          facturaVentaFacade.edit(ventaxD);
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
    if(pagoventacredito.getFacturaVenta() != null){
        return pagoventacredito.getFacturaVenta().getTotalVentaIncluidoIgv().subtract(pagoventacredito.getFacturaVenta().getTotalPagosCredito());

    }else{
       return new BigDecimal(0);
    }
}
public List<PagoFacturaVentaCredito> getListaFiltrada(){
    lista.clear();

    try {
        for (PagoFacturaVentaCredito p : pagoFacturaVentaCreditoFacade.findAll()){
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
    for(PagoFacturaVentaCredito p : pagoventacredito.getFacturaVenta().getPagoFacturaVentaCreditoList())
    {
    total_pagos= total_pagos.add(p.getCantidad());
    }
    return total_pagos;
}

public String Seguimiento(){
cliente = new Cliente();
lista = new LinkedList<PagoFacturaVentaCredito>();
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
    public String getBloqueFactura(){
String bloque = "000";
bloque = bloque.concat(String.valueOf(pagoventacredito.getFacturaVenta().getBloqueFactura()));
return bloque.substring(bloque.length()-3);
}

public String getNumeroFactura(){
String numero ="000000";
numero = numero.concat(String.valueOf(pagoventacredito.getFacturaVenta().getBloqueFactura()));
return numero.substring(numero.length()-6);
}


}

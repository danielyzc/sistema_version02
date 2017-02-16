
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.DetalleOrdenCompraProductoFacadeLocal;
import bc.OrdenCompraFacadeLocal;
import be.DetalleOrdenCompraProducto;
import be.DetalleOrdenCompraProductoPK;
import be.EstadoFacturacionOrdenCompra;
import be.OrdenCompra;
import be.Producto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

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
public class ManagedBeanOrdenCompra implements Serializable{
    @EJB
    private OrdenCompraFacadeLocal ordenCompraFacade;
    @EJB
    private DetalleOrdenCompraProductoFacadeLocal detalleOrdenCompraProductoFacade;
private OrdenCompra ordencompra;
private List<OrdenCompra> lista;
private BigDecimal venta_total_detalles;
    private DetalleOrdenCompraProducto detalleorrdencompraproducto;

   private List<DetalleOrdenCompraProducto> lista_detalles ;
private Date fecha_busqueda;

    public ManagedBeanOrdenCompra() {
    ordencompra = new OrdenCompra();
    lista = new LinkedList<OrdenCompra>();
    detalleorrdencompraproducto = new DetalleOrdenCompraProducto();
    lista_detalles = new LinkedList<DetalleOrdenCompraProducto>();
    fecha_busqueda = new Date();
    }

    public Date getFecha_busqueda() {
        return fecha_busqueda;
    }

    public void setFecha_busqueda(Date fecha_busqueda) {
        this.fecha_busqueda = fecha_busqueda;
    }

    
    public OrdenCompra getOrdencompra() {
        return ordencompra;
    }

    public void setOrdencompra(OrdenCompra ordencompra) {
        this.ordencompra = ordencompra;
    }

    public DetalleOrdenCompraProducto getDetalleorrdencompraproducto() {
        return detalleorrdencompraproducto;
    }

    public void setDetalleorrdencompraproducto(DetalleOrdenCompraProducto detalleorrdencompraproducto) {
        this.detalleorrdencompraproducto = detalleorrdencompraproducto;
    }

    public List<DetalleOrdenCompraProducto> getLista_detalles() {
        return lista_detalles;
    }

    public void setLista_detalles(List<DetalleOrdenCompraProducto> lista_detalles) {
        this.lista_detalles = lista_detalles;
    }


    
public String Nueva(){
ordencompra = new OrdenCompra();
ordencompra.setFechaCreacionOrdenCompra(new Date());
ordencompra.setTotalOrdenCompra(new BigDecimal(0));
ordencompra.setTotalPagosCreditoOrdenCompra(new BigDecimal(0));
ordencompra.setEstadoFacturacionOrdenCompra(new EstadoFacturacionOrdenCompra(1));
return "nueva_compra";
}



public void AgregarDetalleProducto(){
    //Solo cuando es nulo
if(ordencompra.getIdOrdenCompra()==null){
//venta.setIdVenta(100);
ordenCompraFacade.create(ordencompra);
}
if(Existe_duplicado_detalle(detalleorrdencompraproducto)) {
       FacesMessage msg = new FacesMessage("Duplicado", "El Producto ya ha sido Ingresado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
}
else {
    detalleorrdencompraproducto.setDescuento(new BigDecimal(0));
 BigDecimal cantidad =  new BigDecimal(detalleorrdencompraproducto.getCantidad());
 detalleorrdencompraproducto.setSubTotal((detalleorrdencompraproducto.getPrecioVenta().subtract(detalleorrdencompraproducto.getDescuento())).multiply(cantidad));
    DetalleOrdenCompraProducto dt = new DetalleOrdenCompraProducto();
 dt = detalleorrdencompraproducto;
 dt.setDetalleOrdenCompraProductoPK(new DetalleOrdenCompraProductoPK(ordencompra.getIdOrdenCompra(), detalleorrdencompraproducto.getProducto().getIdProducto()));
 // Prueba Aqui
 dt.setOrdenCompra(ordencompra);
 lista_detalles.add(dt);
    Producto p = new Producto();
    p = detalleorrdencompraproducto.getProducto();
    detalleorrdencompraproducto = new DetalleOrdenCompraProducto();
    detalleorrdencompraproducto.setProducto(p);
    detalleorrdencompraproducto.setCantidad(1);
detalleorrdencompraproducto.setDescuento(new BigDecimal("0"));
detalleorrdencompraproducto.setPrecioVenta(new BigDecimal("0"));
venta_total_detalles = this.calcular_total_venta();
// te quedaste aqui
}



}

 public BigDecimal calcular_total_venta(){
        BigDecimal total_venta = new  BigDecimal(0);
        if (lista_detalles == null){

        return total_venta;
        }
 else{
                for(DetalleOrdenCompraProducto dt: lista_detalles){
//venta.setTotalVenta( venta.getTotalVenta().add(dt.getSubTotal()));
total_venta = total_venta.add(dt.getSubTotal());
                    }

                return total_venta;
        }
   }

public Boolean Existe_duplicado_detalle(DetalleOrdenCompraProducto det){
    for (DetalleOrdenCompraProducto dt : lista_detalles){
if(dt.getProducto().getIdProducto()==det.getProducto().getIdProducto()){
return true;
}
}
    return false;
}

public void EliminarLista(){
    try {
        venta_total_detalles = venta_total_detalles.subtract(detalleorrdencompraproducto.getSubTotal());
        lista_detalles.remove(detalleorrdencompraproducto);
    } catch (Exception e) {
        e.printStackTrace();
    }

}

    public BigDecimal getVenta_total_detalles() {
        return venta_total_detalles;
    }

    public void setVenta_total_detalles(BigDecimal venta_total_detalles) {
        this.venta_total_detalles = venta_total_detalles;
    }


 public String editar_guardar_compra(){
              try {

   //  this.calcular_total_venta();
    // venta.setEstadoVenta(new EstadoVenta(1));
     ordencompra.setTotalOrdenCompra(this.calcular_total_venta());
     ordencompra.setDetalleOrdenCompraProductoList(lista_detalles);
     ordenCompraFacade.edit(ordencompra);
                          } catch (Exception e) {
            e.printStackTrace();
        }
              lista_detalles.clear();
              venta_total_detalles = new BigDecimal(0);
                    return "compras?faces-redirect=true";
    }


 public String Facturacion(){
  fecha_busqueda = new Date();
  lista  = new LinkedList<OrdenCompra>();
  SimpleDateFormat fecha1_11 = new SimpleDateFormat("dd-MM-yyyy");
  StringBuilder cadena_fecha1_11 = new StringBuilder(fecha1_11.format(fecha_busqueda));
 String fecha_uno=cadena_fecha1_11.toString();
  String fecha_dos=null;
  SimpleDateFormat fecha1_22 = new SimpleDateFormat("dd-MM-yyyy");
  StringBuilder cadena_fecha22 = null;

       
     System.out.println("lista empieza "+lista.size());
        try {
            for(OrdenCompra p : ordenCompraFacade.findAll()){
               
                cadena_fecha22 = new StringBuilder(fecha1_22.format(p.getFechaEntregaOrdenCompra()));
           fecha_dos=cadena_fecha22.toString();
                System.out.println(fecha_uno+" vs "+fecha_dos);
               
               if(fecha_uno.equals(fecha_dos)){
                  lista.add(p);
                }


      }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("lista sale "+lista.size());
 return "facturacion";
 }

  public  void FiltrarListaOrdenesCompraFecha(){
         lista.clear();
        try {
            for(OrdenCompra p : ordenCompraFacade.findAll()){
                if(fecha_busqueda.equals(p.getFechaEntregaOrdenCompra())){
                  lista.add(p);
                }


      }
        } catch (Exception e) {
            e.printStackTrace();
        }
           }

  
  
  public  void FiltrarListaOrdenesCompraFechaAJAX(SelectEvent event){
         lista.clear();
         Date date = (Date) event.getObject();
        try {
            for(OrdenCompra p : ordenCompraFacade.findAll()){
                if(date.equals(p.getFechaEntregaOrdenCompra())){
                  lista.add(p);
                }


      }
        } catch (Exception e) {
            e.printStackTrace();
        }
           }
  
public List<OrdenCompra> getRetornaLista() {
        return lista;
    }

public String Volver_OrdenCompra(){
return "compras?faces-redirect=true";
     }


public List<OrdenCompra> getListaFiltradaOrdenesCompra() {
 // lista= new LinkedList<Venta>();
BigDecimal cero = new BigDecimal(BigInteger.ZERO);
int comp;
    lista.clear();
    try {
        for(OrdenCompra oc : ordenCompraFacade.findAll())
              {
             comp = oc.getTotalOrdenCompra().compareTo(cero);
            if(oc.getEstadoOrdenCompra().getIdEstadoOrdenCompra()==2 && (comp ==1) ){
            lista.add(oc);
            }
               }
    } catch (Exception e) {
        e.printStackTrace();
    }
      return lista;
    }


public String Pagos(){
return "pagos_compras";
}

}

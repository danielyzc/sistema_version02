
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.CambioFacadeLocal;
import bc.ProductoFacadeLocal;
import bc.VentaFacadeLocal;
import be.Cambio;
import be.DetalleCambioProducto;
import be.DetalleCambioProductoPK;
import be.DetalleVentaProducto;
import be.Producto;
import be.Venta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;

/**
 *
 **Copyright  2011 Yury Daniel Zavaleta De la Cruz  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at* http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the specific language governing permissions and  limitations under the License.
 */


@ManagedBean
@SessionScoped
public class ManagedBeanCambio implements Serializable {
    @EJB
    private ProductoFacadeLocal ProductoFacade;
    @EJB
    private CambioFacadeLocal cambioFacade;
     @EJB
    private VentaFacadeLocal ventaFacade;
 private Cambio cambio;
private List <Cambio> lista;
 private List<Venta> listav ;
private Venta venta;
private Producto Producto1;
private Producto Producto2;
private List<Producto> lista1;
private List<Producto> lista2;
private List<DetalleVentaProducto> detalle_ventas;
private DetalleCambioProducto detalle_cambio_Producto;
private List<DetalleCambioProducto> lista_detalle_cambio_Productos;
private List<SelectItem> ProductosItems = new LinkedList<SelectItem>();
private HashMap<Integer, Producto> myProductos = new HashMap<Integer,Producto>();


      private Date Fecha_venta;
    private Date Fecha_reporte_final;
    private int codigo_venta;
    public ManagedBeanCambio() {
        cambio= new Cambio();
        lista= new LinkedList<Cambio>();
        venta = new Venta();
        Producto1 = new Producto();
        Producto2 = new Producto();
         Fecha_venta = new Date();
        Fecha_reporte_final = new Date();
        detalle_ventas = new LinkedList<DetalleVentaProducto>();
        detalle_cambio_Producto = new DetalleCambioProducto();
        lista_detalle_cambio_Productos = new LinkedList<DetalleCambioProducto>();

        lista1 = new LinkedList<Producto>();
lista2 = new LinkedList<Producto>();
    }

   

    public List<DetalleCambioProducto> getLista_detalle_cambio_Productos() {

        return lista_detalle_cambio_Productos;
       
    }

    public void setLista_detalle_cambio_Productos(List<DetalleCambioProducto> lista_detalle_cambio_Productos) {
        this.lista_detalle_cambio_Productos = lista_detalle_cambio_Productos;
    }


    public List<DetalleVentaProducto> getLista_Producto_venta(){
        try {
            if(detalle_ventas== null || detalle_ventas.isEmpty())
            {
            detalle_ventas = venta.getDetalleVentaProductoList();
            }
        } catch (Exception e) {
        }
    return detalle_ventas;
    }

     

    public Date getFecha_reporte_final() {
        return Fecha_reporte_final;
    }

    public void setFecha_reporte_final(Date Fecha_reporte_final) {
        this.Fecha_reporte_final = Fecha_reporte_final;
    }

    public Date getFecha_venta() {
        return Fecha_venta;
    }

    public int getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(int codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public List<Producto> getLista1() {
        return lista1;
    }


     public List<Producto> getListaVendidas() {
        return lista1;
    }
    public void setLista1(List<Producto> lista1) {
        this.lista1 = lista1;
    }

    public List<Producto> getLista2() {
        return lista2;
    }

    public void setLista2(List<Producto> lista2) {
        this.lista2 = lista2;
    }



    public void setFecha_venta(Date Fecha_venta) {
        this.Fecha_venta = Fecha_venta;
    }

    public Producto getProducto1() {
        return Producto1;
    }

    public void setProducto1(Producto Producto1) {
        this.Producto1 = Producto1;
    }

    public Producto getProducto2() {
        return Producto2;
    }

    public void setProducto2(Producto Producto2) {
        this.Producto2 = Producto2;
    }

  


public String Nuevo(){
cambio = new Cambio();
return "index";
}

public String Nuevo_cambio(){
return "realizar_cambios";
}


public List<Producto> completar_filtrado_Producto(String nombre) {
 LinkedList<Producto> lista_Productos = new LinkedList<Producto>();
            for(Producto p : ProductoFacade.findAll()){
                 myProductos.put(p.getIdProducto(), p);
    if (p.getNombreProducto().toUpperCase().indexOf(nombre.toUpperCase())!=-1){
    lista_Productos.add(p);

    }
    }
       return lista_Productos;
    }


    public void handleSelect(SelectEvent event) {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected:" + event.getObject().toString(), null);
    FacesContext.getCurrentInstance().addMessage(null, message);
}
  public void Filtrar_lista_busqueda(){
         listav= new LinkedList<Venta>();
     
        for (Venta v : ventaFacade.findAll()){
            if(  v.getFechaVenta().equals(Fecha_venta) || v.getFechaVenta().equals(Fecha_reporte_final)   ||  (v.getFechaVenta().after(Fecha_venta) & v.getFechaVenta().before(Fecha_reporte_final)) ){
            listav.add(v);
                        }
        }
    }


    public List<Venta> getListaVentas() {
 
    if(listav==null){
     //listav = ventaFacade.findAll();
     listav = new LinkedList<Venta>();
    }
          return listav;
   // return ventaFacade.findAll();

    }


     public void Buscar_venta() {
    Venta venta_encontrada = new Venta();
    venta = new Venta();
   for(Venta v : ventaFacade.findAll()){
   if(v.getIdVenta()==codigo_venta){
   venta_encontrada=v;
   }
   }
   venta=venta_encontrada;
    }


    public String realizar_cambio()
    {
        cambio.setFechaCambio(new Date());
        cambio.setVenta(venta);
        lista_detalle_cambio_Productos.clear();
      //  cambioFacade.create(cambio);
    return "realizando_cambio";
    }

     public String realizar_cambio2()
    {
      lista_detalle_cambio_Productos.clear();
       cambio = new Cambio();
       cambio.setVenta(venta);
     //  cambio.setMotivoCambio("Cambio");
   return "realizando_cambio";
    }
    public Cambio getCambio() {
        return cambio;
    }
 public String Volver_Venta(){
     venta = new Venta();
     return "index?faces-redirect=true";
     }
    public void setCambio(Cambio cambio) {
        this.cambio = cambio;
    }

    public List<Cambio> getLista() {
        return lista;
    }

    public void setLista(List<Cambio> lista) {
        this.lista = lista;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public HashMap<Integer, Producto> getMyProductos() {
        return myProductos;
    }

    public void setMyProductos(HashMap<Integer, Producto> myProductos) {
        this.myProductos = myProductos;
    }

    public List<SelectItem> getProductosItems() {
      List <DetalleVentaProducto>   lista_Productos = new ArrayList<DetalleVentaProducto>();
        ProductosItems = new LinkedList<SelectItem>();
      
        try {
            if(venta != null && venta.getDetalleVentaProductoList()!=null){
             lista_Productos =venta.getDetalleVentaProductoList();
                       for(DetalleVentaProducto p: lista_Productos){
        myProductos.put(p.getProducto().getIdProducto(), p.getProducto());
        ProductosItems.add(new SelectItem(p.getProducto(), p.getProducto().getNombreProducto()));
      
        }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       


        return ProductosItems;

    }

    public void setProductosItems(List<SelectItem> ProductosItems) {
        this.ProductosItems = ProductosItems;
    }

 public Producto getProducto(Integer id) {
    return (Producto) myProductos.get(id);
     }

    public DetalleCambioProducto getDetalle_cambio_Producto() {
        return detalle_cambio_Producto;
    }

    public void setDetalle_cambio_Producto(DetalleCambioProducto detalle_cambio_Producto) {
        this.detalle_cambio_Producto = detalle_cambio_Producto;
    }









 public void AgregarDetalleCambioProducto(){
     if(cambio.getIdCambio()==null){
      cambio.setFechaCambio(new Date());
      cambioFacade.create(cambio);
     }
    
     DetalleCambioProducto det = new DetalleCambioProducto();
     det= detalle_cambio_Producto;
     det.setCambio(cambio);
    det.setDetalleCambioProductoPK(new DetalleCambioProductoPK(cambio.getIdCambio(), detalle_cambio_Producto.getProducto().getIdProducto(), detalle_cambio_Producto.getProducto1().getIdProducto()));
     lista_detalle_cambio_Productos.add(det);
   detalle_cambio_Producto = new DetalleCambioProducto();
  

 }

 public List<DetalleCambioProducto> getListaCambios(){
     
 return lista_detalle_cambio_Productos;
 }


 public String Terminar_cambio(){
       cambio.setDetalleCambioProductoList(new LinkedList<DetalleCambioProducto>());
  cambio.setDetalleCambioProductoList(lista_detalle_cambio_Productos);
 cambioFacade.edit(cambio);
return "ventas?faces-redirect=true";
}

}

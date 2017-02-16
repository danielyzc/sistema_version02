
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.DetalleFacturaVentaProductoFacadeLocal;
import bc.FacturaVentaFacadeLocal;
import bc.GuiaRemicionFacadeLocal;
import bc.PromocionFacadeLocal;
import be.DetalleFacturaVentaProducto;

import be.DetallePromocionProducto;
import be.FacturaVenta;
import be.GuiaRemicion;
import be.Producto;
import be.Promocion;
import be.TipoVenta;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;

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
public class ManagedBeanFacturaVenta implements Serializable{
      @EJB
    private PromocionFacadeLocal promocionFacade;
    @EJB
    private DetalleFacturaVentaProductoFacadeLocal detalleFacturaVentaProductoFacade;
    @EJB
    private GuiaRemicionFacadeLocal guiaRemicionFacade;
    @EJB
    private FacturaVentaFacadeLocal facturaVentaFacade;

    private List<FacturaVenta> lista;
    private GuiaRemicion guia;
private FacturaVenta factura;
 private List<SelectItem> facturasItems = new LinkedList<SelectItem>();
private HashMap<Integer, FacturaVenta> myfacrueas = new HashMap<Integer,FacturaVenta>();


  private DetalleFacturaVentaProducto detalle_factura_venta_Producto;
  private List<DetalleFacturaVentaProducto> lista_detalles ;
   private List<DetalleFacturaVentaProducto> lista_detalles_mostrar ;
private BigDecimal venta_total_detalles;

    public ManagedBeanFacturaVenta() {
        lista = new LinkedList<FacturaVenta>();
        factura = new FacturaVenta();
        guia = new GuiaRemicion();
        detalle_factura_venta_Producto  = new DetalleFacturaVentaProducto();
        lista_detalles = new LinkedList<DetalleFacturaVentaProducto>();
        lista_detalles_mostrar = new LinkedList<DetalleFacturaVentaProducto>();
     venta_total_detalles = new BigDecimal(0);
    }

    public DetalleFacturaVentaProducto getDetalle_factura_venta_Producto() {
        return detalle_factura_venta_Producto;
    }

    public void setDetalle_factura_venta_Producto(DetalleFacturaVentaProducto detalle_factura_venta_Producto) {
        this.detalle_factura_venta_Producto = detalle_factura_venta_Producto;
    }

    public List<DetalleFacturaVentaProducto> getLista_detalles_mostrar() {
        return lista_detalles_mostrar;
    }

    public void setLista_detalles_mostrar(List<DetalleFacturaVentaProducto> lista_detalles_mostrar) {
        this.lista_detalles_mostrar = lista_detalles_mostrar;
    }

    public List<DetalleFacturaVentaProducto> getLista_detalles() {
        return lista_detalles;
    }

    public BigDecimal getVenta_total_detalles() {
        return venta_total_detalles;
    }

    public void setVenta_total_detalles(BigDecimal venta_total_detalles) {
        this.venta_total_detalles = venta_total_detalles;
    }

    public void setLista_detalles(List<DetalleFacturaVentaProducto> lista_detalles) {
        this.lista_detalles = lista_detalles;
    }

    
    public FacturaVenta getFactura() {
        return factura;
    }

    public GuiaRemicion getGuia() {
        return guia;
    }

    public void setGuia(GuiaRemicion guia) {
        this.guia = guia;
    }

    public void setFactura(FacturaVenta factura) {
        this.factura = factura;
    }

    public List<SelectItem> getFacturasItems() {
        return facturasItems;
    }

    public void setFacturasItems(List<SelectItem> facturasItems) {
        this.facturasItems = facturasItems;
    }

    public List<FacturaVenta> getLista() {
        try {
            lista = facturaVentaFacade.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void setLista(List<FacturaVenta> lista) {
        this.lista = lista;
    }

    public HashMap<Integer, FacturaVenta> getMyfacrueas() {
        return myfacrueas;
    }

    public void setMyfacrueas(HashMap<Integer, FacturaVenta> myfacrueas) {
        this.myfacrueas = myfacrueas;
    }

public String Nueva(){
   
factura = new FacturaVenta();
factura.setFechaVentaEmision(new Date());
factura.setFechaVenta(new Date());
factura.setBloqueFactura(0);
factura.setNumeroFactura(0);
factura.setTipoVenta(new TipoVenta(2));
factura.setTotalPagosCredito(new BigDecimal(0));

guia.setFechaInicioTranslado(new Date());
lista_detalles = new LinkedList<DetalleFacturaVentaProducto>();
    detalle_factura_venta_Producto = new DetalleFacturaVentaProducto();
    detalle_factura_venta_Producto.setCantidad(1);
    detalle_factura_venta_Producto.setDescuento(new BigDecimal(0));
    detalle_factura_venta_Producto.setFacturaVenta(factura);
    venta_total_detalles = new BigDecimal(BigInteger.ZERO);
return "nueva_factura_venta";
 }


    public String crear(){
     try {
        
             factura.setTotalVenta(venta_total_detalles);
             factura.setTotalVentaIncluidoIgv(venta_total_detalles.add(venta_total_detalles.multiply(factura.getIgvFactura().getMonto())));
                      facturaVentaFacade.create(factura);
                      this.formatearfactura();
                      facturaVentaFacade.edit(factura);

                              guia.setFacturaVenta(factura);
         guiaRemicionFacade.create(guia);
         for (DetalleFacturaVentaProducto d : lista_detalles){
         d.setFacturaVenta(factura);
        // d.setDetalleFacturaVentaProductoPK(new DetalleFacturaVentaProductoPK(factura.getIdFacturaVenta(), d.getProducto().getIdProducto()));
         detalleFacturaVentaProductoFacade.create(d);
         }
          this.generar_boleta_unica_texto();
lista_detalles_mostrar  = new LinkedList<DetalleFacturaVentaProducto>();
             lista_detalles_mostrar    = lista_detalles;

     }
     catch (Exception e) {
    e.printStackTrace();
     }
    
return "felcitacionesfac?faces-redirect=true";
 }

    public String Volver_Factura(){
return "ventas?faces-redirect=true";
     }

public Boolean Existe_duplicado_detalle(DetalleFacturaVentaProducto det){
    for (DetalleFacturaVentaProducto dt : lista_detalles){
if(dt.getProducto().getIdProducto()==det.getProducto().getIdProducto()){
return true;
}
}
    return false;
}






public void AgregarDetalleProducto(){

if(Existe_duplicado_detalle(detalle_factura_venta_Producto)) {
       FacesMessage msg = new FacesMessage("Duplicado", "El Producto ya ha sido Ingresado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
}
else {
 BigDecimal cantidad =  new BigDecimal(detalle_factura_venta_Producto.getCantidad());
 detalle_factura_venta_Producto.setSubTotal((detalle_factura_venta_Producto.getPrecioVenta().subtract(detalle_factura_venta_Producto.getDescuento())).multiply(cantidad));
    DetalleFacturaVentaProducto dt = new DetalleFacturaVentaProducto();
 dt = detalle_factura_venta_Producto;
// dt.setDetalleVentaProductoPK(new DetalleVentaProductoPK(venta.getIdVenta(), detalle_venta_Producto.getProducto().getIdProducto()));
 // Prueba Aqui
 dt.setFacturaVenta(factura);
 lista_detalles.add(dt);
    Producto p = new Producto();
    p = detalle_factura_venta_Producto.getProducto();
    detalle_factura_venta_Producto = new DetalleFacturaVentaProducto();
    detalle_factura_venta_Producto.setProducto(p);
    detalle_factura_venta_Producto.setCantidad(1);
detalle_factura_venta_Producto.setDescuento(new BigDecimal("0"));
detalle_factura_venta_Producto.setPrecioVenta(new BigDecimal("0"));
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
                for(DetalleFacturaVentaProducto dt: lista_detalles){
//venta.setTotalVenta( venta.getTotalVenta().add(dt.getSubTotal()));
total_venta = total_venta.add(dt.getSubTotal());
                    }
        
                return total_venta;
        }
   }



public void EliminarLista(){
    try {
        venta_total_detalles = venta_total_detalles.subtract(detalle_factura_venta_Producto.getSubTotal());
        lista_detalles.remove(detalle_factura_venta_Producto);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void formatearfactura(){
    if(factura.getIdFacturaVenta()%999999==0){
    factura.setNumeroFactura(999999);
    factura.setBloqueFactura((int) Math.ceil(factura.getIdFacturaVenta()/999999));
    }
 else{
factura.setBloqueFactura((int) Math.ceil(factura.getIdFacturaVenta()/999999)+1);
factura.setNumeroFactura(factura.getIdFacturaVenta()%999999);
    }
 }


public String getBloqueFactura(){

    String bloque = "000";
bloque = bloque.concat(String.valueOf(factura.getBloqueFactura()));
return bloque.substring(bloque.length()-3);
}

public String getNumeroFactura(){
String numero ="000000";
numero = numero.concat(String.valueOf(factura.getNumeroFactura()));
return numero.substring(numero.length()-6);
}


public String getBloqueGuia(){
 String bloque = "000";
    if(guia.getIdGuiaRemicion()%999999==0){
      bloque = bloque.concat(String.valueOf((int) Math.ceil(guia.getIdGuiaRemicion()/999999)));
      return bloque.substring(bloque.length()-3);
    }
 else{
           bloque = bloque.concat(String.valueOf((int) Math.ceil(guia.getIdGuiaRemicion()/999999)+1));
           return bloque.substring(bloque.length()-3);
    }

}

public String getNumeroGuia(){
    String numero ="000000";

    if(guia.getIdGuiaRemicion()%999999==0){
    numero = numero.concat(String.valueOf(999999));
    return numero.substring(numero.length()-6);

    }
 else{
numero = numero.concat(String.valueOf(guia.getIdGuiaRemicion()%999999));
return numero.substring(numero.length()-6);
    }
}



public List<FacturaVenta> getListaFiltradaFacturaVentas() {
 // lista= new LinkedList<Venta>();
BigDecimal cero = new BigDecimal(BigInteger.ZERO);
int comp;
    lista.clear();
    try {
        for(FacturaVenta v : facturaVentaFacade.findAll())
              {
             comp = v.getTotalVenta().compareTo(cero);
            if(v.getEstadoVenta().getIdEstadoVenta()==2 && (comp ==1) ){
            lista.add(v);
            }
               }
    } catch (Exception e) {
        e.printStackTrace();
    }
      return lista;
    }
   


public String Movimientos(){
    return "movimiento_facturas";
}

public String Formato(FacturaVenta v){
    
    if(v!=null){
       String bloque = "000";
    String numero ="000000";
bloque = bloque.concat(String.valueOf(v.getBloqueFactura()));

bloque = bloque.substring(bloque.length()-3);



numero = numero.concat(String.valueOf(v.getNumeroFactura()));
numero = numero.substring(numero.length()-6);

return bloque + '-' + numero; 
    }else {
        return "";
    }

    

}




  public void generar_boleta_unica_texto(){

ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        FileWriter fichero = null;
        PrintWriter pw = null;
        SimpleDateFormat fecha_boleta = new SimpleDateFormat("dd/MM/yyyy");

   StringBuilder cadena_fecha_buscar = new StringBuilder( fecha_boleta.format( factura.getFechaVenta() ) );
        try
        {
            fichero = new FileWriter(extContext.getRealPath("//facturas//factura"+factura.getIdFacturaVenta()+".txt"));
            pw = new PrintWriter(fichero);
           String cliente_string = factura.getCliente().getNombreCliente() + "                 .";
           String producto_string ="";

                 pw.println(factura.getTienda().getNegocio().getNombreNegocio());

                pw.println("SISTEMAS INTEGRADOS");
                pw.println("ARGOLUZ");
                pw.println("TRUJILLO- LA LIBERTAD");
                pw.println("FACTURA DE VENTA");
                pw.println("Fecha: "  + cadena_fecha_buscar);
                pw.println("ID:  "+ this.Formato(factura) );


                 pw.println("RUC:   "+factura.getTienda().getNumeroRuc());
                pw.println("Almacén:   "+factura.getTienda().getNombreTienda() );
                pw.println("CLIENTE:    " +cliente_string.substring(0,15));
                pw.println("OBS"+factura.getObservaciones());
                pw.println("PRUCTOS A VENDER -CN- PR" );
                pw.println("-----------------------------" );
                for(DetalleFacturaVentaProducto dt : lista_detalles){
                    producto_string = dt.getProducto().getNombreProducto() + "                 .";
                pw.println(producto_string.substring(0,15)+"   "+dt.getCantidad()+"  " +  "S/." + dt.getPrecioVenta() );
                }
                pw.println("-----------------------------" );
                pw.println("TOTAL SIN IGV  " +factura.getTotalVenta()+" SOLES.");
                pw.println("TOTAL + IGV  " +factura.getTotalVentaIncluidoIgv()+" SOLES."+"\n");


               pw.println("-----------------------------" );
               pw.println(" GRACIAS POR SU PREFERENCIA" );
               pw.println("    danielyzc@gmail.com  " );
               pw.println(" MEJOR CALIDAD PARA USTED" );
                pw.println("-----------------------------" );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
     }

public void handleSelectPRECIO(SelectEvent event) {  
      //  System.out.println(" entramos al handled ... ");
    Producto pro  =    (Producto)event.getObject();
    detalle_factura_venta_Producto.setPrecioVenta(pro.getPrecioProducto().getPrecioProducto());
   // vamos a verificar si existe promocion con este producto.
    for(Promocion p :promocionFacade.findAll()){
    if(p.getEstadoPromocion()==1){
  for(DetallePromocionProducto det : p.getDetallePromocionProductoList()){
  
      if(det.getProducto().getIdProducto()==detalle_factura_venta_Producto.getProducto().getIdProducto()){
      // se ecnontro el producto en la prommocion
      
               FacesMessage msg = new FacesMessage("PROMOCION ",p.getObservaciones()+" DESC "+det.getDescuentoPorcentaje().toString()+"%");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    
          detalle_factura_venta_Producto.setPrecioVenta(detalle_factura_venta_Producto.getPrecioVenta().subtract(detalle_factura_venta_Producto.getPrecioVenta().multiply(det.getDescuentoPorcentaje().divide(new BigDecimal(100)))));
  
      }
      
  }  
        
        
    }
    }
    }
}

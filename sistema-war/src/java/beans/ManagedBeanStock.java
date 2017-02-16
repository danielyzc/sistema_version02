
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.DetalleAlmacenProductosFacadeLocal;
import bc.DetalleVentaProductoFacadeLocal;
import bc.IngresoProductoTiendaFacadeLocal;
import bc.SalidaProductoTiendaFacadeLocal;
import bc.StockProductoTiendaOrigenFacadeLocal;
import be.DetalleAlmacenProductos;
import be.DetalleCambioProducto;
import be.DetalleFacturaVentaProducto;
import be.DetalleVentaProducto;
import be.EstadoProductoCostoAlmacen;
import be.IngresoProductoTienda;
import be.Producto;
import be.SalidaProductoTienda;
import be.StockProductoTiendaOrigen;
import be.StockProductoTiendaOrigenPK;
import be.Tienda;
import be.UbicacionFisica;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 **Copyright  2011 Yury Daniel Zavaleta De la Cruz
 * Licensed under the Apache License,
 * Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS
 * ,  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.
 * See the License for the specific language governing permissions and  limitations under the License.
 */


@ManagedBean
@SessionScoped
public class ManagedBeanStock implements Serializable{
    @EJB
    private DetalleAlmacenProductosFacadeLocal detalleAlmacenProductosFacade;
    @EJB
    private DetalleVentaProductoFacadeLocal detalleVentaProductoFacade;
    @EJB
    private SalidaProductoTiendaFacadeLocal salidaProductoTiendaFacade;
    @EJB
    private IngresoProductoTiendaFacadeLocal ingresoProductoTiendaFacade;

    @EJB
    private StockProductoTiendaOrigenFacadeLocal stockProductoTiendaOrigenFacade;


private UbicacionFisica ubicacionFisica;

 private StringBuilder cadena_fecha1 = new StringBuilder();
 private StringBuilder cadena_fecha2 = new StringBuilder();
private StockProductoTiendaOrigen    stockProductoTiendaOrigen;
private List<StockProductoTiendaOrigen> lista;
private List<StockProductoTiendaOrigen> lista2;
private int cantidad_stock;
private BigDecimal costo;
private Producto Producto;
private Tienda tienda;
private Date fecha_vencimiento;
private Date fecha_actual;
private int Paso;
private IngresoProductoTienda ingresotiendaProducto;
private SalidaProductoTienda salidatiendaProducto;

private Date fecha_inicio;
private Date fecha_fin;

private List<IngresoProductoTienda> lista_entradas;
private List<SalidaProductoTienda> lista_salidas;
private List<DetalleVentaProducto> lista_detalles_venta;
private List<DetalleFacturaVentaProducto> lista_detalles_factura_venta;

private int total_entrada =0;
private int total_salida =0;
private int total_ventas =0;
private int total_factura_ventas =0;

private int total_entrada_anterior =0;
private int total_salida_anterior =0;
private int total_ventas_anterior =0;
private int total_factura_ventas_anterior =0;

private int total_stok_anterior =0;
private String descripcion ="";
private String motivo ="";
private String ubicacion ="";




 private DetalleAlmacenProductos detalle;




private List<DetalleCambioProducto> lista_detalles_cambios;
private List<DetalleCambioProducto> lista_detalles_cambios_antes;
private int total_cambios_entrada =0;
private int total_cambios_salida =0;
private int total_cambios_entrada_anterior =0;
private int total_cambios_salida_anterior =0;

    public ManagedBeanStock() {
        costo = new BigDecimal(0);
        stockProductoTiendaOrigen  = new StockProductoTiendaOrigen();
        lista = new LinkedList<StockProductoTiendaOrigen>();
        Producto = new Producto();
        tienda = new Tienda(1);
        Paso=0;
        ingresotiendaProducto = new IngresoProductoTienda();
        salidatiendaProducto = new SalidaProductoTienda();
        fecha_vencimiento = new Date();
           fecha_actual = new Date();
    fecha_inicio = new Date();
    fecha_fin = new  Date();
    lista_entradas = new  LinkedList<IngresoProductoTienda>();
    lista_salidas = new  LinkedList<SalidaProductoTienda>();
    lista_detalles_venta = new LinkedList<DetalleVentaProducto>();
    lista_detalles_factura_venta = new LinkedList<DetalleFacturaVentaProducto>();
    lista_detalles_cambios =  new LinkedList<DetalleCambioProducto>();
    lista_detalles_cambios_antes =  new LinkedList<DetalleCambioProducto>();


ubicacionFisica= new UbicacionFisica();
    detalle = new DetalleAlmacenProductos();
    }

    public UbicacionFisica getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(UbicacionFisica ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
    }

    public DetalleAlmacenProductos getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleAlmacenProductos detalle) {
        this.detalle = detalle;
    }



    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    
    public List<DetalleFacturaVentaProducto> getLista_detalles_factura_venta() {
        return lista_detalles_factura_venta;
    }

    public void setLista_detalles_factura_venta(List<DetalleFacturaVentaProducto> lista_detalles_factura_venta) {
        this.lista_detalles_factura_venta = lista_detalles_factura_venta;
    }


    
    public IngresoProductoTienda getIngresotiendaProducto() {
        return ingresotiendaProducto;
    }

    public void setIngresotiendaProducto(IngresoProductoTienda ingresotiendaProducto) {
        this.ingresotiendaProducto = ingresotiendaProducto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public SalidaProductoTienda getSalidatiendaProducto() {
        return salidatiendaProducto;
    }

    public void setSalidatiendaProducto(SalidaProductoTienda salidatiendaProducto) {
        this.salidatiendaProducto = salidatiendaProducto;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTotal_entrada_anterior() {
        return total_entrada_anterior;
    }

    public int getTotal_salida_anterior() {
        return total_salida_anterior;
    }

    public int getTotal_ventas_anterior() {
        return total_ventas_anterior;
    }

    public int getTotal_factura_ventas() {
        return total_factura_ventas;
    }

    public void setTotal_factura_ventas(int total_factura_ventas) {
        this.total_factura_ventas = total_factura_ventas;
    }

    public int getTotal_factura_ventas_anterior() {
        return total_factura_ventas_anterior;
    }

    public void setTotal_factura_ventas_anterior(int total_factura_ventas_anterior) {
        this.total_factura_ventas_anterior = total_factura_ventas_anterior;
    }


    public int getTotal_stok_anterior() {
        total_stok_anterior = total_entrada_anterior - (total_salida_anterior + total_ventas_anterior);
        return total_stok_anterior;
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

    public String getCadena_fecha1() {
          SimpleDateFormat fecha1 = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
          cadena_fecha1 = new StringBuilder( fecha1.format( fecha_inicio ) );

        return cadena_fecha1.toString();
    }

    public String getCadena_fecha2() {
         SimpleDateFormat fecha2 = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
          cadena_fecha2 = new StringBuilder( fecha2.format( fecha_fin ) );
        return cadena_fecha2.toString();

    }


    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(Date fecha_actual) {
        this.fecha_actual = fecha_actual;
    }


    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public int getCantidad_stock() {
        return cantidad_stock;
    }

    public int getTotal_ventas() {
        return total_ventas;
    }


    public void setCantidad_stock(int cantidad_stock) {
        this.cantidad_stock = cantidad_stock;
    }

    public int getTotal_entrada() {
        return total_entrada;
    }

    public int getTotal_salida() {
        return total_salida;
    }


public List<StockProductoTiendaOrigen> getLista() {
 
    return lista;
}

    public StockProductoTiendaOrigen getStockProductoTiendaOrigen() {
        return stockProductoTiendaOrigen;
    }

    public void setStockProductoTiendaOrigen(StockProductoTiendaOrigen stockProductoTiendaOrigen) {
        this.stockProductoTiendaOrigen = stockProductoTiendaOrigen;
    }


    public void buscar(){
lista.clear();
     
this.cargar_lista2();

for(StockProductoTiendaOrigen st : lista2){

    if(st.getProducto().getNombreProducto().equals(Producto.getNombreProducto()))
    {
    lista.add(st);
    }
}
if(lista.isEmpty())
{
 FacesMessage msg = new FacesMessage("Producto NO registrado, dar click en NEW para registrar.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
}

    }


     public void seguimiento_productos(){
         lista_entradas.clear();
         lista_salidas.clear();
         lista_detalles_venta.clear();
         lista_detalles_factura_venta.clear();

         total_entrada=0;
         total_salida=0;
         total_ventas =0;
         total_factura_ventas=0;

         total_entrada_anterior=0;
         total_salida_anterior=0;
         total_ventas_anterior =0;
         total_factura_ventas_anterior = 0;

         lista_detalles_cambios.clear();
         lista_detalles_cambios_antes.clear();
         total_cambios_entrada_anterior=0;
total_cambios_entrada =0;
total_cambios_salida=0;
total_cambios_salida_anterior =0;

         total_stok_anterior=0;
for ( IngresoProductoTienda i : Producto.getIngresoProductoTiendaList())
{
    if(i.getFechaIngreso().equals(fecha_inicio) || i.getFechaIngreso().equals(fecha_fin) || (i.getFechaIngreso().after(fecha_inicio) && i.getFechaIngreso().before(fecha_fin)))
    {
    if(i.getCantidad() != 0 && i.getTienda().getNombreTienda().equals(tienda.getNombreTienda()))
    {
    lista_entradas.add(i);
    total_entrada = total_entrada + i.getCantidad();
    }
   }

 else {
    if(i.getFechaIngreso().before(fecha_inicio) && i.getTienda().getNombreTienda().equals(tienda.getNombreTienda())){
  total_entrada_anterior = total_entrada_anterior + i.getCantidad();
   }
    }
}
//lista_entradas = ingresoProductoTiendaFacade.findAll();



for ( SalidaProductoTienda s: Producto.getSalidaProductoTiendaList())
{
   if(s.getFechaSalida().equals(fecha_inicio) || s.getFechaSalida().equals(fecha_fin) || (s.getFechaSalida().after(fecha_inicio) && s.getFechaSalida().before(fecha_fin)))
    {
    if(s.getCantidad() !=0 && s.getTienda().getNombreTienda().equals(tienda.getNombreTienda())){
    lista_salidas.add(s);
    total_salida = total_salida + s.getCantidad();
    }
    }
    else {
   if(s.getFechaSalida().before(fecha_inicio) && s.getTienda().getNombreTienda().equals(tienda.getNombreTienda())){
   total_salida_anterior = total_salida_anterior + s.getCantidad();
   }
    }
}

for(DetalleVentaProducto d: Producto.getDetalleVentaProductoList()){

    if(d.getVenta().getFechaVenta().equals(fecha_inicio) || d.getVenta().getFechaVenta().equals(fecha_fin) || (d.getVenta().getFechaVenta().after(fecha_inicio) && d.getVenta().getFechaVenta().before(fecha_fin)) ){
     if( d.getVenta().getTienda().getNombreTienda().equals(tienda.getNombreTienda())){
    lista_detalles_venta.add(d);
    total_ventas = total_ventas + d.getCantidad();
        }
    }
 else{
     if(d.getVenta().getFechaVenta().before(fecha_inicio) && d.getVenta().getTienda().getNombreTienda().equals(tienda.getNombreTienda())){
   total_ventas_anterior = total_ventas_anterior + d.getCantidad();
   }
        }

}




for(DetalleFacturaVentaProducto d: Producto.getDetalleFacturaVentaProductoList()){

    if(d.getFacturaVenta().getFechaVenta().equals(fecha_inicio) || d.getFacturaVenta().getFechaVenta().equals(fecha_fin) || (d.getFacturaVenta().getFechaVenta().after(fecha_inicio) && d.getFacturaVenta().getFechaVenta().before(fecha_fin)) ){
     if( d.getFacturaVenta().getTienda().getNombreTienda().equals(tienda.getNombreTienda())){
    lista_detalles_factura_venta.add(d);
    total_factura_ventas = total_factura_ventas + d.getCantidad();
        }
    }
 else{
     if(d.getFacturaVenta().getFechaVenta().before(fecha_inicio) && d.getFacturaVenta().getTienda().getNombreTienda().equals(tienda.getNombreTienda())){
   total_factura_ventas_anterior = total_factura_ventas_anterior + d.getCantidad();
   }
        }

}



// puede ser la prenda que entra

for(DetalleCambioProducto d: Producto.getDetalleCambioProductoList()){

    if(d.getCambio().getVenta().getFechaVenta().equals(fecha_inicio) || d.getCambio().getVenta().getFechaVenta().equals(fecha_fin) || (d.getCambio().getVenta().getFechaVenta().after(fecha_inicio) && d.getCambio().getVenta().getFechaVenta().before(fecha_fin)) ){
     if( d.getCambio().getVenta().getTienda().getNombreTienda().equals(tienda.getNombreTienda())){
    lista_detalles_cambios.add(d);

    // Aqui total de prendas que entraron
   // total_ventas = total_ventas + d.getCantidad();
        }
    }
 else{
     if(d.getCambio().getVenta().getFechaVenta().before(fecha_inicio) && d.getCambio().getVenta().getTienda().getNombreTienda().equals(tienda.getNombreTienda())){
  // AQUI es donde se pone los cambios anteiores , esto es importante, el void de abajo no se usa nunca
   //      total_ventas_anterior = total_ventas_anterior + 1;  //d.getCantidad(); se supone que la cantidad es 1
 lista_detalles_cambios_antes.add(d);
     }
        }


}

for(DetalleCambioProducto d: Producto.getDetalleCambioProductoList1()){

    if(d.getCambio().getVenta().getFechaVenta().equals(fecha_inicio) || d.getCambio().getVenta().getFechaVenta().equals(fecha_fin) || (d.getCambio().getVenta().getFechaVenta().after(fecha_inicio) && d.getCambio().getVenta().getFechaVenta().before(fecha_fin)) ){
     if( d.getCambio().getVenta().getTienda().getNombreTienda().equals(tienda.getNombreTienda())){
       if(lista_detalles_cambios.contains(d)==false){
         lista_detalles_cambios.add(d);
         }
    // Aqui total de prendas que entraron
   // total_ventas = total_ventas + d.getCantidad();
        }
    }
 else{
     if(d.getCambio().getVenta().getFechaVenta().before(fecha_inicio) && d.getCambio().getVenta().getTienda().getNombreTienda().equals(tienda.getNombreTienda())){
  // AQUI es donde se pone los cambios anteiores , esto es importante, el void de abajo no se usa nunca
   //      total_ventas_anterior = total_ventas_anterior + 1;  //d.getCantidad(); se supone que la cantidad es 1
   if(lista_detalles_cambios_antes.contains(d)==false){
         lista_detalles_cambios_antes.add(d);
         }
     }
        }


}



//lista_salidas = salidaProductoTiendaFacade.findAll();

     }

       public void seguimiento_productos_stock_anterior(){
total_stok_anterior =0;
for ( IngresoProductoTienda i : Producto.getIngresoProductoTiendaList())
{
    if(i.getFechaIngreso().equals(fecha_inicio) || i.getFechaIngreso().equals(fecha_fin) || i.getFechaIngreso().after(fecha_inicio) || i.getFechaIngreso().before(fecha_fin))
    {
    if(i.getCantidad() != 0 && i.getTienda().getNombreTienda().equals(tienda.getNombreTienda()))
    {
    lista_entradas.add(i);
    total_entrada = total_entrada + i.getCantidad();
    }
   }
}
//lista_entradas = ingresoProductoTiendaFacade.findAll();



for ( SalidaProductoTienda s: Producto.getSalidaProductoTiendaList())
{
   if(s.getFechaSalida().equals(fecha_inicio) || s.getFechaSalida().equals(fecha_fin) || s.getFechaSalida().after(fecha_inicio) || s.getFechaSalida().before(fecha_fin))

    {
    if(s.getCantidad() !=0 && s.getTienda().getNombreTienda().equals(tienda.getNombreTienda())){
    lista_salidas.add(s);
    total_salida = total_salida + s.getCantidad();
    }
    }
}

for(DetalleVentaProducto d: Producto.getDetalleVentaProductoList()){

    if(d.getVenta().getFechaVenta().equals(fecha_inicio) || d.getVenta().getFechaVenta().equals(fecha_fin) || d.getVenta().getFechaVenta().after(fecha_inicio) || d.getVenta().getFechaVenta().before(fecha_fin) ){
     if( d.getVenta().getTienda().getNombreTienda().equals(tienda.getNombreTienda())){
    lista_detalles_venta.add(d);
    total_ventas = total_ventas + d.getCantidad();
        }
    }

}

//lista_salidas = salidaProductoTiendaFacade.findAll();

     }

    public List<StockProductoTiendaOrigen> getRetornaLista() {
        return lista;
    }
public String entra(){
    costo = new BigDecimal(0);
    cantidad_stock=0;
    motivo = "";
    ubicacion="";
return "ingreso_almacen";
}

public String Almacen(){
 Producto = new Producto();
  lista.clear();
    costo = new BigDecimal(0);
    cantidad_stock=0;
     ubicacion="";
return "almacen";
}

public String Nuevo_ingreso(){
    costo = new BigDecimal(0);
    cantidad_stock=0;
    motivo = "";
     ubicacion="";
     ubicacionFisica = new UbicacionFisica();
    stockProductoTiendaOrigen = new StockProductoTiendaOrigen();
    
return "nuevo_ingreso";
}
public String sale(){
     costo = new BigDecimal(0);
     cantidad_stock=0;
    motivo = "";
     ubicacion="";
     detalle = new DetalleAlmacenProductos();
return "salida_almacen";
}

public String getImprimir_almacen(){
return "imprimir_almacen.jsf";
}

public String fecha(){
return "fecha_vencimiento";
}

public String registrar(){
    try {
StockProductoTiendaOrigen st = new StockProductoTiendaOrigen();
StockProductoTiendaOrigen st2 = new StockProductoTiendaOrigen();
st.setProducto(Producto);
st.setTienda(tienda);
st.setCantidad(cantidad_stock);
st.setStockProductoTiendaOrigenPK(new StockProductoTiendaOrigenPK(Producto.getIdProducto(), tienda.getIdTienda()) );
st.setUltimaFechaIngreso(fecha_vencimiento);


st2.setProducto(Producto);
st2.setTienda(tienda);
st2.setCantidad(0);
st2.setDescripcion(descripcion);
st2.setStockProductoTiendaOrigenPK(new StockProductoTiendaOrigenPK(Producto.getIdProducto(), tienda.getIdTienda()) );
st2.setUltimaFechaIngreso(fecha_vencimiento);

//Aqui Yuryyyyyy
stockProductoTiendaOrigenFacade.create(st2);

// Agregado
stockProductoTiendaOrigen = st2;
this.Registro_Incremento2();
        this.cargar_lista2();
       this.buscar();
    } catch (Exception e) {
    }
       tienda = new Tienda(1);
       cantidad_stock = 0;
       costo = new BigDecimal(0);
       fecha_vencimiento = new Date();
       descripcion ="";
ubicacionFisica = new UbicacionFisica();
    return "almacen?faces-redirect=true";

}

public String Registro_Incremento(){

      try {
   stockProductoTiendaOrigen.setCantidad(stockProductoTiendaOrigen.getCantidad()+cantidad_stock);
   stockProductoTiendaOrigenFacade.edit(stockProductoTiendaOrigen);
   ingresotiendaProducto.setCantidad(cantidad_stock);
   ingresotiendaProducto.setCostoUnitario(costo);
   ingresotiendaProducto.setFechaIngreso(new Date());
   ingresotiendaProducto.setFechaVencimiento(fecha_vencimiento);
   // YALTA AQUI
   //  ingresotiendaProducto.setUbicacion(ubicacion);
   ingresotiendaProducto.setUbicacionFisica(ubicacionFisica);
   ingresotiendaProducto.setProducto(stockProductoTiendaOrigen.getProducto());
   ingresotiendaProducto.setTienda(stockProductoTiendaOrigen.getTienda());
   ingresotiendaProducto.setMotivo(motivo);
   ingresoProductoTiendaFacade.create(ingresotiendaProducto);
   cantidad_stock=0;
   motivo = "";
    } catch (Exception e) {
    e.printStackTrace();
    }
  return "almacen?faces-redirect=true";
}



public String EditarFecha(){


  try {

   stockProductoTiendaOrigenFacade.edit(stockProductoTiendaOrigen);
    } catch (Exception e) {
    e.printStackTrace();
    }
  return "almacen?faces-redirect=true";
}

public void editar(){


  try {

   stockProductoTiendaOrigenFacade.edit(stockProductoTiendaOrigen);
    } catch (Exception e) {
    e.printStackTrace();

    }

}
public String Registro_Decremento(){


  try {
   stockProductoTiendaOrigen.setCantidad(stockProductoTiendaOrigen.getCantidad()-cantidad_stock);
   stockProductoTiendaOrigenFacade.edit(stockProductoTiendaOrigen);
   salidatiendaProducto.setCantidad(cantidad_stock);
   salidatiendaProducto.setFechaSalida(new Date());
   salidatiendaProducto.setProducto(stockProductoTiendaOrigen.getProducto());
   salidatiendaProducto.setTienda(stockProductoTiendaOrigen.getTienda());
   salidatiendaProducto.setMotivo(motivo);
   salidaProductoTiendaFacade.create(salidatiendaProducto);
  

   /*
    Agregando la prueba con los productos.
    * se tiene que filtrar por la fecha de vencimiento
    */

   detalle.setSalieron(detalle.getSalieron()+cantidad_stock);
   detalle.setQuedaron(detalle.getCantidad() - detalle.getSalieron());

   if(detalle.getQuedaron() <=0 )
   {
       // el estado 2 significa que se acabaron los productos de esa ubicacion
   detalle.setEstadoProductoCostoAlmacen(new EstadoProductoCostoAlmacen(2));
   }
  detalleAlmacenProductosFacade.edit(detalle);

   cantidad_stock=0;
   motivo = "";
    } catch (Exception e) {
    e.printStackTrace();
    }
  return "almacen?faces-redirect=true";
}




public String Actualizar_Vencimiento(){


  try {




   detalle.setFechaVencimiento(fecha_vencimiento);
   
  detalleAlmacenProductosFacade.edit(detalle);

  
    } catch (Exception e) {
    e.printStackTrace();
    }
  return "almacen?faces-redirect=true";
}

public void cargar_lista2(){
    
    try {
       lista2= stockProductoTiendaOrigenFacade.findAll();
    } catch (Exception e) {
    }

}


public List<StockProductoTiendaOrigen> getListaTotales(){
return  stockProductoTiendaOrigenFacade.findAll();
   
}
public String seguimiento(){
    Producto = new Producto();
    tienda= new Tienda(1);

    lista_detalles_venta = new LinkedList<DetalleVentaProducto>();
    lista_detalles_factura_venta = new LinkedList<DetalleFacturaVentaProducto>();
    lista_salidas = new LinkedList<SalidaProductoTienda>();
    lista_entradas = new LinkedList<IngresoProductoTienda>();
    lista_detalles_cambios = new LinkedList<DetalleCambioProducto>();
    total_cambios_entrada=0;
    total_cambios_salida = 0;
total_cambios_entrada_anterior=0;
total_cambios_salida_anterior=0;
total_entrada=0;
total_entrada_anterior=0;
total_factura_ventas=0;
total_factura_ventas_anterior=0;
total_salida=0;
total_salida_anterior=0;
total_stok_anterior=0;
total_ventas=0;
total_ventas_anterior=0;
return "seguimiento";
}

public String Volver_Almacen(){
return "index?faces-redirect=true";
     }

public String Volver_Fechas(){
return "almacen?faces-redirect=true";
     }

    public List<IngresoProductoTienda> getLista_entradas() {
return lista_entradas;


    }

    public List<SalidaProductoTienda> getLista_salidas() {
        return lista_salidas;
    }


    public void Registro_Incremento2(){

      try {
   stockProductoTiendaOrigen.setCantidad(stockProductoTiendaOrigen.getCantidad()+cantidad_stock);
   stockProductoTiendaOrigenFacade.edit(stockProductoTiendaOrigen);
   ingresotiendaProducto.setCantidad(cantidad_stock);
   ingresotiendaProducto.setFechaVencimiento(fecha_vencimiento);
// FALTA AQUI
//   ingresotiendaProducto.setUbicacion(descripcion);
   System.out.println( " UBICACION FISICA : " + ubicacionFisica);
  ingresotiendaProducto.setUbicacionFisica(ubicacionFisica);
   ingresotiendaProducto.setCostoUnitario(costo);
   ingresotiendaProducto.setFechaIngreso(new Date());
   ingresotiendaProducto.setProducto(stockProductoTiendaOrigen.getProducto());
   ingresotiendaProducto.setTienda(stockProductoTiendaOrigen.getTienda());
   ingresotiendaProducto.setMotivo("Primer Ingreso");
   ingresoProductoTiendaFacade.create(ingresotiendaProducto);
   cantidad_stock=0;
   motivo = "";
    } catch (Exception e) {
    e.printStackTrace();
    }
  
}

    public List<DetalleVentaProducto> getLista_detalles_venta() {
        return lista_detalles_venta;
    }


public List<DetalleCambioProducto> getLista_detalles_cambios() {
        return lista_detalles_cambios;
    }
 public int getTotal_cambios_entrada_anterior() {
        total_cambios_entrada_anterior =0;
         for(DetalleCambioProducto d : lista_detalles_cambios_antes){
        if(d.getProducto1().getNombreProducto().equals(Producto.getNombreProducto())){
        total_cambios_entrada_anterior = total_cambios_entrada_anterior + 1;
        }
        }

        return total_cambios_entrada_anterior;
    }

    public int getTotal_cambios_salida_anterior() {

        total_cambios_salida_anterior =0;
        for(DetalleCambioProducto d : lista_detalles_cambios_antes){
        if(d.getProducto().getNombreProducto().equals(Producto.getNombreProducto())){
        total_cambios_salida_anterior = total_cambios_salida_anterior + 1;
        }
        }
        return total_cambios_salida_anterior;
    }

    public int getTotal_cambios_entrada() {
        total_cambios_entrada =0;
        for(DetalleCambioProducto d : lista_detalles_cambios){
        if(d.getProducto1().getNombreProducto().equals(Producto.getNombreProducto())){
        total_cambios_entrada = total_cambios_entrada + 1;
        }
        }
        return total_cambios_entrada;
    }

    public int getTotal_cambios_salida() {
        total_cambios_salida =0;
        for(DetalleCambioProducto d : lista_detalles_cambios){
        if(d.getProducto().getNombreProducto().equals(Producto.getNombreProducto())){
        total_cambios_salida = total_cambios_salida + 1;
        }
        }

        return total_cambios_salida;
    }



    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Producto Seleccionado",((StockProductoTiendaOrigen) event.getObject()).getProducto().getNombreProducto());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


 public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Servicio No seleccionado", ((StockProductoTiendaOrigen) event.getObject()).getProducto().getNombreProducto());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }



    public void onRowDblselect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
        Flash flash = context.getExternalContext().getFlash();
        flash.put("selectedCar", (StockProductoTiendaOrigen) event.getObject());

        handler.performNavigation("carDetail");
    }

    public String ListaUbicaciones(List<DetalleAlmacenProductos> detalle){
       String resultado ="";
        try {

            for(DetalleAlmacenProductos det : detalle){
            resultado = resultado+ " , " + det.getUbicacionFisica().getNombreUbicacionFisica().substring(14);
            }
        } catch (Exception e) {
        }

        return resultado;
    }
    
    public void handleSelect(SelectEvent event) {  
       // System.out.println("entro");
    Producto pro  =    (Producto)event.getObject();
  lista.clear();
     
this.cargar_lista2();

for(StockProductoTiendaOrigen st : lista2){

    if(st.getProducto().getNombreProducto().equalsIgnoreCase(pro.getNombreProducto()))
    {
    lista.add(st);
    }
}
if(lista.isEmpty())
{
 FacesMessage msg = new FacesMessage("Producto NO registrado, dar click en NEW para registrar.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
}
    
//System.out.println("Salio");
    }
}

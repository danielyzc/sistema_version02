
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.ActividadFacadeLocal;
import bc.ContratoFumigacionFacadeLocal;
import bc.DetalleAlmacenProductosFacadeLocal;
import bc.DetalleFumigacionProductoFacadeLocal;
import bc.ReporteDesratizacionFacadeLocal;
import bc.ReporteFumigacionFacadeLocal;
import bc.SalidaProductoTiendaFacadeLocal;
import bc.StockProductoTiendaOrigenFacadeLocal;
import be.Actividad;
import be.ContratoFumigacion;
import be.DetalleAlmacenProductos;
import be.DetalleFumigacionProducto;
import be.EstadoProductoCostoAlmacen;
import be.Producto;
import be.ReporteDesratizacion;
import be.ReporteFumigacion;
import be.SalidaProductoTienda;
import be.StockProductoTiendaOrigen;
import be.Tienda;
import be.Venta;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.SelectableDataModel;

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
public class ManagedBeanContratoFumigacion implements  Serializable{
    @EJB
    private ActividadFacadeLocal actividadFacade;
    @EJB
    private DetalleFumigacionProductoFacadeLocal detalleFumigacionProductoFacade;
    @EJB
    private ReporteFumigacionFacadeLocal reporteFumigacionFacade;
    @EJB
    private ReporteDesratizacionFacadeLocal reporteDesratizacionFacade;
    @EJB
  private   ContratoFumigacionFacadeLocal contratoFumigacionFacade;





     @EJB
    private SalidaProductoTiendaFacadeLocal salidaProductoTiendaFacade;
      @EJB
    private DetalleAlmacenProductosFacadeLocal detalleAlmacenProductosFacade;

    @EJB
    private StockProductoTiendaOrigenFacadeLocal stockProductoTiendaOrigenFacade;


    private SalidaProductoTienda salidatiendaProducto;


private ContratoFumigacion contrato;
private List<ContratoFumigacion> lista ;
private DetalleFumigacionProducto detalle_producto;

private List<DetalleFumigacionProducto> lista_detalle_producto ;

private Date fecha_ ;
private Modelo_Contratos_lista lista_modelos;
private ReporteFumigacion fumigacion;
private ReporteDesratizacion desratizacion;
private Producto producto;
private Tienda tienda;
private int cantidad;
    public ManagedBeanContratoFumigacion() {
        contrato = new ContratoFumigacion();
        contrato.setFechaHoraFumigacion(new Date());
        lista = new LinkedList<ContratoFumigacion>();
        fumigacion = new ReporteFumigacion();
        desratizacion = new ReporteDesratizacion();
        lista_modelos = new Modelo_Contratos_lista();
        producto = new Producto();
        detalle_producto = new DetalleFumigacionProducto();
        tienda = new Tienda();
        lista_detalle_producto= new LinkedList<DetalleFumigacionProducto>();
        fecha_ = new Date();
    }

    public List<DetalleFumigacionProducto> getLista_detalle_producto() {
        return lista_detalle_producto;
    }

    public void setLista_detalle_producto(List<DetalleFumigacionProducto> lista_detalle_producto) {
        this.lista_detalle_producto = lista_detalle_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Producto getProducto() {
        return producto;
    }

    public DetalleFumigacionProducto getDetalle_producto() {
        return detalle_producto;
    }

    public void setDetalle_producto(DetalleFumigacionProducto detalle_producto) {
        this.detalle_producto = detalle_producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Modelo_Contratos_lista getLista_modelos() {
        return lista_modelos;
    }

    public void setLista_modelos(Modelo_Contratos_lista lista_modelos) {
        this.lista_modelos = lista_modelos;
    }

    public ReporteDesratizacion getDesratizacion() {
        return desratizacion;
    }

    public Date getFecha_() {
        return fecha_;
    }

    public void setFecha_(Date fecha_) {
        this.fecha_ = fecha_;
    }

    public void setDesratizacion(ReporteDesratizacion desratizacion) {
        this.desratizacion = desratizacion;
    }

    public ReporteFumigacion getFumigacion() {
        return fumigacion;
    }

    public void setFumigacion(ReporteFumigacion fumigacion) {
        this.fumigacion = fumigacion;
    }

    public ContratoFumigacion getContrato() {
        return contrato;
    }

    public void setContrato(ContratoFumigacion contrato) {
        this.contrato = contrato;
    }

    public List<ContratoFumigacion> getLista() {
        try {
          lista =  contratoFumigacionFacade.findAll();
        } catch (Exception e) {
        }
        return lista;
    }


      public List<ContratoFumigacion> ListaVenta(Venta v) {
        try {
            lista = new LinkedList<ContratoFumigacion>();
          for(ContratoFumigacion cont: contratoFumigacionFacade.findAll()){
          if(cont.getVenta().getIdVenta().equals(v.getIdVenta())){
          lista.add(cont);
          }

          }

        } catch (Exception e) {
        }
        return lista;
    }

    public void setLista(List<ContratoFumigacion> lista) {
        this.lista = lista;
    }


    public String nuevo(Venta v){
        lista_detalle_producto =  new LinkedList<DetalleFumigacionProducto>();
    contrato = new ContratoFumigacion();
 contrato.setFechaHoraFumigacion(fecha_);
   // contrato.setFechaHoraFumigacion(Fecha);
detalle_producto= new DetalleFumigacionProducto();
tienda = new Tienda(1);
        contrato.setVenta(v);
return "nuevo_contrato";
    }

public String nuevo_reporte_fumigacion(){
fumigacion = new ReporteFumigacion();
fumigacion.setContratoFumigacion(contrato);
fumigacion.setFecha(new Date());
fumigacion.setDescripcionCliente("");
detalle_producto= new DetalleFumigacionProducto();
return "nuevo_reporte_fumigacion";

}

public String crear_rep_fumigacion(){
    try {
        reporteFumigacionFacade.create(fumigacion);
        contratoFumigacionFacade.edit(fumigacion.getContratoFumigacion());
    } catch (Exception e) {
    }
    return "contratos?faces-redirect=true";

}

public String crear_rep_desrat(){
    try {
        
        reporteDesratizacionFacade.create(desratizacion);
        contratoFumigacionFacade.edit(desratizacion.getContratoFumigacion());
    } catch (Exception e) {
    }
    return "contratos?faces-redirect=true";
}


 public List<DetalleFumigacionProducto> getListaDetalleProductosContrato() {
        try {
            lista_detalle_producto = new LinkedList<DetalleFumigacionProducto>();
            // verificar siempre la persistencia.
          lista_detalle_producto = fumigacion.getContratoFumigacion().getDetalleFumigacionProductoList();

        } catch (Exception e) {
        }
        return lista_detalle_producto;
    }


public String nuevo_reporte_desratizacion(){
desratizacion = new ReporteDesratizacion();
desratizacion.setContratoFumigacion(contrato);
desratizacion.setFecha(new Date());
//desratizacion.setDescripcionCliente("");
return "nuevo_reporte_desratizacion";
}

    public String crear(){
        try {
    //     contrato.setFechaHoraFumigacion(fecha_);
            contrato.setCuenta(new BigDecimal(0));
            contrato.setFechaVenta(new Date());
            contrato.setFechaVentaEmision(new Date());
            contrato.setPlaga(contrato.getVenta().getObservaciones());
            contrato.setSaldo(BigDecimal.ZERO);
            contrato.setTotalServicio(contrato.getVenta().getTotalVenta());
            contratoFumigacionFacade.create(contrato);


      // AHORA se le agregara los productod al Detalle
       /*     detalle_producto = new DetalleFumigacionProducto();
            detalle_producto.setProducto(producto);
            detalle_producto.setContratoFumigacion(contrato);
            detalle_producto.setCantidad(cantidad);
            detalleFumigacionProductoFacade.create(detalle_producto);
*/


              // se va a crear una actividad
            Actividad act = new Actividad();
            act.setCliente(contrato.getVenta().getCliente());
            act.setFecha(contrato.getFechaHoraFumigacion());
            act.setDescripcionActividad("ATENDER EL SERVICIO N° "+this.Formato_venta(contrato.getVenta()) + " CONTRATO : "+ this.Formato(contrato));

            actividadFacade.create(act);



            // vamos a registrar el decremento, que hace uso de 3 tablas, el de detalle y el de costo y falta almacen.
this.Registro_Decremento();

            
   

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "contratos?faces-redirect=true";
        
    }


public String Formato_venta(Venta v){
if(v.getIdVenta()==null)
{
v = new Venta(0);
}
    String bloque = "000";
    String numero ="000000";
bloque = bloque.concat(String.valueOf(v.getBloqueVenta()));

bloque = bloque.substring(bloque.length()-3);



numero = numero.concat(String.valueOf(v.getNumeroVenta()));
numero = numero.substring(numero.length()-6);

return bloque + '-' + numero;

}



    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Contrato Seleccionado",this.Formato((ContratoFumigacion) event.getObject()));

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


 public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Servicio No seleccionado", this.Formato((ContratoFumigacion) event.getObject()));

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }



    public void onRowDblselect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
        Flash flash = context.getExternalContext().getFlash();
        flash.put("selectedCar", (Venta) event.getObject());

        handler.performNavigation("carDetail");
    }

  public void destroyWorld(ActionEvent actionEvent){

        try {
           //  this.editar2();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acción ejecutada con éxito",  "Se ejecutó con éxito");
        FacesContext.getCurrentInstance().addMessage(null, message);

        } catch (Exception e) {
   e.printStackTrace();

   FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error en la Aplicación",  "Se ejecuto con exito");
        FacesContext.getCurrentInstance().addMessage(null, message);

        }



    }

  public String Formato(ContratoFumigacion v){
if(v.getIdContratoFumigacion()==null)
{
v = new ContratoFumigacion();
}

    String numero ="0000000";

numero = numero.concat(String.valueOf(v.getIdContratoFumigacion()));
numero = numero.substring(numero.length()-7);

return  numero;

}
  
  
  public  class Modelo_Contratos_lista extends ListDataModel<ContratoFumigacion> implements SelectableDataModel<ContratoFumigacion>{

        public Modelo_Contratos_lista() {
        }



    public Modelo_Contratos_lista(List<ContratoFumigacion> data) {
        super(data);
    }

     @Override
    public ContratoFumigacion getRowData(String rowKey) {
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data

    List<ContratoFumigacion> ordenes = (List<ContratoFumigacion>)this.getWrappedData();

        // List<OrdenSalidaDetalleAlmacenProductos> ordenes = ordenSalidaDetalleAlmacenProductosFacade.findAll();

         
        for(ContratoFumigacion orden : ordenes) {
            if(orden.getIdContratoFumigacion().toString().equalsIgnoreCase(rowKey))
               
            {
                return orden;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(ContratoFumigacion orden) {
        return orden.getIdContratoFumigacion();
    }



    }


  public void agregar_detalle_producto(){
    DetalleFumigacionProducto det = new DetalleFumigacionProducto();
    det.setProducto(producto);
    det.setCantidad(cantidad);
    det.setContratoFumigacion(contrato);
   lista_detalle_producto.add(det);
  }

  public void EliminarLista(){
    try {

        lista_detalle_producto.remove(detalle_producto);
    } catch (Exception e) {
        e.printStackTrace();
    }

}

  public int Cantidad_reportes(ContratoFumigacion cont){
 
      // tienes que areglar la persistencia aqui, para que muestre tados sincronizados.
if( cont.getReporteDesratizacionList()==null && cont.getReporteFumigacionList() ==null)
{
return 0;
}
 else
{

      return cont.getReporteDesratizacionList().size()+cont.getReporteFumigacionList().size();
     
 }

  }



  public Boolean Existe_duplicado_detalle(DetalleFumigacionProducto det){

 
      for (DetalleFumigacionProducto dt : lista_detalle_producto){
if(dt.getProducto().getIdProducto() == det.getProducto().getIdProducto()){
return true;
}
}
    return false;
}



public void AgregarDetalleProducto_FinalDZ(){
   
 DetalleFumigacionProducto det = new DetalleFumigacionProducto();
    det.setProducto(producto);
    det.setCantidad(cantidad);
    det.setUtilizo(BigDecimal.ZERO);
    det.setQuedo(BigDecimal.ZERO);

    det.setContratoFumigacion(contrato);

if(Existe_duplicado_detalle(det)) {
       FacesMessage msg = new FacesMessage("Duplicado", "El Producto ya ha sido Ingresado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
}
else {


    
   lista_detalle_producto.add(det);
   cantidad = 0;
    
}

}










public void Registro_Decremento(){


  try {


for(DetalleFumigacionProducto det: lista_detalle_producto){

// vamos a encontrar el stock y luego a disminuir.
for(StockProductoTiendaOrigen stk : stockProductoTiendaOrigenFacade.findAll()){

    if(det.getProducto().getNombreProducto().equals(stk.getProducto().getNombreProducto()) && det.getContratoFumigacion().getVenta().getTienda().getNombreTienda().equals(stk.getTienda().getNombreTienda()))
    {
    // encontramos el stock que buscamos
      stk.setCantidad(stk.getCantidad()-det.getCantidad());
   stockProductoTiendaOrigenFacade.edit(stk);
   salidatiendaProducto = new SalidaProductoTienda();
  salidatiendaProducto.setCantidad(det.getCantidad());
   salidatiendaProducto.setFechaSalida(new Date());
   salidatiendaProducto.setProducto(det.getProducto());
   salidatiendaProducto.setTienda(det.getContratoFumigacion().getVenta().getTienda());
   salidatiendaProducto.setMotivo("ATENDER EL CONTRATO :" + this.Formato(det.getContratoFumigacion()));
   salidaProductoTiendaFacade.create(salidatiendaProducto);


    }


}

int cantidad_para_sacar=0;
cantidad_para_sacar =det.getCantidad();
for(DetalleAlmacenProductos det2 :   detalleAlmacenProductosFacade.findAll()){

    if((det2.getEstadoProductoCostoAlmacen().getIdEstadoProductoCostoAlmacen()==1)&&(det2.getProducto().getNombreProducto().equals(det.getProducto().getNombreProducto())) && (det2.getTienda().getNombreTienda().equals(det.getContratoFumigacion().getVenta().getTienda().getNombreTienda())))
    {
    //encontramos al detalle de almacen ahora vamos a validar que las cantidades sean las que necesitamos
if(det2.getQuedaron() >= cantidad_para_sacar){

det2.setSalieron(det2.getSalieron()+cantidad_para_sacar);
det2.setQuedaron(det2.getQuedaron()-cantidad_para_sacar);


if(det2.getQuedaron()<=0){
det2.setEstadoProductoCostoAlmacen(new EstadoProductoCostoAlmacen(2));

}

detalleAlmacenProductosFacade.edit(det2);
break;
}else{
    cantidad_para_sacar = cantidad_para_sacar - det2.getQuedaron();
det2.setSalieron(det2.getSalieron()+det2.getQuedaron());
det2.setQuedaron(0);
det2.setEstadoProductoCostoAlmacen(new EstadoProductoCostoAlmacen(2));
detalleAlmacenProductosFacade.edit(det2);

if(cantidad_para_sacar<=0){
    break;
}

}


        
    }
}
// al final de todo creamos el detalle
detalleFumigacionProductoFacade.create(det);

}












   /*
    Agregando la prueba con los productos.
    * se tiene que filtrar por la fecha de vencimiento
    */
/*
   detalle.setSalieron(detalle.getSalieron()+cantidad_stock);
   detalle.setQuedaron(detalle.getCantidad() - detalle.getSalieron());

   if(detalle.getQuedaron() <=0 )
   {
   detalle.setEstadoProductoCostoAlmacen(new EstadoProductoCostoAlmacen(2));
   }
  detalleAlmacenProductosFacade.edit(detalle);

   cantidad_stock=0;
   motivo = "";
 * */

    }
  








  catch (Exception e) {
    e.printStackTrace();
    }
  
}

public String ver_todos_contratos(){

return "ver_todos_contratos";
}


}

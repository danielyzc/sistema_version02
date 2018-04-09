/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bc.ClienteFacadeLocal;
import bc.DetalleAlmacenProductosFacadeLocal;
import bc.DetalleVentaProductoFacadeLocal;
import bc.IngresoProductoTiendaFacadeLocal;
import bc.ProductoFacadeLocal;
import bc.PromocionFacadeLocal;
import bc.SalidaProductoTiendaFacadeLocal;
import bc.StockProductoTiendaOrigenFacadeLocal;
import bc.TiendaFacadeLocal;
import bc.VentaFacadeLocal;
import be.Cliente;
import be.DetalleAlmacenProductos;
import be.DetallePromocionProducto;
import be.DetalleVentaProducto;

import be.Empleado;
import be.EstadoProductoCostoAlmacen;
import be.EstadoVenta;
import be.IngresoProductoTienda;
import be.Producto;
import be.Promocion;
import be.SalidaProductoTienda;
import be.StockProductoTiendaOrigen;
import be.StockProductoTiendaOrigenPK;
import be.Tienda;
import be.TipoVenta;
import be.UbicacionFisica;
import be.Venta;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.el.ValueExpression;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import net.sf.jasperreports.crosstabs.fill.calculation.BucketDefinition.Bucket;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.SelectableDataModel;
import utils.StockProductoTiendaOrigen_ayuda;

/**
 *
 **Copyright 2011 Yury Daniel Zavaleta De la Cruz Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
@ManagedBean
@SessionScoped
public class ManagedBeanVenta implements Serializable {

    @EJB
    private StockProductoTiendaOrigenFacadeLocal stockProductoTiendaOrigenFacade;

    @EJB
    private IngresoProductoTiendaFacadeLocal ingresoProductoTiendaFacade;
    @EJB
    private PromocionFacadeLocal promocionFacade;
    @EJB
    private VentaFacadeLocal ventaFacade;
    @EJB
    private ClienteFacadeLocal clienteFacade;
    @EJB
    private ProductoFacadeLocal ProductoFacade;
    @EJB
    private TiendaFacadeLocal TiendaFacade;
    @EJB
    private DetalleVentaProductoFacadeLocal detalleVentaProductoFacade;

    @EJB
    private SalidaProductoTiendaFacadeLocal salidaProductoTiendaFacade;

    @EJB
    private DetalleAlmacenProductosFacadeLocal detalleAlmacenProductosFacade;

    private Date fecha_para_ventas = new Date();
    private Venta venta;
    private DetalleVentaProducto detalle_venta_Producto;
    private List<Venta> lista;
    private List<DetalleVentaProducto> lista_detalles;
    private List<DetalleVentaProducto> lista_detalles_mostrar;
    private Producto Producto;
    private List<SelectItem> ProductosItems = new LinkedList<SelectItem>();
    private HashMap<Integer, Producto> myProductos = new HashMap<Integer, Producto>();

    private List<SelectItem> clientesItems = new LinkedList<SelectItem>();
    private HashMap<Integer, Cliente> myclientes = new HashMap<Integer, Cliente>();

    private List<SelectItem> empleadosItems = new LinkedList<SelectItem>();
    private HashMap<Integer, Empleado> myempleados = new HashMap<Integer, Empleado>();

    private List<Producto> lista_Productos;

    private List<Producto> lista_Productos_totales;
    private List<Cliente> lista_clientes;

    private BigDecimal venta_total_detalles;
    private Date Fecha_venta;
    private Date Fecha_reporte_final;

    private Date fecha_busqueda;

    private Date fecha_emision;

    private Date fecha_inicial;
    private Date fecha_final;

    private Modelo_Servicios_lista lista_modelos;
    private String CodigoBarras = "";
    private String ventaFormateada = "";
    private List<StockProductoTiendaOrigen_ayuda> listaAyuda;
    private List<StockProductoTiendaOrigen_ayuda> listaAyuda_Final;
    private StockProductoTiendaOrigen_ayuda objetoAyuda;
    private int stock_faltante = 0;

    public ManagedBeanVenta() {
        venta = new Venta();
        venta.setDetalleVentaProductoList(new LinkedList<DetalleVentaProducto>());
        detalle_venta_Producto = new DetalleVentaProducto();
        lista = new LinkedList<Venta>();
        Producto = new Producto();
        lista_Productos = new LinkedList<Producto>();
        lista_detalles = new LinkedList<DetalleVentaProducto>();
        venta_total_detalles = new BigDecimal(0);
        Fecha_venta = new Date();
        lista_Productos_totales = new LinkedList<Producto>();
        fecha_busqueda = new Date();
        fecha_emision = new Date();
        fecha_inicial = new Date();
        fecha_final = new Date();
        lista_detalles_mostrar = new LinkedList<DetalleVentaProducto>();
        lista_modelos = new Modelo_Servicios_lista();
        listaAyuda = new LinkedList<StockProductoTiendaOrigen_ayuda>();
        objetoAyuda = new StockProductoTiendaOrigen_ayuda();
        listaAyuda_Final = new LinkedList<StockProductoTiendaOrigen_ayuda>();
    }

    public StockProductoTiendaOrigen_ayuda getObjetoAyuda() {
        return objetoAyuda;
    }

    public void setObjetoAyuda(StockProductoTiendaOrigen_ayuda objetoAyuda) {
        this.objetoAyuda = objetoAyuda;
    }

    public int getStock_faltante() {
        return stock_faltante;
    }

    public void setStock_faltante(int stock_faltante) {
        this.stock_faltante = stock_faltante;
    }

    public List<StockProductoTiendaOrigen_ayuda> getListaAyuda() {
        return listaAyuda;
    }

    public void setListaAyuda(List<StockProductoTiendaOrigen_ayuda> listaAyuda) {
        this.listaAyuda = listaAyuda;
    }

    public String getVentaFormateada() {
        return ventaFormateada;
    }

    public void setVentaFormateada(String ventaFormateada) {
        this.ventaFormateada = ventaFormateada;
    }

    public Date getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(Date fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    public Modelo_Servicios_lista getLista_modelos() {

        lista = new LinkedList<Venta>();
        for (Venta v : ventaFacade.findAll()) {
            if (v.getTipoVenta().getIdTipoVenta() == 3 && (v.getEstadoVenta().getIdEstadoVenta() == 4 || v.getEstadoVenta().getIdEstadoVenta() == 6 || v.getEstadoVenta().getIdEstadoVenta() == 9)) {
                lista.add(v);
            }
        }

        lista_modelos = new Modelo_Servicios_lista(lista);
        return lista_modelos;
    }

    public Modelo_Servicios_lista getLista_modelos_sin_filtrar() {

        lista = new LinkedList<Venta>();

        lista = ventaFacade.findAll();
        // AQUI PUEDES PONERLE SOLO PARA SERVICIOS
      /* for(Venta v : ventaFacade.findAll()){
         if(v.getTipoVenta().getIdTipoVenta()==3 && (v.getEstadoVenta().getIdEstadoVenta()== 4 || v.getEstadoVenta().getIdEstadoVenta()== 6))
         {
         lista.add(v);
         }
         }
         */
        lista_modelos = new Modelo_Servicios_lista(lista);
        return lista_modelos;
    }

    public String getCodigoBarras() {
        return CodigoBarras;
    }

    public void setCodigoBarras(String CodigoBarras) {
        this.CodigoBarras = CodigoBarras;
    }

    public void setLista_modelos(Modelo_Servicios_lista lista_modelos) {
        this.lista_modelos = lista_modelos;
    }

    public List<DetalleVentaProducto> getLista_detalles_mostrar() {
        return lista_detalles_mostrar;
    }

    public void setLista_detalles_mostrar(List<DetalleVentaProducto> lista_detalles_mostrar) {
        this.lista_detalles_mostrar = lista_detalles_mostrar;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public List<Producto> getLista_Productos() {
        return lista_Productos;
    }

    public void setLista_Productos(List<Producto> lista_Productos) {
        this.lista_Productos = lista_Productos;
    }

    public Date getFecha_reporte_final() {
        return Fecha_reporte_final;
    }

    public void setFecha_reporte_final(Date Fecha_reporte_final) {
        this.Fecha_reporte_final = Fecha_reporte_final;
    }

    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha_venta() {
        return Fecha_venta;
    }

    public void setFecha_venta(Date Fecha_venta) {
        this.Fecha_venta = Fecha_venta;
    }

    public DetalleVentaProducto getDetalle_venta_Producto() {
        return detalle_venta_Producto;
    }

    public void setDetalle_venta_Producto(DetalleVentaProducto detalle_venta_Producto) {
        this.detalle_venta_Producto = detalle_venta_Producto;
    }

    public Date getFecha_busqueda() {
        return fecha_busqueda;
    }

    public void setFecha_busqueda(Date fecha_busqueda) {
        this.fecha_busqueda = fecha_busqueda;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String Cambios() {
        return "cambios";
    }

    public String Cobros() {
        return "cobros_ventas";
    }

    public String Movimientos() {
        return "movimiento_boletas";
    }

    public String Precios() {
        return "precios";
    }

    public String ReportesEsp() {
        return "respecializado";
    }

    public String ProductosClientes() {
        return "productos_cliente";
    }

    public String Almacen() {
        return "almacen";
    }

    public void newObject() {
        venta = new Venta();
        // siempre publico en general
        // Cliente cli = clienteFacade.find(1);
        String texto = "";
        Cliente cli = new Cliente(1, "PUBLICO", texto, texto, texto, texto, texto, texto, texto, texto, texto);
        venta.setCliente(cli);
        venta.setFacturaRelacionada("");

        // Aqui tienes que agregar al empleado de la empresa que usa el sistema en ese momento
        venta.setEmpleado(new Empleado(1));
        venta.setEstadoVenta(new EstadoVenta(1));
        venta.setObservaciones("");
        venta.setTienda(new Tienda(1));
        venta.setTipoVenta(new TipoVenta(1));
        venta.setTotalVenta(new BigDecimal("0"));
        venta.setFechaVenta(fecha_para_ventas);
        venta.setFechaVentaEmision(fecha_para_ventas);
        venta.setTotalPagosCredito(new BigDecimal(0));
        lista_detalles = new LinkedList<DetalleVentaProducto>();
        detalle_venta_Producto = new DetalleVentaProducto();
        detalle_venta_Producto.setCantidad(1);
        detalle_venta_Producto.setVenta(venta);

        detalle_venta_Producto.setDescuento(BigDecimal.ZERO);
        lista_Productos = new LinkedList<Producto>();
        venta_total_detalles = new BigDecimal(0);

    }

    public String Nueva_venta() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), "#{managedBeanLogin}", ManagedBeanLogin.class);
        ManagedBeanLogin bean = (ManagedBeanLogin) vex.getValue(ctx.getELContext());
        stock_faltante = 0;
        listaAyuda = new LinkedList<StockProductoTiendaOrigen_ayuda>();
        listaAyuda_Final = new LinkedList<StockProductoTiendaOrigen_ayuda>();
        venta = new Venta();

        // siempre publico en general
        // Cliente cli = clienteFacade.find(1);
        String texto = "";
        Cliente cli = new Cliente(1, "PUBLICO", texto, texto, texto, texto, texto, texto, texto, texto, texto);
        venta.setCliente(cli);
        venta.setFacturaRelacionada("");

        // Aqui tienes que agregar al empleado de la empresa que usa el sistema en ese momento
        venta.setEmpleado(bean.getObjetoEmpleado());
        venta.setTienda(bean.getObjetoEmpleado().getTienda());

        venta.setEstadoVenta(new EstadoVenta(1));
        venta.setObservaciones("");

        venta.setTipoVenta(new TipoVenta(1));
        venta.setTotalVenta(new BigDecimal("0"));
        venta.setFechaVenta(fecha_para_ventas);
        venta.setFechaVentaEmision(fecha_para_ventas);
        venta.setTotalPagosCredito(new BigDecimal(0));
        lista_detalles = new LinkedList<DetalleVentaProducto>();
        detalle_venta_Producto = new DetalleVentaProducto();
        detalle_venta_Producto.setCantidad(1);
        detalle_venta_Producto.setVenta(venta);

        detalle_venta_Producto.setDescuento(BigDecimal.ZERO);
        lista_Productos = new LinkedList<Producto>();
        venta_total_detalles = new BigDecimal(0);
        return "nueva_venta";
    }

    public String NewVentaMobile() {
        venta = new Venta();
        // siempre publico en general
        // Cliente cli = clienteFacade.find(1);
        String texto = "";

        Cliente cli = new Cliente(1, "PUBLICO", texto, texto, texto, texto, texto, texto, texto, texto, texto);
        cli = clienteFacade.find(cli.getIdCliente());
        venta.setCliente(cli);
        venta.setFacturaRelacionada("");

        // Aqui tienes que agregar al empleado de la empresa que usa el sistema en ese momento
        venta.setEmpleado(new Empleado(1));
        venta.setEstadoVenta(new EstadoVenta(1));
        venta.setObservaciones("");
        venta.setTienda(new Tienda(1));
        venta.setTipoVenta(new TipoVenta(1));
        venta.setTotalVenta(new BigDecimal("0"));
        venta.setFechaVenta(fecha_para_ventas);
        venta.setFechaVentaEmision(fecha_para_ventas);
        venta.setTotalPagosCredito(new BigDecimal(0));
        lista_detalles = new LinkedList<DetalleVentaProducto>();
        detalle_venta_Producto = new DetalleVentaProducto();
        detalle_venta_Producto.setCantidad(1);
        detalle_venta_Producto.setVenta(venta);

        detalle_venta_Producto.setDescuento(BigDecimal.ZERO);
        lista_Productos = new LinkedList<Producto>();
        venta_total_detalles = new BigDecimal(0);
        return "nueva_venta";
    }

    public String Nueva_venta_rapida() {
        venta = new Venta();

        venta.setFacturaRelacionada("");

        // Aqui tienes que agregar al empleado de la empresa que usa el sistema en ese momento
        venta.setEmpleado(new Empleado(1));
        venta.setEstadoVenta(new EstadoVenta(1));
        venta.setObservaciones("");
        venta.setTienda(new Tienda(1));
        venta.setTipoVenta(new TipoVenta(1));
        venta.setTotalVenta(new BigDecimal("0"));
        venta.setFechaVenta(fecha_para_ventas);
        venta.setFechaVentaEmision(fecha_para_ventas);
        venta.setTotalPagosCredito(new BigDecimal(0));
        lista_detalles = new LinkedList<DetalleVentaProducto>();
        detalle_venta_Producto = new DetalleVentaProducto();
        detalle_venta_Producto.setCantidad(1);
        detalle_venta_Producto.setVenta(venta);

        detalle_venta_Producto.setDescuento(BigDecimal.ZERO);
        lista_Productos = new LinkedList<Producto>();
        venta_total_detalles = new BigDecimal(0);
        return "nueva_venta_rapida";
    }

    public String Nueva_ventaFactura() {
        venta = new Venta();

        // Aqui tienes que agregar al empleado de la empresa que usa el sistema en ese momento
        venta.setEmpleado(new Empleado(1));
        venta.setEstadoVenta(new EstadoVenta(1));
        venta.setObservaciones("");
        venta.setTienda(new Tienda(1));
        venta.setTipoVenta(new TipoVenta(2));
        venta.setTotalVenta(new BigDecimal("0"));
        venta.setFechaVenta(fecha_para_ventas);
        venta.setFechaVentaEmision(fecha_para_ventas);
        venta.setTotalPagosCredito(new BigDecimal(0));
        lista_detalles = new LinkedList<DetalleVentaProducto>();
        detalle_venta_Producto = new DetalleVentaProducto();
        detalle_venta_Producto.setCantidad(1);
        detalle_venta_Producto.setVenta(venta);

        detalle_venta_Producto.setDescuento(BigDecimal.ZERO);
        lista_Productos = new LinkedList<Producto>();
        venta_total_detalles = new BigDecimal(0);
        return "nueva_venta_factura";
    }

    public String editar_guardar_venta() {
        try {

            //  this.calcular_total_venta();
            // venta.setEstadoVenta(new EstadoVenta(1));
            venta.setTotalVenta(this.calcular_total_venta());
            venta.setDetalleVentaProductoList(lista_detalles);
            this.formatearVenta();
            ventaFacade.edit(venta);
            this.generar_boleta_unica_texto();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "felcitaciones";
    }

    public void crearNew() {

        try {
            venta.setTotalVenta(this.calcular_total_venta());
            venta.setDetalleVentaProductoList(lista_detalles);

            ventaFacade.create(venta);
            this.formatearVenta();
            ventaFacade.edit(venta);
            ventaFormateada = this.Formato(venta);
            this.generar_boleta_unica_texto();

            lista_detalles_mostrar = new LinkedList<DetalleVentaProducto>();
            lista_detalles_mostrar = lista_detalles;
            FacesMessage msg = new FacesMessage("CREADO CON EXITO", "CORRECTO");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage("ERROR", "CONTACTE CON EL ADMINISTRADOR");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        }

    }

    public String editar_guardar_venta_FinalDZ() {
        try {

            // vamos a utilizar la funcion ayuda., esto debe de ser antes de la venta
            for (StockProductoTiendaOrigen_ayuda det : listaAyuda_Final) {
                //SALIDA
                StockProductoTiendaOrigen stk_ = det.getStock();
                stk_.setCantidad(stk_.getCantidad() - det.getCantidad_ayuda());
                stockProductoTiendaOrigenFacade.edit(stk_);
                SalidaProductoTienda salida_ = new SalidaProductoTienda();
                salida_.setCantidad(det.getCantidad_ayuda());
                salida_.setFechaSalida(new Date());
                salida_.setProducto(stk_.getProducto());
                salida_.setTienda(stk_.getTienda());
                salida_.setMotivo("PRESTAMO_TIENDA:" + venta.getTienda().getIdTienda());
                salidaProductoTiendaFacade.create(salida_);
                /*
                 Agregando la prueba con los productos.
                 * se tiene que filtrar por la fecha de vencimiento
                 */
                DetalleAlmacenProductos detalle_ = new DetalleAlmacenProductos();
                detalle_ = det.getDetalle();
                detalle_.setSalieron(detalle_.getSalieron() + det.getCantidad_ayuda());
                detalle_.setQuedaron(detalle_.getCantidad() - detalle_.getSalieron());

                if (detalle_.getQuedaron() <= 0) {
                    // el estado 2 significa que se acabaron los productos de esa ubicacion
                    detalle_.setEstadoProductoCostoAlmacen(new EstadoProductoCostoAlmacen(2));
                }
                detalleAlmacenProductosFacade.edit(detalle_);

                // INGRESO 
                StockProductoTiendaOrigen stk02_ = det.getStock_tienda_actual();
                stk02_.setCantidad(stk02_.getCantidad() + det.getCantidad_ayuda());
                stockProductoTiendaOrigenFacade.edit(stk02_);
                IngresoProductoTienda ingreso_ = new IngresoProductoTienda();
                ingreso_.setCantidad(det.getCantidad_ayuda());
                ingreso_.setCostoUnitario(new BigDecimal(BigInteger.ZERO));
                ingreso_.setFechaIngreso(new Date());
                ingreso_.setFechaVencimiento(new Date());
                // SETEAMOS TIENDA SISTEMA POR DEFECTO.
                ingreso_.setUbicacionFisica(new UbicacionFisica(1));
                ingreso_.setProducto(stk02_.getProducto());
                ingreso_.setTienda(venta.getTienda());
                ingreso_.setMotivo("RECIBIENDO DESDE :" + stk02_.getTienda().getIdTienda());
                ingresoProductoTiendaFacade.create(ingreso_);
            }

            venta.setEstadoExistencia(1);
            venta.setFecReg(new Date());
            venta.setTotalVenta(this.calcular_total_venta());

            ventaFacade.create(venta);
            this.formatearVenta();
            ventaFacade.edit(venta);

            for (DetalleVentaProducto d : lista_detalles) {
                d.setVenta(venta);
                //d.setDetalleVentaProductoPK(new DetalleVentaProductoPK(venta.getIdVenta(), d.getProducto().getIdProducto()));
                detalleVentaProductoFacade.create(d);
            }

            this.generar_boleta_unica_texto();
            lista_detalles_mostrar = new LinkedList<DetalleVentaProducto>();
            lista_detalles_mostrar = lista_detalles;
            listaAyuda = new LinkedList<StockProductoTiendaOrigen_ayuda>();
            listaAyuda_Final = new LinkedList<StockProductoTiendaOrigen_ayuda>();
            objetoAyuda = new StockProductoTiendaOrigen_ayuda();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "felcitaciones";
    }

    public String editar_guardar_ventaFactura() {
        try {

            //  this.calcular_total_venta();
            // venta.setEstadoVenta(new EstadoVenta(1));
            venta.setTotalVenta(this.calcular_total_venta());
            venta.setDetalleVentaProductoList(lista_detalles);
            ventaFacade.edit(venta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "felcitacionesfac";
    }

    public List<DetalleVentaProducto> getListaDetalles() {
        if (venta.getDetalleVentaProductoList() == null) {
            venta.setDetalleVentaProductoList(new LinkedList<DetalleVentaProducto>());
            return venta.getDetalleVentaProductoList();
        } else {
            return venta.getDetalleVentaProductoList();
        }

    }

    public void AgregarDetalleProducto() {
        //Solo cuando es nulo
        if (venta.getIdVenta() == null) {
//venta.setIdVenta(100);

            ventaFacade.create(venta);
        }
        if (Existe_duplicado_detalle(detalle_venta_Producto)) {
            FacesMessage msg = new FacesMessage("Duplicado", "El Producto ya ha sido Ingresado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            BigDecimal cantidad = new BigDecimal(detalle_venta_Producto.getCantidad());
            detalle_venta_Producto.setSubTotal((detalle_venta_Producto.getPrecioVenta().subtract(detalle_venta_Producto.getDescuento())).multiply(cantidad));
            DetalleVentaProducto dt = new DetalleVentaProducto();
            dt = detalle_venta_Producto;
            //dt.setDetalleVentaProductoPK(new DetalleVentaProductoPK(venta.getIdVenta(), detalle_venta_Producto.getProducto().getIdProducto()));
            // Prueba Aqui
            dt.setVenta(venta);
            lista_detalles.add(dt);
            Producto p = new Producto();
            p = detalle_venta_Producto.getProducto();
            detalle_venta_Producto = new DetalleVentaProducto();
            detalle_venta_Producto.setProducto(p);
            detalle_venta_Producto.setCantidad(1);
            detalle_venta_Producto.setDescuento(new BigDecimal("0"));
            detalle_venta_Producto.setPrecioVenta(new BigDecimal("0"));
            venta_total_detalles = this.calcular_total_venta();
// te quedaste aqui
        }

    }

    public void AgregarDetalleProducto_FinalDZ() {
        //Solo cuando es nulo

        if (Existe_duplicado_detalle(detalle_venta_Producto)) {
            FacesMessage msg = new FacesMessage("Duplicado", "El Producto ya ha sido Ingresado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            // vamos a validar el stock a ver si no se sobrepasa.
            int resp_stock = stock_suficiente(detalle_venta_Producto);

            if (resp_stock == 1) {
                // todo bien
                BigDecimal cantidad = new BigDecimal(detalle_venta_Producto.getCantidad());
                detalle_venta_Producto.setSubTotal((detalle_venta_Producto.getPrecioVenta().subtract(detalle_venta_Producto.getDescuento())).multiply(cantidad));
                DetalleVentaProducto dt = new DetalleVentaProducto();
                dt = detalle_venta_Producto;

                //asignandole el tipo de servicio
                // venta.setObservaciones(detalle_venta_Producto.getProducto().getTipoProducto().getNombreTipoProducto());
                dt.setVenta(venta);

                lista_detalles.add(dt);
                Producto p = new Producto();
                p = detalle_venta_Producto.getProducto();
                detalle_venta_Producto = new DetalleVentaProducto();
                detalle_venta_Producto.setProducto(p);
                detalle_venta_Producto.setCantidad(1);
                detalle_venta_Producto.setDescuento(new BigDecimal("0"));
                detalle_venta_Producto.setPrecioVenta(new BigDecimal("0"));
                venta_total_detalles = this.calcular_total_venta();

            }
            if (resp_stock == 2) {
// mostrar_pantallaAyudaStock
                // vamos a cargar los stocks de ayuda.
                listaAyuda = new LinkedList<StockProductoTiendaOrigen_ayuda>();
                StockProductoTiendaOrigen mistock_ = new StockProductoTiendaOrigen();
                for (StockProductoTiendaOrigen s : stockProductoTiendaOrigenFacade.lista_stock_producto(detalle_venta_Producto.getProducto())) {
                    if (s.getTienda().getIdTienda().equals(venta.getTienda().getIdTienda()) == false) {
                        StockProductoTiendaOrigen_ayuda obj = new StockProductoTiendaOrigen_ayuda();
                        obj.setStock(s);
                        obj.setCantidad_ayuda(0);
                        listaAyuda.add(obj);
                    } else {
                        mistock_ = s;
                    }
                }
                for (StockProductoTiendaOrigen_ayuda p : listaAyuda) {
                    p.setStock_tienda_actual(mistock_);
                }
                RequestContext.getCurrentInstance().update("dialogo_:pnlgprincipal");
                RequestContext.getCurrentInstance().execute("PF('dlg_ayudaStock').show()");
            }
            if (resp_stock == -1) {
// mostrar_pantalla ayuda y registrar por primera vez el stock
                StockProductoTiendaOrigen stk = new StockProductoTiendaOrigen();
                stk.setCantidad(0);
                stk.setCantidadMinimaStock(0);
                stk.setDescripcion("DESDE AYUDA STOCK");
                stk.setProducto(detalle_venta_Producto.getProducto());
                stk.setTienda(venta.getTienda());
                stk.setUltimaFechaIngreso(new Date());
                stk.setStockProductoTiendaOrigenPK(new StockProductoTiendaOrigenPK(detalle_venta_Producto.getProducto().getIdProducto(), venta.getTienda().getIdTienda()));
                try {
                    stockProductoTiendaOrigenFacade.create(stk);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // vamos a cargar los stocks de ayuda.
                listaAyuda = new LinkedList<StockProductoTiendaOrigen_ayuda>();
                StockProductoTiendaOrigen mistock_ = new StockProductoTiendaOrigen();
                for (StockProductoTiendaOrigen s : stockProductoTiendaOrigenFacade.lista_stock_producto(detalle_venta_Producto.getProducto())) {
                    if (s.getTienda().getIdTienda().equals(venta.getTienda().getIdTienda()) == false) {
                        StockProductoTiendaOrigen_ayuda obj = new StockProductoTiendaOrigen_ayuda();
                        obj.setStock(s);
                        obj.setCantidad_ayuda(0);
                        listaAyuda.add(obj);
                    } else {
                        mistock_ = s;
                    }
                }
                for (StockProductoTiendaOrigen_ayuda p : listaAyuda) {
                    p.setStock_tienda_actual(mistock_);
                }
                RequestContext.getCurrentInstance().update("dialogo_:pnlgprincipal");
                RequestContext.getCurrentInstance().execute("PF('dlg_ayudaStock').show()");

            }

        }

    }

    public void AgregarDetalleServicio_FinalDZ() {
        //Solo cuando es nulo

        if (Existe_duplicado_detalle(detalle_venta_Producto)) {
            FacesMessage msg = new FacesMessage("Duplicado", "El Producto ya ha sido Ingresado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            BigDecimal cantidad = new BigDecimal(detalle_venta_Producto.getCantidad());
            detalle_venta_Producto.setSubTotal((detalle_venta_Producto.getPrecioVenta().subtract(detalle_venta_Producto.getDescuento())).multiply(cantidad));
            DetalleVentaProducto dt = new DetalleVentaProducto();
            dt = detalle_venta_Producto;

            //asignandole el tipo de servicio
            venta.setObservaciones(detalle_venta_Producto.getProducto().getTipoProducto().getNombreTipoProducto());

            dt.setVenta(venta);
            lista_detalles.add(dt);
            Producto p = new Producto();
            p = detalle_venta_Producto.getProducto();
            detalle_venta_Producto = new DetalleVentaProducto();
            detalle_venta_Producto.setProducto(p);
            detalle_venta_Producto.setCantidad(1);
            detalle_venta_Producto.setDescuento(new BigDecimal("0"));
            detalle_venta_Producto.setPrecioVenta(new BigDecimal("0"));
            venta_total_detalles = this.calcular_total_venta();
// te quedaste aqui
        }

    }

    public void AgregarDetalleProducto_Mejorado() {
        //Solo cuando es nulo
        if (venta.getIdVenta() == null) {
//venta.setIdVenta(100);
            ventaFacade.create(venta);
        }
        if (Existe_duplicado_detalle(detalle_venta_Producto)) {
            FacesMessage msg = new FacesMessage("Duplicado", "El Producto ya ha sido Ingresado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            BigDecimal cantidad = new BigDecimal(detalle_venta_Producto.getCantidad());
            detalle_venta_Producto.setSubTotal((detalle_venta_Producto.getPrecioVenta().subtract(detalle_venta_Producto.getDescuento())).multiply(cantidad));
//  detalle_venta_Producto.setDetalleVentaProductoPK(new DetalleVentaProductoPK(venta.getIdVenta(), detalle_venta_Producto.getProducto().getIdProducto()));

            detalle_venta_Producto.setVenta(venta);
            lista_detalles.add(detalle_venta_Producto);
            venta.getDetalleVentaProductoList().add(detalle_venta_Producto);

            Producto p = new Producto();
            p = detalle_venta_Producto.getProducto();
            detalle_venta_Producto = new DetalleVentaProducto();
            detalle_venta_Producto.setProducto(p);
            detalle_venta_Producto.setCantidad(1);
            detalle_venta_Producto.setDescuento(new BigDecimal("0"));
            detalle_venta_Producto.setPrecioVenta(new BigDecimal("0"));
            venta_total_detalles = this.calcular_total_venta();
// te quedaste aqui
        }

    }

    public void EliminarLista() {
        try {
            venta_total_detalles = venta_total_detalles.subtract(detalle_venta_Producto.getSubTotal());
            lista_detalles.remove(detalle_venta_Producto);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Boolean Existe_duplicado_detalle(DetalleVentaProducto det) {
        for (DetalleVentaProducto dt : lista_detalles) {
            if (dt.getProducto().getIdProducto() == det.getProducto().getIdProducto()) {
                return true;
            }
        }
        return false;
    }

    public void insertar_detalles_Producto() {

        try {
            venta.setDetalleVentaProductoList(lista_detalles);
        } catch (Exception e) {
        }

    }

    public List<String> complete(String nombre) {
        List<String> results = new ArrayList<String>();

        for (Producto p : ProductoFacade.findAll()) {
            if (p.getNombreProducto().toUpperCase().indexOf(nombre.toUpperCase()) != -1) {
                results.add(p.getNombreProducto());
            }
        }
        return results;
    }

    public List<Producto> completar_filtrado_Producto(String nombre) {
        lista_Productos = new LinkedList<Producto>();
        for (Producto p : ProductoFacade.findAll()) {

            myProductos.put(p.getIdProducto(), p);
            if (p.getNombreProducto().toUpperCase().indexOf(nombre.toUpperCase()) != -1) {
                lista_Productos.add(p);

            }
        }
        return lista_Productos;
    }

    public List<Producto> Traer_Lista_Producto_Total() {
        if (lista_Productos_totales.isEmpty() || lista_Productos_totales == null) {
            lista_Productos_totales = ProductoFacade.findAll();
        }
        return lista_Productos_totales;

    }

    public List<Cliente> completar_filtrado_Clientes(String nombre) {
        lista_clientes = new LinkedList<Cliente>();
        for (Cliente p : clienteFacade.findAll()) {
            myclientes.put(p.getIdCliente(), p);
            if (p.getNombreCliente().toUpperCase().indexOf(nombre.toUpperCase()) != -1) {
                lista_clientes.add(p);

            }
        }
        return lista_clientes;
    }

    public List<Venta> getListaVentas() {
        // lista= new LinkedList<Venta>();
        if (lista == null) {
            lista = ventaFacade.findAll();
        }

        return lista;
    }

    public List<Venta> getListaFiltradaVentas() {
        // lista= new LinkedList<Venta>();
        BigDecimal cero = new BigDecimal(BigInteger.ZERO);
        int comp;
        lista.clear();
        try {
            for (Venta v : ventaFacade.findAll()) {
                comp = v.getTotalVenta().compareTo(cero);
                if ((v.getEstadoVenta().getIdEstadoVenta() == 2 || v.getEstadoVenta().getIdEstadoVenta() == 6 || v.getEstadoVenta().getIdEstadoVenta() == 7) && (comp == 1)) {
                    lista.add(v);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Venta> getLista() {
        return lista;
    }

    public List<Venta> getListaFiltrada() {
        lista = new LinkedList<Venta>();
        for (Venta v : ventaFacade.findAll()) {
            if (v.getTipoVenta().getIdTipoVenta() == 3 && (v.getEstadoVenta().getIdEstadoVenta() == 4 || v.getEstadoVenta().getIdEstadoVenta() == 6)) {
                lista.add(v);
            }
        }

        return lista;
    }

    public void setLista(List<Venta> lista) {
        this.lista = lista;
    }

    public List<String> complete2(String nombre) {

        lista_Productos = new LinkedList<Producto>();
        List<String> resultado = new LinkedList<String>();
        this.llenar_Productos();
        for (Producto p : ProductoFacade.findAll()) {
            if (p.getNombreProducto().toUpperCase().indexOf(nombre.toUpperCase()) != -1) {
                lista_Productos.add(p);
                resultado.add(p.getNombreProducto());
            }
        }
        return resultado;

    }

    public void handleSelect(SelectEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected:" + event.getObject().toString(), null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public HashMap<Integer, Producto> getMyProductos() {
        return myProductos;
    }

    public void setMyProductos(HashMap<Integer, Producto> myProductos) {
        this.myProductos = myProductos;
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    }

    public List<DetalleVentaProducto> getLista_detalles() {
        return lista_detalles;
    }

    public void setLista_detalles(List<DetalleVentaProducto> lista_detalles) {
        this.lista_detalles = lista_detalles;
    }

    public List<SelectItem> getProductosItems() {
        lista_Productos = new ArrayList<Producto>();
        ProductosItems = new LinkedList<SelectItem>();
        lista_Productos = ProductoFacade.findAll();
        for (Producto p : lista_Productos) {
            myProductos.put(p.getIdProducto(), p);
            ProductosItems.add(new SelectItem(p, p.getNombreProducto()));
        }

        return ProductosItems;

    }

    public void llenar_Productos() {
        for (Producto p : ProductoFacade.findAll()) {
            myProductos.put(p.getIdProducto(), p);
        }
    }

    public BigDecimal calcular_total_venta() {
        BigDecimal total_venta = new BigDecimal(0);
        if (lista_detalles == null) {

            return total_venta;
        } else {
            for (DetalleVentaProducto dt : lista_detalles) {
//venta.setTotalVenta( venta.getTotalVenta().add(dt.getSubTotal()));
                total_venta = total_venta.add(dt.getSubTotal());
            }

            return total_venta;
        }
    }

    public void llenar_myClientes() {
        try {

            for (Cliente p : clienteFacade.findAll()) {
                myclientes.put(p.getIdCliente(), p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cliente getDevuelve_Cliente(Integer id) {
        return (Cliente) myclientes.get(id);
    }

    public Producto getDevuelve_Producto(Integer id) {
        return (Producto) myProductos.get(id);
    }

    public void setProductosItems(List<SelectItem> ProductosItems) {
        this.ProductosItems = ProductosItems;
    }

    public BigDecimal getVenta_total_detalles() {
        return venta_total_detalles;
    }

    public void setVenta_total_detalles(BigDecimal venta_total_detalles) {
        this.venta_total_detalles = venta_total_detalles;
    }

    public String getTest_devuelve_fecha_string() {

        Date dateNow = new Date();

        SimpleDateFormat dateformatDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");

        StringBuilder nowDDMMYYYY = new StringBuilder(dateformatDDMMYYYY.format(Fecha_venta));

        return nowDDMMYYYY.toString();
    }

    public String getTest_encontro_fecha_string() {
        SimpleDateFormat fecha_buscar = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat fecha_detalle = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder cadena_fecha_buscar = new StringBuilder(fecha_buscar.format(Fecha_venta));
        for (Venta v : ventaFacade.findAll()) {

            StringBuilder cadena_fecha_detalle = new StringBuilder(fecha_detalle.format(v.getFechaVenta()));
            if (cadena_fecha_buscar.toString().equals(cadena_fecha_detalle.toString())) {
                return "Si";
            }
        }
        return "No";
    }

    /*
     public void Filtrar_lista_busqueda(){
     lista= new LinkedList<Venta>();
     //  lista = ventaFacade.findAll();
     //  return lista;
     SimpleDateFormat fecha_buscar = new SimpleDateFormat("dd/MM/yyyy");
     SimpleDateFormat fecha_detalle = new SimpleDateFormat("dd/MM/yyyy");
     StringBuilder cadena_fecha_buscar = new StringBuilder( fecha_buscar.format( Fecha_venta ) );
     for (Venta v : ventaFacade.findAll()){

     StringBuilder cadena_fecha_detalle = new StringBuilder( fecha_detalle.format( v.getFechaVenta() ) );
     if(cadena_fecha_buscar.toString().equals(cadena_fecha_detalle.toString()))
     lista.add(v);
     }
      
     }

     */
    public void Filtrar_lista_busqueda() {
        lista = new LinkedList<Venta>();

        for (Venta v : ventaFacade.findAll()) {

            if (v.getFechaVenta().equals(Fecha_venta) || v.getFechaVenta().equals(Fecha_reporte_final) || (v.getFechaVenta().after(Fecha_venta) & v.getFechaVenta().before(Fecha_reporte_final))) {
                lista.add(v);

            }
        }

    }

    public void Filtrar_lista_busqueda_mejorada() {
        lista = new LinkedList<Venta>();
        for (Venta v : ventaFacade.findAll()) {
            if (v.getFechaVenta().equals(Fecha_reporte_final)) {
                lista.add(v);
            }
        }
    }

    // este es para los movimientos de boleta.
    public void Filtrar_lista_Fecha() {
        lista = new LinkedList<Venta>();
        for (Venta v : ventaFacade.findAll()) {
            if (v.getFechaVentaEmision().equals(fecha_emision)) {
                lista.add(v);
            }
        }
    }

    public String Volver_Venta() {
        venta = new Venta();
        return "ventas?faces-redirect=true";
    }

    public String Volver_Trabajos() {

        return "realizar_trabajo?faces-redirect=true";
    }

    public String Volver_Contratos() {

        return "contratos?faces-redirect=true";
    }

    public void formatearVenta() {
        if (venta.getIdVenta() % 999999 == 0) {
            venta.setNumeroVenta(999999);
            venta.setBloqueVenta((int) Math.ceil(venta.getIdVenta() / 999999));
        } else {
            venta.setBloqueVenta((int) Math.ceil(venta.getIdVenta() / 999999) + 1);
            venta.setNumeroVenta(venta.getIdVenta() % 999999);
        }
    }

    public String getBloqueBoleta() {

        String bloque = "000";
        bloque = bloque.concat(String.valueOf(venta.getBloqueVenta()));
        return bloque.substring(bloque.length() - 3);
    }

    public String getNumeroBoleta() {
        String numero = "000000";
        numero = numero.concat(String.valueOf(venta.getNumeroVenta()));
        return numero.substring(numero.length() - 6);
    }

    public String BloqueBoletas(int num) {

        String bloque = "000";
        bloque = bloque.concat(String.valueOf(num));
        return bloque.substring(bloque.length() - 3);
    }

    public String NumeroBoletas(int num) {
        String numero = "000000";
        numero = numero.concat(String.valueOf(num));
        return numero.substring(numero.length() - 6);
    }

    public String Formato(Venta v) {

       // System.out.println(" recibiendo en venta " + v);

        if (v != null) {
            String bloque = "000";
            String numero = "000000";
            bloque = bloque.concat(String.valueOf(v.getBloqueVenta()));

            bloque = bloque.substring(bloque.length() - 3);

            numero = numero.concat(String.valueOf(v.getNumeroVenta()));
            numero = numero.substring(numero.length() - 6);

            return bloque + '-' + numero;
        } else {
            return "";
        }

    }

    public String Edicion() {
        //   detalle = formulacion.getDetalleFormulacionInsumosList().get(0).getMateriaPrima();
        return "editar_boleta";
    }

    public void generar_boleta_unica_texto() {

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        FileWriter fichero = null;
        PrintWriter pw = null;
        SimpleDateFormat fecha_boleta = new SimpleDateFormat("dd/MM/yyyy");
        // System.out.println(" en la venta tenemos " + venta);
        StringBuilder cadena_fecha_buscar = new StringBuilder(fecha_boleta.format(venta.getFechaVenta()));
        try {
            //System.out.println("en el path tenemos:" + FacesContext.getCurrentInstance().getExternalContext().getRealPath("//boletas//"));
            String path_ = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//boletas//");
            fichero = new FileWriter(path_ + "/boleta" + venta.getIdVenta() + ".txt");
            pw = new PrintWriter(fichero);
            String cliente_string = venta.getCliente().getNombreCliente() + "                 .";
            String producto_string = "";

            venta.setTienda(TiendaFacade.find(venta.getTienda().getIdTienda()));
            // System.out.println("TEST:" + venta.getTienda().getNegocio());
            pw.println(venta.getTienda().getNegocio().getNombreNegocio());

            pw.println("SISTEMAS INTEGRADOS");
            pw.println("SINERGIA");
            pw.println("TRUJILLO- LA LIBERTAD");
            pw.println("TICKET DE VENTA");
            pw.println("Fecha: " + cadena_fecha_buscar);
            pw.println("ID:  " + this.Formato(venta));

            pw.println("RUC:   " + venta.getTienda().getNumeroRuc());
            pw.println("Almacén:   " + venta.getTienda().getNombreTienda());
            pw.println("CLIENTE:    " + cliente_string.substring(0, 15));
            pw.println("OBS" + venta.getObservaciones());
            pw.println("PRUCTOS A VENDER -CN- PR");
            pw.println("-----------------------------");
            for (DetalleVentaProducto dt : lista_detalles) {
                producto_string = dt.getProducto().getNombreProducto() + "                 .";
                pw.println(producto_string.substring(0, 15) + "   " + dt.getCantidad() + "  " + "S/." + dt.getPrecioVenta());
            }
            pw.println("-----------------------------");
            pw.println("TOTAL  " + venta.getTotalVenta() + " SOLES." + "\n");

            pw.println("-----------------------------");
            pw.println(" GRACIAS POR SU PREFERENCIA");
            pw.println("    danielyzc@gmail.com  ");
            pw.println(" MEJOR CALIDAD PARA USTED");
            pw.println("-----------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public String ListaServicios() {
        venta = new Venta();
        venta.setEstadoVenta(new EstadoVenta(1, "", ""));
        return "lista_servicios_pendientes";

    }

    public String Trabajos() {
        venta = new Venta();
        return "realizar_trabajo";

    }

    public String Nueva_venta_servicios() {
        venta = new Venta();
        venta.setFacturaRelacionada("");
        // Aqui tienes que agregar al empleado de la empresa que usa el sistema en ese momento
        venta.setEmpleado(new Empleado(1));
        venta.setEstadoVenta(new EstadoVenta(4));
        venta.setObservaciones("");
        venta.setTienda(new Tienda(1));
        venta.setTipoVenta(new TipoVenta(3));
        venta.setTotalVenta(new BigDecimal("0"));
        venta.setFechaVenta(fecha_para_ventas);
        venta.setFechaVentaEmision(fecha_para_ventas);
        venta.setTotalPagosCredito(new BigDecimal(0));
        lista_detalles = new LinkedList<DetalleVentaProducto>();
        detalle_venta_Producto = new DetalleVentaProducto();
        detalle_venta_Producto.setCantidad(1);
        detalle_venta_Producto.setPrecioVenta(new BigDecimal(0));
        detalle_venta_Producto.setVenta(venta);

        detalle_venta_Producto.setDescuento(BigDecimal.ZERO);
        lista_Productos = new LinkedList<Producto>();
        venta_total_detalles = new BigDecimal(0);
        return "nuevo_servicio";
    }

// OODIGO AGREGADO PARA LECTOR DE CODIGO DE BARRAS.
    public String getResetar_caja() {
        System.out.println("entro");
        CodigoBarras = "";
        return null;
    }

    public String VerActividades() {
        return "calendario_actividades";
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Servcico Seleccionado", this.Formato((Venta) event.getObject()));

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Servicio No seleccionado", this.Formato((Venta) event.getObject()));

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowDblselect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
        Flash flash = context.getExternalContext().getFlash();
        flash.put("selectedCar", (Venta) event.getObject());

        handler.performNavigation("carDetail");
    }

    public void destroyWorld(ActionEvent actionEvent) {

        try {

            this.editar2();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acción ejecutada con éxito", "Se ejecutó con éxito");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } catch (Exception e) {
            e.printStackTrace();

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error en la Aplicación", "Se ejecuto con exito");
            FacesContext.getCurrentInstance().addMessage(null, message);

        }

    }

    public void editar2() {
        try {
            ventaFacade.edit(venta);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String contratos() {
        return "contratos";
    }

    public class Modelo_Servicios_lista extends ListDataModel<Venta> implements SelectableDataModel<Venta>, Serializable {

        public Modelo_Servicios_lista() {
        }

        public Modelo_Servicios_lista(List<Venta> data) {
            super(data);
        }

        @Override
        public Venta getRowData(String rowKey) {
            //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data

            List<Venta> servicios = (List<Venta>) this.getWrappedData();

            // List<OrdenSalidaDetalleAlmacenProductos> ordenes = ordenSalidaDetalleAlmacenProductosFacade.findAll();
            for (Venta v : servicios) {
                if (v.getIdVenta().toString().equalsIgnoreCase(rowKey)) {
                    return v;
                }
            }

            return null;
        }

        @Override
        public Object getRowKey(Venta venta) {
            return venta.getIdVenta();
        }

    }

    public void precioP() {
        System.out.println("cabmiando");

    }

    public void handleSelectPRECIO(SelectEvent event) {
        // System.out.println(" entramos al handled ... ");
        Producto pro = (Producto) event.getObject();
        BigDecimal precio_final = new BigDecimal(BigInteger.ZERO);
        if (pro.getPrecioProductoList().size() > 0) {
            precio_final = pro.getPrecioProductoList().get(0).getPrecioProducto();
        }
        detalle_venta_Producto.setPrecioVenta(precio_final);
        // vamos a verificar si existe promocion con este producto.
        for (Promocion p : promocionFacade.findAll()) {
            if (p.getEstadoPromocion() == 1) {
                for (DetallePromocionProducto det : p.getDetallePromocionProductoList()) {

                    if (det.getProducto().getIdProducto() == detalle_venta_Producto.getProducto().getIdProducto()) {
                        // se ecnontro el producto en la prommocion

                        FacesMessage msg = new FacesMessage("PROMOCION ", p.getObservaciones() + " DESC " + det.getDescuentoPorcentaje().toString() + "%");

                        FacesContext.getCurrentInstance().addMessage(null, msg);

                        detalle_venta_Producto.setPrecioVenta(detalle_venta_Producto.getPrecioVenta().subtract(detalle_venta_Producto.getPrecioVenta().multiply(det.getDescuentoPorcentaje().divide(new BigDecimal(100)))));

                    }

                }

            }
        }
    }

    public void filtrarProductosCliente() {

        List<DetalleVentaProducto> lista_temp = new LinkedList<DetalleVentaProducto>();
        lista_detalles = new LinkedList<DetalleVentaProducto>();
        //  System.out.println(" antes "+lista_detalles.size());
        lista_temp = detalleVentaProductoFacade.findAll();
        // System.out.println(" despues "+lista_detalles.size());
        for (int i = lista_temp.size() - 1; i >= 0; i--) {
            // validaciones AQUI.
            if (lista_temp.get(i).getVenta().getCliente().getIdCliente() == venta.getCliente().getIdCliente()) {

                if (lista_temp.get(i).getVenta().getFechaVenta().equals(fecha_inicial) || lista_temp.get(i).getVenta().getFechaVenta().equals(fecha_final) || (lista_temp.get(i).getVenta().getFechaVenta().after(fecha_inicial) && lista_temp.get(i).getVenta().getFechaVenta().before(fecha_final))) {
                    lista_detalles.add(lista_temp.get(i));
                }

            }

        }

    }

    public int getTotal_ventas() {
        return lista_detalles.size();
    }

    public int stock_suficiente(DetalleVentaProducto det) {
        int res = 0;
        stock_faltante = 0;
        List<StockProductoTiendaOrigen> resp_ = stockProductoTiendaOrigenFacade.lista_stock_tienda_producto(venta.getTienda(), det.getProducto());
        if (resp_.size() > 0) {
            if (resp_.get(0).getCantidad() >= det.getCantidad()) {
                // todo bien.
                res = 1;
            } else {
                //mostrar pantalla de stock ayuda.
                res = 2;
                if (resp_.get(0).getCantidad() > 0) {
                    stock_faltante = det.getCantidad() - resp_.get(0).getCantidad();
                } else {
                    stock_faltante = det.getCantidad();
                }

            }

        } else {
            // nunca se registro en esta tienda.
            res = -1;
            stock_faltante = det.getCantidad();
        }
        return res;
    }

    public int getAsignados() {
        int res = 0;
        for (StockProductoTiendaOrigen_ayuda p : listaAyuda) {
            if (p.getCantidad_ayuda() > 0) {
                res = res + p.getCantidad_ayuda();
            }
        }

        return res;
    }

    public void preparaAyuda(StockProductoTiendaOrigen_ayuda sa) {
        objetoAyuda = sa;
    }

    public void asignacionFinal() {
        
        for (StockProductoTiendaOrigen_ayuda p : listaAyuda) {
            if (p.getCantidad_ayuda() > 0) {
                listaAyuda_Final.add(p);
            }
        }
        // ahora si pasamos el producto normalmente:
        BigDecimal cantidad = new BigDecimal(detalle_venta_Producto.getCantidad());
        detalle_venta_Producto.setSubTotal((detalle_venta_Producto.getPrecioVenta().subtract(detalle_venta_Producto.getDescuento())).multiply(cantidad));
        DetalleVentaProducto dt = new DetalleVentaProducto();
        dt = detalle_venta_Producto;

        //asignandole el tipo de servicio
        // venta.setObservaciones(detalle_venta_Producto.getProducto().getTipoProducto().getNombreTipoProducto());
        dt.setVenta(venta);

        lista_detalles.add(dt);
        Producto p = new Producto();
        p = detalle_venta_Producto.getProducto();
        detalle_venta_Producto = new DetalleVentaProducto();
        detalle_venta_Producto.setProducto(p);
        detalle_venta_Producto.setCantidad(1);
        detalle_venta_Producto.setDescuento(new BigDecimal("0"));
        detalle_venta_Producto.setPrecioVenta(new BigDecimal("0"));
        venta_total_detalles = this.calcular_total_venta();
    }
}

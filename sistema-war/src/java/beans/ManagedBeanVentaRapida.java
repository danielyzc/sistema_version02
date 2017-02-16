/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bc.DetalleVentaRapidaProductoFacadeLocal;
import bc.ProductoFacadeLocal;
import bc.VentaRapidaFacadeLocal;
import be.Cliente;
import be.DetalleVentaRapidaProducto;
import be.Producto;
import be.Tienda;
import be.VentaRapida;
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
import javax.faces.event.ActionEvent;

/**
 *
 * @author daniel
 */
@ManagedBean
@SessionScoped
public class ManagedBeanVentaRapida implements Serializable {

    @EJB
    private DetalleVentaRapidaProductoFacadeLocal detalleVentaRapidaProductoFacade;
    @EJB
    private VentaRapidaFacadeLocal ventaRapidaFacade;
    @EJB
    private ProductoFacadeLocal productoFacade;
    private VentaRapida ventaRapida;
    private List<VentaRapida> lista;
    private String codigoBarras = "";
    private Date fecha;
    private int estado = 0;
    private Producto producto_elegido;
    private Tienda tienda;
    private String nombre_producto = "";
    private int cantidad = 1;
    private DetalleVentaRapidaProducto detalle;
    private Cliente cliente;

    public ManagedBeanVentaRapida() {
        ventaRapida = new VentaRapida();
        fecha = new Date();
        producto_elegido = new Producto();
        tienda = new Tienda();
        detalle = new DetalleVentaRapidaProducto();
        cliente = new Cliente();
    }

    public int getCantidad() {
        return cantidad;
    }

    public DetalleVentaRapidaProducto getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleVentaRapidaProducto detalle) {

        this.detalle = detalle;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Producto getProducto_elegido() {
        return producto_elegido;
    }

    public void setProducto_elegido(Producto producto_elegido) {
        this.producto_elegido = producto_elegido;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public List<VentaRapida> getLista() {
        try {
            lista = new LinkedList<VentaRapida>();
            List<VentaRapida> lista_temp = new LinkedList<VentaRapida>();
            //  System.out.println("TAMAÑO LISTA TEMPORAL: "+lista_temp.size());
            lista_temp = ventaRapidaFacade.findAll();

            for (int i = lista_temp.size() - 1; i >= 0; i--) {
                //   System.out.println("HOLA MUNDO"+i);
                lista.add(lista_temp.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void setLista(List<VentaRapida> lista) {
        this.lista = lista;
    }

    public VentaRapida getVentaRapida() {
        return ventaRapida;
    }

    public void setVentaRapida(VentaRapida ventaRapida) {
        this.ventaRapida = ventaRapida;
    }

    public String Ventas_rapidas() {
        return "ventas_rapidas";
    }

    public String nueva() {
//tienda = new Tienda();
        codigoBarras = "";
        return "vrapidas";
    }

    public void crearNueva() {
        ventaRapida = new VentaRapida();
        codigoBarras = "";

    }

    public String ingreso_productos() {
        return "ingProdVentaRapida";
    }

    public String crear() {
        try {
            ventaRapida.setFechaVenta(fecha);
            ventaRapidaFacade.create(ventaRapida);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "REGISTRO EXITOSO", "Se ejecutó con éxito");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
        }
        return "ventas_rapidas?faces-redirect=true";
    }

    public void registrarRapido() {
        ventaRapida = new VentaRapida();
        try {

            if (codigoBarras.length() >= 13) {

                for (Producto p : productoFacade.findAll()) {
                    if (p.getNombreProducto().contains(codigoBarras)) {
                        producto_elegido = p;
//            ventaRapida.setProducto(producto);
                        // debe existir por lo menos un cliente
                        //   ventaRapida.setCliente(new Cliente(1));
                        //   ventaRapida.setPrecioVenta(BigDecimal.ZERO);
                        ventaRapida.setTienda(tienda);
                        //    ventaRapida.setVentaRapidaPK(new VentaRapidaPK(codigoBarras,tienda.getIdTienda()));

                        ventaRapidaFacade.create(ventaRapida);

                        // ventaRapida = detalleInventarioUbicacionFisicaFacade.find(detalleInventarioUbicacionFisica.getIdDetalleInventarioUbicacionFisica());

                        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "REGISTRO EXITOSO", "Se ejecutó con éxito");
                        FacesContext.getCurrentInstance().addMessage(null, message);

                    } else {
                        producto_elegido = new Producto();
                    }

                }

            }


        } catch (Exception e) {
            e.printStackTrace();

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "NO SE REGISTRO", "Se ejecuto con exito");
            FacesContext.getCurrentInstance().addMessage(null, message);

        }



    }

    public void eliminar_lista_productos() {
        try {

            //    detalleUbicacionFisicaProductoFacade.remove(detalleUbicacionFisicaProducto);
            //        detalleInventarioUbicacionFisica = detalleInventarioUbicacionFisicaFacade.find(detalleInventarioUbicacionFisica.getIdDetalleInventarioUbicacionFisica());

            producto_elegido = new Producto();
            codigoBarras = "";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ELIMINADO", "SE SACO EL PRODUCTO DE LA LISTA");
            FacesContext.getCurrentInstance().addMessage(null, message);


        } catch (Exception e) {
        }

    }

    public void buscar() {
        try {

            //  producto = new Producto();
            if (codigoBarras.length() >= 13) {

                for (Producto p : productoFacade.findAll()) {
                    if (p.getNombreProducto().contains(codigoBarras)) {
                        producto_elegido = new Producto();
                        producto_elegido = p;
                        nombre_producto = producto_elegido.getNombreProducto();
                        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "PRODUCTO SELECCIONADO", "");
                        FacesContext.getCurrentInstance().addMessage(null, message);

                    }
                }

            }


        } catch (Exception e) {
            e.printStackTrace();

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "NO SE REGISTRO", "Se ejecuto con exito");
            FacesContext.getCurrentInstance().addMessage(null, message);

        }

        System.out.println("ESTAMOS SACANDO :" + producto_elegido.getIdProducto());

    }

    public void agregarLista() {

        try {

            
           DetalleVentaRapidaProducto det = new DetalleVentaRapidaProducto();
            det.setCantidad(cantidad);
            det.setCliente(new Cliente(1));
            det.setPrecioVenta(BigDecimal.ZERO);
            System.out.println("JOJOJO" + producto_elegido.getIdProducto());
            det.setProducto(producto_elegido);
            det.setVentaRapida(ventaRapida);

            detalleVentaRapidaProductoFacade.create(det);
            ventaRapida = ventaRapidaFacade.find(ventaRapida.getIdVentaRapida());

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO CON EXITO", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void eliminar_lista() {

        try {
            detalleVentaRapidaProductoFacade.remove(detalle);
            ventaRapida = ventaRapidaFacade.find(ventaRapida.getIdVentaRapida());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCantidadLista() {
        int cant = 0;
        for (DetalleVentaRapidaProducto det : ventaRapida.getDetalleVentaRapidaProductoList()) {
            cant = cant + det.getCantidad();
        }
        return cant;
    }

    public List<DetalleVentaRapidaProducto> getListaProductos() {
        List<DetalleVentaRapidaProducto> lista_retornar = new LinkedList<DetalleVentaRapidaProducto>();
        for (int i = ventaRapida.getDetalleVentaRapidaProductoList().size() - 1; i >= 0; i--) {

            lista_retornar.add(ventaRapida.getDetalleVentaRapidaProductoList().get(i));
        }

        return lista_retornar;
    }

    public void editarDetalle() {
        try {

            detalleVentaRapidaProductoFacade.edit(detalle);

        } catch (Exception e) {
        }

    }

    public String volver() {
        return "vrapidas?faces-redirect=true";
    }
}

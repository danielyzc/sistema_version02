/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "orden_salida_detalle_almacen_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductos.findAll", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductos o"),
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductos.findByIdOrdenSalidaDetalleAlmacenProductosCostos", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductos o WHERE o.idOrdenSalidaDetalleAlmacenProductosCostos = :idOrdenSalidaDetalleAlmacenProductosCostos"),
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductos.findByObservacionesUbicacion", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductos o WHERE o.observacionesUbicacion = :observacionesUbicacion"),
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductos.findByFechaRegistro", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductos o WHERE o.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductos.findByCodigoFacturaBoleta", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductos o WHERE o.codigoFacturaBoleta = :codigoFacturaBoleta"),
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductos.findByCantidad", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductos o WHERE o.cantidad = :cantidad")})
public class OrdenSalidaDetalleAlmacenProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_salida_detalle_almacen_productos_costos")
    private Integer idOrdenSalidaDetalleAlmacenProductosCostos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 300)
    @Column(name = "observaciones_ubicacion")
    private String observacionesUbicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 150)
    @Column(name = "codigo_factura_boleta")
    private String codigoFacturaBoleta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "id_detalle_almacen_productos", referencedColumnName = "id_detalle_almacen_productos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DetalleAlmacenProductos detalleAlmacenProductos;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "id_estado_orden_salida_detalle_almacen_productos", referencedColumnName = "id_estado_orden_salida_detalle_almacen_productos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoOrdenSalidaDetalleAlmacenProductos estadoOrdenSalidaDetalleAlmacenProductos;

    public OrdenSalidaDetalleAlmacenProductos() {
    }

    public OrdenSalidaDetalleAlmacenProductos(Integer idOrdenSalidaDetalleAlmacenProductosCostos) {
        this.idOrdenSalidaDetalleAlmacenProductosCostos = idOrdenSalidaDetalleAlmacenProductosCostos;
    }

    public OrdenSalidaDetalleAlmacenProductos(Integer idOrdenSalidaDetalleAlmacenProductosCostos, String observacionesUbicacion, Date fechaRegistro, String codigoFacturaBoleta, int cantidad) {
        this.idOrdenSalidaDetalleAlmacenProductosCostos = idOrdenSalidaDetalleAlmacenProductosCostos;
        this.observacionesUbicacion = observacionesUbicacion;
        this.fechaRegistro = fechaRegistro;
        this.codigoFacturaBoleta = codigoFacturaBoleta;
        this.cantidad = cantidad;
    }

    public Integer getIdOrdenSalidaDetalleAlmacenProductosCostos() {
        return idOrdenSalidaDetalleAlmacenProductosCostos;
    }

    public void setIdOrdenSalidaDetalleAlmacenProductosCostos(Integer idOrdenSalidaDetalleAlmacenProductosCostos) {
        this.idOrdenSalidaDetalleAlmacenProductosCostos = idOrdenSalidaDetalleAlmacenProductosCostos;
    }

    public String getObservacionesUbicacion() {
        return observacionesUbicacion;
    }

    public void setObservacionesUbicacion(String observacionesUbicacion) {
        this.observacionesUbicacion = observacionesUbicacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCodigoFacturaBoleta() {
        return codigoFacturaBoleta;
    }

    public void setCodigoFacturaBoleta(String codigoFacturaBoleta) {
        this.codigoFacturaBoleta = codigoFacturaBoleta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public DetalleAlmacenProductos getDetalleAlmacenProductos() {
        return detalleAlmacenProductos;
    }

    public void setDetalleAlmacenProductos(DetalleAlmacenProductos detalleAlmacenProductos) {
        this.detalleAlmacenProductos = detalleAlmacenProductos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoOrdenSalidaDetalleAlmacenProductos getEstadoOrdenSalidaDetalleAlmacenProductos() {
        return estadoOrdenSalidaDetalleAlmacenProductos;
    }

    public void setEstadoOrdenSalidaDetalleAlmacenProductos(EstadoOrdenSalidaDetalleAlmacenProductos estadoOrdenSalidaDetalleAlmacenProductos) {
        this.estadoOrdenSalidaDetalleAlmacenProductos = estadoOrdenSalidaDetalleAlmacenProductos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenSalidaDetalleAlmacenProductosCostos != null ? idOrdenSalidaDetalleAlmacenProductosCostos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenSalidaDetalleAlmacenProductos)) {
            return false;
        }
        OrdenSalidaDetalleAlmacenProductos other = (OrdenSalidaDetalleAlmacenProductos) object;
        if ((this.idOrdenSalidaDetalleAlmacenProductosCostos == null && other.idOrdenSalidaDetalleAlmacenProductosCostos != null) || (this.idOrdenSalidaDetalleAlmacenProductosCostos != null && !this.idOrdenSalidaDetalleAlmacenProductosCostos.equals(other.idOrdenSalidaDetalleAlmacenProductosCostos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.OrdenSalidaDetalleAlmacenProductos[ idOrdenSalidaDetalleAlmacenProductosCostos=" + idOrdenSalidaDetalleAlmacenProductosCostos + " ]";
    }
    
}

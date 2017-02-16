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
 * @author developer
 */
@Entity
@Table(name = "orden_salida_detalle_almacen_productos_costos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductosCostos.findAll", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductosCostos o"),
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductosCostos.findByIdOrdenSalidaDetalleAlmacenProductosCostos", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductosCostos o WHERE o.idOrdenSalidaDetalleAlmacenProductosCostos = :idOrdenSalidaDetalleAlmacenProductosCostos"),
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductosCostos.findByObservacionesUbicacion", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductosCostos o WHERE o.observacionesUbicacion = :observacionesUbicacion"),
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductosCostos.findByFechaRegistro", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductosCostos o WHERE o.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductosCostos.findByCodigoFacturaBoleta", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductosCostos o WHERE o.codigoFacturaBoleta = :codigoFacturaBoleta")})
public class OrdenSalidaDetalleAlmacenProductosCostos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_salida_detalle_almacen_productos_costos")
    private Integer idOrdenSalidaDetalleAlmacenProductosCostos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "observaciones_ubicacion")
    private String observacionesUbicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "codigo_factura_boleta")
    private String codigoFacturaBoleta;
    @JoinColumn(name = "id_detalle_almacen_productos_costos", referencedColumnName = "id_detalle_almacen_productos_costos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DetalleAlmacenProductosCostos detalleAlmacenProductosCostos;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;

    public OrdenSalidaDetalleAlmacenProductosCostos() {
    }

    public OrdenSalidaDetalleAlmacenProductosCostos(Integer idOrdenSalidaDetalleAlmacenProductosCostos) {
        this.idOrdenSalidaDetalleAlmacenProductosCostos = idOrdenSalidaDetalleAlmacenProductosCostos;
    }

    public OrdenSalidaDetalleAlmacenProductosCostos(Integer idOrdenSalidaDetalleAlmacenProductosCostos, String observacionesUbicacion, Date fechaRegistro, String codigoFacturaBoleta) {
        this.idOrdenSalidaDetalleAlmacenProductosCostos = idOrdenSalidaDetalleAlmacenProductosCostos;
        this.observacionesUbicacion = observacionesUbicacion;
        this.fechaRegistro = fechaRegistro;
        this.codigoFacturaBoleta = codigoFacturaBoleta;
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

    public DetalleAlmacenProductosCostos getDetalleAlmacenProductosCostos() {
        return detalleAlmacenProductosCostos;
    }

    public void setDetalleAlmacenProductosCostos(DetalleAlmacenProductosCostos detalleAlmacenProductosCostos) {
        this.detalleAlmacenProductosCostos = detalleAlmacenProductosCostos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        if (!(object instanceof OrdenSalidaDetalleAlmacenProductosCostos)) {
            return false;
        }
        OrdenSalidaDetalleAlmacenProductosCostos other = (OrdenSalidaDetalleAlmacenProductosCostos) object;
        if ((this.idOrdenSalidaDetalleAlmacenProductosCostos == null && other.idOrdenSalidaDetalleAlmacenProductosCostos != null) || (this.idOrdenSalidaDetalleAlmacenProductosCostos != null && !this.idOrdenSalidaDetalleAlmacenProductosCostos.equals(other.idOrdenSalidaDetalleAlmacenProductosCostos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.OrdenSalidaDetalleAlmacenProductosCostos[ idOrdenSalidaDetalleAlmacenProductosCostos=" + idOrdenSalidaDetalleAlmacenProductosCostos + " ]";
    }
    
}

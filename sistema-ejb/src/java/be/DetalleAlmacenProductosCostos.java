/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "detalle_almacen_productos_costos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findAll", query = "SELECT d FROM DetalleAlmacenProductosCostos d"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByIdDetalleAlmacenProductosCostos", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.idDetalleAlmacenProductosCostos = :idDetalleAlmacenProductosCostos"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByCosto", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.costo = :costo"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByFechaEntrada", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.fechaEntrada = :fechaEntrada"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByFechaSalida", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByObservaciones", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.observaciones = :observaciones")})
public class DetalleAlmacenProductosCostos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_almacen_productos_costos")
    private Integer idDetalleAlmacenProductosCostos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private BigDecimal costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 300)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    @JoinColumn(name = "id_procedencia_producto_almacen", referencedColumnName = "id_procedencia_producto_almacen")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProcedenciaProductoAlmacen procedenciaProductoAlmacen;
    @JoinColumn(name = "id_estado_producto_costo_almacen", referencedColumnName = "id_estado_producto_costo_almacen")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoProductoCostoAlmacen estadoProductoCostoAlmacen;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleAlmacenProductosCostos", fetch = FetchType.LAZY)
    private List<OrdenSalidaDetalleAlmacenProductosCostos> ordenSalidaDetalleAlmacenProductosCostosList;

    public DetalleAlmacenProductosCostos() {
    }

    public DetalleAlmacenProductosCostos(Integer idDetalleAlmacenProductosCostos) {
        this.idDetalleAlmacenProductosCostos = idDetalleAlmacenProductosCostos;
    }

    public DetalleAlmacenProductosCostos(Integer idDetalleAlmacenProductosCostos, BigDecimal costo, Date fechaEntrada, String observaciones) {
        this.idDetalleAlmacenProductosCostos = idDetalleAlmacenProductosCostos;
        this.costo = costo;
        this.fechaEntrada = fechaEntrada;
        this.observaciones = observaciones;
    }

    public Integer getIdDetalleAlmacenProductosCostos() {
        return idDetalleAlmacenProductosCostos;
    }

    public void setIdDetalleAlmacenProductosCostos(Integer idDetalleAlmacenProductosCostos) {
        this.idDetalleAlmacenProductosCostos = idDetalleAlmacenProductosCostos;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ProcedenciaProductoAlmacen getProcedenciaProductoAlmacen() {
        return procedenciaProductoAlmacen;
    }

    public void setProcedenciaProductoAlmacen(ProcedenciaProductoAlmacen procedenciaProductoAlmacen) {
        this.procedenciaProductoAlmacen = procedenciaProductoAlmacen;
    }

    public EstadoProductoCostoAlmacen getEstadoProductoCostoAlmacen() {
        return estadoProductoCostoAlmacen;
    }

    public void setEstadoProductoCostoAlmacen(EstadoProductoCostoAlmacen estadoProductoCostoAlmacen) {
        this.estadoProductoCostoAlmacen = estadoProductoCostoAlmacen;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @XmlTransient
    public List<OrdenSalidaDetalleAlmacenProductosCostos> getOrdenSalidaDetalleAlmacenProductosCostosList() {
        return ordenSalidaDetalleAlmacenProductosCostosList;
    }

    public void setOrdenSalidaDetalleAlmacenProductosCostosList(List<OrdenSalidaDetalleAlmacenProductosCostos> ordenSalidaDetalleAlmacenProductosCostosList) {
        this.ordenSalidaDetalleAlmacenProductosCostosList = ordenSalidaDetalleAlmacenProductosCostosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleAlmacenProductosCostos != null ? idDetalleAlmacenProductosCostos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleAlmacenProductosCostos)) {
            return false;
        }
        DetalleAlmacenProductosCostos other = (DetalleAlmacenProductosCostos) object;
        if ((this.idDetalleAlmacenProductosCostos == null && other.idDetalleAlmacenProductosCostos != null) || (this.idDetalleAlmacenProductosCostos != null && !this.idDetalleAlmacenProductosCostos.equals(other.idDetalleAlmacenProductosCostos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleAlmacenProductosCostos[ idDetalleAlmacenProductosCostos=" + idDetalleAlmacenProductosCostos + " ]";
    }
    
}

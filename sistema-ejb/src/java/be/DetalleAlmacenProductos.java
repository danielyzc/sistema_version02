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
@Table(name = "detalle_almacen_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleAlmacenProductos.findAll", query = "SELECT d FROM DetalleAlmacenProductos d"),
    @NamedQuery(name = "DetalleAlmacenProductos.findByIdDetalleAlmacenProductos", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.idDetalleAlmacenProductos = :idDetalleAlmacenProductos"),
    @NamedQuery(name = "DetalleAlmacenProductos.findByCosto", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.costo = :costo"),
    @NamedQuery(name = "DetalleAlmacenProductos.findByCantidad", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleAlmacenProductos.findBySalieron", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.salieron = :salieron"),
    @NamedQuery(name = "DetalleAlmacenProductos.findByQuedaron", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.quedaron = :quedaron"),
    @NamedQuery(name = "DetalleAlmacenProductos.findByFechaIngreso", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "DetalleAlmacenProductos.findByFechaVencimiento", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "DetalleAlmacenProductos.findByDescripcionMotivo", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.descripcionMotivo = :descripcionMotivo")})
public class DetalleAlmacenProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_almacen_productos")
    private Integer idDetalleAlmacenProductos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private BigDecimal costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salieron")
    private int salieron;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quedaron")
    private int quedaron;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Size(max = 370)
    @Column(name = "descripcion_motivo")
    private String descripcionMotivo;
    @JoinColumn(name = "id_estado_producto_costo_almacen", referencedColumnName = "id_estado_producto_costo_almacen")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoProductoCostoAlmacen estadoProductoCostoAlmacen;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    @JoinColumn(name = "id_procedencia_producto_almacen", referencedColumnName = "id_procedencia_producto_almacen")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProcedenciaProductoAlmacen procedenciaProductoAlmacen;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda;
    @JoinColumn(name = "id_ubicacion_fisica", referencedColumnName = "id_ubicacion_fisica")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UbicacionFisica ubicacionFisica;
    @JoinColumn(name = "id_ingreso_producto_tienda", referencedColumnName = "id_ingreso_producto_tienda")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private IngresoProductoTienda ingresoProductoTienda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleAlmacenProductos", fetch = FetchType.LAZY)
    private List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList;

    public DetalleAlmacenProductos() {
    }

    public DetalleAlmacenProductos(Integer idDetalleAlmacenProductos) {
        this.idDetalleAlmacenProductos = idDetalleAlmacenProductos;
    }

    public DetalleAlmacenProductos(Integer idDetalleAlmacenProductos, BigDecimal costo, int cantidad, int salieron, int quedaron, Date fechaIngreso, Date fechaVencimiento) {
        this.idDetalleAlmacenProductos = idDetalleAlmacenProductos;
        this.costo = costo;
        this.cantidad = cantidad;
        this.salieron = salieron;
        this.quedaron = quedaron;
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getIdDetalleAlmacenProductos() {
        return idDetalleAlmacenProductos;
    }

    public void setIdDetalleAlmacenProductos(Integer idDetalleAlmacenProductos) {
        this.idDetalleAlmacenProductos = idDetalleAlmacenProductos;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSalieron() {
        return salieron;
    }

    public void setSalieron(int salieron) {
        this.salieron = salieron;
    }

    public int getQuedaron() {
        return quedaron;
    }

    public void setQuedaron(int quedaron) {
        this.quedaron = quedaron;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getDescripcionMotivo() {
        return descripcionMotivo;
    }

    public void setDescripcionMotivo(String descripcionMotivo) {
        this.descripcionMotivo = descripcionMotivo;
    }

    public EstadoProductoCostoAlmacen getEstadoProductoCostoAlmacen() {
        return estadoProductoCostoAlmacen;
    }

    public void setEstadoProductoCostoAlmacen(EstadoProductoCostoAlmacen estadoProductoCostoAlmacen) {
        this.estadoProductoCostoAlmacen = estadoProductoCostoAlmacen;
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

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public UbicacionFisica getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(UbicacionFisica ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
    }

    public IngresoProductoTienda getIngresoProductoTienda() {
        return ingresoProductoTienda;
    }

    public void setIngresoProductoTienda(IngresoProductoTienda ingresoProductoTienda) {
        this.ingresoProductoTienda = ingresoProductoTienda;
    }

    @XmlTransient
    public List<OrdenSalidaDetalleAlmacenProductos> getOrdenSalidaDetalleAlmacenProductosList() {
        return ordenSalidaDetalleAlmacenProductosList;
    }

    public void setOrdenSalidaDetalleAlmacenProductosList(List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList) {
        this.ordenSalidaDetalleAlmacenProductosList = ordenSalidaDetalleAlmacenProductosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleAlmacenProductos != null ? idDetalleAlmacenProductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleAlmacenProductos)) {
            return false;
        }
        DetalleAlmacenProductos other = (DetalleAlmacenProductos) object;
        if ((this.idDetalleAlmacenProductos == null && other.idDetalleAlmacenProductos != null) || (this.idDetalleAlmacenProductos != null && !this.idDetalleAlmacenProductos.equals(other.idDetalleAlmacenProductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleAlmacenProductos[ idDetalleAlmacenProductos=" + idDetalleAlmacenProductos + " ]";
    }
    
}

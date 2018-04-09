/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "Producto.findByFechaIngreso", query = "SELECT p FROM Producto p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Producto.findByFecCreacion", query = "SELECT p FROM Producto p WHERE p.fecCreacion = :fecCreacion"),
    @NamedQuery(name = "Producto.findByFecModificacion", query = "SELECT p FROM Producto p WHERE p.fecModificacion = :fecModificacion"),
    @NamedQuery(name = "Producto.findByFecEliminacion", query = "SELECT p FROM Producto p WHERE p.fecEliminacion = :fecEliminacion"),
    @NamedQuery(name = "Producto.findByUsuCrea", query = "SELECT p FROM Producto p WHERE p.usuCrea = :usuCrea"),
    @NamedQuery(name = "Producto.findByUsuModi", query = "SELECT p FROM Producto p WHERE p.usuModi = :usuModi"),
    @NamedQuery(name = "Producto.findByUsuElim", query = "SELECT p FROM Producto p WHERE p.usuElim = :usuElim"),
    @NamedQuery(name = "Producto.findByEstadoExistencia", query = "SELECT p FROM Producto p WHERE p.estadoExistencia = :estadoExistencia")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 300)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "fec_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreacion;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModificacion;
    @Column(name = "fec_eliminacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEliminacion;
    @Column(name = "usu_crea")
    private Integer usuCrea;
    @Column(name = "usu_modi")
    private Integer usuModi;
    @Column(name = "usu_elim")
    private Integer usuElim;
    @Column(name = "estado_existencia")
    private Integer estadoExistencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<StockProductoTiendaOrigen> stockProductoTiendaOrigenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleCambioProducto> detalleCambioProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto1", fetch = FetchType.LAZY)
    private List<DetalleCambioProducto> detalleCambioProductoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleOrdenCompraProducto> detalleOrdenCompraProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DevolucionLima> devolucionLimaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetallePromocionProducto> detallePromocionProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleFacturaVentaProducto> detalleFacturaVentaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleAlmacenProductos> detalleAlmacenProductosList;
    @JoinColumn(name = "fk_marca_producto", referencedColumnName = "pk_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MarcaProducto marcaProducto;
    @JoinColumn(name = "id_modelo_producto", referencedColumnName = "id_modelo_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ModeloProducto modeloProducto;
    @JoinColumn(name = "id_tipo_producto", referencedColumnName = "id_tipo_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoProducto tipoProducto;
    @JoinColumn(name = "id_color_producto", referencedColumnName = "id_color_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ColorProducto colorProducto;
    @JoinColumn(name = "fk_talla_producto", referencedColumnName = "pk_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TallaProducto tallaProducto;
    @JoinColumn(name = "id_estado_producto", referencedColumnName = "id_estado_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoProducto estadoProducto;
    @JoinColumn(name = "id_material_producto", referencedColumnName = "id_material_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MaterialProducto materialProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleVentaProducto> detalleVentaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleFumigacionProducto> detalleFumigacionProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<IngresoProductoTienda> ingresoProductoTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleServicioProducto> detalleServicioProductoList;
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private List<PrecioProducto> precioProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<SalidaProductoTienda> salidaProductoTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleVentaRapidaProducto> detalleVentaRapidaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<Formulacion> formulacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleUbicacionFisicaProducto> detalleUbicacionFisicaProductoList;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombreProducto, Date fechaIngreso) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public Date getFecModificacion() {
        return fecModificacion;
    }

    public void setFecModificacion(Date fecModificacion) {
        this.fecModificacion = fecModificacion;
    }

    public Date getFecEliminacion() {
        return fecEliminacion;
    }

    public void setFecEliminacion(Date fecEliminacion) {
        this.fecEliminacion = fecEliminacion;
    }

    public Integer getUsuCrea() {
        return usuCrea;
    }

    public void setUsuCrea(Integer usuCrea) {
        this.usuCrea = usuCrea;
    }

    public Integer getUsuModi() {
        return usuModi;
    }

    public void setUsuModi(Integer usuModi) {
        this.usuModi = usuModi;
    }

    public Integer getUsuElim() {
        return usuElim;
    }

    public void setUsuElim(Integer usuElim) {
        this.usuElim = usuElim;
    }

    public Integer getEstadoExistencia() {
        return estadoExistencia;
    }

    public void setEstadoExistencia(Integer estadoExistencia) {
        this.estadoExistencia = estadoExistencia;
    }

    @XmlTransient
    public List<StockProductoTiendaOrigen> getStockProductoTiendaOrigenList() {
        return stockProductoTiendaOrigenList;
    }

    public void setStockProductoTiendaOrigenList(List<StockProductoTiendaOrigen> stockProductoTiendaOrigenList) {
        this.stockProductoTiendaOrigenList = stockProductoTiendaOrigenList;
    }

    @XmlTransient
    public List<DetalleCambioProducto> getDetalleCambioProductoList() {
        return detalleCambioProductoList;
    }

    public void setDetalleCambioProductoList(List<DetalleCambioProducto> detalleCambioProductoList) {
        this.detalleCambioProductoList = detalleCambioProductoList;
    }

    @XmlTransient
    public List<DetalleCambioProducto> getDetalleCambioProductoList1() {
        return detalleCambioProductoList1;
    }

    public void setDetalleCambioProductoList1(List<DetalleCambioProducto> detalleCambioProductoList1) {
        this.detalleCambioProductoList1 = detalleCambioProductoList1;
    }

    @XmlTransient
    public List<DetalleAlmacenProductosCostos> getDetalleAlmacenProductosCostosList() {
        return detalleAlmacenProductosCostosList;
    }

    public void setDetalleAlmacenProductosCostosList(List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList) {
        this.detalleAlmacenProductosCostosList = detalleAlmacenProductosCostosList;
    }

    @XmlTransient
    public List<DetalleOrdenCompraProducto> getDetalleOrdenCompraProductoList() {
        return detalleOrdenCompraProductoList;
    }

    public void setDetalleOrdenCompraProductoList(List<DetalleOrdenCompraProducto> detalleOrdenCompraProductoList) {
        this.detalleOrdenCompraProductoList = detalleOrdenCompraProductoList;
    }

    @XmlTransient
    public List<DevolucionLima> getDevolucionLimaList() {
        return devolucionLimaList;
    }

    public void setDevolucionLimaList(List<DevolucionLima> devolucionLimaList) {
        this.devolucionLimaList = devolucionLimaList;
    }

    @XmlTransient
    public List<DetallePromocionProducto> getDetallePromocionProductoList() {
        return detallePromocionProductoList;
    }

    public void setDetallePromocionProductoList(List<DetallePromocionProducto> detallePromocionProductoList) {
        this.detallePromocionProductoList = detallePromocionProductoList;
    }

    @XmlTransient
    public List<DetalleFacturaVentaProducto> getDetalleFacturaVentaProductoList() {
        return detalleFacturaVentaProductoList;
    }

    public void setDetalleFacturaVentaProductoList(List<DetalleFacturaVentaProducto> detalleFacturaVentaProductoList) {
        this.detalleFacturaVentaProductoList = detalleFacturaVentaProductoList;
    }

    @XmlTransient
    public List<DetalleAlmacenProductos> getDetalleAlmacenProductosList() {
        return detalleAlmacenProductosList;
    }

    public void setDetalleAlmacenProductosList(List<DetalleAlmacenProductos> detalleAlmacenProductosList) {
        this.detalleAlmacenProductosList = detalleAlmacenProductosList;
    }

    public MarcaProducto getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(MarcaProducto marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public ModeloProducto getModeloProducto() {
        return modeloProducto;
    }

    public void setModeloProducto(ModeloProducto modeloProducto) {
        this.modeloProducto = modeloProducto;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public ColorProducto getColorProducto() {
        return colorProducto;
    }

    public void setColorProducto(ColorProducto colorProducto) {
        this.colorProducto = colorProducto;
    }

    public TallaProducto getTallaProducto() {
        return tallaProducto;
    }

    public void setTallaProducto(TallaProducto tallaProducto) {
        this.tallaProducto = tallaProducto;
    }

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public MaterialProducto getMaterialProducto() {
        return materialProducto;
    }

    public void setMaterialProducto(MaterialProducto materialProducto) {
        this.materialProducto = materialProducto;
    }

    @XmlTransient
    public List<DetalleVentaProducto> getDetalleVentaProductoList() {
        return detalleVentaProductoList;
    }

    public void setDetalleVentaProductoList(List<DetalleVentaProducto> detalleVentaProductoList) {
        this.detalleVentaProductoList = detalleVentaProductoList;
    }

    @XmlTransient
    public List<DetalleFumigacionProducto> getDetalleFumigacionProductoList() {
        return detalleFumigacionProductoList;
    }

    public void setDetalleFumigacionProductoList(List<DetalleFumigacionProducto> detalleFumigacionProductoList) {
        this.detalleFumigacionProductoList = detalleFumigacionProductoList;
    }

    @XmlTransient
    public List<IngresoProductoTienda> getIngresoProductoTiendaList() {
        return ingresoProductoTiendaList;
    }

    public void setIngresoProductoTiendaList(List<IngresoProductoTienda> ingresoProductoTiendaList) {
        this.ingresoProductoTiendaList = ingresoProductoTiendaList;
    }

    @XmlTransient
    public List<DetalleServicioProducto> getDetalleServicioProductoList() {
        return detalleServicioProductoList;
    }

    public void setDetalleServicioProductoList(List<DetalleServicioProducto> detalleServicioProductoList) {
        this.detalleServicioProductoList = detalleServicioProductoList;
    }

    @XmlTransient
    public List<PrecioProducto> getPrecioProductoList() {
        return precioProductoList;
    }

    public void setPrecioProductoList(List<PrecioProducto> precioProductoList) {
        this.precioProductoList = precioProductoList;
    }

    @XmlTransient
    public List<SalidaProductoTienda> getSalidaProductoTiendaList() {
        return salidaProductoTiendaList;
    }

    public void setSalidaProductoTiendaList(List<SalidaProductoTienda> salidaProductoTiendaList) {
        this.salidaProductoTiendaList = salidaProductoTiendaList;
    }

    @XmlTransient
    public List<DetalleVentaRapidaProducto> getDetalleVentaRapidaProductoList() {
        return detalleVentaRapidaProductoList;
    }

    public void setDetalleVentaRapidaProductoList(List<DetalleVentaRapidaProducto> detalleVentaRapidaProductoList) {
        this.detalleVentaRapidaProductoList = detalleVentaRapidaProductoList;
    }

    @XmlTransient
    public List<Formulacion> getFormulacionList() {
        return formulacionList;
    }

    public void setFormulacionList(List<Formulacion> formulacionList) {
        this.formulacionList = formulacionList;
    }

    @XmlTransient
    public List<DetalleUbicacionFisicaProducto> getDetalleUbicacionFisicaProductoList() {
        return detalleUbicacionFisicaProductoList;
    }

    public void setDetalleUbicacionFisicaProductoList(List<DetalleUbicacionFisicaProducto> detalleUbicacionFisicaProductoList) {
        this.detalleUbicacionFisicaProductoList = detalleUbicacionFisicaProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Producto[ idProducto=" + idProducto + " ]";
    }
    
}

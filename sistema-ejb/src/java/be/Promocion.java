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
@Table(name = "promocion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promocion.findAll", query = "SELECT p FROM Promocion p"),
    @NamedQuery(name = "Promocion.findByIdPromocion", query = "SELECT p FROM Promocion p WHERE p.idPromocion = :idPromocion"),
    @NamedQuery(name = "Promocion.findByFechaEmision", query = "SELECT p FROM Promocion p WHERE p.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Promocion.findByFechaInicio", query = "SELECT p FROM Promocion p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Promocion.findByFechaFin", query = "SELECT p FROM Promocion p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Promocion.findByEstadoPromocion", query = "SELECT p FROM Promocion p WHERE p.estadoPromocion = :estadoPromocion"),
    @NamedQuery(name = "Promocion.findByObservaciones", query = "SELECT p FROM Promocion p WHERE p.observaciones = :observaciones")})
public class Promocion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_promocion")
    private Integer idPromocion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "estado_promocion")
    private Integer estadoPromocion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promocion", fetch = FetchType.LAZY)
    private List<DetallePromocionProducto> detallePromocionProductoList;

    public Promocion() {
    }

    public Promocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public Promocion(Integer idPromocion, Date fechaEmision, Date fechaInicio, Date fechaFin, String observaciones) {
        this.idPromocion = idPromocion;
        this.fechaEmision = fechaEmision;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.observaciones = observaciones;
    }

    public Integer getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getEstadoPromocion() {
        return estadoPromocion;
    }

    public void setEstadoPromocion(Integer estadoPromocion) {
        this.estadoPromocion = estadoPromocion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @XmlTransient
    public List<DetallePromocionProducto> getDetallePromocionProductoList() {
        return detallePromocionProductoList;
    }

    public void setDetallePromocionProductoList(List<DetallePromocionProducto> detallePromocionProductoList) {
        this.detallePromocionProductoList = detallePromocionProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPromocion != null ? idPromocion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promocion)) {
            return false;
        }
        Promocion other = (Promocion) object;
        if ((this.idPromocion == null && other.idPromocion != null) || (this.idPromocion != null && !this.idPromocion.equals(other.idPromocion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Promocion[ idPromocion=" + idPromocion + " ]";
    }
    
}

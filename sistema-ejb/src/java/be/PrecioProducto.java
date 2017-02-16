/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "precio_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrecioProducto.findAll", query = "SELECT p FROM PrecioProducto p"),
    @NamedQuery(name = "PrecioProducto.findByIdProducto", query = "SELECT p FROM PrecioProducto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "PrecioProducto.findByFechaActualizacion", query = "SELECT p FROM PrecioProducto p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PrecioProducto.findByPrecioProducto", query = "SELECT p FROM PrecioProducto p WHERE p.precioProducto = :precioProducto")})
public class PrecioProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_producto")
    private BigDecimal precioProducto;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;

    public PrecioProducto() {
    }

    public PrecioProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public PrecioProducto(Integer idProducto, Date fechaActualizacion, BigDecimal precioProducto) {
        this.idProducto = idProducto;
        this.fechaActualizacion = fechaActualizacion;
        this.precioProducto = precioProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        if (!(object instanceof PrecioProducto)) {
            return false;
        }
        PrecioProducto other = (PrecioProducto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.PrecioProducto[ idProducto=" + idProducto + " ]";
    }
    
}

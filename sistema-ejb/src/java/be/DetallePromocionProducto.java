/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "detalle_promocion_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePromocionProducto.findAll", query = "SELECT d FROM DetallePromocionProducto d"),
    @NamedQuery(name = "DetallePromocionProducto.findByIdDetallePromocionProducto", query = "SELECT d FROM DetallePromocionProducto d WHERE d.idDetallePromocionProducto = :idDetallePromocionProducto"),
    @NamedQuery(name = "DetallePromocionProducto.findByPrecioVenta", query = "SELECT d FROM DetallePromocionProducto d WHERE d.precioVenta = :precioVenta"),
    @NamedQuery(name = "DetallePromocionProducto.findByDescuentoPorcentaje", query = "SELECT d FROM DetallePromocionProducto d WHERE d.descuentoPorcentaje = :descuentoPorcentaje")})
public class DetallePromocionProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_promocion_producto")
    private Integer idDetallePromocionProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private BigDecimal precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento_porcentaje")
    private BigDecimal descuentoPorcentaje;
    @JoinColumn(name = "id_promocion", referencedColumnName = "id_promocion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Promocion promocion;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;

    public DetallePromocionProducto() {
    }

    public DetallePromocionProducto(Integer idDetallePromocionProducto) {
        this.idDetallePromocionProducto = idDetallePromocionProducto;
    }

    public DetallePromocionProducto(Integer idDetallePromocionProducto, BigDecimal precioVenta, BigDecimal descuentoPorcentaje) {
        this.idDetallePromocionProducto = idDetallePromocionProducto;
        this.precioVenta = precioVenta;
        this.descuentoPorcentaje = descuentoPorcentaje;
    }

    public Integer getIdDetallePromocionProducto() {
        return idDetallePromocionProducto;
    }

    public void setIdDetallePromocionProducto(Integer idDetallePromocionProducto) {
        this.idDetallePromocionProducto = idDetallePromocionProducto;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigDecimal getDescuentoPorcentaje() {
        return descuentoPorcentaje;
    }

    public void setDescuentoPorcentaje(BigDecimal descuentoPorcentaje) {
        this.descuentoPorcentaje = descuentoPorcentaje;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
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
        hash += (idDetallePromocionProducto != null ? idDetallePromocionProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePromocionProducto)) {
            return false;
        }
        DetallePromocionProducto other = (DetallePromocionProducto) object;
        if ((this.idDetallePromocionProducto == null && other.idDetallePromocionProducto != null) || (this.idDetallePromocionProducto != null && !this.idDetallePromocionProducto.equals(other.idDetallePromocionProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetallePromocionProducto[ idDetallePromocionProducto=" + idDetallePromocionProducto + " ]";
    }
    
}

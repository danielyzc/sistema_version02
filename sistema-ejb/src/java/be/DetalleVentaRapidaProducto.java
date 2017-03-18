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
@Table(name = "detalle_venta_rapida_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVentaRapidaProducto.findAll", query = "SELECT d FROM DetalleVentaRapidaProducto d"),
    @NamedQuery(name = "DetalleVentaRapidaProducto.findByIdDetalleVentaRapidaProducto", query = "SELECT d FROM DetalleVentaRapidaProducto d WHERE d.idDetalleVentaRapidaProducto = :idDetalleVentaRapidaProducto"),
    @NamedQuery(name = "DetalleVentaRapidaProducto.findByPrecioVenta", query = "SELECT d FROM DetalleVentaRapidaProducto d WHERE d.precioVenta = :precioVenta"),
    @NamedQuery(name = "DetalleVentaRapidaProducto.findByCantidad", query = "SELECT d FROM DetalleVentaRapidaProducto d WHERE d.cantidad = :cantidad")})
public class DetalleVentaRapidaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_venta_rapida_producto")
    private Integer idDetalleVentaRapidaProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private BigDecimal precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "id_venta_rapida", referencedColumnName = "id_venta_rapida")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private VentaRapida ventaRapida;

    public DetalleVentaRapidaProducto() {
    }

    public DetalleVentaRapidaProducto(Integer idDetalleVentaRapidaProducto) {
        this.idDetalleVentaRapidaProducto = idDetalleVentaRapidaProducto;
    }

    public DetalleVentaRapidaProducto(Integer idDetalleVentaRapidaProducto, BigDecimal precioVenta, int cantidad) {
        this.idDetalleVentaRapidaProducto = idDetalleVentaRapidaProducto;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
    }

    public Integer getIdDetalleVentaRapidaProducto() {
        return idDetalleVentaRapidaProducto;
    }

    public void setIdDetalleVentaRapidaProducto(Integer idDetalleVentaRapidaProducto) {
        this.idDetalleVentaRapidaProducto = idDetalleVentaRapidaProducto;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public VentaRapida getVentaRapida() {
        return ventaRapida;
    }

    public void setVentaRapida(VentaRapida ventaRapida) {
        this.ventaRapida = ventaRapida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleVentaRapidaProducto != null ? idDetalleVentaRapidaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVentaRapidaProducto)) {
            return false;
        }
        DetalleVentaRapidaProducto other = (DetalleVentaRapidaProducto) object;
        if ((this.idDetalleVentaRapidaProducto == null && other.idDetalleVentaRapidaProducto != null) || (this.idDetalleVentaRapidaProducto != null && !this.idDetalleVentaRapidaProducto.equals(other.idDetalleVentaRapidaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleVentaRapidaProducto[ idDetalleVentaRapidaProducto=" + idDetalleVentaRapidaProducto + " ]";
    }
    
}

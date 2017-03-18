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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "stock_producto_tienda_origen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockProductoTiendaOrigen.findAll", query = "SELECT s FROM StockProductoTiendaOrigen s"),
    @NamedQuery(name = "StockProductoTiendaOrigen.findByIdProducto", query = "SELECT s FROM StockProductoTiendaOrigen s WHERE s.stockProductoTiendaOrigenPK.idProducto = :idProducto"),
    @NamedQuery(name = "StockProductoTiendaOrigen.findByIdTiendaOrigen", query = "SELECT s FROM StockProductoTiendaOrigen s WHERE s.stockProductoTiendaOrigenPK.idTiendaOrigen = :idTiendaOrigen"),
    @NamedQuery(name = "StockProductoTiendaOrigen.findByCantidad", query = "SELECT s FROM StockProductoTiendaOrigen s WHERE s.cantidad = :cantidad"),
    @NamedQuery(name = "StockProductoTiendaOrigen.findByUltimaFechaIngreso", query = "SELECT s FROM StockProductoTiendaOrigen s WHERE s.ultimaFechaIngreso = :ultimaFechaIngreso"),
    @NamedQuery(name = "StockProductoTiendaOrigen.findByDescripcion", query = "SELECT s FROM StockProductoTiendaOrigen s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "StockProductoTiendaOrigen.findByCantidadMinimaStock", query = "SELECT s FROM StockProductoTiendaOrigen s WHERE s.cantidadMinimaStock = :cantidadMinimaStock")})
public class StockProductoTiendaOrigen implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StockProductoTiendaOrigenPK stockProductoTiendaOrigenPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ultima_fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date ultimaFechaIngreso;
    @Size(max = 370)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_minima_stock")
    private int cantidadMinimaStock;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    @JoinColumn(name = "id_tienda_origen", referencedColumnName = "id_tienda", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda;

    public StockProductoTiendaOrigen() {
    }

    public StockProductoTiendaOrigen(StockProductoTiendaOrigenPK stockProductoTiendaOrigenPK) {
        this.stockProductoTiendaOrigenPK = stockProductoTiendaOrigenPK;
    }

    public StockProductoTiendaOrigen(StockProductoTiendaOrigenPK stockProductoTiendaOrigenPK, int cantidad, Date ultimaFechaIngreso, int cantidadMinimaStock) {
        this.stockProductoTiendaOrigenPK = stockProductoTiendaOrigenPK;
        this.cantidad = cantidad;
        this.ultimaFechaIngreso = ultimaFechaIngreso;
        this.cantidadMinimaStock = cantidadMinimaStock;
    }

    public StockProductoTiendaOrigen(int idProducto, int idTiendaOrigen) {
        this.stockProductoTiendaOrigenPK = new StockProductoTiendaOrigenPK(idProducto, idTiendaOrigen);
    }

    public StockProductoTiendaOrigenPK getStockProductoTiendaOrigenPK() {
        return stockProductoTiendaOrigenPK;
    }

    public void setStockProductoTiendaOrigenPK(StockProductoTiendaOrigenPK stockProductoTiendaOrigenPK) {
        this.stockProductoTiendaOrigenPK = stockProductoTiendaOrigenPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getUltimaFechaIngreso() {
        return ultimaFechaIngreso;
    }

    public void setUltimaFechaIngreso(Date ultimaFechaIngreso) {
        this.ultimaFechaIngreso = ultimaFechaIngreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadMinimaStock() {
        return cantidadMinimaStock;
    }

    public void setCantidadMinimaStock(int cantidadMinimaStock) {
        this.cantidadMinimaStock = cantidadMinimaStock;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockProductoTiendaOrigenPK != null ? stockProductoTiendaOrigenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockProductoTiendaOrigen)) {
            return false;
        }
        StockProductoTiendaOrigen other = (StockProductoTiendaOrigen) object;
        if ((this.stockProductoTiendaOrigenPK == null && other.stockProductoTiendaOrigenPK != null) || (this.stockProductoTiendaOrigenPK != null && !this.stockProductoTiendaOrigenPK.equals(other.stockProductoTiendaOrigenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.StockProductoTiendaOrigen[ stockProductoTiendaOrigenPK=" + stockProductoTiendaOrigenPK + " ]";
    }
    
}

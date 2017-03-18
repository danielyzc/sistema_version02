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
@Table(name = "stock_materia_prima_tienda_origen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockMateriaPrimaTiendaOrigen.findAll", query = "SELECT s FROM StockMateriaPrimaTiendaOrigen s"),
    @NamedQuery(name = "StockMateriaPrimaTiendaOrigen.findByIdMateriaPrima", query = "SELECT s FROM StockMateriaPrimaTiendaOrigen s WHERE s.stockMateriaPrimaTiendaOrigenPK.idMateriaPrima = :idMateriaPrima"),
    @NamedQuery(name = "StockMateriaPrimaTiendaOrigen.findByIdTiendaOrigen", query = "SELECT s FROM StockMateriaPrimaTiendaOrigen s WHERE s.stockMateriaPrimaTiendaOrigenPK.idTiendaOrigen = :idTiendaOrigen"),
    @NamedQuery(name = "StockMateriaPrimaTiendaOrigen.findByCantidad", query = "SELECT s FROM StockMateriaPrimaTiendaOrigen s WHERE s.cantidad = :cantidad"),
    @NamedQuery(name = "StockMateriaPrimaTiendaOrigen.findByUltimaFechaIngreso", query = "SELECT s FROM StockMateriaPrimaTiendaOrigen s WHERE s.ultimaFechaIngreso = :ultimaFechaIngreso"),
    @NamedQuery(name = "StockMateriaPrimaTiendaOrigen.findByDescripcion", query = "SELECT s FROM StockMateriaPrimaTiendaOrigen s WHERE s.descripcion = :descripcion")})
public class StockMateriaPrimaTiendaOrigen implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StockMateriaPrimaTiendaOrigenPK stockMateriaPrimaTiendaOrigenPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ultima_fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date ultimaFechaIngreso;
    @Size(max = 370)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_materia_prima", referencedColumnName = "id_materia_prima", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MateriaPrima materiaPrima;
    @JoinColumn(name = "id_tienda_origen", referencedColumnName = "id_tienda", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda;

    public StockMateriaPrimaTiendaOrigen() {
    }

    public StockMateriaPrimaTiendaOrigen(StockMateriaPrimaTiendaOrigenPK stockMateriaPrimaTiendaOrigenPK) {
        this.stockMateriaPrimaTiendaOrigenPK = stockMateriaPrimaTiendaOrigenPK;
    }

    public StockMateriaPrimaTiendaOrigen(StockMateriaPrimaTiendaOrigenPK stockMateriaPrimaTiendaOrigenPK, BigDecimal cantidad, Date ultimaFechaIngreso) {
        this.stockMateriaPrimaTiendaOrigenPK = stockMateriaPrimaTiendaOrigenPK;
        this.cantidad = cantidad;
        this.ultimaFechaIngreso = ultimaFechaIngreso;
    }

    public StockMateriaPrimaTiendaOrigen(int idMateriaPrima, int idTiendaOrigen) {
        this.stockMateriaPrimaTiendaOrigenPK = new StockMateriaPrimaTiendaOrigenPK(idMateriaPrima, idTiendaOrigen);
    }

    public StockMateriaPrimaTiendaOrigenPK getStockMateriaPrimaTiendaOrigenPK() {
        return stockMateriaPrimaTiendaOrigenPK;
    }

    public void setStockMateriaPrimaTiendaOrigenPK(StockMateriaPrimaTiendaOrigenPK stockMateriaPrimaTiendaOrigenPK) {
        this.stockMateriaPrimaTiendaOrigenPK = stockMateriaPrimaTiendaOrigenPK;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
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

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
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
        hash += (stockMateriaPrimaTiendaOrigenPK != null ? stockMateriaPrimaTiendaOrigenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockMateriaPrimaTiendaOrigen)) {
            return false;
        }
        StockMateriaPrimaTiendaOrigen other = (StockMateriaPrimaTiendaOrigen) object;
        if ((this.stockMateriaPrimaTiendaOrigenPK == null && other.stockMateriaPrimaTiendaOrigenPK != null) || (this.stockMateriaPrimaTiendaOrigenPK != null && !this.stockMateriaPrimaTiendaOrigenPK.equals(other.stockMateriaPrimaTiendaOrigenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.StockMateriaPrimaTiendaOrigen[ stockMateriaPrimaTiendaOrigenPK=" + stockMateriaPrimaTiendaOrigenPK + " ]";
    }
    
}

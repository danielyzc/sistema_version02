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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "venta_rapida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaRapida.findAll", query = "SELECT v FROM VentaRapida v"),
    @NamedQuery(name = "VentaRapida.findByIdVentaRapida", query = "SELECT v FROM VentaRapida v WHERE v.idVentaRapida = :idVentaRapida"),
    @NamedQuery(name = "VentaRapida.findByFechaVenta", query = "SELECT v FROM VentaRapida v WHERE v.fechaVenta = :fechaVenta")})
public class VentaRapida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venta_rapida")
    private Integer idVentaRapida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventaRapida", fetch = FetchType.LAZY)
    private List<DetalleVentaRapidaProducto> detalleVentaRapidaProductoList;

    public VentaRapida() {
    }

    public VentaRapida(Integer idVentaRapida) {
        this.idVentaRapida = idVentaRapida;
    }

    public VentaRapida(Integer idVentaRapida, Date fechaVenta) {
        this.idVentaRapida = idVentaRapida;
        this.fechaVenta = fechaVenta;
    }

    public Integer getIdVentaRapida() {
        return idVentaRapida;
    }

    public void setIdVentaRapida(Integer idVentaRapida) {
        this.idVentaRapida = idVentaRapida;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @XmlTransient
    public List<DetalleVentaRapidaProducto> getDetalleVentaRapidaProductoList() {
        return detalleVentaRapidaProductoList;
    }

    public void setDetalleVentaRapidaProductoList(List<DetalleVentaRapidaProducto> detalleVentaRapidaProductoList) {
        this.detalleVentaRapidaProductoList = detalleVentaRapidaProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentaRapida != null ? idVentaRapida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaRapida)) {
            return false;
        }
        VentaRapida other = (VentaRapida) object;
        if ((this.idVentaRapida == null && other.idVentaRapida != null) || (this.idVentaRapida != null && !this.idVentaRapida.equals(other.idVentaRapida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.VentaRapida[ idVentaRapida=" + idVentaRapida + " ]";
    }
    
}

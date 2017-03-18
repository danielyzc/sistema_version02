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
@Table(name = "cambio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cambio.findAll", query = "SELECT c FROM Cambio c"),
    @NamedQuery(name = "Cambio.findByIdCambio", query = "SELECT c FROM Cambio c WHERE c.idCambio = :idCambio"),
    @NamedQuery(name = "Cambio.findByFechaCambio", query = "SELECT c FROM Cambio c WHERE c.fechaCambio = :fechaCambio"),
    @NamedQuery(name = "Cambio.findByMotivoCambio", query = "SELECT c FROM Cambio c WHERE c.motivoCambio = :motivoCambio")})
public class Cambio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cambio")
    private Integer idCambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cambio")
    @Temporal(TemporalType.DATE)
    private Date fechaCambio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 300)
    @Column(name = "motivo_cambio")
    private String motivoCambio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cambio", fetch = FetchType.LAZY)
    private List<DetalleCambioProducto> detalleCambioProductoList;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Venta venta;

    public Cambio() {
    }

    public Cambio(Integer idCambio) {
        this.idCambio = idCambio;
    }

    public Cambio(Integer idCambio, Date fechaCambio, String motivoCambio) {
        this.idCambio = idCambio;
        this.fechaCambio = fechaCambio;
        this.motivoCambio = motivoCambio;
    }

    public Integer getIdCambio() {
        return idCambio;
    }

    public void setIdCambio(Integer idCambio) {
        this.idCambio = idCambio;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public String getMotivoCambio() {
        return motivoCambio;
    }

    public void setMotivoCambio(String motivoCambio) {
        this.motivoCambio = motivoCambio;
    }

    @XmlTransient
    public List<DetalleCambioProducto> getDetalleCambioProductoList() {
        return detalleCambioProductoList;
    }

    public void setDetalleCambioProductoList(List<DetalleCambioProducto> detalleCambioProductoList) {
        this.detalleCambioProductoList = detalleCambioProductoList;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCambio != null ? idCambio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cambio)) {
            return false;
        }
        Cambio other = (Cambio) object;
        if ((this.idCambio == null && other.idCambio != null) || (this.idCambio != null && !this.idCambio.equals(other.idCambio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Cambio[ idCambio=" + idCambio + " ]";
    }
    
}

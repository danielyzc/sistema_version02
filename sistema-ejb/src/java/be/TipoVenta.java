/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "tipo_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVenta.findAll", query = "SELECT t FROM TipoVenta t"),
    @NamedQuery(name = "TipoVenta.findByIdTipoVenta", query = "SELECT t FROM TipoVenta t WHERE t.idTipoVenta = :idTipoVenta"),
    @NamedQuery(name = "TipoVenta.findByNombreTipoVenta", query = "SELECT t FROM TipoVenta t WHERE t.nombreTipoVenta = :nombreTipoVenta"),
    @NamedQuery(name = "TipoVenta.findByDescripcion", query = "SELECT t FROM TipoVenta t WHERE t.descripcion = :descripcion")})
public class TipoVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_venta")
    private Integer idTipoVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "nombre_tipo_venta")
    private String nombreTipoVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 170)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoVenta", fetch = FetchType.LAZY)
    private List<FacturaVenta> facturaVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoVenta", fetch = FetchType.LAZY)
    private List<Venta> ventaList;

    public TipoVenta() {
    }

    public TipoVenta(Integer idTipoVenta) {
        this.idTipoVenta = idTipoVenta;
    }

    public TipoVenta(Integer idTipoVenta, String nombreTipoVenta, String descripcion) {
        this.idTipoVenta = idTipoVenta;
        this.nombreTipoVenta = nombreTipoVenta;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoVenta() {
        return idTipoVenta;
    }

    public void setIdTipoVenta(Integer idTipoVenta) {
        this.idTipoVenta = idTipoVenta;
    }

    public String getNombreTipoVenta() {
        return nombreTipoVenta;
    }

    public void setNombreTipoVenta(String nombreTipoVenta) {
        this.nombreTipoVenta = nombreTipoVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<FacturaVenta> getFacturaVentaList() {
        return facturaVentaList;
    }

    public void setFacturaVentaList(List<FacturaVenta> facturaVentaList) {
        this.facturaVentaList = facturaVentaList;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoVenta != null ? idTipoVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVenta)) {
            return false;
        }
        TipoVenta other = (TipoVenta) object;
        if ((this.idTipoVenta == null && other.idTipoVenta != null) || (this.idTipoVenta != null && !this.idTipoVenta.equals(other.idTipoVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoVenta[ idTipoVenta=" + idTipoVenta + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "igv_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IgvFactura.findAll", query = "SELECT i FROM IgvFactura i"),
    @NamedQuery(name = "IgvFactura.findByIdIgvFactura", query = "SELECT i FROM IgvFactura i WHERE i.idIgvFactura = :idIgvFactura"),
    @NamedQuery(name = "IgvFactura.findByMonto", query = "SELECT i FROM IgvFactura i WHERE i.monto = :monto"),
    @NamedQuery(name = "IgvFactura.findByDescripcion", query = "SELECT i FROM IgvFactura i WHERE i.descripcion = :descripcion")})
public class IgvFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_igv_factura")
    private Integer idIgvFactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_estado_igv", referencedColumnName = "id_estado_igv")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoIgv estadoIgv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "igvFactura", fetch = FetchType.LAZY)
    private List<FacturaVenta> facturaVentaList;

    public IgvFactura() {
    }

    public IgvFactura(Integer idIgvFactura) {
        this.idIgvFactura = idIgvFactura;
    }

    public IgvFactura(Integer idIgvFactura, BigDecimal monto, String descripcion) {
        this.idIgvFactura = idIgvFactura;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public Integer getIdIgvFactura() {
        return idIgvFactura;
    }

    public void setIdIgvFactura(Integer idIgvFactura) {
        this.idIgvFactura = idIgvFactura;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoIgv getEstadoIgv() {
        return estadoIgv;
    }

    public void setEstadoIgv(EstadoIgv estadoIgv) {
        this.estadoIgv = estadoIgv;
    }

    @XmlTransient
    public List<FacturaVenta> getFacturaVentaList() {
        return facturaVentaList;
    }

    public void setFacturaVentaList(List<FacturaVenta> facturaVentaList) {
        this.facturaVentaList = facturaVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIgvFactura != null ? idIgvFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IgvFactura)) {
            return false;
        }
        IgvFactura other = (IgvFactura) object;
        if ((this.idIgvFactura == null && other.idIgvFactura != null) || (this.idIgvFactura != null && !this.idIgvFactura.equals(other.idIgvFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.IgvFactura[ idIgvFactura=" + idIgvFactura + " ]";
    }
    
}

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "letras_pago_canje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LetrasPagoCanje.findAll", query = "SELECT l FROM LetrasPagoCanje l"),
    @NamedQuery(name = "LetrasPagoCanje.findByIdLetrasPagoCanje", query = "SELECT l FROM LetrasPagoCanje l WHERE l.idLetrasPagoCanje = :idLetrasPagoCanje"),
    @NamedQuery(name = "LetrasPagoCanje.findByFechaPago", query = "SELECT l FROM LetrasPagoCanje l WHERE l.fechaPago = :fechaPago"),
    @NamedQuery(name = "LetrasPagoCanje.findByFechaRealizoPago", query = "SELECT l FROM LetrasPagoCanje l WHERE l.fechaRealizoPago = :fechaRealizoPago"),
    @NamedQuery(name = "LetrasPagoCanje.findByTotalLetra", query = "SELECT l FROM LetrasPagoCanje l WHERE l.totalLetra = :totalLetra"),
    @NamedQuery(name = "LetrasPagoCanje.findByObservaciones", query = "SELECT l FROM LetrasPagoCanje l WHERE l.observaciones = :observaciones")})
public class LetrasPagoCanje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_letras_pago_canje")
    private Integer idLetrasPagoCanje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_realizo_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaRealizoPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_letra")
    private BigDecimal totalLetra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 300)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_estado_letras_pago_canje", referencedColumnName = "id_estado_letras_pago_canje")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoLetrasPagoCanje estadoLetrasPagoCanje;
    @JoinColumn(name = "id_canje_orden_compra", referencedColumnName = "id_canje_orden_compra")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CanjeOrdenCompra canjeOrdenCompra;

    public LetrasPagoCanje() {
    }

    public LetrasPagoCanje(Integer idLetrasPagoCanje) {
        this.idLetrasPagoCanje = idLetrasPagoCanje;
    }

    public LetrasPagoCanje(Integer idLetrasPagoCanje, Date fechaPago, Date fechaRealizoPago, BigDecimal totalLetra, String observaciones) {
        this.idLetrasPagoCanje = idLetrasPagoCanje;
        this.fechaPago = fechaPago;
        this.fechaRealizoPago = fechaRealizoPago;
        this.totalLetra = totalLetra;
        this.observaciones = observaciones;
    }

    public Integer getIdLetrasPagoCanje() {
        return idLetrasPagoCanje;
    }

    public void setIdLetrasPagoCanje(Integer idLetrasPagoCanje) {
        this.idLetrasPagoCanje = idLetrasPagoCanje;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaRealizoPago() {
        return fechaRealizoPago;
    }

    public void setFechaRealizoPago(Date fechaRealizoPago) {
        this.fechaRealizoPago = fechaRealizoPago;
    }

    public BigDecimal getTotalLetra() {
        return totalLetra;
    }

    public void setTotalLetra(BigDecimal totalLetra) {
        this.totalLetra = totalLetra;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstadoLetrasPagoCanje getEstadoLetrasPagoCanje() {
        return estadoLetrasPagoCanje;
    }

    public void setEstadoLetrasPagoCanje(EstadoLetrasPagoCanje estadoLetrasPagoCanje) {
        this.estadoLetrasPagoCanje = estadoLetrasPagoCanje;
    }

    public CanjeOrdenCompra getCanjeOrdenCompra() {
        return canjeOrdenCompra;
    }

    public void setCanjeOrdenCompra(CanjeOrdenCompra canjeOrdenCompra) {
        this.canjeOrdenCompra = canjeOrdenCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLetrasPagoCanje != null ? idLetrasPagoCanje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LetrasPagoCanje)) {
            return false;
        }
        LetrasPagoCanje other = (LetrasPagoCanje) object;
        if ((this.idLetrasPagoCanje == null && other.idLetrasPagoCanje != null) || (this.idLetrasPagoCanje != null && !this.idLetrasPagoCanje.equals(other.idLetrasPagoCanje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.LetrasPagoCanje[ idLetrasPagoCanje=" + idLetrasPagoCanje + " ]";
    }
    
}

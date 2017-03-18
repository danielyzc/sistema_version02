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
@Table(name = "pago_venta_credito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoVentaCredito.findAll", query = "SELECT p FROM PagoVentaCredito p"),
    @NamedQuery(name = "PagoVentaCredito.findByIdPagoVentaCredito", query = "SELECT p FROM PagoVentaCredito p WHERE p.idPagoVentaCredito = :idPagoVentaCredito"),
    @NamedQuery(name = "PagoVentaCredito.findByFechaIngreso", query = "SELECT p FROM PagoVentaCredito p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "PagoVentaCredito.findByObservaciones", query = "SELECT p FROM PagoVentaCredito p WHERE p.observaciones = :observaciones"),
    @NamedQuery(name = "PagoVentaCredito.findByCantidad", query = "SELECT p FROM PagoVentaCredito p WHERE p.cantidad = :cantidad")})
public class PagoVentaCredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago_venta_credito")
    private Integer idPagoVentaCredito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 170)
    @Column(name = "observaciones")
    private String observaciones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    @ManyToOne(fetch = FetchType.LAZY)
    private Venta venta;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empleado;

    public PagoVentaCredito() {
    }

    public PagoVentaCredito(Integer idPagoVentaCredito) {
        this.idPagoVentaCredito = idPagoVentaCredito;
    }

    public PagoVentaCredito(Integer idPagoVentaCredito, Date fechaIngreso, String observaciones, BigDecimal cantidad) {
        this.idPagoVentaCredito = idPagoVentaCredito;
        this.fechaIngreso = fechaIngreso;
        this.observaciones = observaciones;
        this.cantidad = cantidad;
    }

    public Integer getIdPagoVentaCredito() {
        return idPagoVentaCredito;
    }

    public void setIdPagoVentaCredito(Integer idPagoVentaCredito) {
        this.idPagoVentaCredito = idPagoVentaCredito;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagoVentaCredito != null ? idPagoVentaCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoVentaCredito)) {
            return false;
        }
        PagoVentaCredito other = (PagoVentaCredito) object;
        if ((this.idPagoVentaCredito == null && other.idPagoVentaCredito != null) || (this.idPagoVentaCredito != null && !this.idPagoVentaCredito.equals(other.idPagoVentaCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.PagoVentaCredito[ idPagoVentaCredito=" + idPagoVentaCredito + " ]";
    }
    
}

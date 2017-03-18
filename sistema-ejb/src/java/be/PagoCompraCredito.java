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
@Table(name = "pago_compra_credito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoCompraCredito.findAll", query = "SELECT p FROM PagoCompraCredito p"),
    @NamedQuery(name = "PagoCompraCredito.findByIdPagoCompraCredito", query = "SELECT p FROM PagoCompraCredito p WHERE p.idPagoCompraCredito = :idPagoCompraCredito"),
    @NamedQuery(name = "PagoCompraCredito.findByFechaIngreso", query = "SELECT p FROM PagoCompraCredito p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "PagoCompraCredito.findByObservaciones", query = "SELECT p FROM PagoCompraCredito p WHERE p.observaciones = :observaciones"),
    @NamedQuery(name = "PagoCompraCredito.findByCantidad", query = "SELECT p FROM PagoCompraCredito p WHERE p.cantidad = :cantidad")})
public class PagoCompraCredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago_compra_credito")
    private Integer idPagoCompraCredito;
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
    @JoinColumn(name = "id_orden_compra", referencedColumnName = "id_orden_compra")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrdenCompra ordenCompra;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;

    public PagoCompraCredito() {
    }

    public PagoCompraCredito(Integer idPagoCompraCredito) {
        this.idPagoCompraCredito = idPagoCompraCredito;
    }

    public PagoCompraCredito(Integer idPagoCompraCredito, Date fechaIngreso, String observaciones, BigDecimal cantidad) {
        this.idPagoCompraCredito = idPagoCompraCredito;
        this.fechaIngreso = fechaIngreso;
        this.observaciones = observaciones;
        this.cantidad = cantidad;
    }

    public Integer getIdPagoCompraCredito() {
        return idPagoCompraCredito;
    }

    public void setIdPagoCompraCredito(Integer idPagoCompraCredito) {
        this.idPagoCompraCredito = idPagoCompraCredito;
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

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
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
        hash += (idPagoCompraCredito != null ? idPagoCompraCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoCompraCredito)) {
            return false;
        }
        PagoCompraCredito other = (PagoCompraCredito) object;
        if ((this.idPagoCompraCredito == null && other.idPagoCompraCredito != null) || (this.idPagoCompraCredito != null && !this.idPagoCompraCredito.equals(other.idPagoCompraCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.PagoCompraCredito[ idPagoCompraCredito=" + idPagoCompraCredito + " ]";
    }
    
}

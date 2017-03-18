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
@Table(name = "ingreso_materia_prima_tienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findAll", query = "SELECT i FROM IngresoMateriaPrimaTienda i"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByIdIngresoMateriaPrimaTienda", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.idIngresoMateriaPrimaTienda = :idIngresoMateriaPrimaTienda"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByCantidad", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByFechaIngreso", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByMotivo", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.motivo = :motivo")})
public class IngresoMateriaPrimaTienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingreso_materia_prima_tienda")
    private Integer idIngresoMateriaPrimaTienda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 300)
    @Column(name = "motivo")
    private String motivo;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda;
    @JoinColumn(name = "id_materia_prima", referencedColumnName = "id_materia_prima")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MateriaPrima materiaPrima;

    public IngresoMateriaPrimaTienda() {
    }

    public IngresoMateriaPrimaTienda(Integer idIngresoMateriaPrimaTienda) {
        this.idIngresoMateriaPrimaTienda = idIngresoMateriaPrimaTienda;
    }

    public IngresoMateriaPrimaTienda(Integer idIngresoMateriaPrimaTienda, BigDecimal cantidad, Date fechaIngreso, String motivo) {
        this.idIngresoMateriaPrimaTienda = idIngresoMateriaPrimaTienda;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.motivo = motivo;
    }

    public Integer getIdIngresoMateriaPrimaTienda() {
        return idIngresoMateriaPrimaTienda;
    }

    public void setIdIngresoMateriaPrimaTienda(Integer idIngresoMateriaPrimaTienda) {
        this.idIngresoMateriaPrimaTienda = idIngresoMateriaPrimaTienda;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngresoMateriaPrimaTienda != null ? idIngresoMateriaPrimaTienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoMateriaPrimaTienda)) {
            return false;
        }
        IngresoMateriaPrimaTienda other = (IngresoMateriaPrimaTienda) object;
        if ((this.idIngresoMateriaPrimaTienda == null && other.idIngresoMateriaPrimaTienda != null) || (this.idIngresoMateriaPrimaTienda != null && !this.idIngresoMateriaPrimaTienda.equals(other.idIngresoMateriaPrimaTienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.IngresoMateriaPrimaTienda[ idIngresoMateriaPrimaTienda=" + idIngresoMateriaPrimaTienda + " ]";
    }
    
}

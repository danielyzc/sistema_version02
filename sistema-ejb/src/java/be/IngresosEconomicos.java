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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ingresos_economicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresosEconomicos.findAll", query = "SELECT i FROM IngresosEconomicos i"),
    @NamedQuery(name = "IngresosEconomicos.findByIdIngresosEconomicos", query = "SELECT i FROM IngresosEconomicos i WHERE i.idIngresosEconomicos = :idIngresosEconomicos"),
    @NamedQuery(name = "IngresosEconomicos.findByMotivo", query = "SELECT i FROM IngresosEconomicos i WHERE i.motivo = :motivo"),
    @NamedQuery(name = "IngresosEconomicos.findByNota", query = "SELECT i FROM IngresosEconomicos i WHERE i.nota = :nota"),
    @NamedQuery(name = "IngresosEconomicos.findByFechaCreacion", query = "SELECT i FROM IngresosEconomicos i WHERE i.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "IngresosEconomicos.findByTotal", query = "SELECT i FROM IngresosEconomicos i WHERE i.total = :total")})
public class IngresosEconomicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingresos_economicos")
    private Integer idIngresosEconomicos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 200)
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 300)
    @Column(name = "nota")
    private String nota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private BigDecimal total;

    public IngresosEconomicos() {
    }

    public IngresosEconomicos(Integer idIngresosEconomicos) {
        this.idIngresosEconomicos = idIngresosEconomicos;
    }

    public IngresosEconomicos(Integer idIngresosEconomicos, String motivo, String nota, Date fechaCreacion, BigDecimal total) {
        this.idIngresosEconomicos = idIngresosEconomicos;
        this.motivo = motivo;
        this.nota = nota;
        this.fechaCreacion = fechaCreacion;
        this.total = total;
    }

    public Integer getIdIngresosEconomicos() {
        return idIngresosEconomicos;
    }

    public void setIdIngresosEconomicos(Integer idIngresosEconomicos) {
        this.idIngresosEconomicos = idIngresosEconomicos;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngresosEconomicos != null ? idIngresosEconomicos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresosEconomicos)) {
            return false;
        }
        IngresosEconomicos other = (IngresosEconomicos) object;
        if ((this.idIngresosEconomicos == null && other.idIngresosEconomicos != null) || (this.idIngresosEconomicos != null && !this.idIngresosEconomicos.equals(other.idIngresosEconomicos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.IngresosEconomicos[ idIngresosEconomicos=" + idIngresosEconomicos + " ]";
    }
    
}

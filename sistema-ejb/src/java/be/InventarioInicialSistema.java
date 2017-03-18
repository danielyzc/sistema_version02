/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
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
@Table(name = "inventario_inicial_sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioInicialSistema.findAll", query = "SELECT i FROM InventarioInicialSistema i"),
    @NamedQuery(name = "InventarioInicialSistema.findByIdInventarioInicialSistema", query = "SELECT i FROM InventarioInicialSistema i WHERE i.idInventarioInicialSistema = :idInventarioInicialSistema"),
    @NamedQuery(name = "InventarioInicialSistema.findByObervaciones", query = "SELECT i FROM InventarioInicialSistema i WHERE i.obervaciones = :obervaciones"),
    @NamedQuery(name = "InventarioInicialSistema.findByFechaRegistro", query = "SELECT i FROM InventarioInicialSistema i WHERE i.fechaRegistro = :fechaRegistro")})
public class InventarioInicialSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inventario_inicial_sistema")
    private Integer idInventarioInicialSistema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 50)
    @Column(name = "obervaciones")
    private String obervaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @JoinColumn(name = "id_inventario_fisico", referencedColumnName = "id_inventario_fisico")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private InventarioFisico inventarioFisico;

    public InventarioInicialSistema() {
    }

    public InventarioInicialSistema(Integer idInventarioInicialSistema) {
        this.idInventarioInicialSistema = idInventarioInicialSistema;
    }

    public InventarioInicialSistema(Integer idInventarioInicialSistema, String obervaciones, Date fechaRegistro) {
        this.idInventarioInicialSistema = idInventarioInicialSistema;
        this.obervaciones = obervaciones;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdInventarioInicialSistema() {
        return idInventarioInicialSistema;
    }

    public void setIdInventarioInicialSistema(Integer idInventarioInicialSistema) {
        this.idInventarioInicialSistema = idInventarioInicialSistema;
    }

    public String getObervaciones() {
        return obervaciones;
    }

    public void setObervaciones(String obervaciones) {
        this.obervaciones = obervaciones;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public InventarioFisico getInventarioFisico() {
        return inventarioFisico;
    }

    public void setInventarioFisico(InventarioFisico inventarioFisico) {
        this.inventarioFisico = inventarioFisico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventarioInicialSistema != null ? idInventarioInicialSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioInicialSistema)) {
            return false;
        }
        InventarioInicialSistema other = (InventarioInicialSistema) object;
        if ((this.idInventarioInicialSistema == null && other.idInventarioInicialSistema != null) || (this.idInventarioInicialSistema != null && !this.idInventarioInicialSistema.equals(other.idInventarioInicialSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.InventarioInicialSistema[ idInventarioInicialSistema=" + idInventarioInicialSistema + " ]";
    }
    
}

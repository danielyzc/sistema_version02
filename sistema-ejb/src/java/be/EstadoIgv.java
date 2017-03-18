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
@Table(name = "estado_igv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoIgv.findAll", query = "SELECT e FROM EstadoIgv e"),
    @NamedQuery(name = "EstadoIgv.findByIdEstadoIgv", query = "SELECT e FROM EstadoIgv e WHERE e.idEstadoIgv = :idEstadoIgv"),
    @NamedQuery(name = "EstadoIgv.findByNombreEstado", query = "SELECT e FROM EstadoIgv e WHERE e.nombreEstado = :nombreEstado"),
    @NamedQuery(name = "EstadoIgv.findByDescripcion", query = "SELECT e FROM EstadoIgv e WHERE e.descripcion = :descripcion")})
public class EstadoIgv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_igv")
    private Integer idEstadoIgv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "nombre_estado")
    private String nombreEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 170)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoIgv", fetch = FetchType.LAZY)
    private List<IgvFactura> igvFacturaList;

    public EstadoIgv() {
    }

    public EstadoIgv(Integer idEstadoIgv) {
        this.idEstadoIgv = idEstadoIgv;
    }

    public EstadoIgv(Integer idEstadoIgv, String nombreEstado, String descripcion) {
        this.idEstadoIgv = idEstadoIgv;
        this.nombreEstado = nombreEstado;
        this.descripcion = descripcion;
    }

    public Integer getIdEstadoIgv() {
        return idEstadoIgv;
    }

    public void setIdEstadoIgv(Integer idEstadoIgv) {
        this.idEstadoIgv = idEstadoIgv;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<IgvFactura> getIgvFacturaList() {
        return igvFacturaList;
    }

    public void setIgvFacturaList(List<IgvFactura> igvFacturaList) {
        this.igvFacturaList = igvFacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoIgv != null ? idEstadoIgv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoIgv)) {
            return false;
        }
        EstadoIgv other = (EstadoIgv) object;
        if ((this.idEstadoIgv == null && other.idEstadoIgv != null) || (this.idEstadoIgv != null && !this.idEstadoIgv.equals(other.idEstadoIgv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoIgv[ idEstadoIgv=" + idEstadoIgv + " ]";
    }
    
}

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
@Table(name = "zona_ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZonaCiudad.findAll", query = "SELECT z FROM ZonaCiudad z"),
    @NamedQuery(name = "ZonaCiudad.findByIdZonaCiudad", query = "SELECT z FROM ZonaCiudad z WHERE z.idZonaCiudad = :idZonaCiudad"),
    @NamedQuery(name = "ZonaCiudad.findByDescripcionZonaCiudad", query = "SELECT z FROM ZonaCiudad z WHERE z.descripcionZonaCiudad = :descripcionZonaCiudad"),
    @NamedQuery(name = "ZonaCiudad.findByFlagEstado", query = "SELECT z FROM ZonaCiudad z WHERE z.flagEstado = :flagEstado")})
public class ZonaCiudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_zona_ciudad")
    private Integer idZonaCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 150)
    @Column(name = "descripcion_zona_ciudad")
    private String descripcionZonaCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 2)
    @Column(name = "flag_estado")
    private String flagEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zonaCiudad", fetch = FetchType.LAZY)
    private List<Cliente> clienteList;

    public ZonaCiudad() {
    }

    public ZonaCiudad(Integer idZonaCiudad) {
        this.idZonaCiudad = idZonaCiudad;
    }

    public ZonaCiudad(Integer idZonaCiudad, String descripcionZonaCiudad, String flagEstado) {
        this.idZonaCiudad = idZonaCiudad;
        this.descripcionZonaCiudad = descripcionZonaCiudad;
        this.flagEstado = flagEstado;
    }

    public Integer getIdZonaCiudad() {
        return idZonaCiudad;
    }

    public void setIdZonaCiudad(Integer idZonaCiudad) {
        this.idZonaCiudad = idZonaCiudad;
    }

    public String getDescripcionZonaCiudad() {
        return descripcionZonaCiudad;
    }

    public void setDescripcionZonaCiudad(String descripcionZonaCiudad) {
        this.descripcionZonaCiudad = descripcionZonaCiudad;
    }

    public String getFlagEstado() {
        return flagEstado;
    }

    public void setFlagEstado(String flagEstado) {
        this.flagEstado = flagEstado;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZonaCiudad != null ? idZonaCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaCiudad)) {
            return false;
        }
        ZonaCiudad other = (ZonaCiudad) object;
        if ((this.idZonaCiudad == null && other.idZonaCiudad != null) || (this.idZonaCiudad != null && !this.idZonaCiudad.equals(other.idZonaCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ZonaCiudad[ idZonaCiudad=" + idZonaCiudad + " ]";
    }
    
}

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
@Table(name = "mercado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mercado.findAll", query = "SELECT m FROM Mercado m"),
    @NamedQuery(name = "Mercado.findByIdMercado", query = "SELECT m FROM Mercado m WHERE m.idMercado = :idMercado"),
    @NamedQuery(name = "Mercado.findByNombreMercado", query = "SELECT m FROM Mercado m WHERE m.nombreMercado = :nombreMercado"),
    @NamedQuery(name = "Mercado.findByDescripcion", query = "SELECT m FROM Mercado m WHERE m.descripcion = :descripcion")})
public class Mercado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mercado")
    private Integer idMercado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 200)
    @Column(name = "nombre_mercado")
    private String nombreMercado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mercado", fetch = FetchType.LAZY)
    private List<Cliente> clienteList;

    public Mercado() {
    }

    public Mercado(Integer idMercado) {
        this.idMercado = idMercado;
    }

    public Mercado(Integer idMercado, String nombreMercado, String descripcion) {
        this.idMercado = idMercado;
        this.nombreMercado = nombreMercado;
        this.descripcion = descripcion;
    }

    public Integer getIdMercado() {
        return idMercado;
    }

    public void setIdMercado(Integer idMercado) {
        this.idMercado = idMercado;
    }

    public String getNombreMercado() {
        return nombreMercado;
    }

    public void setNombreMercado(String nombreMercado) {
        this.nombreMercado = nombreMercado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idMercado != null ? idMercado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mercado)) {
            return false;
        }
        Mercado other = (Mercado) object;
        if ((this.idMercado == null && other.idMercado != null) || (this.idMercado != null && !this.idMercado.equals(other.idMercado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Mercado[ idMercado=" + idMercado + " ]";
    }
    
}

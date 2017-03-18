/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "negocio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Negocio.findAll", query = "SELECT n FROM Negocio n"),
    @NamedQuery(name = "Negocio.findByIdNegocio", query = "SELECT n FROM Negocio n WHERE n.idNegocio = :idNegocio"),
    @NamedQuery(name = "Negocio.findByNombreNegocio", query = "SELECT n FROM Negocio n WHERE n.nombreNegocio = :nombreNegocio")})
public class Negocio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_negocio")
    private Integer idNegocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 350)
    @Column(name = "nombre_negocio")
    private String nombreNegocio;
    @OneToMany(mappedBy = "negocio", fetch = FetchType.LAZY)
    private List<Tienda> tiendaList;

    public Negocio() {
    }

    public Negocio(Integer idNegocio) {
        this.idNegocio = idNegocio;
    }

    public Negocio(Integer idNegocio, String nombreNegocio) {
        this.idNegocio = idNegocio;
        this.nombreNegocio = nombreNegocio;
    }

    public Integer getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(Integer idNegocio) {
        this.idNegocio = idNegocio;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    @XmlTransient
    public List<Tienda> getTiendaList() {
        return tiendaList;
    }

    public void setTiendaList(List<Tienda> tiendaList) {
        this.tiendaList = tiendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNegocio != null ? idNegocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Negocio)) {
            return false;
        }
        Negocio other = (Negocio) object;
        if ((this.idNegocio == null && other.idNegocio != null) || (this.idNegocio != null && !this.idNegocio.equals(other.idNegocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Negocio[ idNegocio=" + idNegocio + " ]";
    }
    
}

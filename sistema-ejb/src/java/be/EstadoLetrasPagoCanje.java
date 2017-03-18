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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "estado_letras_pago_canje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoLetrasPagoCanje.findAll", query = "SELECT e FROM EstadoLetrasPagoCanje e"),
    @NamedQuery(name = "EstadoLetrasPagoCanje.findByIdEstadoLetrasPagoCanje", query = "SELECT e FROM EstadoLetrasPagoCanje e WHERE e.idEstadoLetrasPagoCanje = :idEstadoLetrasPagoCanje"),
    @NamedQuery(name = "EstadoLetrasPagoCanje.findByNombre", query = "SELECT e FROM EstadoLetrasPagoCanje e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoLetrasPagoCanje.findByDescripcion", query = "SELECT e FROM EstadoLetrasPagoCanje e WHERE e.descripcion = :descripcion")})
public class EstadoLetrasPagoCanje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_letras_pago_canje")
    private Integer idEstadoLetrasPagoCanje;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 170)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "estadoLetrasPagoCanje", fetch = FetchType.LAZY)
    private List<LetrasPagoCanje> letrasPagoCanjeList;

    public EstadoLetrasPagoCanje() {
    }

    public EstadoLetrasPagoCanje(Integer idEstadoLetrasPagoCanje) {
        this.idEstadoLetrasPagoCanje = idEstadoLetrasPagoCanje;
    }

    public Integer getIdEstadoLetrasPagoCanje() {
        return idEstadoLetrasPagoCanje;
    }

    public void setIdEstadoLetrasPagoCanje(Integer idEstadoLetrasPagoCanje) {
        this.idEstadoLetrasPagoCanje = idEstadoLetrasPagoCanje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<LetrasPagoCanje> getLetrasPagoCanjeList() {
        return letrasPagoCanjeList;
    }

    public void setLetrasPagoCanjeList(List<LetrasPagoCanje> letrasPagoCanjeList) {
        this.letrasPagoCanjeList = letrasPagoCanjeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoLetrasPagoCanje != null ? idEstadoLetrasPagoCanje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoLetrasPagoCanje)) {
            return false;
        }
        EstadoLetrasPagoCanje other = (EstadoLetrasPagoCanje) object;
        if ((this.idEstadoLetrasPagoCanje == null && other.idEstadoLetrasPagoCanje != null) || (this.idEstadoLetrasPagoCanje != null && !this.idEstadoLetrasPagoCanje.equals(other.idEstadoLetrasPagoCanje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoLetrasPagoCanje[ idEstadoLetrasPagoCanje=" + idEstadoLetrasPagoCanje + " ]";
    }
    
}

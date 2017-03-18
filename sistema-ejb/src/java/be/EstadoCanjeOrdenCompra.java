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
@Table(name = "estado_canje_orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCanjeOrdenCompra.findAll", query = "SELECT e FROM EstadoCanjeOrdenCompra e"),
    @NamedQuery(name = "EstadoCanjeOrdenCompra.findByIdEstadoCanjeOrdenCompra", query = "SELECT e FROM EstadoCanjeOrdenCompra e WHERE e.idEstadoCanjeOrdenCompra = :idEstadoCanjeOrdenCompra"),
    @NamedQuery(name = "EstadoCanjeOrdenCompra.findByNombre", query = "SELECT e FROM EstadoCanjeOrdenCompra e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoCanjeOrdenCompra.findByDescripcion", query = "SELECT e FROM EstadoCanjeOrdenCompra e WHERE e.descripcion = :descripcion")})
public class EstadoCanjeOrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_canje_orden_compra")
    private Integer idEstadoCanjeOrdenCompra;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 170)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "estadoCanjeOrdenCompra", fetch = FetchType.LAZY)
    private List<CanjeOrdenCompra> canjeOrdenCompraList;

    public EstadoCanjeOrdenCompra() {
    }

    public EstadoCanjeOrdenCompra(Integer idEstadoCanjeOrdenCompra) {
        this.idEstadoCanjeOrdenCompra = idEstadoCanjeOrdenCompra;
    }

    public Integer getIdEstadoCanjeOrdenCompra() {
        return idEstadoCanjeOrdenCompra;
    }

    public void setIdEstadoCanjeOrdenCompra(Integer idEstadoCanjeOrdenCompra) {
        this.idEstadoCanjeOrdenCompra = idEstadoCanjeOrdenCompra;
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
    public List<CanjeOrdenCompra> getCanjeOrdenCompraList() {
        return canjeOrdenCompraList;
    }

    public void setCanjeOrdenCompraList(List<CanjeOrdenCompra> canjeOrdenCompraList) {
        this.canjeOrdenCompraList = canjeOrdenCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoCanjeOrdenCompra != null ? idEstadoCanjeOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCanjeOrdenCompra)) {
            return false;
        }
        EstadoCanjeOrdenCompra other = (EstadoCanjeOrdenCompra) object;
        if ((this.idEstadoCanjeOrdenCompra == null && other.idEstadoCanjeOrdenCompra != null) || (this.idEstadoCanjeOrdenCompra != null && !this.idEstadoCanjeOrdenCompra.equals(other.idEstadoCanjeOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoCanjeOrdenCompra[ idEstadoCanjeOrdenCompra=" + idEstadoCanjeOrdenCompra + " ]";
    }
    
}

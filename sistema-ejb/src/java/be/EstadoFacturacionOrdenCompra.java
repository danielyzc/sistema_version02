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
@Table(name = "estado_facturacion_orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoFacturacionOrdenCompra.findAll", query = "SELECT e FROM EstadoFacturacionOrdenCompra e"),
    @NamedQuery(name = "EstadoFacturacionOrdenCompra.findByIdEstadoFacturacionOrdenCompra", query = "SELECT e FROM EstadoFacturacionOrdenCompra e WHERE e.idEstadoFacturacionOrdenCompra = :idEstadoFacturacionOrdenCompra"),
    @NamedQuery(name = "EstadoFacturacionOrdenCompra.findByNombre", query = "SELECT e FROM EstadoFacturacionOrdenCompra e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoFacturacionOrdenCompra.findByDescripcion", query = "SELECT e FROM EstadoFacturacionOrdenCompra e WHERE e.descripcion = :descripcion")})
public class EstadoFacturacionOrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_facturacion_orden_compra")
    private Integer idEstadoFacturacionOrdenCompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 250)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoFacturacionOrdenCompra", fetch = FetchType.LAZY)
    private List<OrdenCompra> ordenCompraList;

    public EstadoFacturacionOrdenCompra() {
    }

    public EstadoFacturacionOrdenCompra(Integer idEstadoFacturacionOrdenCompra) {
        this.idEstadoFacturacionOrdenCompra = idEstadoFacturacionOrdenCompra;
    }

    public EstadoFacturacionOrdenCompra(Integer idEstadoFacturacionOrdenCompra, String nombre, String descripcion) {
        this.idEstadoFacturacionOrdenCompra = idEstadoFacturacionOrdenCompra;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdEstadoFacturacionOrdenCompra() {
        return idEstadoFacturacionOrdenCompra;
    }

    public void setIdEstadoFacturacionOrdenCompra(Integer idEstadoFacturacionOrdenCompra) {
        this.idEstadoFacturacionOrdenCompra = idEstadoFacturacionOrdenCompra;
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
    public List<OrdenCompra> getOrdenCompraList() {
        return ordenCompraList;
    }

    public void setOrdenCompraList(List<OrdenCompra> ordenCompraList) {
        this.ordenCompraList = ordenCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoFacturacionOrdenCompra != null ? idEstadoFacturacionOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoFacturacionOrdenCompra)) {
            return false;
        }
        EstadoFacturacionOrdenCompra other = (EstadoFacturacionOrdenCompra) object;
        if ((this.idEstadoFacturacionOrdenCompra == null && other.idEstadoFacturacionOrdenCompra != null) || (this.idEstadoFacturacionOrdenCompra != null && !this.idEstadoFacturacionOrdenCompra.equals(other.idEstadoFacturacionOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoFacturacionOrdenCompra[ idEstadoFacturacionOrdenCompra=" + idEstadoFacturacionOrdenCompra + " ]";
    }
    
}

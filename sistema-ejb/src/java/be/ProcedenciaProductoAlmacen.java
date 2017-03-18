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
@Table(name = "procedencia_producto_almacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findAll", query = "SELECT p FROM ProcedenciaProductoAlmacen p"),
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findByIdProcedenciaProductoAlmacen", query = "SELECT p FROM ProcedenciaProductoAlmacen p WHERE p.idProcedenciaProductoAlmacen = :idProcedenciaProductoAlmacen"),
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findByNombre", query = "SELECT p FROM ProcedenciaProductoAlmacen p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findByDescripcion", query = "SELECT p FROM ProcedenciaProductoAlmacen p WHERE p.descripcion = :descripcion")})
public class ProcedenciaProductoAlmacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_procedencia_producto_almacen")
    private Integer idProcedenciaProductoAlmacen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 170)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedenciaProductoAlmacen", fetch = FetchType.LAZY)
    private List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedenciaProductoAlmacen", fetch = FetchType.LAZY)
    private List<DetalleAlmacenProductos> detalleAlmacenProductosList;

    public ProcedenciaProductoAlmacen() {
    }

    public ProcedenciaProductoAlmacen(Integer idProcedenciaProductoAlmacen) {
        this.idProcedenciaProductoAlmacen = idProcedenciaProductoAlmacen;
    }

    public ProcedenciaProductoAlmacen(Integer idProcedenciaProductoAlmacen, String nombre, String descripcion) {
        this.idProcedenciaProductoAlmacen = idProcedenciaProductoAlmacen;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdProcedenciaProductoAlmacen() {
        return idProcedenciaProductoAlmacen;
    }

    public void setIdProcedenciaProductoAlmacen(Integer idProcedenciaProductoAlmacen) {
        this.idProcedenciaProductoAlmacen = idProcedenciaProductoAlmacen;
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
    public List<DetalleAlmacenProductosCostos> getDetalleAlmacenProductosCostosList() {
        return detalleAlmacenProductosCostosList;
    }

    public void setDetalleAlmacenProductosCostosList(List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList) {
        this.detalleAlmacenProductosCostosList = detalleAlmacenProductosCostosList;
    }

    @XmlTransient
    public List<DetalleAlmacenProductos> getDetalleAlmacenProductosList() {
        return detalleAlmacenProductosList;
    }

    public void setDetalleAlmacenProductosList(List<DetalleAlmacenProductos> detalleAlmacenProductosList) {
        this.detalleAlmacenProductosList = detalleAlmacenProductosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcedenciaProductoAlmacen != null ? idProcedenciaProductoAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedenciaProductoAlmacen)) {
            return false;
        }
        ProcedenciaProductoAlmacen other = (ProcedenciaProductoAlmacen) object;
        if ((this.idProcedenciaProductoAlmacen == null && other.idProcedenciaProductoAlmacen != null) || (this.idProcedenciaProductoAlmacen != null && !this.idProcedenciaProductoAlmacen.equals(other.idProcedenciaProductoAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ProcedenciaProductoAlmacen[ idProcedenciaProductoAlmacen=" + idProcedenciaProductoAlmacen + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "marca_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaProducto.findAll", query = "SELECT m FROM MarcaProducto m"),
    @NamedQuery(name = "MarcaProducto.findByPkId", query = "SELECT m FROM MarcaProducto m WHERE m.pkId = :pkId"),
    @NamedQuery(name = "MarcaProducto.findByNombre", query = "SELECT m FROM MarcaProducto m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "MarcaProducto.findByDescripcion", query = "SELECT m FROM MarcaProducto m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "MarcaProducto.findByFecCreacion", query = "SELECT m FROM MarcaProducto m WHERE m.fecCreacion = :fecCreacion"),
    @NamedQuery(name = "MarcaProducto.findByFecModificacion", query = "SELECT m FROM MarcaProducto m WHERE m.fecModificacion = :fecModificacion"),
    @NamedQuery(name = "MarcaProducto.findByFecEliminacion", query = "SELECT m FROM MarcaProducto m WHERE m.fecEliminacion = :fecEliminacion"),
    @NamedQuery(name = "MarcaProducto.findByUsuCrea", query = "SELECT m FROM MarcaProducto m WHERE m.usuCrea = :usuCrea"),
    @NamedQuery(name = "MarcaProducto.findByUsuModi", query = "SELECT m FROM MarcaProducto m WHERE m.usuModi = :usuModi"),
    @NamedQuery(name = "MarcaProducto.findByUsuElim", query = "SELECT m FROM MarcaProducto m WHERE m.usuElim = :usuElim"),
    @NamedQuery(name = "MarcaProducto.findByEstadoExistencia", query = "SELECT m FROM MarcaProducto m WHERE m.estadoExistencia = :estadoExistencia")})
public class MarcaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
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
    @Column(name = "fec_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreacion;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModificacion;
    @Column(name = "fec_eliminacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEliminacion;
    @Column(name = "usu_crea")
    private Integer usuCrea;
    @Column(name = "usu_modi")
    private Integer usuModi;
    @Column(name = "usu_elim")
    private Integer usuElim;
    @Column(name = "estado_existencia")
    private Integer estadoExistencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marcaProducto", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public MarcaProducto() {
    }

    public MarcaProducto(Integer pkId) {
        this.pkId = pkId;
    }

    public MarcaProducto(Integer pkId, String nombre, String descripcion) {
        this.pkId = pkId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
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

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public Date getFecModificacion() {
        return fecModificacion;
    }

    public void setFecModificacion(Date fecModificacion) {
        this.fecModificacion = fecModificacion;
    }

    public Date getFecEliminacion() {
        return fecEliminacion;
    }

    public void setFecEliminacion(Date fecEliminacion) {
        this.fecEliminacion = fecEliminacion;
    }

    public Integer getUsuCrea() {
        return usuCrea;
    }

    public void setUsuCrea(Integer usuCrea) {
        this.usuCrea = usuCrea;
    }

    public Integer getUsuModi() {
        return usuModi;
    }

    public void setUsuModi(Integer usuModi) {
        this.usuModi = usuModi;
    }

    public Integer getUsuElim() {
        return usuElim;
    }

    public void setUsuElim(Integer usuElim) {
        this.usuElim = usuElim;
    }

    public Integer getEstadoExistencia() {
        return estadoExistencia;
    }

    public void setEstadoExistencia(Integer estadoExistencia) {
        this.estadoExistencia = estadoExistencia;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkId != null ? pkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaProducto)) {
            return false;
        }
        MarcaProducto other = (MarcaProducto) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.MarcaProducto[ pkId=" + pkId + " ]";
    }
    
}

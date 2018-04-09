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
@Table(name = "modelo_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModeloProducto.findAll", query = "SELECT m FROM ModeloProducto m"),
    @NamedQuery(name = "ModeloProducto.findByIdModeloProducto", query = "SELECT m FROM ModeloProducto m WHERE m.idModeloProducto = :idModeloProducto"),
    @NamedQuery(name = "ModeloProducto.findByNombreModeloProducto", query = "SELECT m FROM ModeloProducto m WHERE m.nombreModeloProducto = :nombreModeloProducto"),
    @NamedQuery(name = "ModeloProducto.findByDescripcion", query = "SELECT m FROM ModeloProducto m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "ModeloProducto.findByFecCreacion", query = "SELECT m FROM ModeloProducto m WHERE m.fecCreacion = :fecCreacion"),
    @NamedQuery(name = "ModeloProducto.findByFecModificacion", query = "SELECT m FROM ModeloProducto m WHERE m.fecModificacion = :fecModificacion"),
    @NamedQuery(name = "ModeloProducto.findByFecEliminacion", query = "SELECT m FROM ModeloProducto m WHERE m.fecEliminacion = :fecEliminacion"),
    @NamedQuery(name = "ModeloProducto.findByUsuCrea", query = "SELECT m FROM ModeloProducto m WHERE m.usuCrea = :usuCrea"),
    @NamedQuery(name = "ModeloProducto.findByUsuModi", query = "SELECT m FROM ModeloProducto m WHERE m.usuModi = :usuModi"),
    @NamedQuery(name = "ModeloProducto.findByUsuElim", query = "SELECT m FROM ModeloProducto m WHERE m.usuElim = :usuElim"),
    @NamedQuery(name = "ModeloProducto.findByEstadoExistencia", query = "SELECT m FROM ModeloProducto m WHERE m.estadoExistencia = :estadoExistencia")})
public class ModeloProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_modelo_producto")
    private Integer idModeloProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "nombre_modelo_producto")
    private String nombreModeloProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 250)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modeloProducto", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public ModeloProducto() {
    }

    public ModeloProducto(Integer idModeloProducto) {
        this.idModeloProducto = idModeloProducto;
    }

    public ModeloProducto(Integer idModeloProducto, String nombreModeloProducto, String descripcion) {
        this.idModeloProducto = idModeloProducto;
        this.nombreModeloProducto = nombreModeloProducto;
        this.descripcion = descripcion;
    }

    public Integer getIdModeloProducto() {
        return idModeloProducto;
    }

    public void setIdModeloProducto(Integer idModeloProducto) {
        this.idModeloProducto = idModeloProducto;
    }

    public String getNombreModeloProducto() {
        return nombreModeloProducto;
    }

    public void setNombreModeloProducto(String nombreModeloProducto) {
        this.nombreModeloProducto = nombreModeloProducto;
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
        hash += (idModeloProducto != null ? idModeloProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeloProducto)) {
            return false;
        }
        ModeloProducto other = (ModeloProducto) object;
        if ((this.idModeloProducto == null && other.idModeloProducto != null) || (this.idModeloProducto != null && !this.idModeloProducto.equals(other.idModeloProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ModeloProducto[ idModeloProducto=" + idModeloProducto + " ]";
    }
    
}

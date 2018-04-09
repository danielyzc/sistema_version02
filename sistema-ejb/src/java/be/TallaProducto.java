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
@Table(name = "talla_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TallaProducto.findAll", query = "SELECT t FROM TallaProducto t"),
    @NamedQuery(name = "TallaProducto.findByPkId", query = "SELECT t FROM TallaProducto t WHERE t.pkId = :pkId"),
    @NamedQuery(name = "TallaProducto.findByNombreTallaProducto", query = "SELECT t FROM TallaProducto t WHERE t.nombreTallaProducto = :nombreTallaProducto"),
    @NamedQuery(name = "TallaProducto.findByDescripcion", query = "SELECT t FROM TallaProducto t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TallaProducto.findByFecCreacion", query = "SELECT t FROM TallaProducto t WHERE t.fecCreacion = :fecCreacion"),
    @NamedQuery(name = "TallaProducto.findByFecModificacion", query = "SELECT t FROM TallaProducto t WHERE t.fecModificacion = :fecModificacion"),
    @NamedQuery(name = "TallaProducto.findByFecEliminacion", query = "SELECT t FROM TallaProducto t WHERE t.fecEliminacion = :fecEliminacion"),
    @NamedQuery(name = "TallaProducto.findByUsuCrea", query = "SELECT t FROM TallaProducto t WHERE t.usuCrea = :usuCrea"),
    @NamedQuery(name = "TallaProducto.findByUsuModi", query = "SELECT t FROM TallaProducto t WHERE t.usuModi = :usuModi"),
    @NamedQuery(name = "TallaProducto.findByUsuElim", query = "SELECT t FROM TallaProducto t WHERE t.usuElim = :usuElim"),
    @NamedQuery(name = "TallaProducto.findByEstadoExistencia", query = "SELECT t FROM TallaProducto t WHERE t.estadoExistencia = :estadoExistencia")})
public class TallaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "nombre_talla_producto")
    private String nombreTallaProducto;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tallaProducto", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public TallaProducto() {
    }

    public TallaProducto(Integer pkId) {
        this.pkId = pkId;
    }

    public TallaProducto(Integer pkId, String nombreTallaProducto, String descripcion) {
        this.pkId = pkId;
        this.nombreTallaProducto = nombreTallaProducto;
        this.descripcion = descripcion;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getNombreTallaProducto() {
        return nombreTallaProducto;
    }

    public void setNombreTallaProducto(String nombreTallaProducto) {
        this.nombreTallaProducto = nombreTallaProducto;
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
        if (!(object instanceof TallaProducto)) {
            return false;
        }
        TallaProducto other = (TallaProducto) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TallaProducto[ pkId=" + pkId + " ]";
    }
    
}

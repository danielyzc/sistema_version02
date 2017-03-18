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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s"),
    @NamedQuery(name = "Servicio.findByIdServicio", query = "SELECT s FROM Servicio s WHERE s.idServicio = :idServicio"),
    @NamedQuery(name = "Servicio.findByFechaRegistro", query = "SELECT s FROM Servicio s WHERE s.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Servicio.findByNombreServicio", query = "SELECT s FROM Servicio s WHERE s.nombreServicio = :nombreServicio"),
    @NamedQuery(name = "Servicio.findByPalabraClave", query = "SELECT s FROM Servicio s WHERE s.palabraClave = :palabraClave"),
    @NamedQuery(name = "Servicio.findByDescripcion", query = "SELECT s FROM Servicio s WHERE s.descripcion = :descripcion")})
public class Servicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servicio")
    private Integer idServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 250)
    @Column(name = "nombre_servicio")
    private String nombreServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 250)
    @Column(name = "palabra_clave")
    private String palabraClave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 800)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio", fetch = FetchType.LAZY)
    private List<DetalleServicioProducto> detalleServicioProductoList;
    @JoinColumn(name = "id_tipo_servicio", referencedColumnName = "id_tipo_servicio")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoServicio tipoServicio;

    public Servicio() {
    }

    public Servicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Servicio(Integer idServicio, Date fechaRegistro, String nombreServicio, String palabraClave, String descripcion) {
        this.idServicio = idServicio;
        this.fechaRegistro = fechaRegistro;
        this.nombreServicio = nombreServicio;
        this.palabraClave = palabraClave;
        this.descripcion = descripcion;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getPalabraClave() {
        return palabraClave;
    }

    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<DetalleServicioProducto> getDetalleServicioProductoList() {
        return detalleServicioProductoList;
    }

    public void setDetalleServicioProductoList(List<DetalleServicioProducto> detalleServicioProductoList) {
        this.detalleServicioProductoList = detalleServicioProductoList;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Servicio[ idServicio=" + idServicio + " ]";
    }
    
}

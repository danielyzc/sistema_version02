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
@Table(name = "ubicacion_fisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UbicacionFisica.findAll", query = "SELECT u FROM UbicacionFisica u"),
    @NamedQuery(name = "UbicacionFisica.findByIdUbicacionFisica", query = "SELECT u FROM UbicacionFisica u WHERE u.idUbicacionFisica = :idUbicacionFisica"),
    @NamedQuery(name = "UbicacionFisica.findByNombreUbicacionFisica", query = "SELECT u FROM UbicacionFisica u WHERE u.nombreUbicacionFisica = :nombreUbicacionFisica"),
    @NamedQuery(name = "UbicacionFisica.findByDescripcionUbicacionFisica", query = "SELECT u FROM UbicacionFisica u WHERE u.descripcionUbicacionFisica = :descripcionUbicacionFisica")})
public class UbicacionFisica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ubicacion_fisica")
    private Integer idUbicacionFisica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "nombre_ubicacion_fisica")
    private String nombreUbicacionFisica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "descripcion_ubicacion_fisica")
    private String descripcionUbicacionFisica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ubicacionFisica", fetch = FetchType.LAZY)
    private List<DetalleAlmacenProductos> detalleAlmacenProductosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ubicacionFisica", fetch = FetchType.LAZY)
    private List<DetalleInventarioUbicacionFisica> detalleInventarioUbicacionFisicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ubicacionFisica", fetch = FetchType.LAZY)
    private List<IngresoProductoTienda> ingresoProductoTiendaList;

    public UbicacionFisica() {
    }

    public UbicacionFisica(Integer idUbicacionFisica) {
        this.idUbicacionFisica = idUbicacionFisica;
    }

    public UbicacionFisica(Integer idUbicacionFisica, String nombreUbicacionFisica, String descripcionUbicacionFisica) {
        this.idUbicacionFisica = idUbicacionFisica;
        this.nombreUbicacionFisica = nombreUbicacionFisica;
        this.descripcionUbicacionFisica = descripcionUbicacionFisica;
    }

    public Integer getIdUbicacionFisica() {
        return idUbicacionFisica;
    }

    public void setIdUbicacionFisica(Integer idUbicacionFisica) {
        this.idUbicacionFisica = idUbicacionFisica;
    }

    public String getNombreUbicacionFisica() {
        return nombreUbicacionFisica;
    }

    public void setNombreUbicacionFisica(String nombreUbicacionFisica) {
        this.nombreUbicacionFisica = nombreUbicacionFisica;
    }

    public String getDescripcionUbicacionFisica() {
        return descripcionUbicacionFisica;
    }

    public void setDescripcionUbicacionFisica(String descripcionUbicacionFisica) {
        this.descripcionUbicacionFisica = descripcionUbicacionFisica;
    }

    @XmlTransient
    public List<DetalleAlmacenProductos> getDetalleAlmacenProductosList() {
        return detalleAlmacenProductosList;
    }

    public void setDetalleAlmacenProductosList(List<DetalleAlmacenProductos> detalleAlmacenProductosList) {
        this.detalleAlmacenProductosList = detalleAlmacenProductosList;
    }

    @XmlTransient
    public List<DetalleInventarioUbicacionFisica> getDetalleInventarioUbicacionFisicaList() {
        return detalleInventarioUbicacionFisicaList;
    }

    public void setDetalleInventarioUbicacionFisicaList(List<DetalleInventarioUbicacionFisica> detalleInventarioUbicacionFisicaList) {
        this.detalleInventarioUbicacionFisicaList = detalleInventarioUbicacionFisicaList;
    }

    @XmlTransient
    public List<IngresoProductoTienda> getIngresoProductoTiendaList() {
        return ingresoProductoTiendaList;
    }

    public void setIngresoProductoTiendaList(List<IngresoProductoTienda> ingresoProductoTiendaList) {
        this.ingresoProductoTiendaList = ingresoProductoTiendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUbicacionFisica != null ? idUbicacionFisica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UbicacionFisica)) {
            return false;
        }
        UbicacionFisica other = (UbicacionFisica) object;
        if ((this.idUbicacionFisica == null && other.idUbicacionFisica != null) || (this.idUbicacionFisica != null && !this.idUbicacionFisica.equals(other.idUbicacionFisica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.UbicacionFisica[ idUbicacionFisica=" + idUbicacionFisica + " ]";
    }
    
}

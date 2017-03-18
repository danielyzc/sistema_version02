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
@Table(name = "color_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColorProducto.findAll", query = "SELECT c FROM ColorProducto c"),
    @NamedQuery(name = "ColorProducto.findByIdColorProducto", query = "SELECT c FROM ColorProducto c WHERE c.idColorProducto = :idColorProducto"),
    @NamedQuery(name = "ColorProducto.findByNombreColorProducto", query = "SELECT c FROM ColorProducto c WHERE c.nombreColorProducto = :nombreColorProducto"),
    @NamedQuery(name = "ColorProducto.findByDescripcion", query = "SELECT c FROM ColorProducto c WHERE c.descripcion = :descripcion")})
public class ColorProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_color_producto")
    private Integer idColorProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "nombre_color_producto")
    private String nombreColorProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 170)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colorProducto", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public ColorProducto() {
    }

    public ColorProducto(Integer idColorProducto) {
        this.idColorProducto = idColorProducto;
    }

    public ColorProducto(Integer idColorProducto, String nombreColorProducto, String descripcion) {
        this.idColorProducto = idColorProducto;
        this.nombreColorProducto = nombreColorProducto;
        this.descripcion = descripcion;
    }

    public Integer getIdColorProducto() {
        return idColorProducto;
    }

    public void setIdColorProducto(Integer idColorProducto) {
        this.idColorProducto = idColorProducto;
    }

    public String getNombreColorProducto() {
        return nombreColorProducto;
    }

    public void setNombreColorProducto(String nombreColorProducto) {
        this.nombreColorProducto = nombreColorProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idColorProducto != null ? idColorProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColorProducto)) {
            return false;
        }
        ColorProducto other = (ColorProducto) object;
        if ((this.idColorProducto == null && other.idColorProducto != null) || (this.idColorProducto != null && !this.idColorProducto.equals(other.idColorProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ColorProducto[ idColorProducto=" + idColorProducto + " ]";
    }
    
}

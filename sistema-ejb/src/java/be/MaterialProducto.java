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
@Table(name = "material_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialProducto.findAll", query = "SELECT m FROM MaterialProducto m"),
    @NamedQuery(name = "MaterialProducto.findByIdMaterialProducto", query = "SELECT m FROM MaterialProducto m WHERE m.idMaterialProducto = :idMaterialProducto"),
    @NamedQuery(name = "MaterialProducto.findByNombreMaterialProducto", query = "SELECT m FROM MaterialProducto m WHERE m.nombreMaterialProducto = :nombreMaterialProducto"),
    @NamedQuery(name = "MaterialProducto.findByDescripcion", query = "SELECT m FROM MaterialProducto m WHERE m.descripcion = :descripcion")})
public class MaterialProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_material_producto")
    private Integer idMaterialProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "nombre_material_producto")
    private String nombreMaterialProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 170)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialProducto", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public MaterialProducto() {
    }

    public MaterialProducto(Integer idMaterialProducto) {
        this.idMaterialProducto = idMaterialProducto;
    }

    public MaterialProducto(Integer idMaterialProducto, String nombreMaterialProducto, String descripcion) {
        this.idMaterialProducto = idMaterialProducto;
        this.nombreMaterialProducto = nombreMaterialProducto;
        this.descripcion = descripcion;
    }

    public Integer getIdMaterialProducto() {
        return idMaterialProducto;
    }

    public void setIdMaterialProducto(Integer idMaterialProducto) {
        this.idMaterialProducto = idMaterialProducto;
    }

    public String getNombreMaterialProducto() {
        return nombreMaterialProducto;
    }

    public void setNombreMaterialProducto(String nombreMaterialProducto) {
        this.nombreMaterialProducto = nombreMaterialProducto;
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
        hash += (idMaterialProducto != null ? idMaterialProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialProducto)) {
            return false;
        }
        MaterialProducto other = (MaterialProducto) object;
        if ((this.idMaterialProducto == null && other.idMaterialProducto != null) || (this.idMaterialProducto != null && !this.idMaterialProducto.equals(other.idMaterialProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.MaterialProducto[ idMaterialProducto=" + idMaterialProducto + " ]";
    }
    
}

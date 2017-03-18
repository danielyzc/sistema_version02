/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "detalle_fumigacion_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFumigacionProducto.findAll", query = "SELECT d FROM DetalleFumigacionProducto d"),
    @NamedQuery(name = "DetalleFumigacionProducto.findByIdDetalleFumigacionProducto", query = "SELECT d FROM DetalleFumigacionProducto d WHERE d.idDetalleFumigacionProducto = :idDetalleFumigacionProducto"),
    @NamedQuery(name = "DetalleFumigacionProducto.findByCantidad", query = "SELECT d FROM DetalleFumigacionProducto d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleFumigacionProducto.findByUtilizo", query = "SELECT d FROM DetalleFumigacionProducto d WHERE d.utilizo = :utilizo"),
    @NamedQuery(name = "DetalleFumigacionProducto.findByQuedo", query = "SELECT d FROM DetalleFumigacionProducto d WHERE d.quedo = :quedo")})
public class DetalleFumigacionProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_fumigacion_producto")
    private Integer idDetalleFumigacionProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "utilizo")
    private BigDecimal utilizo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quedo")
    private BigDecimal quedo;
    @JoinColumn(name = "id_contrato_fumigacion", referencedColumnName = "id_contrato_fumigacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ContratoFumigacion contratoFumigacion;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;

    public DetalleFumigacionProducto() {
    }

    public DetalleFumigacionProducto(Integer idDetalleFumigacionProducto) {
        this.idDetalleFumigacionProducto = idDetalleFumigacionProducto;
    }

    public DetalleFumigacionProducto(Integer idDetalleFumigacionProducto, int cantidad, BigDecimal utilizo, BigDecimal quedo) {
        this.idDetalleFumigacionProducto = idDetalleFumigacionProducto;
        this.cantidad = cantidad;
        this.utilizo = utilizo;
        this.quedo = quedo;
    }

    public Integer getIdDetalleFumigacionProducto() {
        return idDetalleFumigacionProducto;
    }

    public void setIdDetalleFumigacionProducto(Integer idDetalleFumigacionProducto) {
        this.idDetalleFumigacionProducto = idDetalleFumigacionProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getUtilizo() {
        return utilizo;
    }

    public void setUtilizo(BigDecimal utilizo) {
        this.utilizo = utilizo;
    }

    public BigDecimal getQuedo() {
        return quedo;
    }

    public void setQuedo(BigDecimal quedo) {
        this.quedo = quedo;
    }

    public ContratoFumigacion getContratoFumigacion() {
        return contratoFumigacion;
    }

    public void setContratoFumigacion(ContratoFumigacion contratoFumigacion) {
        this.contratoFumigacion = contratoFumigacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleFumigacionProducto != null ? idDetalleFumigacionProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFumigacionProducto)) {
            return false;
        }
        DetalleFumigacionProducto other = (DetalleFumigacionProducto) object;
        if ((this.idDetalleFumigacionProducto == null && other.idDetalleFumigacionProducto != null) || (this.idDetalleFumigacionProducto != null && !this.idDetalleFumigacionProducto.equals(other.idDetalleFumigacionProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleFumigacionProducto[ idDetalleFumigacionProducto=" + idDetalleFumigacionProducto + " ]";
    }
    
}

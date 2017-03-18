/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "cuenta_contable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaContable.findAll", query = "SELECT c FROM CuentaContable c"),
    @NamedQuery(name = "CuentaContable.findByIdCuentaContable", query = "SELECT c FROM CuentaContable c WHERE c.idCuentaContable = :idCuentaContable"),
    @NamedQuery(name = "CuentaContable.findByNumero", query = "SELECT c FROM CuentaContable c WHERE c.numero = :numero"),
    @NamedQuery(name = "CuentaContable.findByNombreCuentaContable", query = "SELECT c FROM CuentaContable c WHERE c.nombreCuentaContable = :nombreCuentaContable"),
    @NamedQuery(name = "CuentaContable.findByDescripcion", query = "SELECT c FROM CuentaContable c WHERE c.descripcion = :descripcion")})
public class CuentaContable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta_contable")
    private Integer idCuentaContable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 170)
    @Column(name = "nombre_cuenta_contable")
    private String nombreCuentaContable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_tipo_cuenta_contable", referencedColumnName = "id_tipo_cuenta_contable")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoCuentaContable tipoCuentaContable;
    @JoinColumn(name = "id_tipo_elemento", referencedColumnName = "id_tipo_elemento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoElemento tipoElemento;
    @JoinColumn(name = "id_sub_elemento", referencedColumnName = "id_sub_elemento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SubElemento subElemento;

    public CuentaContable() {
    }

    public CuentaContable(Integer idCuentaContable) {
        this.idCuentaContable = idCuentaContable;
    }

    public CuentaContable(Integer idCuentaContable, int numero, String nombreCuentaContable, String descripcion) {
        this.idCuentaContable = idCuentaContable;
        this.numero = numero;
        this.nombreCuentaContable = nombreCuentaContable;
        this.descripcion = descripcion;
    }

    public Integer getIdCuentaContable() {
        return idCuentaContable;
    }

    public void setIdCuentaContable(Integer idCuentaContable) {
        this.idCuentaContable = idCuentaContable;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombreCuentaContable() {
        return nombreCuentaContable;
    }

    public void setNombreCuentaContable(String nombreCuentaContable) {
        this.nombreCuentaContable = nombreCuentaContable;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoCuentaContable getTipoCuentaContable() {
        return tipoCuentaContable;
    }

    public void setTipoCuentaContable(TipoCuentaContable tipoCuentaContable) {
        this.tipoCuentaContable = tipoCuentaContable;
    }

    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(TipoElemento tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    public SubElemento getSubElemento() {
        return subElemento;
    }

    public void setSubElemento(SubElemento subElemento) {
        this.subElemento = subElemento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuentaContable != null ? idCuentaContable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaContable)) {
            return false;
        }
        CuentaContable other = (CuentaContable) object;
        if ((this.idCuentaContable == null && other.idCuentaContable != null) || (this.idCuentaContable != null && !this.idCuentaContable.equals(other.idCuentaContable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.CuentaContable[ idCuentaContable=" + idCuentaContable + " ]";
    }
    
}

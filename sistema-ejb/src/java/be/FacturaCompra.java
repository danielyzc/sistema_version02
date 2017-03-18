/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "factura_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaCompra.findAll", query = "SELECT f FROM FacturaCompra f"),
    @NamedQuery(name = "FacturaCompra.findByIdFacturaCompra", query = "SELECT f FROM FacturaCompra f WHERE f.idFacturaCompra = :idFacturaCompra"),
    @NamedQuery(name = "FacturaCompra.findByFechaRecepcion", query = "SELECT f FROM FacturaCompra f WHERE f.fechaRecepcion = :fechaRecepcion"),
    @NamedQuery(name = "FacturaCompra.findByNumeroFacturaCompra", query = "SELECT f FROM FacturaCompra f WHERE f.numeroFacturaCompra = :numeroFacturaCompra"),
    @NamedQuery(name = "FacturaCompra.findByNumeroGuiaRemision", query = "SELECT f FROM FacturaCompra f WHERE f.numeroGuiaRemision = :numeroGuiaRemision"),
    @NamedQuery(name = "FacturaCompra.findByDescripcion", query = "SELECT f FROM FacturaCompra f WHERE f.descripcion = :descripcion")})
public class FacturaCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factura_compra")
    private Integer idFacturaCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_recepcion")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 68)
    @Column(name = "numero_factura_compra")
    private String numeroFacturaCompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 68)
    @Column(name = "numero_guia_remision")
    private String numeroGuiaRemision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 170)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_orden_compra", referencedColumnName = "id_orden_compra")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrdenCompra ordenCompra;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empleado;

    public FacturaCompra() {
    }

    public FacturaCompra(Integer idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }

    public FacturaCompra(Integer idFacturaCompra, Date fechaRecepcion, String numeroFacturaCompra, String numeroGuiaRemision, String descripcion) {
        this.idFacturaCompra = idFacturaCompra;
        this.fechaRecepcion = fechaRecepcion;
        this.numeroFacturaCompra = numeroFacturaCompra;
        this.numeroGuiaRemision = numeroGuiaRemision;
        this.descripcion = descripcion;
    }

    public Integer getIdFacturaCompra() {
        return idFacturaCompra;
    }

    public void setIdFacturaCompra(Integer idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getNumeroFacturaCompra() {
        return numeroFacturaCompra;
    }

    public void setNumeroFacturaCompra(String numeroFacturaCompra) {
        this.numeroFacturaCompra = numeroFacturaCompra;
    }

    public String getNumeroGuiaRemision() {
        return numeroGuiaRemision;
    }

    public void setNumeroGuiaRemision(String numeroGuiaRemision) {
        this.numeroGuiaRemision = numeroGuiaRemision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturaCompra != null ? idFacturaCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaCompra)) {
            return false;
        }
        FacturaCompra other = (FacturaCompra) object;
        if ((this.idFacturaCompra == null && other.idFacturaCompra != null) || (this.idFacturaCompra != null && !this.idFacturaCompra.equals(other.idFacturaCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.FacturaCompra[ idFacturaCompra=" + idFacturaCompra + " ]";
    }
    
}

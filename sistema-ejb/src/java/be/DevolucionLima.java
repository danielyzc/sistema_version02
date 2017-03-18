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
@Table(name = "devolucion_lima")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DevolucionLima.findAll", query = "SELECT d FROM DevolucionLima d"),
    @NamedQuery(name = "DevolucionLima.findByIdDevolucion", query = "SELECT d FROM DevolucionLima d WHERE d.idDevolucion = :idDevolucion"),
    @NamedQuery(name = "DevolucionLima.findByFechaDevolucion", query = "SELECT d FROM DevolucionLima d WHERE d.fechaDevolucion = :fechaDevolucion"),
    @NamedQuery(name = "DevolucionLima.findByMotivoDevolucion", query = "SELECT d FROM DevolucionLima d WHERE d.motivoDevolucion = :motivoDevolucion")})
public class DevolucionLima implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_devolucion")
    private Integer idDevolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 300)
    @Column(name = "motivo_devolucion")
    private String motivoDevolucion;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;

    public DevolucionLima() {
    }

    public DevolucionLima(Integer idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public DevolucionLima(Integer idDevolucion, Date fechaDevolucion, String motivoDevolucion) {
        this.idDevolucion = idDevolucion;
        this.fechaDevolucion = fechaDevolucion;
        this.motivoDevolucion = motivoDevolucion;
    }

    public Integer getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(Integer idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
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
        hash += (idDevolucion != null ? idDevolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DevolucionLima)) {
            return false;
        }
        DevolucionLima other = (DevolucionLima) object;
        if ((this.idDevolucion == null && other.idDevolucion != null) || (this.idDevolucion != null && !this.idDevolucion.equals(other.idDevolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DevolucionLima[ idDevolucion=" + idDevolucion + " ]";
    }
    
}

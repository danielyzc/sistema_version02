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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "prestamo_producto_tienda_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrestamoProductoTiendaUsuario.findAll", query = "SELECT p FROM PrestamoProductoTiendaUsuario p"),
    @NamedQuery(name = "PrestamoProductoTiendaUsuario.findByIdPrestamoProductoTienda", query = "SELECT p FROM PrestamoProductoTiendaUsuario p WHERE p.idPrestamoProductoTienda = :idPrestamoProductoTienda"),
    @NamedQuery(name = "PrestamoProductoTiendaUsuario.findByCantidad", query = "SELECT p FROM PrestamoProductoTiendaUsuario p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PrestamoProductoTiendaUsuario.findByFechaIngreso", query = "SELECT p FROM PrestamoProductoTiendaUsuario p WHERE p.fechaIngreso = :fechaIngreso")})
public class PrestamoProductoTiendaUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prestamo_producto_tienda")
    private Integer idPrestamoProductoTienda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;
    @JoinColumn(name = "id_tienda_presta", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda;
    @JoinColumn(name = "id_tienda_recibe", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda1;

    public PrestamoProductoTiendaUsuario() {
    }

    public PrestamoProductoTiendaUsuario(Integer idPrestamoProductoTienda) {
        this.idPrestamoProductoTienda = idPrestamoProductoTienda;
    }

    public PrestamoProductoTiendaUsuario(Integer idPrestamoProductoTienda, int cantidad, Date fechaIngreso) {
        this.idPrestamoProductoTienda = idPrestamoProductoTienda;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdPrestamoProductoTienda() {
        return idPrestamoProductoTienda;
    }

    public void setIdPrestamoProductoTienda(Integer idPrestamoProductoTienda) {
        this.idPrestamoProductoTienda = idPrestamoProductoTienda;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Tienda getTienda1() {
        return tienda1;
    }

    public void setTienda1(Tienda tienda1) {
        this.tienda1 = tienda1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestamoProductoTienda != null ? idPrestamoProductoTienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrestamoProductoTiendaUsuario)) {
            return false;
        }
        PrestamoProductoTiendaUsuario other = (PrestamoProductoTiendaUsuario) object;
        if ((this.idPrestamoProductoTienda == null && other.idPrestamoProductoTienda != null) || (this.idPrestamoProductoTienda != null && !this.idPrestamoProductoTienda.equals(other.idPrestamoProductoTienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.PrestamoProductoTiendaUsuario[ idPrestamoProductoTienda=" + idPrestamoProductoTienda + " ]";
    }
    
}

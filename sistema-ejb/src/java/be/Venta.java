/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByIdVenta", query = "SELECT v FROM Venta v WHERE v.idVenta = :idVenta"),
    @NamedQuery(name = "Venta.findByBloqueVenta", query = "SELECT v FROM Venta v WHERE v.bloqueVenta = :bloqueVenta"),
    @NamedQuery(name = "Venta.findByNumeroVenta", query = "SELECT v FROM Venta v WHERE v.numeroVenta = :numeroVenta"),
    @NamedQuery(name = "Venta.findByFechaVenta", query = "SELECT v FROM Venta v WHERE v.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "Venta.findByFechaVentaEmision", query = "SELECT v FROM Venta v WHERE v.fechaVentaEmision = :fechaVentaEmision"),
    @NamedQuery(name = "Venta.findByTotalVenta", query = "SELECT v FROM Venta v WHERE v.totalVenta = :totalVenta"),
    @NamedQuery(name = "Venta.findByObservaciones", query = "SELECT v FROM Venta v WHERE v.observaciones = :observaciones"),
    @NamedQuery(name = "Venta.findByTotalPagosCredito", query = "SELECT v FROM Venta v WHERE v.totalPagosCredito = :totalPagosCredito"),
    @NamedQuery(name = "Venta.findByFacturaRelacionada", query = "SELECT v FROM Venta v WHERE v.facturaRelacionada = :facturaRelacionada"),
    @NamedQuery(name = "Venta.findByTipoDocumento", query = "SELECT v FROM Venta v WHERE v.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Venta.findByDatoDocumento", query = "SELECT v FROM Venta v WHERE v.datoDocumento = :datoDocumento"),
    @NamedQuery(name = "Venta.findByEstadoExistencia", query = "SELECT v FROM Venta v WHERE v.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "Venta.findByFecReg", query = "SELECT v FROM Venta v WHERE v.fecReg = :fecReg")})
public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venta")
    private Integer idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bloque_venta")
    private int bloqueVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_venta")
    private int numeroVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaVentaEmision;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_venta")
    private BigDecimal totalVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_pagos_credito")
    private BigDecimal totalPagosCredito;
    @Size(max = 50)
    @Column(name = "factura_relacionada")
    private String facturaRelacionada;
    @Column(name = "tipo_documento")
    private Integer tipoDocumento;
    @Size(max = 100)
    @Column(name = "dato_documento")
    private String datoDocumento;
    @Column(name = "estado_existencia")
    private Integer estadoExistencia;
    @Column(name = "fec_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecReg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta", fetch = FetchType.LAZY)
    private List<Cambio> cambioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta", fetch = FetchType.LAZY)
    private List<ContratoFumigacion> contratoFumigacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta", fetch = FetchType.LAZY)
    private List<DetalleVentaProducto> detalleVentaProductoList;
    @OneToMany(mappedBy = "venta", fetch = FetchType.LAZY)
    private List<NotaCredito> notaCreditoList;
    @OneToMany(mappedBy = "venta", fetch = FetchType.LAZY)
    private List<PagoVentaCredito> pagoVentaCreditoList;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;
    @JoinColumn(name = "id_tipo_venta", referencedColumnName = "id_tipo_venta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoVenta tipoVenta;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "id_estado_venta", referencedColumnName = "id_estado_venta")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoVenta estadoVenta;

    public Venta() {
    }

    public Venta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Venta(Integer idVenta, int bloqueVenta, int numeroVenta, Date fechaVenta, Date fechaVentaEmision, BigDecimal totalVenta, String observaciones, BigDecimal totalPagosCredito) {
        this.idVenta = idVenta;
        this.bloqueVenta = bloqueVenta;
        this.numeroVenta = numeroVenta;
        this.fechaVenta = fechaVenta;
        this.fechaVentaEmision = fechaVentaEmision;
        this.totalVenta = totalVenta;
        this.observaciones = observaciones;
        this.totalPagosCredito = totalPagosCredito;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public int getBloqueVenta() {
        return bloqueVenta;
    }

    public void setBloqueVenta(int bloqueVenta) {
        this.bloqueVenta = bloqueVenta;
    }

    public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaVentaEmision() {
        return fechaVentaEmision;
    }

    public void setFechaVentaEmision(Date fechaVentaEmision) {
        this.fechaVentaEmision = fechaVentaEmision;
    }

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getTotalPagosCredito() {
        return totalPagosCredito;
    }

    public void setTotalPagosCredito(BigDecimal totalPagosCredito) {
        this.totalPagosCredito = totalPagosCredito;
    }

    public String getFacturaRelacionada() {
        return facturaRelacionada;
    }

    public void setFacturaRelacionada(String facturaRelacionada) {
        this.facturaRelacionada = facturaRelacionada;
    }

    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDatoDocumento() {
        return datoDocumento;
    }

    public void setDatoDocumento(String datoDocumento) {
        this.datoDocumento = datoDocumento;
    }

    public Integer getEstadoExistencia() {
        return estadoExistencia;
    }

    public void setEstadoExistencia(Integer estadoExistencia) {
        this.estadoExistencia = estadoExistencia;
    }

    public Date getFecReg() {
        return fecReg;
    }

    public void setFecReg(Date fecReg) {
        this.fecReg = fecReg;
    }

    @XmlTransient
    public List<Cambio> getCambioList() {
        return cambioList;
    }

    public void setCambioList(List<Cambio> cambioList) {
        this.cambioList = cambioList;
    }

    @XmlTransient
    public List<ContratoFumigacion> getContratoFumigacionList() {
        return contratoFumigacionList;
    }

    public void setContratoFumigacionList(List<ContratoFumigacion> contratoFumigacionList) {
        this.contratoFumigacionList = contratoFumigacionList;
    }

    @XmlTransient
    public List<DetalleVentaProducto> getDetalleVentaProductoList() {
        return detalleVentaProductoList;
    }

    public void setDetalleVentaProductoList(List<DetalleVentaProducto> detalleVentaProductoList) {
        this.detalleVentaProductoList = detalleVentaProductoList;
    }

    @XmlTransient
    public List<NotaCredito> getNotaCreditoList() {
        return notaCreditoList;
    }

    public void setNotaCreditoList(List<NotaCredito> notaCreditoList) {
        this.notaCreditoList = notaCreditoList;
    }

    @XmlTransient
    public List<PagoVentaCredito> getPagoVentaCreditoList() {
        return pagoVentaCreditoList;
    }

    public void setPagoVentaCreditoList(List<PagoVentaCredito> pagoVentaCreditoList) {
        this.pagoVentaCreditoList = pagoVentaCreditoList;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public TipoVenta getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(TipoVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Venta[ idVenta=" + idVenta + " ]";
    }
    
}

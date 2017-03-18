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
@Table(name = "guia_remicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuiaRemicion.findAll", query = "SELECT g FROM GuiaRemicion g"),
    @NamedQuery(name = "GuiaRemicion.findByIdGuiaRemicion", query = "SELECT g FROM GuiaRemicion g WHERE g.idGuiaRemicion = :idGuiaRemicion"),
    @NamedQuery(name = "GuiaRemicion.findByPuntoPartida", query = "SELECT g FROM GuiaRemicion g WHERE g.puntoPartida = :puntoPartida"),
    @NamedQuery(name = "GuiaRemicion.findByPuntoLlegada", query = "SELECT g FROM GuiaRemicion g WHERE g.puntoLlegada = :puntoLlegada"),
    @NamedQuery(name = "GuiaRemicion.findByObservaciones", query = "SELECT g FROM GuiaRemicion g WHERE g.observaciones = :observaciones"),
    @NamedQuery(name = "GuiaRemicion.findByFechaInicioTranslado", query = "SELECT g FROM GuiaRemicion g WHERE g.fechaInicioTranslado = :fechaInicioTranslado")})
public class GuiaRemicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_guia_remicion")
    private Integer idGuiaRemicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 200)
    @Column(name = "punto_partida")
    private String puntoPartida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 200)
    @Column(name = "punto_llegada")
    private String puntoLlegada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio_translado")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioTranslado;
    @JoinColumn(name = "id_unidad_transporte", referencedColumnName = "id_unidad_transporte")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UnidadTransporte unidadTransporte;
    @JoinColumn(name = "id_conductor", referencedColumnName = "id_conductor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Conductor conductor;
    @JoinColumn(name = "id_motivo_translado_factura", referencedColumnName = "id_motivo_translado_factura")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MotivoTransladoFactura motivoTransladoFactura;
    @JoinColumn(name = "id_factura_venta", referencedColumnName = "id_factura_venta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private FacturaVenta facturaVenta;

    public GuiaRemicion() {
    }

    public GuiaRemicion(Integer idGuiaRemicion) {
        this.idGuiaRemicion = idGuiaRemicion;
    }

    public GuiaRemicion(Integer idGuiaRemicion, String puntoPartida, String puntoLlegada, String observaciones, Date fechaInicioTranslado) {
        this.idGuiaRemicion = idGuiaRemicion;
        this.puntoPartida = puntoPartida;
        this.puntoLlegada = puntoLlegada;
        this.observaciones = observaciones;
        this.fechaInicioTranslado = fechaInicioTranslado;
    }

    public Integer getIdGuiaRemicion() {
        return idGuiaRemicion;
    }

    public void setIdGuiaRemicion(Integer idGuiaRemicion) {
        this.idGuiaRemicion = idGuiaRemicion;
    }

    public String getPuntoPartida() {
        return puntoPartida;
    }

    public void setPuntoPartida(String puntoPartida) {
        this.puntoPartida = puntoPartida;
    }

    public String getPuntoLlegada() {
        return puntoLlegada;
    }

    public void setPuntoLlegada(String puntoLlegada) {
        this.puntoLlegada = puntoLlegada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaInicioTranslado() {
        return fechaInicioTranslado;
    }

    public void setFechaInicioTranslado(Date fechaInicioTranslado) {
        this.fechaInicioTranslado = fechaInicioTranslado;
    }

    public UnidadTransporte getUnidadTransporte() {
        return unidadTransporte;
    }

    public void setUnidadTransporte(UnidadTransporte unidadTransporte) {
        this.unidadTransporte = unidadTransporte;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public MotivoTransladoFactura getMotivoTransladoFactura() {
        return motivoTransladoFactura;
    }

    public void setMotivoTransladoFactura(MotivoTransladoFactura motivoTransladoFactura) {
        this.motivoTransladoFactura = motivoTransladoFactura;
    }

    public FacturaVenta getFacturaVenta() {
        return facturaVenta;
    }

    public void setFacturaVenta(FacturaVenta facturaVenta) {
        this.facturaVenta = facturaVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGuiaRemicion != null ? idGuiaRemicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaRemicion)) {
            return false;
        }
        GuiaRemicion other = (GuiaRemicion) object;
        if ((this.idGuiaRemicion == null && other.idGuiaRemicion != null) || (this.idGuiaRemicion != null && !this.idGuiaRemicion.equals(other.idGuiaRemicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.GuiaRemicion[ idGuiaRemicion=" + idGuiaRemicion + " ]";
    }
    
}

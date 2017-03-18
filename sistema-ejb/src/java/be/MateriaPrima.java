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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "materia_prima")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaPrima.findAll", query = "SELECT m FROM MateriaPrima m"),
    @NamedQuery(name = "MateriaPrima.findByIdMateriaPrima", query = "SELECT m FROM MateriaPrima m WHERE m.idMateriaPrima = :idMateriaPrima"),
    @NamedQuery(name = "MateriaPrima.findByNombreMateriaPrima", query = "SELECT m FROM MateriaPrima m WHERE m.nombreMateriaPrima = :nombreMateriaPrima"),
    @NamedQuery(name = "MateriaPrima.findByDescripcion", query = "SELECT m FROM MateriaPrima m WHERE m.descripcion = :descripcion")})
public class MateriaPrima implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_materia_prima")
    private Integer idMateriaPrima;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 150)
    @Column(name = "nombre_materia_prima")
    private String nombreMateriaPrima;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaPrima", fetch = FetchType.LAZY)
    private List<DetalleFormulacionInsumos> detalleFormulacionInsumosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaPrima", fetch = FetchType.LAZY)
    private List<StockMateriaPrimaTiendaOrigen> stockMateriaPrimaTiendaOrigenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaPrima", fetch = FetchType.LAZY)
    private List<SalidaMateriaPrimaTienda> salidaMateriaPrimaTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaPrima", fetch = FetchType.LAZY)
    private List<IngresoMateriaPrimaTienda> ingresoMateriaPrimaTiendaList;
    @JoinColumn(name = "id_unidad_medida", referencedColumnName = "id_unidad_medida")
    @ManyToOne(fetch = FetchType.LAZY)
    private UnidadMedida unidadMedida;

    public MateriaPrima() {
    }

    public MateriaPrima(Integer idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public MateriaPrima(Integer idMateriaPrima, String nombreMateriaPrima, String descripcion) {
        this.idMateriaPrima = idMateriaPrima;
        this.nombreMateriaPrima = nombreMateriaPrima;
        this.descripcion = descripcion;
    }

    public Integer getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(Integer idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public String getNombreMateriaPrima() {
        return nombreMateriaPrima;
    }

    public void setNombreMateriaPrima(String nombreMateriaPrima) {
        this.nombreMateriaPrima = nombreMateriaPrima;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<DetalleFormulacionInsumos> getDetalleFormulacionInsumosList() {
        return detalleFormulacionInsumosList;
    }

    public void setDetalleFormulacionInsumosList(List<DetalleFormulacionInsumos> detalleFormulacionInsumosList) {
        this.detalleFormulacionInsumosList = detalleFormulacionInsumosList;
    }

    @XmlTransient
    public List<StockMateriaPrimaTiendaOrigen> getStockMateriaPrimaTiendaOrigenList() {
        return stockMateriaPrimaTiendaOrigenList;
    }

    public void setStockMateriaPrimaTiendaOrigenList(List<StockMateriaPrimaTiendaOrigen> stockMateriaPrimaTiendaOrigenList) {
        this.stockMateriaPrimaTiendaOrigenList = stockMateriaPrimaTiendaOrigenList;
    }

    @XmlTransient
    public List<SalidaMateriaPrimaTienda> getSalidaMateriaPrimaTiendaList() {
        return salidaMateriaPrimaTiendaList;
    }

    public void setSalidaMateriaPrimaTiendaList(List<SalidaMateriaPrimaTienda> salidaMateriaPrimaTiendaList) {
        this.salidaMateriaPrimaTiendaList = salidaMateriaPrimaTiendaList;
    }

    @XmlTransient
    public List<IngresoMateriaPrimaTienda> getIngresoMateriaPrimaTiendaList() {
        return ingresoMateriaPrimaTiendaList;
    }

    public void setIngresoMateriaPrimaTiendaList(List<IngresoMateriaPrimaTienda> ingresoMateriaPrimaTiendaList) {
        this.ingresoMateriaPrimaTiendaList = ingresoMateriaPrimaTiendaList;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriaPrima != null ? idMateriaPrima.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaPrima)) {
            return false;
        }
        MateriaPrima other = (MateriaPrima) object;
        if ((this.idMateriaPrima == null && other.idMateriaPrima != null) || (this.idMateriaPrima != null && !this.idMateriaPrima.equals(other.idMateriaPrima))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.MateriaPrima[ idMateriaPrima=" + idMateriaPrima + " ]";
    }
    
}

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
@Table(name = "motivo_translado_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotivoTransladoFactura.findAll", query = "SELECT m FROM MotivoTransladoFactura m"),
    @NamedQuery(name = "MotivoTransladoFactura.findByIdMotivoTransladoFactura", query = "SELECT m FROM MotivoTransladoFactura m WHERE m.idMotivoTransladoFactura = :idMotivoTransladoFactura"),
    @NamedQuery(name = "MotivoTransladoFactura.findByMotivo", query = "SELECT m FROM MotivoTransladoFactura m WHERE m.motivo = :motivo"),
    @NamedQuery(name = "MotivoTransladoFactura.findByDescripcion", query = "SELECT m FROM MotivoTransladoFactura m WHERE m.descripcion = :descripcion")})
public class MotivoTransladoFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_motivo_translado_factura")
    private Integer idMotivoTransladoFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "motivoTransladoFactura", fetch = FetchType.LAZY)
    private List<GuiaRemicion> guiaRemicionList;

    public MotivoTransladoFactura() {
    }

    public MotivoTransladoFactura(Integer idMotivoTransladoFactura) {
        this.idMotivoTransladoFactura = idMotivoTransladoFactura;
    }

    public MotivoTransladoFactura(Integer idMotivoTransladoFactura, String motivo, String descripcion) {
        this.idMotivoTransladoFactura = idMotivoTransladoFactura;
        this.motivo = motivo;
        this.descripcion = descripcion;
    }

    public Integer getIdMotivoTransladoFactura() {
        return idMotivoTransladoFactura;
    }

    public void setIdMotivoTransladoFactura(Integer idMotivoTransladoFactura) {
        this.idMotivoTransladoFactura = idMotivoTransladoFactura;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<GuiaRemicion> getGuiaRemicionList() {
        return guiaRemicionList;
    }

    public void setGuiaRemicionList(List<GuiaRemicion> guiaRemicionList) {
        this.guiaRemicionList = guiaRemicionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotivoTransladoFactura != null ? idMotivoTransladoFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotivoTransladoFactura)) {
            return false;
        }
        MotivoTransladoFactura other = (MotivoTransladoFactura) object;
        if ((this.idMotivoTransladoFactura == null && other.idMotivoTransladoFactura != null) || (this.idMotivoTransladoFactura != null && !this.idMotivoTransladoFactura.equals(other.idMotivoTransladoFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.MotivoTransladoFactura[ idMotivoTransladoFactura=" + idMotivoTransladoFactura + " ]";
    }
    
}

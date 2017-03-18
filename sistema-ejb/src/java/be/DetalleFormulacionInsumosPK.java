/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author argos
 */
@Embeddable
public class DetalleFormulacionInsumosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_formulacion")
    private int idFormulacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_materia_prima")
    private int idMateriaPrima;

    public DetalleFormulacionInsumosPK() {
    }

    public DetalleFormulacionInsumosPK(int idFormulacion, int idMateriaPrima) {
        this.idFormulacion = idFormulacion;
        this.idMateriaPrima = idMateriaPrima;
    }

    public int getIdFormulacion() {
        return idFormulacion;
    }

    public void setIdFormulacion(int idFormulacion) {
        this.idFormulacion = idFormulacion;
    }

    public int getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(int idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFormulacion;
        hash += (int) idMateriaPrima;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFormulacionInsumosPK)) {
            return false;
        }
        DetalleFormulacionInsumosPK other = (DetalleFormulacionInsumosPK) object;
        if (this.idFormulacion != other.idFormulacion) {
            return false;
        }
        if (this.idMateriaPrima != other.idMateriaPrima) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleFormulacionInsumosPK[ idFormulacion=" + idFormulacion + ", idMateriaPrima=" + idMateriaPrima + " ]";
    }
    
}

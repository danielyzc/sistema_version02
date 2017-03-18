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
public class DetalleCambioProductoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cambio")
    private int idCambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto_cambio")
    private int idProductoCambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto_cambiada")
    private int idProductoCambiada;

    public DetalleCambioProductoPK() {
    }

    public DetalleCambioProductoPK(int idCambio, int idProductoCambio, int idProductoCambiada) {
        this.idCambio = idCambio;
        this.idProductoCambio = idProductoCambio;
        this.idProductoCambiada = idProductoCambiada;
    }

    public int getIdCambio() {
        return idCambio;
    }

    public void setIdCambio(int idCambio) {
        this.idCambio = idCambio;
    }

    public int getIdProductoCambio() {
        return idProductoCambio;
    }

    public void setIdProductoCambio(int idProductoCambio) {
        this.idProductoCambio = idProductoCambio;
    }

    public int getIdProductoCambiada() {
        return idProductoCambiada;
    }

    public void setIdProductoCambiada(int idProductoCambiada) {
        this.idProductoCambiada = idProductoCambiada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCambio;
        hash += (int) idProductoCambio;
        hash += (int) idProductoCambiada;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCambioProductoPK)) {
            return false;
        }
        DetalleCambioProductoPK other = (DetalleCambioProductoPK) object;
        if (this.idCambio != other.idCambio) {
            return false;
        }
        if (this.idProductoCambio != other.idProductoCambio) {
            return false;
        }
        if (this.idProductoCambiada != other.idProductoCambiada) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleCambioProductoPK[ idCambio=" + idCambio + ", idProductoCambio=" + idProductoCambio + ", idProductoCambiada=" + idProductoCambiada + " ]";
    }
    
}

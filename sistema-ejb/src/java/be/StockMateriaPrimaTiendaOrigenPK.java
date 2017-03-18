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
public class StockMateriaPrimaTiendaOrigenPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_materia_prima")
    private int idMateriaPrima;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tienda_origen")
    private int idTiendaOrigen;

    public StockMateriaPrimaTiendaOrigenPK() {
    }

    public StockMateriaPrimaTiendaOrigenPK(int idMateriaPrima, int idTiendaOrigen) {
        this.idMateriaPrima = idMateriaPrima;
        this.idTiendaOrigen = idTiendaOrigen;
    }

    public int getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(int idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public int getIdTiendaOrigen() {
        return idTiendaOrigen;
    }

    public void setIdTiendaOrigen(int idTiendaOrigen) {
        this.idTiendaOrigen = idTiendaOrigen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMateriaPrima;
        hash += (int) idTiendaOrigen;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockMateriaPrimaTiendaOrigenPK)) {
            return false;
        }
        StockMateriaPrimaTiendaOrigenPK other = (StockMateriaPrimaTiendaOrigenPK) object;
        if (this.idMateriaPrima != other.idMateriaPrima) {
            return false;
        }
        if (this.idTiendaOrigen != other.idTiendaOrigen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.StockMateriaPrimaTiendaOrigenPK[ idMateriaPrima=" + idMateriaPrima + ", idTiendaOrigen=" + idTiendaOrigen + " ]";
    }
    
}

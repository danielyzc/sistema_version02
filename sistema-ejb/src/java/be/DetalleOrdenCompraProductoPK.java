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
public class DetalleOrdenCompraProductoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orden_compra")
    private int idOrdenCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;

    public DetalleOrdenCompraProductoPK() {
    }

    public DetalleOrdenCompraProductoPK(int idOrdenCompra, int idProducto) {
        this.idOrdenCompra = idOrdenCompra;
        this.idProducto = idProducto;
    }

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrdenCompra;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleOrdenCompraProductoPK)) {
            return false;
        }
        DetalleOrdenCompraProductoPK other = (DetalleOrdenCompraProductoPK) object;
        if (this.idOrdenCompra != other.idOrdenCompra) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleOrdenCompraProductoPK[ idOrdenCompra=" + idOrdenCompra + ", idProducto=" + idProducto + " ]";
    }
    
}

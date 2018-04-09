/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import be.DetalleAlmacenProductos;
import be.StockProductoTiendaOrigen;
import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author argos
 */
public class StockProductoTiendaOrigen_ayuda implements Serializable {

    private static final long serialVersionUID = 1L;
    private StockProductoTiendaOrigen stock;
    private int cantidad_ayuda;
    private DetalleAlmacenProductos detalle;
    private StockProductoTiendaOrigen stock_tienda_actual;

    public StockProductoTiendaOrigen_ayuda() {
    }

    public StockProductoTiendaOrigen getStock_tienda_actual() {
        return stock_tienda_actual;
    }

    public void setStock_tienda_actual(StockProductoTiendaOrigen stock_tienda_actual) {
        this.stock_tienda_actual = stock_tienda_actual;
    }

    public DetalleAlmacenProductos getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleAlmacenProductos detalle) {
        this.detalle = detalle;
    }

    public StockProductoTiendaOrigen getStock() {
        return stock;
    }

    public void setStock(StockProductoTiendaOrigen stock) {
        this.stock = stock;
    }

    public int getCantidad_ayuda() {
        return cantidad_ayuda;
    }

    public void setCantidad_ayuda(int cantidad_ayuda) {
        this.cantidad_ayuda = cantidad_ayuda;
    }

}

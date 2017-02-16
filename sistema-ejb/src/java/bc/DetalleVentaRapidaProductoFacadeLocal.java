/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleVentaRapidaProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DetalleVentaRapidaProductoFacadeLocal {

    void create(DetalleVentaRapidaProducto detalleVentaRapidaProducto);

    void edit(DetalleVentaRapidaProducto detalleVentaRapidaProducto);

    void remove(DetalleVentaRapidaProducto detalleVentaRapidaProducto);

    DetalleVentaRapidaProducto find(Object id);

    List<DetalleVentaRapidaProducto> findAll();

    List<DetalleVentaRapidaProducto> findRange(int[] range);

    int count();
    
}

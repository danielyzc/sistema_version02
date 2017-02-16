/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleVentaProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DetalleVentaProductoFacadeLocal {

    void create(DetalleVentaProducto detalleVentaProducto);

    void edit(DetalleVentaProducto detalleVentaProducto);

    void remove(DetalleVentaProducto detalleVentaProducto);

    DetalleVentaProducto find(Object id);

    List<DetalleVentaProducto> findAll();

    List<DetalleVentaProducto> findRange(int[] range);

    int count();
    
}

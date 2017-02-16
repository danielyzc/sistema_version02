/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleFacturaVentaProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DetalleFacturaVentaProductoFacadeLocal {

    void create(DetalleFacturaVentaProducto detalleFacturaVentaProducto);

    void edit(DetalleFacturaVentaProducto detalleFacturaVentaProducto);

    void remove(DetalleFacturaVentaProducto detalleFacturaVentaProducto);

    DetalleFacturaVentaProducto find(Object id);

    List<DetalleFacturaVentaProducto> findAll();

    List<DetalleFacturaVentaProducto> findRange(int[] range);

    int count();
    
}

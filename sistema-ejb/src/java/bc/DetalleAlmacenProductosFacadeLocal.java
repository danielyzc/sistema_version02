/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleAlmacenProductos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DetalleAlmacenProductosFacadeLocal {

    void create(DetalleAlmacenProductos detalleAlmacenProductos);

    void edit(DetalleAlmacenProductos detalleAlmacenProductos);

    void remove(DetalleAlmacenProductos detalleAlmacenProductos);

    DetalleAlmacenProductos find(Object id);

    List<DetalleAlmacenProductos> findAll();

    List<DetalleAlmacenProductos> findRange(int[] range);

    int count();
    
}

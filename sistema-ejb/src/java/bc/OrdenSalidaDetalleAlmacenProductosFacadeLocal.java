/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.OrdenSalidaDetalleAlmacenProductos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface OrdenSalidaDetalleAlmacenProductosFacadeLocal {

    void create(OrdenSalidaDetalleAlmacenProductos ordenSalidaDetalleAlmacenProductos);

    void edit(OrdenSalidaDetalleAlmacenProductos ordenSalidaDetalleAlmacenProductos);

    void remove(OrdenSalidaDetalleAlmacenProductos ordenSalidaDetalleAlmacenProductos);

    OrdenSalidaDetalleAlmacenProductos find(Object id);

    List<OrdenSalidaDetalleAlmacenProductos> findAll();

    List<OrdenSalidaDetalleAlmacenProductos> findRange(int[] range);

    int count();
    
}

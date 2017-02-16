/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoOrdenSalidaDetalleAlmacenProductos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface EstadoOrdenSalidaDetalleAlmacenProductosFacadeLocal {

    void create(EstadoOrdenSalidaDetalleAlmacenProductos estadoOrdenSalidaDetalleAlmacenProductos);

    void edit(EstadoOrdenSalidaDetalleAlmacenProductos estadoOrdenSalidaDetalleAlmacenProductos);

    void remove(EstadoOrdenSalidaDetalleAlmacenProductos estadoOrdenSalidaDetalleAlmacenProductos);

    EstadoOrdenSalidaDetalleAlmacenProductos find(Object id);

    List<EstadoOrdenSalidaDetalleAlmacenProductos> findAll();

    List<EstadoOrdenSalidaDetalleAlmacenProductos> findRange(int[] range);

    int count();
    
}

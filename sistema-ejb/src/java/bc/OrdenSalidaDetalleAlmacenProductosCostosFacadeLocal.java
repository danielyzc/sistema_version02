/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.OrdenSalidaDetalleAlmacenProductosCostos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface OrdenSalidaDetalleAlmacenProductosCostosFacadeLocal {

    void create(OrdenSalidaDetalleAlmacenProductosCostos ordenSalidaDetalleAlmacenProductosCostos);

    void edit(OrdenSalidaDetalleAlmacenProductosCostos ordenSalidaDetalleAlmacenProductosCostos);

    void remove(OrdenSalidaDetalleAlmacenProductosCostos ordenSalidaDetalleAlmacenProductosCostos);

    OrdenSalidaDetalleAlmacenProductosCostos find(Object id);

    List<OrdenSalidaDetalleAlmacenProductosCostos> findAll();

    List<OrdenSalidaDetalleAlmacenProductosCostos> findRange(int[] range);

    int count();
    
}

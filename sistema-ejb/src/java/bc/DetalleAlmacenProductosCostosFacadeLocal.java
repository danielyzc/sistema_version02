/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleAlmacenProductosCostos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DetalleAlmacenProductosCostosFacadeLocal {

    void create(DetalleAlmacenProductosCostos detalleAlmacenProductosCostos);

    void edit(DetalleAlmacenProductosCostos detalleAlmacenProductosCostos);

    void remove(DetalleAlmacenProductosCostos detalleAlmacenProductosCostos);

    DetalleAlmacenProductosCostos find(Object id);

    List<DetalleAlmacenProductosCostos> findAll();

    List<DetalleAlmacenProductosCostos> findRange(int[] range);

    int count();
    
}

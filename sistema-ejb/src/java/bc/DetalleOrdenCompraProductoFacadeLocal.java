/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleOrdenCompraProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DetalleOrdenCompraProductoFacadeLocal {

    void create(DetalleOrdenCompraProducto detalleOrdenCompraProducto);

    void edit(DetalleOrdenCompraProducto detalleOrdenCompraProducto);

    void remove(DetalleOrdenCompraProducto detalleOrdenCompraProducto);

    DetalleOrdenCompraProducto find(Object id);

    List<DetalleOrdenCompraProducto> findAll();

    List<DetalleOrdenCompraProducto> findRange(int[] range);

    int count();
    
}

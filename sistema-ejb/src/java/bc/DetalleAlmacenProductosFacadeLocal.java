/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleAlmacenProductos;
import be.Producto;
import be.Tienda;
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
    
    List<DetalleAlmacenProductos> lista_para_stock_tienda(Tienda t, Producto p);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.PrecioProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PrecioProductoFacadeLocal {

    void create(PrecioProducto precioProducto);

    void edit(PrecioProducto precioProducto);

    void remove(PrecioProducto precioProducto);

    PrecioProducto find(Object id);

    List<PrecioProducto> findAll();

    List<PrecioProducto> findRange(int[] range);

    int count();
    
}

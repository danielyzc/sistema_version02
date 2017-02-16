/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleCambioProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DetalleCambioProductoFacadeLocal {

    void create(DetalleCambioProducto detalleCambioProducto);

    void edit(DetalleCambioProducto detalleCambioProducto);

    void remove(DetalleCambioProducto detalleCambioProducto);

    DetalleCambioProducto find(Object id);

    List<DetalleCambioProducto> findAll();

    List<DetalleCambioProducto> findRange(int[] range);

    int count();
    
}

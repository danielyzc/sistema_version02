/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface EstadoProductoFacadeLocal {

    void create(EstadoProducto estadoProducto);

    void edit(EstadoProducto estadoProducto);

    void remove(EstadoProducto estadoProducto);

    EstadoProducto find(Object id);

    List<EstadoProducto> findAll();

    List<EstadoProducto> findRange(int[] range);

    int count();
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DetalleFumigacionProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DetalleFumigacionProductoFacadeLocal {

    void create(DetalleFumigacionProducto detalleFumigacionProducto);

    void edit(DetalleFumigacionProducto detalleFumigacionProducto);

    void remove(DetalleFumigacionProducto detalleFumigacionProducto);

    DetalleFumigacionProducto find(Object id);

    List<DetalleFumigacionProducto> findAll();

    List<DetalleFumigacionProducto> findRange(int[] range);

    int count();
    
}

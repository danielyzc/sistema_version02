/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.SalidaProductoTienda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface SalidaProductoTiendaFacadeLocal {

    void create(SalidaProductoTienda salidaProductoTienda);

    void edit(SalidaProductoTienda salidaProductoTienda);

    void remove(SalidaProductoTienda salidaProductoTienda);

    SalidaProductoTienda find(Object id);

    List<SalidaProductoTienda> findAll();

    List<SalidaProductoTienda> findRange(int[] range);

    int count();
    
}

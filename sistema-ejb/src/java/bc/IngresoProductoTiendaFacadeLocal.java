/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.IngresoProductoTienda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface IngresoProductoTiendaFacadeLocal {

    void create(IngresoProductoTienda ingresoProductoTienda);

    void edit(IngresoProductoTienda ingresoProductoTienda);

    void remove(IngresoProductoTienda ingresoProductoTienda);

    IngresoProductoTienda find(Object id);

    List<IngresoProductoTienda> findAll();

    List<IngresoProductoTienda> findRange(int[] range);

    int count();
    
}

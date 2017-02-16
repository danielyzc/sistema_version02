/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface EstadoVentaFacadeLocal {

    void create(EstadoVenta estadoVenta);

    void edit(EstadoVenta estadoVenta);

    void remove(EstadoVenta estadoVenta);

    EstadoVenta find(Object id);

    List<EstadoVenta> findAll();

    List<EstadoVenta> findRange(int[] range);

    int count();
    
}

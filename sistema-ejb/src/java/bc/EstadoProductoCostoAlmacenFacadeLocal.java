/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoProductoCostoAlmacen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface EstadoProductoCostoAlmacenFacadeLocal {

    void create(EstadoProductoCostoAlmacen estadoProductoCostoAlmacen);

    void edit(EstadoProductoCostoAlmacen estadoProductoCostoAlmacen);

    void remove(EstadoProductoCostoAlmacen estadoProductoCostoAlmacen);

    EstadoProductoCostoAlmacen find(Object id);

    List<EstadoProductoCostoAlmacen> findAll();

    List<EstadoProductoCostoAlmacen> findRange(int[] range);

    int count();
    
}

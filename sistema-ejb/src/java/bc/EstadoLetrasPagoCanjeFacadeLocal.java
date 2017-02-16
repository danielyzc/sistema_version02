/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoLetrasPagoCanje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface EstadoLetrasPagoCanjeFacadeLocal {

    void create(EstadoLetrasPagoCanje estadoLetrasPagoCanje);

    void edit(EstadoLetrasPagoCanje estadoLetrasPagoCanje);

    void remove(EstadoLetrasPagoCanje estadoLetrasPagoCanje);

    EstadoLetrasPagoCanje find(Object id);

    List<EstadoLetrasPagoCanje> findAll();

    List<EstadoLetrasPagoCanje> findRange(int[] range);

    int count();
    
}

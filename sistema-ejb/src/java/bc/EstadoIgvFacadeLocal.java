/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoIgv;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface EstadoIgvFacadeLocal {

    void create(EstadoIgv estadoIgv);

    void edit(EstadoIgv estadoIgv);

    void remove(EstadoIgv estadoIgv);

    EstadoIgv find(Object id);

    List<EstadoIgv> findAll();

    List<EstadoIgv> findRange(int[] range);

    int count();
    
}

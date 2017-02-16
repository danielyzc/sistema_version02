/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Cambio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface CambioFacadeLocal {

    void create(Cambio cambio);

    void edit(Cambio cambio);

    void remove(Cambio cambio);

    Cambio find(Object id);

    List<Cambio> findAll();

    List<Cambio> findRange(int[] range);

    int count();
    
}

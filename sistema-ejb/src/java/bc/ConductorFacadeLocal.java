/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Conductor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ConductorFacadeLocal {

    void create(Conductor conductor);

    void edit(Conductor conductor);

    void remove(Conductor conductor);

    Conductor find(Object id);

    List<Conductor> findAll();

    List<Conductor> findRange(int[] range);

    int count();
    
}

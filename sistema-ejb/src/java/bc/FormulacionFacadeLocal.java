/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Formulacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface FormulacionFacadeLocal {

    void create(Formulacion formulacion);

    void edit(Formulacion formulacion);

    void remove(Formulacion formulacion);

    Formulacion find(Object id);

    List<Formulacion> findAll();

    List<Formulacion> findRange(int[] range);

    int count();
    
}

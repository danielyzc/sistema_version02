/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Desarrollador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DesarrolladorFacadeLocal {

    void create(Desarrollador desarrollador);

    void edit(Desarrollador desarrollador);

    void remove(Desarrollador desarrollador);

    Desarrollador find(Object id);

    List<Desarrollador> findAll();

    List<Desarrollador> findRange(int[] range);

    int count();
    
}

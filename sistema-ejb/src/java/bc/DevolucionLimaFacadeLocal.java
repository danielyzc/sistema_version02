/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.DevolucionLima;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DevolucionLimaFacadeLocal {

    void create(DevolucionLima devolucionLima);

    void edit(DevolucionLima devolucionLima);

    void remove(DevolucionLima devolucionLima);

    DevolucionLima find(Object id);

    List<DevolucionLima> findAll();

    List<DevolucionLima> findRange(int[] range);

    int count();
    
}

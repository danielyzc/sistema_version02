/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.GuiaRemicion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface GuiaRemicionFacadeLocal {

    void create(GuiaRemicion guiaRemicion);

    void edit(GuiaRemicion guiaRemicion);

    void remove(GuiaRemicion guiaRemicion);

    GuiaRemicion find(Object id);

    List<GuiaRemicion> findAll();

    List<GuiaRemicion> findRange(int[] range);

    int count();
    
}

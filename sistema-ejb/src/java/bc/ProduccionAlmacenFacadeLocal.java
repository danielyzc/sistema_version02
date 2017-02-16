/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.ProduccionAlmacen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ProduccionAlmacenFacadeLocal {

    void create(ProduccionAlmacen produccionAlmacen);

    void edit(ProduccionAlmacen produccionAlmacen);

    void remove(ProduccionAlmacen produccionAlmacen);

    ProduccionAlmacen find(Object id);

    List<ProduccionAlmacen> findAll();

    List<ProduccionAlmacen> findRange(int[] range);

    int count();
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Tienda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TiendaFacadeLocal {

    void create(Tienda tienda);

    void edit(Tienda tienda);

    void remove(Tienda tienda);

    Tienda find(Object id);

    List<Tienda> findAll();

    List<Tienda> findRange(int[] range);

    int count();
    
}

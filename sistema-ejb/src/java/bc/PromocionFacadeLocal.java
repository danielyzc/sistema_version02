/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Promocion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PromocionFacadeLocal {

    void create(Promocion promocion);

    void edit(Promocion promocion);

    void remove(Promocion promocion);

    Promocion find(Object id);

    List<Promocion> findAll();

    List<Promocion> findRange(int[] range);

    int count();
    
}

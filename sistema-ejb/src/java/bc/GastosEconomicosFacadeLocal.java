/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.GastosEconomicos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface GastosEconomicosFacadeLocal {

    void create(GastosEconomicos gastosEconomicos);

    void edit(GastosEconomicos gastosEconomicos);

    void remove(GastosEconomicos gastosEconomicos);

    GastosEconomicos find(Object id);

    List<GastosEconomicos> findAll();

    List<GastosEconomicos> findRange(int[] range);

    int count();
    
}

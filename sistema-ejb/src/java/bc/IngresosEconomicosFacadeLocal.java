/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.IngresosEconomicos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface IngresosEconomicosFacadeLocal {

    void create(IngresosEconomicos ingresosEconomicos);

    void edit(IngresosEconomicos ingresosEconomicos);

    void remove(IngresosEconomicos ingresosEconomicos);

    IngresosEconomicos find(Object id);

    List<IngresosEconomicos> findAll();

    List<IngresosEconomicos> findRange(int[] range);

    int count();
    
}

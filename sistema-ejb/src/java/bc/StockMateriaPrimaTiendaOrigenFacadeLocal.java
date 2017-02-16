/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.StockMateriaPrimaTiendaOrigen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface StockMateriaPrimaTiendaOrigenFacadeLocal {

    void create(StockMateriaPrimaTiendaOrigen stockMateriaPrimaTiendaOrigen);

    void edit(StockMateriaPrimaTiendaOrigen stockMateriaPrimaTiendaOrigen);

    void remove(StockMateriaPrimaTiendaOrigen stockMateriaPrimaTiendaOrigen);

    StockMateriaPrimaTiendaOrigen find(Object id);

    List<StockMateriaPrimaTiendaOrigen> findAll();

    List<StockMateriaPrimaTiendaOrigen> findRange(int[] range);

    int count();
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.StockProductoTiendaOrigen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface StockProductoTiendaOrigenFacadeLocal {

    void create(StockProductoTiendaOrigen stockProductoTiendaOrigen);

    void edit(StockProductoTiendaOrigen stockProductoTiendaOrigen);

    void remove(StockProductoTiendaOrigen stockProductoTiendaOrigen);

    StockProductoTiendaOrigen find(Object id);

    List<StockProductoTiendaOrigen> findAll();

    List<StockProductoTiendaOrigen> findRange(int[] range);

    int count();
    
}

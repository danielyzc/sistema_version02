/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Producto;
import be.StockProductoTiendaOrigen;
import be.StockProductoTiendaOrigenPK;
import be.Tienda;
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
    
    List<StockProductoTiendaOrigen> lista_stock_tienda_producto(Tienda t, Producto p);
    List<StockProductoTiendaOrigen> lista_stock_producto(Producto p);
    List<StockProductoTiendaOrigen> lista_stock_tienda(Tienda t);
    List<Object[]> consulta_webservice(String parametro_);
}

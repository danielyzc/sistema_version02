/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.CanjeOrdenCompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface CanjeOrdenCompraFacadeLocal {

    void create(CanjeOrdenCompra canjeOrdenCompra);

    void edit(CanjeOrdenCompra canjeOrdenCompra);

    void remove(CanjeOrdenCompra canjeOrdenCompra);

    CanjeOrdenCompra find(Object id);

    List<CanjeOrdenCompra> findAll();

    List<CanjeOrdenCompra> findRange(int[] range);

    int count();
    
}

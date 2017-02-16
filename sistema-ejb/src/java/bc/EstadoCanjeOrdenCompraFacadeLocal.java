/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoCanjeOrdenCompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface EstadoCanjeOrdenCompraFacadeLocal {

    void create(EstadoCanjeOrdenCompra estadoCanjeOrdenCompra);

    void edit(EstadoCanjeOrdenCompra estadoCanjeOrdenCompra);

    void remove(EstadoCanjeOrdenCompra estadoCanjeOrdenCompra);

    EstadoCanjeOrdenCompra find(Object id);

    List<EstadoCanjeOrdenCompra> findAll();

    List<EstadoCanjeOrdenCompra> findRange(int[] range);

    int count();
    
}

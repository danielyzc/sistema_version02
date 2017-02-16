/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.EstadoOrdenCompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface EstadoOrdenCompraFacadeLocal {

    void create(EstadoOrdenCompra estadoOrdenCompra);

    void edit(EstadoOrdenCompra estadoOrdenCompra);

    void remove(EstadoOrdenCompra estadoOrdenCompra);

    EstadoOrdenCompra find(Object id);

    List<EstadoOrdenCompra> findAll();

    List<EstadoOrdenCompra> findRange(int[] range);

    int count();
    
}

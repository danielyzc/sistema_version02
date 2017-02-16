/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.OrdenCompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface OrdenCompraFacadeLocal {

    void create(OrdenCompra ordenCompra);

    void edit(OrdenCompra ordenCompra);

    void remove(OrdenCompra ordenCompra);

    OrdenCompra find(Object id);

    List<OrdenCompra> findAll();

    List<OrdenCompra> findRange(int[] range);

    int count();
    
}

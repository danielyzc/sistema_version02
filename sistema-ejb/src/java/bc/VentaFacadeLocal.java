/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Venta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface VentaFacadeLocal {

    void create(Venta venta);

    void edit(Venta venta);

    void remove(Venta venta);

    Venta find(Object id);

    List<Venta> findAll();

    List<Venta> findRange(int[] range);

    int count();
    
}

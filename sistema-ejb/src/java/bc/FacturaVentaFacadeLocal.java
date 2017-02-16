/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.FacturaVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface FacturaVentaFacadeLocal {

    void create(FacturaVenta facturaVenta);

    void edit(FacturaVenta facturaVenta);

    void remove(FacturaVenta facturaVenta);

    FacturaVenta find(Object id);

    List<FacturaVenta> findAll();

    List<FacturaVenta> findRange(int[] range);

    int count();
    
}

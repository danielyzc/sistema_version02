/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.PagoFacturaVentaCredito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PagoFacturaVentaCreditoFacadeLocal {

    void create(PagoFacturaVentaCredito pagoFacturaVentaCredito);

    void edit(PagoFacturaVentaCredito pagoFacturaVentaCredito);

    void remove(PagoFacturaVentaCredito pagoFacturaVentaCredito);

    PagoFacturaVentaCredito find(Object id);

    List<PagoFacturaVentaCredito> findAll();

    List<PagoFacturaVentaCredito> findRange(int[] range);

    int count();
    
}

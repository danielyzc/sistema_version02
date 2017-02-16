/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.PagoVentaCredito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PagoVentaCreditoFacadeLocal {

    void create(PagoVentaCredito pagoVentaCredito);

    void edit(PagoVentaCredito pagoVentaCredito);

    void remove(PagoVentaCredito pagoVentaCredito);

    PagoVentaCredito find(Object id);

    List<PagoVentaCredito> findAll();

    List<PagoVentaCredito> findRange(int[] range);

    int count();
    
}

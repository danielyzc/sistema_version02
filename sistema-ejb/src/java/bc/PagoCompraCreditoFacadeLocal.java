/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.PagoCompraCredito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PagoCompraCreditoFacadeLocal {

    void create(PagoCompraCredito pagoCompraCredito);

    void edit(PagoCompraCredito pagoCompraCredito);

    void remove(PagoCompraCredito pagoCompraCredito);

    PagoCompraCredito find(Object id);

    List<PagoCompraCredito> findAll();

    List<PagoCompraCredito> findRange(int[] range);

    int count();
    
}

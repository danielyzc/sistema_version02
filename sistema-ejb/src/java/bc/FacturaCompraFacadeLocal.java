/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.FacturaCompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface FacturaCompraFacadeLocal {

    void create(FacturaCompra facturaCompra);

    void edit(FacturaCompra facturaCompra);

    void remove(FacturaCompra facturaCompra);

    FacturaCompra find(Object id);

    List<FacturaCompra> findAll();

    List<FacturaCompra> findRange(int[] range);

    int count();
    
}

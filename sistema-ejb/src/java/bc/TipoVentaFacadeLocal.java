/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.TipoVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TipoVentaFacadeLocal {

    void create(TipoVenta tipoVenta);

    void edit(TipoVenta tipoVenta);

    void remove(TipoVenta tipoVenta);

    TipoVenta find(Object id);

    List<TipoVenta> findAll();

    List<TipoVenta> findRange(int[] range);

    int count();
    
}

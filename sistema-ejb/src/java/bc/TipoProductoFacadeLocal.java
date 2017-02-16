/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.TipoProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TipoProductoFacadeLocal {

    void create(TipoProducto tipoProducto);

    void edit(TipoProducto tipoProducto);

    void remove(TipoProducto tipoProducto);

    TipoProducto find(Object id);

    List<TipoProducto> findAll();

    List<TipoProducto> findRange(int[] range);

    int count();
    
}

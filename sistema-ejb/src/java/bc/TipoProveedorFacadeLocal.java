/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.TipoProveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TipoProveedorFacadeLocal {

    void create(TipoProveedor tipoProveedor);

    void edit(TipoProveedor tipoProveedor);

    void remove(TipoProveedor tipoProveedor);

    TipoProveedor find(Object id);

    List<TipoProveedor> findAll();

    List<TipoProveedor> findRange(int[] range);

    int count();
    
}

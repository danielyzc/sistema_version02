/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.Proveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ProveedorFacadeLocal {

    void create(Proveedor proveedor);

    void edit(Proveedor proveedor);

    void remove(Proveedor proveedor);

    Proveedor find(Object id);

    List<Proveedor> findAll();

    List<Proveedor> findRange(int[] range);

    int count();
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bc;

import be.MaterialProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface MaterialProductoFacadeLocal {

    void create(MaterialProducto materialProducto);

    void edit(MaterialProducto materialProducto);

    void remove(MaterialProducto materialProducto);

    MaterialProducto find(Object id);

    List<MaterialProducto> findAll();

    List<MaterialProducto> findRange(int[] range);

    int count();
    
}
